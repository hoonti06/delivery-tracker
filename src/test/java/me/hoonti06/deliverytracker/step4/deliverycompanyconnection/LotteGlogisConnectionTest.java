package me.hoonti06.deliverytracker.step4.deliverycompanyconnection;

import static me.hoonti06.deliverytracker.step3.DocumentSteps.DOC_생성;
import static org.assertj.core.api.Assertions.assertThat;

import me.hoonti06.deliverytracker.step4.trackeddelivery.FakeConnection;
import me.hoonti06.deliverytracker.step4.trackeddelivery.FakeResponse;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

class LotteGlogisConnectionTest {

  @Test
  void get_document() {
    // given
    final Document doc = DOC_생성("src/test/resources/delivery/lotteglogis/delivered.html");
    final Connection.Response fakeResponse = new FakeResponse(doc, 200);
    final Connection connection = new FakeConnection(fakeResponse);
    final LotteGlogisConnection lotteGlogisConnection = new LotteGlogisConnection(connection);

    // when
    final Document actualDoc = lotteGlogisConnection.getDocument();

    // then
    assertThat(actualDoc).isEqualTo(doc);
  }

}