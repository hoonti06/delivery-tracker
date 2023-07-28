package me.hoonti06.deliverytracker.step4.deliverycompanyconnection;

import java.io.IOException;
import me.hoonti06.deliverytracker.step4.exception.DeliveryParsingFailException;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

public class LotteGlogisConnection implements DeliveryCompanyConnection {

  private final Connection connection;

  public LotteGlogisConnection(final Connection connection) {
    this.connection = connection;
  }

  @Override
  public Document getDocument() {
    try {
      Connection.Response response = connection.execute();
      return response.parse();
    } catch (IOException e) {
      throw new DeliveryParsingFailException("예외 발생", e);
    }
  }
}
