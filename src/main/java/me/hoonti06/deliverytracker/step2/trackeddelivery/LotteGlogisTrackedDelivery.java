package me.hoonti06.deliverytracker.step2.trackeddelivery;

import java.io.IOException;
import me.hoonti06.deliverytracker.step2.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step2.exception.DeliveryParsingFailException;
import me.hoonti06.deliverytracker.step2.trackingnumber.TrackingNumber;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LotteGlogisTrackedDelivery implements TrackedDelivery {

  private static final String URL = "https://www.lotteglogis.com/home/reservation/tracking/linkView";
  private final TrackingNumber trackingNumber;

  public LotteGlogisTrackedDelivery(final TrackingNumber trackingNumber) {
    this.trackingNumber = trackingNumber;
  }

  @Override
  public DeliveryLastStatus getLastStatus() {
    Document doc = getDocument();
    return new LotteGlogisParsedDocument(doc).getLastStatus();
  }

  private Document getDocument() {
    try {
      Connection.Response response
          = Jsoup.connect(URL)
          .data("InvNo", trackingNumber.getNumber())
          .method(Connection.Method.GET)
          .execute();

      return response.parse();
    } catch (IOException e) {
      throw new DeliveryParsingFailException("IO 예외 발생", e);
    }
  }
}
