package me.hoonti06.deliverytracker.step3.trackeddelivery;

import java.io.IOException;
import me.hoonti06.deliverytracker.step3.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step3.exception.DeliveryParsingFailException;
import me.hoonti06.deliverytracker.step3.trackingnumber.TrackingNumber;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LotteGlogisTrackedDelivery implements TrackedDelivery {

  private static final String URL = "https://www.lotteglogis.com/home/reservation/tracking/linkView";
  private final TrackingNumber trackingNumber;
  private final Connection connection;

  public LotteGlogisTrackedDelivery(final TrackingNumber trackingNumber) {
    this(trackingNumber,
        Jsoup.connect(URL)
            .data("InvNo", trackingNumber.getNumber())
            .method(Connection.Method.GET)
    );
  }

  public LotteGlogisTrackedDelivery(final TrackingNumber trackingNumber,
                                    final Connection connection) {
    this.trackingNumber = trackingNumber;
    this.connection = connection;
  }

  @Override
  public DeliveryLastStatus getLastStatus() {
    return parseStatus();
  }

  private DeliveryLastStatus parseStatus() {
    Document doc = getDocument();
    return new LotteGlogisParsedDocument(doc)
        .getLastStatus();
  }

  private Document getDocument() {
    try {
      Connection.Response response = connection.execute();
      return response.parse();
    } catch (IOException e) {
      throw new DeliveryParsingFailException(trackingNumber, e);
    }
  }
}
