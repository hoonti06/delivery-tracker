package me.hoonti06.deliverytracker.step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

public class DeliveryLastStatusStepsV1 {

  public static void 배송상태_검증(final DeliveryLastStatusV1 deliveryLastStatusV1,
                             final DeliveryStatusV1 deliveryStatus, final LocalDateTime time) {
    assertThat(deliveryLastStatusV1.getDeliveryStatusV1()).isEqualTo(deliveryStatus);
    assertThat(deliveryLastStatusV1.getTime()).isEqualTo(time);
  }
}
