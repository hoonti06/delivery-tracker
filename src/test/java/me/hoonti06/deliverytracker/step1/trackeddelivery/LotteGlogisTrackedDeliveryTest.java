package me.hoonti06.deliverytracker.step1.trackeddelivery;

import static me.hoonti06.deliverytracker.step1.DeliveryLastStatusSteps.배송상태_검증;

import java.time.LocalDateTime;
import me.hoonti06.deliverytracker.UserId;
import me.hoonti06.deliverytracker.step1.DeliveryCompany;
import me.hoonti06.deliverytracker.step1.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step1.DeliveryStatus;
import me.hoonti06.deliverytracker.step1.UserDeliveryInfo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteGlogisTrackedDeliveryTest {

  @Disabled // 3개월 이내의 정보만 조회 가능하기 때문에, 해당 테스트는 특정 시점부터 실패한다
  @DisplayName("배송완료된 송장번호 조회하여 결과 조회")
  @Test
  void get_delivered_status() {
    // given
    UserDeliveryInfo userDeliveryInfo = new UserDeliveryInfo(
        new UserId(1L),
        "405902969290",
        DeliveryCompany.LOTTE_GLOGIS
    );
    LotteGlogisTrackedDelivery trackedDelivery = new LotteGlogisTrackedDelivery(userDeliveryInfo);

    // when
    final DeliveryLastStatus lastStatus = trackedDelivery.getLastStatus();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatus.COMPLETED,
        LocalDateTime.of(2023, 6, 20, 11, 6));
  }
}