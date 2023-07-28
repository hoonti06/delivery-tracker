package me.hoonti06.deliverytracker.step3.trackeddelivery;

import static me.hoonti06.deliverytracker.step3.DeliveryLastStatusSteps.배송상태_검증;
import static me.hoonti06.deliverytracker.step3.DocumentSteps.DOC_생성;

import java.time.LocalDateTime;
import me.hoonti06.deliverytracker.step3.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step3.DeliveryStatus;
import me.hoonti06.deliverytracker.step3.trackingnumber.DefaultTrackingNumber;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteGlogisTrackedDeliveryTest {

  @DisplayName("배송완료 HTML을 리턴하는 가짜 연결 추적")
  @Test
  void track_delivered_html() {
    // given
    final DefaultTrackingNumber trackingNumber = new DefaultTrackingNumber("1234567890");

    final Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/delivered.html");
    final Connection.Response fakeResponse = new FakeResponse(doc, 200);
    final Connection fakeConnection = new FakeConnection(fakeResponse);
    final LotteGlogisTrackedDelivery trackedDelivery
        = new LotteGlogisTrackedDelivery(trackingNumber, fakeConnection);

    // when
    final DeliveryLastStatus lastStatus = trackedDelivery.getLastStatus();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatus.COMPLETED,
        LocalDateTime.of(2023, 4, 11, 14, 34));
  }
}