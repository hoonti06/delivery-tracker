package me.hoonti06.deliverytracker.step3;

import java.time.LocalDateTime;

public class DeliveryLastStatus {

  private final DeliveryStatus deliveryStatus;
  private final LocalDateTime time;

  public DeliveryLastStatus(final DeliveryStatus deliveryStatus, final LocalDateTime time) {
    this.deliveryStatus = deliveryStatus;
    this.time = time;
  }

  public DeliveryStatus getDeliveryStatusV2() {
    return deliveryStatus;
  }

  public LocalDateTime getTime() {
    return time;
  }
}
