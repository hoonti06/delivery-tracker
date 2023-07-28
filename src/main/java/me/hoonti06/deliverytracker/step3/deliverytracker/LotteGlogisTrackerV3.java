package me.hoonti06.deliverytracker.step3.deliverytracker;

import java.io.IOException;
import me.hoonti06.deliverytracker.step3.DeliveryLastStatusV3;
import me.hoonti06.deliverytracker.step3.exception.DeliveryParsingFailExceptionV3;
import me.hoonti06.deliverytracker.step3.trackingnumber.TrackingNumberV3;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LotteGlogisTrackerV3 implements DeliveryTrackerV3 {

  private static final String URL = "https://www.lotteglogis.com/home/reservation/tracking/linkView";
  private final TrackingNumberV3 trackingNumberV3;
  private final Connection connection;

  public LotteGlogisTrackerV3(final TrackingNumberV3 trackingNumberV3) {
    this(trackingNumberV3,
        Jsoup.connect(URL)
            .data("InvNo", trackingNumberV3.getNumber())
            .method(Connection.Method.GET)
    );
  }

  public LotteGlogisTrackerV3(final TrackingNumberV3 trackingNumberV3,
                              final Connection connection) {
    this.trackingNumberV3 = trackingNumberV3;
    this.connection = connection;
  }

  @Override
  public DeliveryLastStatusV3 getLastStatus() {
    return parseStatus();
  }

  private DeliveryLastStatusV3 parseStatus() {
    Document doc;
    try {
      Connection.Response response = connection.execute();
      doc = response.parse();
    } catch (IOException e) {
      throw new DeliveryParsingFailExceptionV3(trackingNumberV3, e);
    }

    LotteGlogisDocParserV3 parser = new LotteGlogisDocParserV3(doc);
    return parser.parse();
  }
}
