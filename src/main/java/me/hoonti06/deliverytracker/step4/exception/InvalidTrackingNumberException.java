package me.hoonti06.deliverytracker.step4.exception;

public class InvalidTrackingNumberException extends RuntimeException {

  public InvalidTrackingNumberException(final String mmessage) {
    super(mmessage);
  }
}
