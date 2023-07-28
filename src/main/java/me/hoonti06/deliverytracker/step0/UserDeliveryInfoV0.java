package me.hoonti06.deliverytracker.step0;

import me.hoonti06.deliverytracker.UserId;

public class UserDeliveryInfoV0 {

  private final UserId userId;
  private final String trackingNumber;
  private final DeliveryCompanyV0 deliveryCompanyV0;

  public UserDeliveryInfoV0(final UserId userId,
                            final String trackingNumber,
                            final DeliveryCompanyV0 deliveryCompanyV0) {
    this.userId = userId;
    this.trackingNumber = trackingNumber;
    this.deliveryCompanyV0 = deliveryCompanyV0;
  }

  public String getTrackingNumber() {
    return trackingNumber;
  }

  public DeliveryCompanyV0 getDeliveryCompany() {
    return deliveryCompanyV0;
  }

}
