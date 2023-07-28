package me.hoonti06.deliverytracker.step0;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

public class DeliveryLastStatusStepsV0 {

  public static void 배송상태_검증(final DeliveryLastStatusV0 deliveryLastStatusV0,
                             final DeliveryStatusV0 deliveryStatus, final LocalDateTime time) {
    assertThat(deliveryLastStatusV0.getDeliveryStatusV0()).isEqualTo(deliveryStatus);
    assertThat(deliveryLastStatusV0.getTime()).isEqualTo(time);
  }
}
