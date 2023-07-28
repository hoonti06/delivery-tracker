package me.hoonti06.deliverytracker.step3.trackingnumber;

import me.hoonti06.deliverytracker.step3.DeliveryCompanyV3;

public class HyphenRemovedTrackingNumberV3 implements TrackingNumberV3 {

  private final TrackingNumberV3 origin;

  public HyphenRemovedTrackingNumberV3(final TrackingNumberV3 origin) {
    this.origin = origin;
  }

  @Override
  public String getNumber() {
    String number = origin.getNumber();
    return number.replace("-", "").trim();
  }

  @Override
  public DeliveryCompanyV3 getDeliveryCompany() {
    return origin.getDeliveryCompany();
  }
}
