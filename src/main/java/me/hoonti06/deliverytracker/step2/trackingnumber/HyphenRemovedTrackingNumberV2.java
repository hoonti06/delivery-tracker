package me.hoonti06.deliverytracker.step2.trackingnumber;

import me.hoonti06.deliverytracker.step2.DeliveryCompanyV2;

public class HyphenRemovedTrackingNumberV2 implements TrackingNumberV2 {

  private final TrackingNumberV2 origin;

  public HyphenRemovedTrackingNumberV2(final TrackingNumberV2 origin) {
    this.origin = origin;
  }

  @Override
  public String getNumber() {
    String number = origin.getNumber();
    return number.replace("-", "").trim();
  }

  @Override
  public DeliveryCompanyV2 getDeliveryCompany() {
    return origin.getDeliveryCompany();
  }
}
