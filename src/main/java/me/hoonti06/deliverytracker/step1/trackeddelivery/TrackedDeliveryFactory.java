package me.hoonti06.deliverytracker.step1.trackeddelivery;

import me.hoonti06.deliverytracker.step1.DeliveryCompany;
import me.hoonti06.deliverytracker.step1.UserDeliveryInfo;

public class TrackedDeliveryFactory {

  private final UserDeliveryInfo userDeliveryInfo;

  public TrackedDeliveryFactory(final UserDeliveryInfo userDeliveryInfo) {
    this.userDeliveryInfo = userDeliveryInfo;
  }

  public TrackedDelivery create() {
    if (DeliveryCompany.LOTTE_GLOGIS.equals(userDeliveryInfo.getDeliveryCompany())) {
      return new LotteGlogisTrackedDelivery(userDeliveryInfo);
    }

    throw new RuntimeException(String.format("지원하지 않는 타입: %s",
        userDeliveryInfo.getDeliveryCompany().name()));
  }
}
