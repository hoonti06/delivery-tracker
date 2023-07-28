package me.hoonti06.deliverytracker.step1.exception;

import me.hoonti06.deliverytracker.step1.UserDeliveryInfo;

public class DeliveryParsingFailException extends RuntimeException {

  private final UserDeliveryInfo userDeliveryInfo;

  public DeliveryParsingFailException(final UserDeliveryInfo userDeliveryInfo,
                                      final String message) {
    super(message);
    this.userDeliveryInfo = userDeliveryInfo;
  }

  public DeliveryParsingFailException(final UserDeliveryInfo userDeliveryInfo,
                                      final Throwable e) {
    super(e);
    this.userDeliveryInfo = userDeliveryInfo;
  }

  public UserDeliveryInfo getUserDeliveryInfo() {
    return userDeliveryInfo;
  }

}
