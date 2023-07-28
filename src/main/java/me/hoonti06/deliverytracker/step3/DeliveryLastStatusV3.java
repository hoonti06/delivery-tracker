package me.hoonti06.deliverytracker.step3;

import java.time.LocalDateTime;

public class DeliveryLastStatusV3 {

  private final DeliveryStatusV3 deliveryStatusV3;
  private final LocalDateTime time;

  public DeliveryLastStatusV3(final DeliveryStatusV3 deliveryStatusV3, final LocalDateTime time) {
    this.deliveryStatusV3 = deliveryStatusV3;
    this.time = time;
  }

  public DeliveryStatusV3 getDeliveryStatusV2() {
    return deliveryStatusV3;
  }

  public LocalDateTime getTime() {
    return time;
  }
}
