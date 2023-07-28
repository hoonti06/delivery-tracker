package me.hoonti06.deliverytracker.step3.deliverytracker;

import me.hoonti06.deliverytracker.step3.DeliveryCompanyV3;
import me.hoonti06.deliverytracker.step3.UserDeliveryInfoV3;
import me.hoonti06.deliverytracker.step3.trackingnumber.DefaultTrackingNumberV3;
import me.hoonti06.deliverytracker.step3.trackingnumber.HyphenRemovedTrackingNumberV3;
import me.hoonti06.deliverytracker.step3.trackingnumber.OnlyDigitTrackingNumberV3;
import me.hoonti06.deliverytracker.step3.trackingnumber.ValidLengthTrackingNumberV3;

public class DeliveryTrackerFactoryV3 {

  private final UserDeliveryInfoV3 userDeliveryInfoV3;

  public DeliveryTrackerFactoryV3(final UserDeliveryInfoV3 userDeliveryInfoV3) {
    this.userDeliveryInfoV3 = userDeliveryInfoV3;
  }

  public DeliveryTrackerV3 create() {
    if (DeliveryCompanyV3.LOTTE_GLOGIS.equals(userDeliveryInfoV3.getDeliveryCompany())) {
      return new LotteGlogisTrackerV3(
          new ValidLengthTrackingNumberV3(
              new OnlyDigitTrackingNumberV3(
                  new HyphenRemovedTrackingNumberV3(
                      new DefaultTrackingNumberV3(
                          userDeliveryInfoV3.getTrackingNumber(),
                          DeliveryCompanyV3.LOTTE_GLOGIS
                      )
                  )
              )
              , new int[]{12})
      );
    }

    throw new RuntimeException(String.format("지원하지 않는 타입: %s",
        userDeliveryInfoV3.getDeliveryCompany().name()));
  }
}
