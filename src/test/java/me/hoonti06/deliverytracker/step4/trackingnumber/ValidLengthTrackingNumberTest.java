package me.hoonti06.deliverytracker.step4.trackingnumber;

import me.hoonti06.deliverytracker.step4.exception.InvalidTrackingNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidLengthTrackingNumberTest {

  @DisplayName("유효한 길이의 송장 번호 검증")
  @Test
  void valid_length_tracking_number() {
    // given
    TrackingNumber trackingNumber =
        new ValidLengthTrackingNumber(
            new DefaultTrackingNumber(
                "12345678"
            ),
            new int[]{8}
        );

    // when
    String number = trackingNumber.getNumber();

    // then
    assertThat(number).isEqualTo("12345678");
  }

  @DisplayName("hyphen이 포함된 유효한 길이의 송장 번호 검증")
  @Test
  void hypphen_included_in_and_valid_length_tracking_number() {
    // given
    TrackingNumber trackingNumber =
        new ValidLengthTrackingNumber(
            new DefaultTrackingNumber(
                "1-3-5-7-9-1-"
            ),
            new int[]{12}
        );

    // when
    String number = trackingNumber.getNumber();

    // then
    assertThat(number).isEqualTo("1-3-5-7-9-1-");
  }


  @DisplayName("유효 길이보다 큰 길이의 송장번호 검증")
  @Test
  void greater_than_valid_length() {
    // given
      TrackingNumber trackingNumber =
        new ValidLengthTrackingNumber(
            new DefaultTrackingNumber(
                "12345678901"
            ),
            new int[]{10}
        );

    // when-then
    assertThatThrownBy(trackingNumber::getNumber)
        .isInstanceOf(InvalidTrackingNumberException.class)
        .hasMessage("유효 길이: [10]");
  }

  @DisplayName("유효 길이보다 작은 길이의 송장번호 검증")
  @Test
  void less_than_valid_length() {
    // given
    TrackingNumber trackingNumber =
        new ValidLengthTrackingNumber(
            new DefaultTrackingNumber(
                "12345678901"
            ),
            new int[]{10}
        );

    // when-then
    assertThatThrownBy(trackingNumber::getNumber)
        .isInstanceOf(InvalidTrackingNumberException.class)
        .hasMessage("유효 길이: [10]");
  }

  @DisplayName("유효 길이 리스트에 포함되지 않는 길이의 송장번호 검증")
  @Test
  void not_included_in_valid_length_list() {
    // given
    TrackingNumber trackingNumber =
        new ValidLengthTrackingNumber(
            new DefaultTrackingNumber(
                "1234567890"
            ),
            new int[]{9, 11}
        );

    // when-then
    assertThatThrownBy(trackingNumber::getNumber)
        .isInstanceOf(InvalidTrackingNumberException.class)
        .hasMessage("유효 길이: [9, 11]");
  }

}