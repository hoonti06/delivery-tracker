package me.hoonti06.deliverytracker.step1.deliverytracker;

import me.hoonti06.deliverytracker.step1.DeliveryCompanyV1;
import me.hoonti06.deliverytracker.step1.UserDeliveryInfoV1;

public class DeliveryTrackerFactoryV1 {

  private final UserDeliveryInfoV1 userDeliveryInfoV1;

  public DeliveryTrackerFactoryV1(final UserDeliveryInfoV1 userDeliveryInfoV1) {
    this.userDeliveryInfoV1 = userDeliveryInfoV1;
  }

  public DeliveryTrackerV1 create() {
    if (DeliveryCompanyV1.LOTTE_GLOGIS.equals(userDeliveryInfoV1.getDeliveryCompany())) {
      return new LotteGlogisTrackerV1(userDeliveryInfoV1);
    }

    throw new RuntimeException(String.format("지원하지 않는 타입: %s",
        userDeliveryInfoV1.getDeliveryCompany().name()));
  }
}
