package me.hoonti06.deliverytracker.step2.trackingnumber;

public class HyphenRemovedTrackingNumber implements TrackingNumber {

  private final TrackingNumber origin;

  public HyphenRemovedTrackingNumber(final TrackingNumber origin) {
    this.origin = origin;
  }

  @Override
  public String getNumber() {
    String number = origin.getNumber();
    return number.replace("-", "").trim();
  }
}
