package me.hoonti06.deliverytracker.step2;

import me.hoonti06.deliverytracker.UserId;

public class UserDeliveryInfoV2 {

  private final UserId userId;
  private final String trackingNumber;
  private final DeliveryCompanyV2 deliveryCompanyV2;

  public UserDeliveryInfoV2(final UserId userId,
                            final String trackingNumber,
                            final DeliveryCompanyV2 deliveryCompanyV2) {
    this.userId = userId;
    this.trackingNumber = trackingNumber;
    this.deliveryCompanyV2 = deliveryCompanyV2;
  }

  public String getTrackingNumber() {
    return trackingNumber;
  }

  public DeliveryCompanyV2 getDeliveryCompany() {
    return deliveryCompanyV2;
  }
}
