package me.hoonti06.deliverytracker.step4.trackingnumber;

public class DefaultTrackingNumber implements TrackingNumber {

  private final String number;

  public DefaultTrackingNumber(final String trackingNumber) {
    this.number = trackingNumber;
  }

  @Override
  public String getNumber() {
    return number;
  }
}
