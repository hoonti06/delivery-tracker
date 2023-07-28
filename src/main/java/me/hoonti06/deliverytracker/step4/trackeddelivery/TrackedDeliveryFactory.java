package me.hoonti06.deliverytracker.step4.trackeddelivery;

import me.hoonti06.deliverytracker.step4.DeliveryCompany;
import me.hoonti06.deliverytracker.step4.deliverycompanyconnection.LotteGlogisConnection;
import me.hoonti06.deliverytracker.step4.UserDeliveryInfo;
import me.hoonti06.deliverytracker.step4.parseddeliverydocument.LotteGlogisParsedDocument;
import me.hoonti06.deliverytracker.step4.trackingnumber.DefaultTrackingNumber;
import me.hoonti06.deliverytracker.step4.trackingnumber.HyphenRemovedTrackingNumber;
import me.hoonti06.deliverytracker.step4.trackingnumber.OnlyDigitTrackingNumber;
import me.hoonti06.deliverytracker.step4.trackingnumber.TrackingNumber;
import me.hoonti06.deliverytracker.step4.trackingnumber.ValidLengthTrackingNumber;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class TrackedDeliveryFactory {

  private final UserDeliveryInfo userDeliveryInfo;

  public TrackedDeliveryFactory(final UserDeliveryInfo userDeliveryInfo) {
    this.userDeliveryInfo = userDeliveryInfo;
  }

  public TrackedDelivery create() {
    if (DeliveryCompany.LOTTE_GLOGIS.equals(userDeliveryInfo.getDeliveryCompany())) {
      return createLotteGlogisTrackedDelivery();
    }

    throw new IllegalArgumentException(String.format("지원하지 않는 타입: %s",
        userDeliveryInfo.getDeliveryCompany().name()));
  }

  private TrackedDelivery createLotteGlogisTrackedDelivery() {
    final TrackingNumber trackingNumber = new ValidLengthTrackingNumber(
        new OnlyDigitTrackingNumber(
            new HyphenRemovedTrackingNumber(
                new DefaultTrackingNumber(
                    userDeliveryInfo.getTrackingNumber()
                )
            )
        )
        , new int[]{12});

    final Connection connection = Jsoup.connect(
            "https://www.lotteglogis.com/home/reservation/tracking/linkView")
        .data("InvNo", trackingNumber.getNumber())
        .method(Connection.Method.GET);
    final LotteGlogisConnection lotteGlogisConnection = new LotteGlogisConnection(connection);
    final LotteGlogisParsedDocument lotteGlogisParsedDocument
        = new LotteGlogisParsedDocument(lotteGlogisConnection);
    return new LotteGlogisTrackedDelivery(lotteGlogisParsedDocument);
  }
}
