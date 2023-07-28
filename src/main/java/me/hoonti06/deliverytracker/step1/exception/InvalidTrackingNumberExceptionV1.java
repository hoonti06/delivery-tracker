package me.hoonti06.deliverytracker.step1.exception;

public class InvalidTrackingNumberExceptionV1 extends RuntimeException {

  private final String trackingNumber;
  private final String cause;

  public InvalidTrackingNumberExceptionV1(final String trackingNumber, final String cause) {
    this.trackingNumber = trackingNumber;
    this.cause = cause;
  }

  @Override
  public String getMessage() {
    return String.format("[trackingNo : %s] %s", trackingNumber, cause);
  }
}
