package me.hoonti06.deliverytracker.step0.deliverytracker;

import static me.hoonti06.deliverytracker.step0.DeliveryLastStatusStepsV0.배송상태_검증;

import java.time.LocalDateTime;
import me.hoonti06.deliverytracker.UserId;
import me.hoonti06.deliverytracker.step0.DeliveryCompanyV0;
import me.hoonti06.deliverytracker.step0.DeliveryLastStatusV0;
import me.hoonti06.deliverytracker.step0.DeliveryStatusV0;
import me.hoonti06.deliverytracker.step0.UserDeliveryInfoV0;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteGlogisTrackerV0Test {

  @Disabled // 3개월 이내의 정보만 조회 가능하기 때문에, 해당 테스트는 특정 시점부터 실패한다
  @DisplayName("배송완료된 송장번호 조회하여 결과 조회")
  @Test
  void get_delivered_status() {
    // given
    UserDeliveryInfoV0 userDeliveryInfo = new UserDeliveryInfoV0(
        new UserId(1L),
        "405902969290",
        DeliveryCompanyV0.LOTTE_GLOGIS
    );
    LotteGlogisTrackerV0 tracker = new LotteGlogisTrackerV0(userDeliveryInfo);

    // when
    final DeliveryLastStatusV0 lastStatus = tracker.getLastStatus();

    // then
    배송상태_검증(lastStatus, DeliveryStatusV0.COMPLETED, LocalDateTime.of(2023, 6, 20, 11, 6));
  }
}