package me.hoonti06.deliverytracker.step3.exception;

import me.hoonti06.deliverytracker.step3.trackingnumber.TrackingNumberV3;

public class InvalidTrackingNumberExceptionV3 extends RuntimeException {

  private final TrackingNumberV3 trackingNumberV3;
  private final String cause;

  public InvalidTrackingNumberExceptionV3(final TrackingNumberV3 trackingNumberV3,
                                          final String cause) {
    this.trackingNumberV3 = trackingNumberV3;
    this.cause = cause;
  }

  @Override
  public String getMessage() {
    return String.format("[Company: %s, trackingNo: %s] %s",
        trackingNumberV3.getDeliveryCompany().getNameKr(),
        trackingNumberV3.getNumber(),
        cause);
  }
}
