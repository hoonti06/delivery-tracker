package me.hoonti06.deliverytracker.step3.deilverytracker;

import static me.hoonti06.deliverytracker.step3.DeliveryLastStatusStepsV3.배송상태_검증;
import static me.hoonti06.deliverytracker.step3.DocumentStepsV3.DOC_생성;

import java.time.LocalDateTime;
import me.hoonti06.deliverytracker.step3.DeliveryCompanyV3;
import me.hoonti06.deliverytracker.step3.DeliveryLastStatusV3;
import me.hoonti06.deliverytracker.step3.DeliveryStatusV3;
import me.hoonti06.deliverytracker.step3.deliverytracker.LotteGlogisTrackerV3;
import me.hoonti06.deliverytracker.step3.trackingnumber.DefaultTrackingNumberV3;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteGlogisTrackerV3Test {

  @DisplayName("배송완료 HTML을 리턴하는 가짜 연결 추적")
  @Test
  void track_delivered_html() {
    // given
    final DefaultTrackingNumberV3 trackingNumber = new DefaultTrackingNumberV3(
        "1234567890",
        DeliveryCompanyV3.LOTTE_GLOGIS);

    final Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/delivered.html");
    final Connection.Response fakeResponse = new FakeResponse(doc, 200);
    final Connection fakeConnection = new FakeConnection(fakeResponse);
    final LotteGlogisTrackerV3 tracker = new LotteGlogisTrackerV3(trackingNumber, fakeConnection);

    // when
    final DeliveryLastStatusV3 lastStatus = tracker.getLastStatus();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatusV3.COMPLETED,
        LocalDateTime.of(2023, 4, 11, 14, 34));
  }
}