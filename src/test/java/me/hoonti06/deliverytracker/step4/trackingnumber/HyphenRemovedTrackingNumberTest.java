package me.hoonti06.deliverytracker.step4.trackingnumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HyphenRemovedTrackingNumberTest {

  @DisplayName("hyphen이 제거된 송장번호")
  @Test
  void hyphen_removed_tracking_number() {
    // given
    TrackingNumber trackingNumber =
        new HyphenRemovedTrackingNumber(
            new DefaultTrackingNumber("1-234567890-12")
        );

    // when
    String number = trackingNumber.getNumber();

    // then
    assertThat(number).isEqualTo("123456789012");
  }

  @DisplayName("hyphen이 제거되고, 트리밍된 송장번호")
  @Test
  void hyphen_removed_and_trimmed_tracking_number() {
    // given
    TrackingNumber trackingNumber =
        new HyphenRemovedTrackingNumber(
            new DefaultTrackingNumber("  123456-789012 ")
        );

    // when
    String number = trackingNumber.getNumber();

    // then
    assertThat(number).isEqualTo("123456789012");
  }
}