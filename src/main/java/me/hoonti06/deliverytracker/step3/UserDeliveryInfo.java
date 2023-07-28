package me.hoonti06.deliverytracker.step3;

import me.hoonti06.deliverytracker.UserId;

public class UserDeliveryInfo {

  private final UserId userId;
  private final String trackingNumber;
  private final DeliveryCompany deliveryCompany;

  public UserDeliveryInfo(final UserId userId,
                          final String trackingNumber,
                          final DeliveryCompany deliveryCompany) {
    this.userId = userId;
    this.trackingNumber = trackingNumber;
    this.deliveryCompany = deliveryCompany;
  }

  public String getTrackingNumber() {
    return trackingNumber;
  }

  public DeliveryCompany getDeliveryCompany() {
    return deliveryCompany;
  }
}
