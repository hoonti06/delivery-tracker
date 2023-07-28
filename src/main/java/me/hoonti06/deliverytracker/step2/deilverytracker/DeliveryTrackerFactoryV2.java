package me.hoonti06.deliverytracker.step2.deilverytracker;

import me.hoonti06.deliverytracker.step2.DeliveryCompanyV2;
import me.hoonti06.deliverytracker.step2.UserDeliveryInfoV2;
import me.hoonti06.deliverytracker.step2.trackingnumber.DefaultTrackingNumberV2;
import me.hoonti06.deliverytracker.step2.trackingnumber.HyphenRemovedTrackingNumberV2;
import me.hoonti06.deliverytracker.step2.trackingnumber.OnlyDigitTrackingNumberV2;
import me.hoonti06.deliverytracker.step2.trackingnumber.ValidLengthTrackingNumberV2;

public class DeliveryTrackerFactoryV2 {

  private final UserDeliveryInfoV2 userDeliveryInfoV2;

  public DeliveryTrackerFactoryV2(final UserDeliveryInfoV2 userDeliveryInfoV2) {
    this.userDeliveryInfoV2 = userDeliveryInfoV2;
  }

  public DeliveryTrackerV2 create() {
    if (DeliveryCompanyV2.LOTTE_GLOGIS.equals(userDeliveryInfoV2.getDeliveryCompany())) {
      return new LotteGlogisTrackerV2(
          new ValidLengthTrackingNumberV2(
              new OnlyDigitTrackingNumberV2(
                  new HyphenRemovedTrackingNumberV2(
                      new DefaultTrackingNumberV2(
                          userDeliveryInfoV2.getTrackingNumber(),
                          DeliveryCompanyV2.LOTTE_GLOGIS
                      )
                  )
              )
              , new int[]{12})
      );
    }

    throw new RuntimeException(String.format("지원하지 않는 타입: %s",
        userDeliveryInfoV2.getDeliveryCompany().name()));
  }
}
