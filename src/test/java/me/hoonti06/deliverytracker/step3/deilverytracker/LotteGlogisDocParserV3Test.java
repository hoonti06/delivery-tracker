package me.hoonti06.deliverytracker.step3.deilverytracker;

import static me.hoonti06.deliverytracker.step3.DeliveryLastStatusStepsV3.배송상태_검증;
import static me.hoonti06.deliverytracker.step3.DocumentStepsV3.DOC_생성;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;
import me.hoonti06.deliverytracker.step3.DeliveryLastStatusV3;
import me.hoonti06.deliverytracker.step3.DeliveryStatusV3;
import me.hoonti06.deliverytracker.step3.deliverytracker.LotteGlogisDocParserV3;
import me.hoonti06.deliverytracker.step3.exception.DocumentParseExceptionV3;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteGlogisDocParserV3Test {

  @DisplayName("배송완료 HTML 파싱 검증")
  @Test
  void parse_delivery_completed_html() {
    // given
    Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/delivered.html");
    LotteGlogisDocParserV3 parser = new LotteGlogisDocParserV3(doc);

    // when
    DeliveryLastStatusV3 lastStatus = parser.parse();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatusV3.COMPLETED,
        LocalDateTime.of(2023, 4, 11, 14, 34));
  }

  @DisplayName("배송중 HTML 파싱 검증")
  @Test
  void parse_delivery_in_progress_html() {
    // given
    Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/inProgress.html");
    LotteGlogisDocParserV3 parser = new LotteGlogisDocParserV3(doc);

    // when
    DeliveryLastStatusV3 lastStatus = parser.parse();

    // then
    배송상태_검증(lastStatus,
        DeliveryStatusV3.IN_PROGRESS,
        LocalDateTime.of(2023, 4, 11, 7, 20));
  }

  @DisplayName("배송준비중 HTML 파싱 검증")
  @Test
  void parse_delivery_no_data_html() {
    // given
    Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/noData.html");
    LotteGlogisDocParserV3 parser = new LotteGlogisDocParserV3(doc);

    // when-then
    assertThatThrownBy(parser::parse)
        .isInstanceOf(DocumentParseExceptionV3.class)
        .hasMessage("[롯데글로벌로지스]미등록운송장");
  }
}