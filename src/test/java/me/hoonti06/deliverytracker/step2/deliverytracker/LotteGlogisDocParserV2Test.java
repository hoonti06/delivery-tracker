package me.hoonti06.deliverytracker.step2.deliverytracker;

import static me.hoonti06.deliverytracker.step2.DeliveryLastStatusStepsV2.배송상태_검증;
import static me.hoonti06.deliverytracker.step2.DocumentStepsV2.DOC_생성;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;
import me.hoonti06.deliverytracker.step2.DeliveryLastStatusV2;
import me.hoonti06.deliverytracker.step2.DeliveryStatusV2;
import me.hoonti06.deliverytracker.step2.deilverytracker.LotteGlogisDocParserV2;
import me.hoonti06.deliverytracker.step2.exception.DocumentParseExceptionV2;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteGlogisDocParserV2Test {

  @DisplayName("배송완료 HTML 파싱 검증")
  @Test
  void parse_delivery_completed_html() {
    // given
    Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/delivered.html");
    LotteGlogisDocParserV2 parser = new LotteGlogisDocParserV2(doc);

    // when
    DeliveryLastStatusV2 lastStatus = parser.parse();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatusV2.COMPLETED,
        LocalDateTime.of(2023, 4, 11, 14, 34));
  }

  @DisplayName("배송중 HTML 파싱 검증")
  @Test
  void parse_delivery_in_progress_html() {
    // given
    Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/inProgress.html");
    LotteGlogisDocParserV2 parser = new LotteGlogisDocParserV2(doc);

    // when
    DeliveryLastStatusV2 lastStatus = parser.parse();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatusV2.IN_PROGRESS,
        LocalDateTime.of(2023, 4, 11, 7, 20));
  }

  @DisplayName("배송준비중 HTML 파싱 검증")
  @Test
  void parse_delivery_no_data_html() {
    // given
    Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/noData.html");
    LotteGlogisDocParserV2 parser = new LotteGlogisDocParserV2(doc);

    // when-then
    assertThatThrownBy(parser::parse)
        .isInstanceOf(DocumentParseExceptionV2.class)
        .hasMessage("[롯데글로벌로지스]미등록운송장");
  }
}