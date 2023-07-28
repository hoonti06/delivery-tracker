package me.hoonti06.deliverytracker.step1.exception;

import me.hoonti06.deliverytracker.step1.UserDeliveryInfoV1;

public class DeliveryParsingFailExceptionV1 extends RuntimeException {

  private final UserDeliveryInfoV1 userDeliveryInfoV1;

  public DeliveryParsingFailExceptionV1(final UserDeliveryInfoV1 userDeliveryInfoV1,
                                        final String message) {
    super(message);
    this.userDeliveryInfoV1 = userDeliveryInfoV1;
  }

  public DeliveryParsingFailExceptionV1(final UserDeliveryInfoV1 userDeliveryInfoV1,
                                        final Throwable e) {
    super(e);
    this.userDeliveryInfoV1 = userDeliveryInfoV1;
  }

  public UserDeliveryInfoV1 getUserDeliveryInfo() {
    return userDeliveryInfoV1;
  }

}
