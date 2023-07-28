package me.hoonti06.deliverytracker.step4.trackeddelivery;

import static me.hoonti06.deliverytracker.step4.DeliveryLastStatusSteps.배송상태_검증;

import java.time.LocalDateTime;
import me.hoonti06.deliverytracker.step4.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step4.DeliveryStatus;
import me.hoonti06.deliverytracker.step4.parseddeliverydocument.FakeParsedDeliveryDocument;
import me.hoonti06.deliverytracker.step4.parseddeliverydocument.ParsedDeliveryDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteGlogisTrackedDeliveryTest {

  @DisplayName("배송완료 HTML을 리턴하는 가짜 연결 추적")
  @Test
  void track_delivered_html() {
    // given
    final ParsedDeliveryDocument fakeParsedDeliveryDocument
        = new FakeParsedDeliveryDocument(
            new DeliveryLastStatus(
                DeliveryStatus.COMPLETED,
                LocalDateTime.of(2023, 4, 11, 14, 34)
            )
    );

    final LotteGlogisTrackedDelivery trackedDelivery
            = new LotteGlogisTrackedDelivery(fakeParsedDeliveryDocument);

    // when
    final DeliveryLastStatus lastStatus = trackedDelivery.getLastStatus();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatus.COMPLETED,
        LocalDateTime.of(2023, 4, 11, 14, 34));
  }
}