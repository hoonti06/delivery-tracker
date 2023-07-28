package me.hoonti06.deliverytracker.step0.deliverytracker;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import me.hoonti06.deliverytracker.step0.DeliveryLastStatusV0;
import me.hoonti06.deliverytracker.step0.DeliveryStatusV0;
import me.hoonti06.deliverytracker.step0.UserDeliveryInfoV0;
import me.hoonti06.deliverytracker.step0.exception.DeliveryParsingFailExceptionV0;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

public class LotteGlogisTrackerV0 implements DeliveryTrackerV0 {

  private static final int CORRECT_TRACKING_NUMBER_LENGTH = 12;
  private final UserDeliveryInfoV0 userDeliveryInfoV0;

  public LotteGlogisTrackerV0(final UserDeliveryInfoV0 userDeliveryInfo) {
    this.userDeliveryInfoV0 = userDeliveryInfo;
  }

  @Override
  public DeliveryLastStatusV0 getLastStatus() {
    return validateTrackingNumberAndGetStatus();
  }

  private DeliveryLastStatusV0 validateTrackingNumberAndGetStatus() {
    String replacedTrackingNumber = userDeliveryInfoV0.getTrackingNumber().replace("-", "").trim();
    if (hasNotDigitCharacter(replacedTrackingNumber)) {
      throw new DeliveryParsingFailExceptionV0(userDeliveryInfoV0, "숫자가 아닌 문자 존재");
    }

    if (isTrackingNumberLengthWrong(replacedTrackingNumber)) {
      throw new DeliveryParsingFailExceptionV0(userDeliveryInfoV0, "잘못된 송장번호");
    }

    Document doc;
    try {
      Connection.Response response
          = Jsoup.connect("https://www.lotteglogis.com/home/reservation/tracking/linkView")
          .data("InvNo", replacedTrackingNumber)
          .method(Connection.Method.GET)
          .execute();

      doc = response.parse();
    } catch (IOException e) {
      throw new DeliveryParsingFailExceptionV0(userDeliveryInfoV0, "파싱 과정 중 예외 발생", e);
    }
    return parse(doc);
  }

  private boolean hasNotDigitCharacter(final String trackingNumber) {
    return !hasOnlyDigit(trackingNumber);
  }

  private boolean hasOnlyDigit(final String trackingNumber) {
    return trackingNumber.chars().allMatch(Character::isDigit);
  }

  private boolean isTrackingNumberLengthWrong(final String trackingNumber) {
    return trackingNumber.length() != CORRECT_TRACKING_NUMBER_LENGTH;
  }

  private DeliveryLastStatusV0 parse(final Document doc) {
    Elements statusTableTds = doc.select("div.contArea > table:nth-of-type(2) > tbody > tr > td");
    if (CollectionUtils.isEmpty(statusTableTds)) {
      throw new DeliveryParsingFailExceptionV0(userDeliveryInfoV0, "statusTableTd IS EMPTY");
    }

    Element statusTd = statusTableTds.get(0);
    if (!statusTd.hasText()) {
      throw new DeliveryParsingFailExceptionV0(userDeliveryInfoV0, "statusTd IS EMPTY");
    }

    String tdText = statusTd.text();
    if (tdText.contains("미등록운송장") || tdText.contains("상품 발송 준비중")) {
      throw new DeliveryParsingFailExceptionV0(userDeliveryInfoV0, "[롯데글로벌로지스]미등록운송장");
    }
    if (tdText.replace(" ", "").contains("배달완료")) {
      return parseCompletedStatus(doc);
    }

    return new DeliveryLastStatusV0(DeliveryStatusV0.IN_PROGRESS, LocalDateTime.now());
  }

  private DeliveryLastStatusV0 parseCompletedStatus(final Document doc) {
    Elements historyTableTrs = doc.select("div.contArea > table:nth-of-type(2) > tbody > tr");
    if (historyTableTrs.size() < 2) {
      throw new DeliveryParsingFailExceptionV0(userDeliveryInfoV0,
          "historyTable row count is less than 2");
    }

    Element secondTr = historyTableTrs.get(1);
    Elements tds = secondTr.getElementsByTag("td");
    if (tds.size() < 2) {
      throw new DeliveryParsingFailExceptionV0(userDeliveryInfoV0, "cell count is less than 2");
    }

    String parsedCompletedDate = tds.get(1).text();
    try {
      LocalDateTime completedDate = LocalDateTime.parse(parsedCompletedDate,
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
      return new DeliveryLastStatusV0(DeliveryStatusV0.COMPLETED, completedDate);
    } catch (DateTimeParseException e) {
      throw new DeliveryParsingFailExceptionV0(userDeliveryInfoV0, e.getMessage(), e);
    }
  }
}
