package me.hoonti06.deliverytracker.step4.parseddeliverydocument;

import me.hoonti06.deliverytracker.step4.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step4.DeliveryStatus;
import me.hoonti06.deliverytracker.step4.exception.DocumentParsingException;
import me.hoonti06.deliverytracker.step4.deliverycompanyconnection.FakeDeliveryCompanyConnection;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static me.hoonti06.deliverytracker.step4.DeliveryLastStatusSteps.배송상태_검증;
import static me.hoonti06.deliverytracker.step4.DocumentSteps.DOC_생성;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteGlogisParsedDocumentTest {

  @DisplayName("배송완료 HTML 파싱 검증")
  @Test
  void parse_delivery_completed_html() {
    // given
    final Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/delivered.html");
    final LotteGlogisParsedDocument parsedDocument
        = new LotteGlogisParsedDocument(new FakeDeliveryCompanyConnection(doc));

    // when
    final DeliveryLastStatus lastStatus = parsedDocument.getLastStatus();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatus.COMPLETED,
        LocalDateTime.of(2023, 4, 11, 14, 34));
  }

  @DisplayName("배송중 HTML 파싱 검증")
  @Test
  void parse_delivery_in_progress_html() {
    // given
    final Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/inProgress.html");
    final LotteGlogisParsedDocument parsedDocument
        = new LotteGlogisParsedDocument(new FakeDeliveryCompanyConnection(doc));

    // when
    final DeliveryLastStatus lastStatus = parsedDocument.getLastStatus();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatus.IN_PROGRESS,
        LocalDateTime.of(2023, 4, 11, 7, 20));
  }

  @DisplayName("배송준비중 HTML 파싱 검증")
  @Test
  void parse_delivery_no_data_html() {
    // given
    final Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/noData.html");
    final LotteGlogisParsedDocument parsedDocument
        = new LotteGlogisParsedDocument(new FakeDeliveryCompanyConnection(doc));

    // when-then
    assertThatThrownBy(parsedDocument::getLastStatus)
        .isInstanceOf(DocumentParsingException.class)
        .hasMessage("미등록운송장");
  }
}