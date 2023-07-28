package me.hoonti06.deliverytracker.step3.trackingnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import me.hoonti06.deliverytracker.step3.DeliveryCompanyV3;
import me.hoonti06.deliverytracker.step3.exception.InvalidTrackingNumberExceptionV3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OnlyDigitTrackingNumberV3Test {

  @DisplayName("숫자가 아닌 문자가 포함된 송장번호 유효성 검증")
  @Test
  void contains_invalid_character() {
    // given
    TrackingNumberV3 trackingNumberV3 =
        new OnlyDigitTrackingNumberV3(
            new DefaultTrackingNumberV3(
                "i234S6789o!2",
                DeliveryCompanyV3.LOTTE_GLOGIS)
        );

    // when-then
    assertThatThrownBy(trackingNumberV3::getNumber)
        .isInstanceOf(InvalidTrackingNumberExceptionV3.class)
        .hasMessage("[Company: 롯데글로벌로지스, trackingNo: i234S6789o!2] 숫자가 아닌 문자 존재");
  }

  @DisplayName("숫자로만 이루어진 송장번호 유효성 검증")
  @Test
  void contains_only_digit() {
    // given
    TrackingNumberV3 trackingNumberV3 =
        new OnlyDigitTrackingNumberV3(
            new DefaultTrackingNumberV3(
                "1234567890",
                DeliveryCompanyV3.LOTTE_GLOGIS)
        );

    // when
    String number = trackingNumberV3.getNumber();

    // then
    assertThat(number).isEqualTo("1234567890");
  }
}