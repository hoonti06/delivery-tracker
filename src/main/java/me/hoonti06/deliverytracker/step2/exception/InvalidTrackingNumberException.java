package me.hoonti06.deliverytracker.step2.exception;

public class InvalidTrackingNumberException extends RuntimeException {

  public InvalidTrackingNumberException(final String message) {
    super(message);
  }
}
