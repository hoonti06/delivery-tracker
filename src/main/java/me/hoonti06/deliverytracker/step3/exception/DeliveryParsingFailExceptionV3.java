package me.hoonti06.deliverytracker.step3.exception;

import me.hoonti06.deliverytracker.step3.trackingnumber.TrackingNumberV3;

public class DeliveryParsingFailExceptionV3 extends RuntimeException {

  private final TrackingNumberV3 trackingNumberV3;

  public DeliveryParsingFailExceptionV3(final TrackingNumberV3 trackingNumberV3,
                                        final String message) {
    super(message);
    this.trackingNumberV3 = trackingNumberV3;
  }

  public DeliveryParsingFailExceptionV3(final TrackingNumberV3 trackingNumberV3,
                                        final Throwable e) {
    super(e);
    this.trackingNumberV3 = trackingNumberV3;
  }

  public TrackingNumberV3 getTrackingNumberV2() {
    return trackingNumberV3;
  }
}
