package me.hoonti06.deliverytracker.step2.exception;

public class DeliveryParsingFailException extends RuntimeException {

  public DeliveryParsingFailException(final String message, final Throwable e) {
    super(message, e);
  }
}
