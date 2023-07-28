package me.hoonti06.deliverytracker.step3.exception;

import me.hoonti06.deliverytracker.step3.trackingnumber.TrackingNumber;

public class DeliveryParsingFailException extends RuntimeException {

  private final TrackingNumber trackingNumber;

  public DeliveryParsingFailException(final TrackingNumber trackingNumber,
                                      final String message) {
    super(message);
    this.trackingNumber = trackingNumber;
  }

  public DeliveryParsingFailException(final TrackingNumber trackingNumber,
                                      final Throwable e) {
    super(e);
    this.trackingNumber = trackingNumber;
  }

  public TrackingNumber getTrackingNumberV2() {
    return trackingNumber;
  }
}
