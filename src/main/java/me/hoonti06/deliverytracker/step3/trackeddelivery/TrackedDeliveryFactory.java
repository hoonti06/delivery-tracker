package me.hoonti06.deliverytracker.step3.trackeddelivery;

import me.hoonti06.deliverytracker.step3.DeliveryCompany;
import me.hoonti06.deliverytracker.step3.UserDeliveryInfo;
import me.hoonti06.deliverytracker.step3.trackingnumber.DefaultTrackingNumber;
import me.hoonti06.deliverytracker.step3.trackingnumber.HyphenRemovedTrackingNumber;
import me.hoonti06.deliverytracker.step3.trackingnumber.OnlyDigitTrackingNumber;
import me.hoonti06.deliverytracker.step3.trackingnumber.ValidLengthTrackingNumber;

public class TrackedDeliveryFactory {

  private final UserDeliveryInfo userDeliveryInfo;

  public TrackedDeliveryFactory(final UserDeliveryInfo userDeliveryInfo) {
    this.userDeliveryInfo = userDeliveryInfo;
  }

  public TrackedDelivery create() {
    if (DeliveryCompany.LOTTE_GLOGIS.equals(userDeliveryInfo.getDeliveryCompany())) {
      return new LotteGlogisTrackedDelivery(
          new ValidLengthTrackingNumber(
              new OnlyDigitTrackingNumber(
                  new HyphenRemovedTrackingNumber(
                      new DefaultTrackingNumber(
                          userDeliveryInfo.getTrackingNumber()
                      )
                  )
              )
              , new int[]{12})
      );
    }

    throw new RuntimeException(String.format("지원하지 않는 타입: %s",
        userDeliveryInfo.getDeliveryCompany().name()));
  }
}
