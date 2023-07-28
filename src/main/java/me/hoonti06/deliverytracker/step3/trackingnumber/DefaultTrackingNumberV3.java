package me.hoonti06.deliverytracker.step3.trackingnumber;

import me.hoonti06.deliverytracker.step3.DeliveryCompanyV3;

public class DefaultTrackingNumberV3 implements TrackingNumberV3 {

  private final String number;
  private final DeliveryCompanyV3 deliveryCompany;

  public DefaultTrackingNumberV3(final String trackingNumber,
                                 final DeliveryCompanyV3 deliveryCompany) {
    this.number = trackingNumber;
    this.deliveryCompany = deliveryCompany;
  }

  @Override
  public String getNumber() {
    return number;
  }

  @Override
  public DeliveryCompanyV3 getDeliveryCompany() {
    return deliveryCompany;
  }
}

