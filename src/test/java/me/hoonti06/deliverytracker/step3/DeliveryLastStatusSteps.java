package me.hoonti06.deliverytracker.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

public class DeliveryLastStatusSteps {

  public static void 배송상태_검증(final DeliveryLastStatus deliveryLastStatus,
                             final DeliveryStatus deliveryStatus, final LocalDateTime time) {
    assertThat(deliveryLastStatus.getDeliveryStatusV2()).isEqualTo(deliveryStatus);
    assertThat(deliveryLastStatus.getTime()).isEqualTo(time);
  }
}