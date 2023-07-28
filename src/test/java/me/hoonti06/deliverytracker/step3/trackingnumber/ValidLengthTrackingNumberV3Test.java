package me.hoonti06.deliverytracker.step3.trackingnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import me.hoonti06.deliverytracker.step3.DeliveryCompanyV3;
import me.hoonti06.deliverytracker.step3.exception.InvalidTrackingNumberExceptionV3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidLengthTrackingNumberV3Test {

  @DisplayName("유효한 길이의 송장 번호 검증")
  @Test
  void valid_length_tracking_number() {
    // given
    TrackingNumberV3 trackingNumberV3 =
        new ValidLengthTrackingNumberV3(
            new DefaultTrackingNumberV3(
                "12345678",
                DeliveryCompanyV3.LOTTE_GLOGIS
            ),
            new int[]{8}
        );

    // when
    String number = trackingNumberV3.getNumber();

    // then
    assertThat(number).isEqualTo("12345678");
  }

  @DisplayName("hyphen이 포함된 유효한 길이의 송장 번호 검증")
  @Test
  void hypphen_included_in_and_valid_length_tracking_number() {
    // given
    TrackingNumberV3 trackingNumberV3 =
        new ValidLengthTrackingNumberV3(
            new DefaultTrackingNumberV3(
                "1-3-5-7-9-1-",
                DeliveryCompanyV3.LOTTE_GLOGIS
            ),
            new int[]{12}
        );

    // when
    String number = trackingNumberV3.getNumber();

    // then
    assertThat(number).isEqualTo("1-3-5-7-9-1-");
  }


  @DisplayName("유효 길이보다 큰 길이의 송장번호 검증")
  @Test
  void greater_than_valid_length() {
    // given
    TrackingNumberV3 trackingNumberV3 =
        new ValidLengthTrackingNumberV3(
            new DefaultTrackingNumberV3(
                "12345678901",
                DeliveryCompanyV3.LOTTE_GLOGIS),
            new int[]{10}
        );

    // when-then
    assertThatThrownBy(trackingNumberV3::getNumber)
        .isInstanceOf(InvalidTrackingNumberExceptionV3.class)
        .hasMessage("[Company: 롯데글로벌로지스, trackingNo: 12345678901] 유효 길이: [10]");
  }

  @DisplayName("유효 길이보다 작은 길이의 송장번호 검증")
  @Test
  void less_than_valid_length() {
    // given
    TrackingNumberV3 trackingNumberV3 =
        new ValidLengthTrackingNumberV3(
            new DefaultTrackingNumberV3(
                "12345678901",
                DeliveryCompanyV3.LOTTE_GLOGIS),
            new int[]{10}
        );

    // when-then
    assertThatThrownBy(trackingNumberV3::getNumber)
        .isInstanceOf(InvalidTrackingNumberExceptionV3.class)
        .hasMessage("[Company: 롯데글로벌로지스, trackingNo: 12345678901] 유효 길이: [10]");
  }

  @DisplayName("유효 길이 리스트에 포함되지 않는 길이의 송장번호 검증")
  @Test
  void not_included_in_valid_length_list() {
    // given
    TrackingNumberV3 trackingNumberV3 =
        new ValidLengthTrackingNumberV3(
            new DefaultTrackingNumberV3(
                "1234567890",
                DeliveryCompanyV3.LOTTE_GLOGIS),
            new int[]{9, 11}
        );

    // when-then
    assertThatThrownBy(trackingNumberV3::getNumber)
        .isInstanceOf(InvalidTrackingNumberExceptionV3.class)
        .hasMessage("[Company: 롯데글로벌로지스, trackingNo: 1234567890] 유효 길이: [9, 11]");
  }

}