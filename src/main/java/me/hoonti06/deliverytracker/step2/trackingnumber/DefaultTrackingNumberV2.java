package me.hoonti06.deliverytracker.step2.trackingnumber;

import me.hoonti06.deliverytracker.step2.DeliveryCompanyV2;

public class DefaultTrackingNumberV2 implements TrackingNumberV2 {

  private final String number;
  private final DeliveryCompanyV2 deliveryCompany;

  public DefaultTrackingNumberV2(final String trackingNumber,
                                 final DeliveryCompanyV2 deliveryCompany) {
    this.number = trackingNumber;
    this.deliveryCompany = deliveryCompany;
  }

  @Override
  public String getNumber() {
    return number;
  }

  @Override
  public DeliveryCompanyV2 getDeliveryCompany() {
    return deliveryCompany;
  }
}

