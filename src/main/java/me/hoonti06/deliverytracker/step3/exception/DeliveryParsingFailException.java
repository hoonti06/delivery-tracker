package me.hoonti06.deliverytracker.step3.exception;

import me.hoonti06.deliverytracker.step3.trackingnumber.TrackingNumber;

public class DeliveryParsingFailException extends RuntimeException {

  public DeliveryParsingFailException(final String message) {
    super(message);
  }

  public DeliveryParsingFailException(final String message, final Throwable e) {
    super(message, e);
  }
}
