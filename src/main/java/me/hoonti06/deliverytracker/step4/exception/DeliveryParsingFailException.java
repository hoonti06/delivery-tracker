package me.hoonti06.deliverytracker.step4.exception;

public class DeliveryParsingFailException extends RuntimeException {

  public DeliveryParsingFailException(final String message) {
    super(message);
  }

  public DeliveryParsingFailException(final String message, final Throwable e) {
    super(message, e);
  }
}
