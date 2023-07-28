package me.hoonti06.deliverytracker.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

public class DeliveryLastStatusStepsV3 {

  public static void 배송상태_검증(final DeliveryLastStatusV3 deliveryLastStatusV3,
                             final DeliveryStatusV3 deliveryStatus, final LocalDateTime time) {
    assertThat(deliveryLastStatusV3.getDeliveryStatusV2()).isEqualTo(deliveryStatus);
    assertThat(deliveryLastStatusV3.getTime()).isEqualTo(time);
  }
}
