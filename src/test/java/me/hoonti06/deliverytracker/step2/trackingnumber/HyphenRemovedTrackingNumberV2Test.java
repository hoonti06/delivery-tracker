package me.hoonti06.deliverytracker.step2.trackingnumber;

import static org.assertj.core.api.Assertions.assertThat;

import me.hoonti06.deliverytracker.step2.DeliveryCompanyV2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HyphenRemovedTrackingNumberV2Test {

  @DisplayName("hyphen이 제거된 송장번호")
  @Test
  void hyphen_removed_tracking_number() {
    // given
    TrackingNumberV2 trackingNumberV2 =
        new HyphenRemovedTrackingNumberV2(
            new DefaultTrackingNumberV2(
                "1-234567890-12",
                DeliveryCompanyV2.LOTTE_GLOGIS)
        );

    // when
    String number = trackingNumberV2.getNumber();

    // then
    assertThat(number).isEqualTo("123456789012");
  }

  @DisplayName("hyphen이 제거되고, 트리밍된 송장번호")
  @Test
  void hyphen_removed_and_trimmed_tracking_number() {
    // given
    TrackingNumberV2 trackingNumberV2 =
        new HyphenRemovedTrackingNumberV2(
            new DefaultTrackingNumberV2(
                "  123456-789012 ",
                DeliveryCompanyV2.LOTTE_GLOGIS)
        );

    // when
    String number = trackingNumberV2.getNumber();

    // then
    assertThat(number).isEqualTo("123456789012");
  }
}