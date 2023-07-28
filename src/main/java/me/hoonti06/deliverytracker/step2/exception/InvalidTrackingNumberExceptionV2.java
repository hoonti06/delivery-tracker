package me.hoonti06.deliverytracker.step2.exception;

import me.hoonti06.deliverytracker.step2.trackingnumber.TrackingNumberV2;

public class InvalidTrackingNumberExceptionV2 extends RuntimeException {

  private final TrackingNumberV2 trackingNumberV2;
  private final String cause;

  public InvalidTrackingNumberExceptionV2(final TrackingNumberV2 trackingNumberV2,
                                          final String cause) {
    this.trackingNumberV2 = trackingNumberV2;
    this.cause = cause;
  }

  @Override
  public String getMessage() {
    return String.format("[Company: %s, trackingNo: %s] %s",
        trackingNumberV2.getDeliveryCompany().getNameKr(),
        trackingNumberV2.getNumber(),
        cause);
  }
}
