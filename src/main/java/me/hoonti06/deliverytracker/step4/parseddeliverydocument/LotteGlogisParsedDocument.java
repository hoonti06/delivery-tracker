package me.hoonti06.deliverytracker.step4.parseddeliverydocument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import me.hoonti06.deliverytracker.step4.deliverycompanyconnection.DeliveryCompanyConnection;
import me.hoonti06.deliverytracker.step4.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step4.DeliveryStatus;
import me.hoonti06.deliverytracker.step4.exception.DocumentParsingException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

public class LotteGlogisParsedDocument implements ParsedDeliveryDocument {

  private final DeliveryCompanyConnection deliveryCompanyConnection;

  public LotteGlogisParsedDocument(DeliveryCompanyConnection deliveryCompanyConnection) {
    this.deliveryCompanyConnection = deliveryCompanyConnection;
  }

  @Override
  public DeliveryLastStatus getLastStatus() {
    Document doc = deliveryCompanyConnection.getDocument();
    return parse(doc);
  }

  private DeliveryLastStatus parse(final Document doc) {
    Elements statusTableRows = doc.select("div.contArea > table:nth-of-type(2) > tbody > tr");
    if (CollectionUtils.isEmpty(statusTableRows)) {
      throw new DocumentParsingException("statusTableTd IS EMPTY");
    }

    Element firstRow = statusTableRows.get(0);

    Elements cells = firstRow.getElementsByTag("td");
    if (cells.size() < 4) {
      throw new DocumentParsingException("미등록운송장");
    }

    final Element statusCell = cells.get(0);

    String statusCellText = statusCell.text();
    if (statusCellText.contains("미등록운송장") || statusCellText.contains("상품 발송 준비중")) {
      throw new DocumentParsingException("미등록운송장");
    }
    if (statusCellText.contains("배달 완료")) {
      return parseLastStatus(statusTableRows.get(1));
    }
    return parseLastStatus(firstRow);
  }

  private DeliveryLastStatus parseLastStatus(final Element lastRow) {
    Elements lastRowCells = lastRow.getElementsByTag("td");
    if (lastRowCells.size() < 4) {
      throw new DocumentParsingException("cell count is less than 4");
    }

    final Element statusCell = lastRowCells.get(0);
    if (!statusCell.hasText()) {
      throw new DocumentParsingException("status cell has no text");
    }

    final DeliveryStatus lastStatus = statusCell.text().contains("배달 완료") ?
        DeliveryStatus.COMPLETED : DeliveryStatus.IN_PROGRESS;

    String parsedLastStatusTime = lastRowCells.get(1).text();
    try {
      LocalDateTime lastStatusTime = LocalDateTime.parse(parsedLastStatusTime,
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
      return new DeliveryLastStatus(lastStatus, lastStatusTime);
    } catch (DateTimeParseException e) {
      throw new DocumentParsingException(e.getMessage(), e);
    }
  }
}

