package me.hoonti06.deliverytracker.step0.trackeddelivery;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import me.hoonti06.deliverytracker.step0.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step0.DeliveryStatus;
import me.hoonti06.deliverytracker.step0.UserDeliveryInfo;
import me.hoonti06.deliverytracker.step0.exception.DeliveryParsingFailException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

public class LotteGlogisTrackedDelivery implements TrackedDelivery {

  private static final int CORRECT_TRACKING_NUMBER_LENGTH = 12;
  private final UserDeliveryInfo userDeliveryInfo;

  public LotteGlogisTrackedDelivery(final UserDeliveryInfo userDeliveryInfo) {
    this.userDeliveryInfo = userDeliveryInfo;
  }

  @Override
  public DeliveryLastStatus getLastStatus() {
    return validateTrackingNumberAndGetStatus();
  }

  private DeliveryLastStatus validateTrackingNumberAndGetStatus() {
    String replacedTrackingNumber = userDeliveryInfo.getTrackingNumber()
        .replace("-", "").trim();
    validateTrackingNumber(replacedTrackingNumber);

    Document doc = getDocument(replacedTrackingNumber);

    return parseDocument(doc);
  }

  private void validateTrackingNumber(final String trackingNumber) {
    if (hasNotDigitCharacter(trackingNumber)) {
      throw new DeliveryParsingFailException(userDeliveryInfo, "숫자가 아닌 문자 존재");
    }

    if (isTrackingNumberLengthWrong(trackingNumber)) {
      throw new DeliveryParsingFailException(userDeliveryInfo, "잘못된 송장번호");
    }
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

  private Document getDocument(final String trackingNumber) {
    Document doc;
    try {
      Connection.Response response
          = Jsoup.connect("https://www.lotteglogis.com/home/reservation/tracking/linkView")
          .data("InvNo", trackingNumber)
          .method(Connection.Method.GET)
          .execute();

      doc = response.parse();
    } catch (IOException e) {
      throw new DeliveryParsingFailException(userDeliveryInfo, "파싱 과정 중 예외 발생", e);
    }
    return doc;
  }

  private DeliveryLastStatus parseDocument(final Document doc) {
    Elements statusTableTds = doc.select("div.contArea > table:nth-of-type(2) > tbody > tr > td");
    if (CollectionUtils.isEmpty(statusTableTds)) {
      throw new DeliveryParsingFailException(userDeliveryInfo, "statusTableTd IS EMPTY");
    }

    Element statusTd = statusTableTds.get(0);
    if (!statusTd.hasText()) {
      throw new DeliveryParsingFailException(userDeliveryInfo, "statusTd IS EMPTY");
    }

    String tdText = statusTd.text();
    if (tdText.contains("미등록운송장") || tdText.contains("상품 발송 준비중")) {
      throw new DeliveryParsingFailException(userDeliveryInfo, "[롯데글로벌로지스]미등록운송장");
    }
    if (tdText.replace(" ", "").contains("배달완료")) {
      return parseCompletedStatus(doc);
    }

    return new DeliveryLastStatus(DeliveryStatus.IN_PROGRESS, LocalDateTime.now());
  }

  private DeliveryLastStatus parseCompletedStatus(final Document doc) {
    Elements historyTableTrs = doc.select("div.contArea > table:nth-of-type(2) > tbody > tr");
    if (historyTableTrs.size() < 2) {
      throw new DeliveryParsingFailException(userDeliveryInfo,
          "historyTable row count is less than 2");
    }

    Element secondTr = historyTableTrs.get(1);
    Elements tds = secondTr.getElementsByTag("td");
    if (tds.size() < 2) {
      throw new DeliveryParsingFailException(userDeliveryInfo, "cell count is less than 2");
    }

    String parsedCompletedDate = tds.get(1).text();
    try {
      LocalDateTime completedDate = LocalDateTime.parse(parsedCompletedDate,
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
      return new DeliveryLastStatus(DeliveryStatus.COMPLETED, completedDate);
    } catch (DateTimeParseException e) {
      throw new DeliveryParsingFailException(userDeliveryInfo, e.getMessage(), e);
    }
  }
}
