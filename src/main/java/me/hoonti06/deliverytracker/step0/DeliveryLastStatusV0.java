package me.hoonti06.deliverytracker.step0;

import java.time.LocalDateTime;

public class DeliveryLastStatusV0 {

  private final DeliveryStatusV0 deliveryStatusV0;
  private final LocalDateTime time;

  public DeliveryLastStatusV0(final DeliveryStatusV0 deliveryStatusV0, final LocalDateTime time) {
    this.deliveryStatusV0 = deliveryStatusV0;
    this.time = time;
  }

  public DeliveryStatusV0 getDeliveryStatusV0() {
    return deliveryStatusV0;
  }

  public LocalDateTime getTime() {
    return time;
  }
}
