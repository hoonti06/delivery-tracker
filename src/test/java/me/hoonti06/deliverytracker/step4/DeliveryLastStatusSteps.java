package me.hoonti06.deliverytracker.step4;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DeliveryLastStatusSteps {

  public static void 배송상태_검증(final DeliveryLastStatus deliveryLastStatus,
                             final DeliveryStatus deliveryStatus, final LocalDateTime time) {
    assertThat(deliveryLastStatus.getDeliveryStatusV2()).isEqualTo(deliveryStatus);
    assertThat(deliveryLastStatus.getTime()).isEqualTo(time);
  }
}
