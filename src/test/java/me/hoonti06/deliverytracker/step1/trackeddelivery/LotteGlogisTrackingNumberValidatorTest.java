package me.hoonti06.deliverytracker.step1.trackeddelivery;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import me.hoonti06.deliverytracker.step1.exception.InvalidTrackingNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteGlogisTrackingNumberValidatorTest {

  @DisplayName("숫자로만 이루어진 유효한 길이의 송장 번호 검증")
  @Test
  void valid_tracking_number() {
    // given
    String trackingNumber = "123456789012";
    LotteGlogisTrackingNumberValidator validator =
        new LotteGlogisTrackingNumberValidator(trackingNumber);

    // when
    validator.validate();
  }

  @DisplayName("유효 길이보다 큰 길이의 송장번호 검증")
  @Test
  void greater_than_valid_length() {
    // given
    String trackingNumber = "1234567890123"; // 13자리
    LotteGlogisTrackingNumberValidator validator
        = new LotteGlogisTrackingNumberValidator(trackingNumber);

    // when-then
    assertThatThrownBy(validator::validate)
        .isInstanceOf(InvalidTrackingNumberException.class);
  }

  @DisplayName("유효 길이보다 작은 길이의 송장번호 검증")
  @Test
  void less_than_valid_length() {
    // given
    String trackingNumber = "12345678901"; // 11자리
    LotteGlogisTrackingNumberValidator validator
        = new LotteGlogisTrackingNumberValidator(trackingNumber);

    // when-then
    assertThatThrownBy(validator::validate)
        .isInstanceOf(InvalidTrackingNumberException.class);
  }

  @DisplayName("숫자가 아닌 문자가 포함된 송장번호 유효성 검증")
  @Test
  void contains_invalid_character() {
    // given
    String trackingNumber = "i234S6789o12";
    LotteGlogisTrackingNumberValidator validator
        = new LotteGlogisTrackingNumberValidator(trackingNumber);

    // when-then
    assertThatThrownBy(validator::validate)
        .isInstanceOf(InvalidTrackingNumberException.class);
  }
}