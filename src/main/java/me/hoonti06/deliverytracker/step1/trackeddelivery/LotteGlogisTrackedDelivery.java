package me.hoonti06.deliverytracker.step1.trackeddelivery;

import java.io.IOException;
import me.hoonti06.deliverytracker.step1.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step1.UserDeliveryInfo;
import me.hoonti06.deliverytracker.step1.exception.DeliveryParsingFailException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LotteGlogisTrackedDelivery implements TrackedDelivery {

  private static final String URL = "https://www.lotteglogis.com/home/reservation/tracking/linkView";
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
    new LotteGlogisTrackingNumberValidator(replacedTrackingNumber)
        .validate();

    Document doc = getDocument(replacedTrackingNumber);

    return new LotteGlogisParsedDocument(doc)
        .getLastStatus();
  }

  private Document getDocument(String trackingNumber) {
    Document doc;
    try {
      Connection.Response response
          = Jsoup.connect(URL)
          .data("InvNo", trackingNumber)
          .method(Connection.Method.GET)
          .execute();

      doc = response.parse();
    } catch (IOException e) {
      throw new DeliveryParsingFailException(userDeliveryInfo, e);
    }
    return doc;
  }
}
