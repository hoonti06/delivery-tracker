package me.hoonti06.deliverytracker.step2.deilverytracker;

import java.io.IOException;
import me.hoonti06.deliverytracker.step2.DeliveryLastStatusV2;
import me.hoonti06.deliverytracker.step2.exception.DeliveryParsingFailExceptionV2;
import me.hoonti06.deliverytracker.step2.trackingnumber.TrackingNumberV2;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LotteGlogisTrackerV2 implements DeliveryTrackerV2 {

  private static final String URL = "https://www.lotteglogis.com/home/reservation/tracking/linkView";
  private final TrackingNumberV2 trackingNumberV2;

  public LotteGlogisTrackerV2(final TrackingNumberV2 trackingNumberV2) {
    this.trackingNumberV2 = trackingNumberV2;
  }

  @Override
  public DeliveryLastStatusV2 getLastStatus() {
    return validateTrackingNumberAndGetStatus();
  }

  private DeliveryLastStatusV2 validateTrackingNumberAndGetStatus() {
    Document doc;
    try {
      Connection.Response response
          = Jsoup.connect(URL)
          .data("InvNo", trackingNumberV2.getNumber())
          .method(Connection.Method.GET)
          .execute();

      doc = response.parse();
    } catch (IOException e) {
      throw new DeliveryParsingFailExceptionV2(trackingNumberV2, e);
    }

    LotteGlogisDocParserV2 parser = new LotteGlogisDocParserV2(doc);
    return parser.parse();
  }
}
