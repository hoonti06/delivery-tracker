package me.hoonti06.deliverytracker.step1.deliverytracker;

import java.io.IOException;
import me.hoonti06.deliverytracker.step1.DeliveryLastStatusV1;
import me.hoonti06.deliverytracker.step1.UserDeliveryInfoV1;
import me.hoonti06.deliverytracker.step1.exception.DeliveryParsingFailExceptionV1;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LotteGlogisTrackerV1 implements DeliveryTrackerV1 {

  private static final String URL = "https://www.lotteglogis.com/home/reservation/tracking/linkView";
  private final UserDeliveryInfoV1 userDeliveryInfoV1;

  public LotteGlogisTrackerV1(final UserDeliveryInfoV1 userDeliveryInfoV1) {
    this.userDeliveryInfoV1 = userDeliveryInfoV1;
  }

  @Override
  public DeliveryLastStatusV1 getLastStatus() {
    return validateTrackingNumberAndGetStatus();
  }

  private DeliveryLastStatusV1 validateTrackingNumberAndGetStatus() {
    String replacedTrackingNumber = userDeliveryInfoV1.getTrackingNumber().replace("-", "").trim();
    LotteGlogisTrackingNumberValidatorV1 validator = new LotteGlogisTrackingNumberValidatorV1(
        replacedTrackingNumber);
    validator.validate();

    Document doc;
    try {
      Connection.Response response
          = Jsoup.connect(URL)
          .data("InvNo", replacedTrackingNumber)
          .method(Connection.Method.GET)
          .execute();

      doc = response.parse();
    } catch (IOException e) {
      throw new DeliveryParsingFailExceptionV1(userDeliveryInfoV1, e);
    }

    LotteGlogisDocParserV1 parser = new LotteGlogisDocParserV1(doc);
    return parser.parse();
  }
}
