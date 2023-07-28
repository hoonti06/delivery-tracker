package me.hoonti06.deliverytracker.step3;

import me.hoonti06.deliverytracker.UserId;

public class UserDeliveryInfoV3 {

  private final UserId userId;
  private final String trackingNumber;
  private final DeliveryCompanyV3 deliveryCompanyV3;

  public UserDeliveryInfoV3(final UserId userId,
                            final String trackingNumber,
                            final DeliveryCompanyV3 deliveryCompanyV3) {
    this.userId = userId;
    this.trackingNumber = trackingNumber;
    this.deliveryCompanyV3 = deliveryCompanyV3;
  }

  public String getTrackingNumber() {
    return trackingNumber;
  }

  public DeliveryCompanyV3 getDeliveryCompany() {
    return deliveryCompanyV3;
  }
}
