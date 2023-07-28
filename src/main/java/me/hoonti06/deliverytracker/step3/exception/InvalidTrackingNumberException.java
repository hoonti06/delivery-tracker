package me.hoonti06.deliverytracker.step3.exception;

public class InvalidTrackingNumberException extends RuntimeException {

  public InvalidTrackingNumberException(final String mmessage) {
    super(mmessage);
  }
}
