package me.hoonti06.deliverytracker.step2.trackingnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import me.hoonti06.deliverytracker.step2.DeliveryCompanyV2;
import me.hoonti06.deliverytracker.step2.exception.InvalidTrackingNumberExceptionV2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidLengthTrackingNumberV2Test {

  @DisplayName("유효한 길이의 송장 번호 검증")
  @Test
  void valid_length_tracking_number() {
    // given
    TrackingNumberV2 trackingNumberV2 =
        new ValidLengthTrackingNumberV2(
            new DefaultTrackingNumberV2(
                "12345678",
                DeliveryCompanyV2.LOTTE_GLOGIS
            ),
            new int[]{8}
        );

    // when
    String number = trackingNumberV2.getNumber();

    // then
    assertThat(number).isEqualTo("12345678");
  }

  @DisplayName("hyphen이 포함된 유효한 길이의 송장 번호 검증")
  @Test
  void hypphen_included_in_and_valid_length_tracking_number() {
    // given
    TrackingNumberV2 trackingNumberV2 =
        new ValidLengthTrackingNumberV2(
            new DefaultTrackingNumberV2(
                "1-3-5-7-9-1-",
                DeliveryCompanyV2.LOTTE_GLOGIS
            ),
            new int[]{12}
        );

    // when
    String number = trackingNumberV2.getNumber();

    // then
    assertThat(number).isEqualTo("1-3-5-7-9-1-");
  }


  @DisplayName("유효 길이보다 큰 길이의 송장번호 검증")
  @Test
  void greater_than_valid_length() {
    // given
    TrackingNumberV2 trackingNumberV2 =
        new ValidLengthTrackingNumberV2(
            new DefaultTrackingNumberV2(
                "12345678901",
                DeliveryCompanyV2.LOTTE_GLOGIS),
            new int[]{10}
        );

    // when-then
    assertThatThrownBy(trackingNumberV2::getNumber)
        .isInstanceOf(InvalidTrackingNumberExceptionV2.class)
        .hasMessage("[Company: 롯데글로벌로지스, trackingNo: 12345678901] 유효 길이: [10]");
  }

  @DisplayName("유효 길이보다 작은 길이의 송장번호 검증")
  @Test
  void less_than_valid_length() {
    // given
    TrackingNumberV2 trackingNumberV2 =
        new ValidLengthTrackingNumberV2(
            new DefaultTrackingNumberV2(
                "12345678901",
                DeliveryCompanyV2.LOTTE_GLOGIS),
            new int[]{10}
        );

    // when-then
    assertThatThrownBy(trackingNumberV2::getNumber)
        .isInstanceOf(InvalidTrackingNumberExceptionV2.class)
        .hasMessage("[Company: 롯데글로벌로지스, trackingNo: 12345678901] 유효 길이: [10]");
  }

  @DisplayName("유효 길이 리스트에 포함되지 않는 길이의 송장번호 검증")
  @Test
  void not_included_in_valid_length_list() {
    // given
    TrackingNumberV2 trackingNumberV2 =
        new ValidLengthTrackingNumberV2(
            new DefaultTrackingNumberV2(
                "1234567890",
                DeliveryCompanyV2.LOTTE_GLOGIS),
            new int[]{9, 11}
        );

    // when-then
    assertThatThrownBy(trackingNumberV2::getNumber)
        .isInstanceOf(InvalidTrackingNumberExceptionV2.class)
        .hasMessage("[Company: 롯데글로벌로지스, trackingNo: 1234567890] 유효 길이: [9, 11]");
  }

}