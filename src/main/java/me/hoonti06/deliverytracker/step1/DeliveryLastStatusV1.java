package me.hoonti06.deliverytracker.step1;

import java.time.LocalDateTime;

public class DeliveryLastStatusV1 {

  private final DeliveryStatusV1 deliveryStatusV1;
  private final LocalDateTime time;

  public DeliveryLastStatusV1(final DeliveryStatusV1 deliveryStatusV1, final LocalDateTime time) {
    this.deliveryStatusV1 = deliveryStatusV1;
    this.time = time;
  }

  public DeliveryStatusV1 getDeliveryStatusV1() {
    return deliveryStatusV1;
  }

  public LocalDateTime getTime() {
    return time;
  }
}
