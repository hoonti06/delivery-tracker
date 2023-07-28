package me.hoonti06.deliverytracker.step2.trackingnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import me.hoonti06.deliverytracker.step2.DeliveryCompanyV2;
import me.hoonti06.deliverytracker.step2.exception.InvalidTrackingNumberExceptionV2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OnlyDigitTrackingNumberV2Test {

  @DisplayName("숫자가 아닌 문자가 포함된 송장번호 유효성 검증")
  @Test
  void contains_invalid_character() {
    // given
    TrackingNumberV2 trackingNumberV2 =
        new OnlyDigitTrackingNumberV2(
            new DefaultTrackingNumberV2(
                "i234S6789o!2",
                DeliveryCompanyV2.LOTTE_GLOGIS)
        );

    // when-then
    assertThatThrownBy(trackingNumberV2::getNumber)
        .isInstanceOf(InvalidTrackingNumberExceptionV2.class)
        .hasMessage("[Company: 롯데글로벌로지스, trackingNo: i234S6789o!2] 숫자가 아닌 문자 존재");
  }

  @DisplayName("숫자로만 이루어진 송장번호 유효성 검증")
  @Test
  void contains_only_digit() {
    // given
    TrackingNumberV2 trackingNumberV2 =
        new OnlyDigitTrackingNumberV2(
            new DefaultTrackingNumberV2(
                "1234567890",
                DeliveryCompanyV2.LOTTE_GLOGIS)
        );

    // when
    String number = trackingNumberV2.getNumber();

    // then
    assertThat(number).isEqualTo("1234567890");
  }
}