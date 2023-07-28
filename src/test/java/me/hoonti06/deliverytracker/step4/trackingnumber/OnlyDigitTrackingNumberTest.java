package me.hoonti06.deliverytracker.step4.trackingnumber;

import me.hoonti06.deliverytracker.step4.exception.InvalidTrackingNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OnlyDigitTrackingNumberTest {

  @DisplayName("숫자가 아닌 문자가 포함된 송장번호 유효성 검증")
  @Test
  void contains_invalid_character() {
    // given
    TrackingNumber trackingNumber =
        new OnlyDigitTrackingNumber(
            new DefaultTrackingNumber("i234S6789o!2")
        );

    // when-then
    assertThatThrownBy(trackingNumber::getNumber)
        .isInstanceOf(InvalidTrackingNumberException.class)
        .hasMessage("숫자가 아닌 문자 존재");
  }

  @DisplayName("숫자로만 이루어진 송장번호 유효성 검증")
  @Test
  void contains_only_digit() {
    // given
    TrackingNumber trackingNumber =
        new OnlyDigitTrackingNumber(
            new DefaultTrackingNumber("1234567890")
        );

    // when
    String number = trackingNumber.getNumber();

    // then
    assertThat(number).isEqualTo("1234567890");
  }
}