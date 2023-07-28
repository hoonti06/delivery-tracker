package me.hoonti06.deliverytracker.step0.deliverytracker;

import me.hoonti06.deliverytracker.step0.DeliveryCompanyV0;
import me.hoonti06.deliverytracker.step0.UserDeliveryInfoV0;

public class DeliveryTrackerFactoryV0 {

  private final UserDeliveryInfoV0 userDeliveryInfoV0;

  public DeliveryTrackerFactoryV0(final UserDeliveryInfoV0 userDeliveryInfoV0) {
    this.userDeliveryInfoV0 = userDeliveryInfoV0;
  }

  public DeliveryTrackerV0 create() {
    if (DeliveryCompanyV0.LOTTE_GLOGIS.equals(userDeliveryInfoV0.getDeliveryCompany())) {
      return new LotteGlogisTrackerV0(userDeliveryInfoV0);
    }

    throw new RuntimeException(String.format("지원하지 않는 타입: %s",
        userDeliveryInfoV0.getDeliveryCompany().name()));
  }
}
