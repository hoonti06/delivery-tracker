package me.hoonti06.deliverytracker.step0.exception;

import me.hoonti06.deliverytracker.step0.UserDeliveryInfoV0;

public class DeliveryParsingFailExceptionV0 extends RuntimeException {

  private final UserDeliveryInfoV0 userDeliveryInfoV0;

  public DeliveryParsingFailExceptionV0(final UserDeliveryInfoV0 userDeliveryInfoV0,
                                        final String message) {
    super(message);
    this.userDeliveryInfoV0 = userDeliveryInfoV0;
  }

  public DeliveryParsingFailExceptionV0(final UserDeliveryInfoV0 userDeliveryInfoV0,
                                        final String message, final Throwable e) {
    super(message, e);
    this.userDeliveryInfoV0 = userDeliveryInfoV0;
  }

  public UserDeliveryInfoV0 getUserDeliveryInfo() {
    return userDeliveryInfoV0;
  }

}
