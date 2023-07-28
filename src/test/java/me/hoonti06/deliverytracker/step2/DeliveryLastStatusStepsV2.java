package me.hoonti06.deliverytracker.step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

public class DeliveryLastStatusStepsV2 {

  public static void 배송상태_검증(final DeliveryLastStatusV2 deliveryLastStatusV2,
                             final DeliveryStatusV2 deliveryStatus, final LocalDateTime time) {
    assertThat(deliveryLastStatusV2.getDeliveryStatusV2()).isEqualTo(deliveryStatus);
    assertThat(deliveryLastStatusV2.getTime()).isEqualTo(time);
  }
}
