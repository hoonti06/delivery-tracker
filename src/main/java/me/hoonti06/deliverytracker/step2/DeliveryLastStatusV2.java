package me.hoonti06.deliverytracker.step2;

import java.time.LocalDateTime;

public class DeliveryLastStatusV2 {

  private final DeliveryStatusV2 deliveryStatusV2;
  private final LocalDateTime time;

  public DeliveryLastStatusV2(DeliveryStatusV2 deliveryStatusV2, LocalDateTime time) {
    this.deliveryStatusV2 = deliveryStatusV2;
    this.time = time;
  }

  public DeliveryStatusV2 getDeliveryStatusV2() {
    return deliveryStatusV2;
  }

  public LocalDateTime getTime() {
    return time;
  }
}
