package me.hoonti06.deliverytracker.step2;

import java.time.LocalDateTime;

public class DeliveryLastStatus {

  private final DeliveryStatus deliveryStatus;
  private final LocalDateTime time;

  public DeliveryLastStatus(DeliveryStatus deliveryStatus, LocalDateTime time) {
    this.deliveryStatus = deliveryStatus;
    this.time = time;
  }

  public DeliveryStatus getDeliveryStatus() {
    return deliveryStatus;
  }

  public LocalDateTime getTime() {
    return time;
  }
}
