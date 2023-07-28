package me.hoonti06.deliverytracker.step1;

import me.hoonti06.deliverytracker.UserId;

public class UserDeliveryInfoV1 {

  private final UserId userId;
  private final String trackingNumber;
  private final DeliveryCompanyV1 deliveryCompanyV1;

  public UserDeliveryInfoV1(final UserId userId,
                            final String trackingNumber,
                            final DeliveryCompanyV1 deliveryCompanyV1) {
    this.userId = userId;
    this.trackingNumber = trackingNumber;
    this.deliveryCompanyV1 = deliveryCompanyV1;
  }

  public String getTrackingNumber() {
    return trackingNumber;
  }

  public DeliveryCompanyV1 getDeliveryCompany() {
    return deliveryCompanyV1;
  }
}
