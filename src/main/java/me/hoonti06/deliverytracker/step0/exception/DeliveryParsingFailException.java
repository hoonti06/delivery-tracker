package me.hoonti06.deliverytracker.step0.exception;

import me.hoonti06.deliverytracker.step0.UserDeliveryInfo;

public class DeliveryParsingFailException extends RuntimeException {

  private final UserDeliveryInfo userDeliveryInfo;

  public DeliveryParsingFailException(final UserDeliveryInfo userDeliveryInfo,
                                      final String message) {
    super(message);
    this.userDeliveryInfo = userDeliveryInfo;
  }

  public DeliveryParsingFailException(final UserDeliveryInfo userDeliveryInfo,
                                      final String message, final Throwable e) {
    super(message, e);
    this.userDeliveryInfo = userDeliveryInfo;
  }

  @Override
  public String getMessage() {
    return String.format("userInfo : %s, message : %s", userDeliveryInfo , super.getMessage());
  }
}
