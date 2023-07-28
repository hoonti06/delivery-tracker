package me.hoonti06.deliverytracker.step2.exception;

import me.hoonti06.deliverytracker.step2.trackingnumber.TrackingNumberV2;

public class DeliveryParsingFailExceptionV2 extends RuntimeException {

  private final TrackingNumberV2 trackingNumberV2;

  public DeliveryParsingFailExceptionV2(final TrackingNumberV2 trackingNumberV2,
                                        final String message) {
    super(message);
    this.trackingNumberV2 = trackingNumberV2;
  }

  public DeliveryParsingFailExceptionV2(final TrackingNumberV2 trackingNumberV2,
                                        final Throwable e) {
    super(e);
    this.trackingNumberV2 = trackingNumberV2;
  }

  public TrackingNumberV2 getTrackingNumberV2() {
    return trackingNumberV2;
  }
}
