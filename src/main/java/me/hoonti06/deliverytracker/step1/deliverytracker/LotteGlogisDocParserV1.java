package me.hoonti06.deliverytracker.step1.deliverytracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import me.hoonti06.deliverytracker.step1.DeliveryLastStatusV1;
import me.hoonti06.deliverytracker.step1.DeliveryStatusV1;
import me.hoonti06.deliverytracker.step1.exception.DocumentParseExceptionV1;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

public class LotteGlogisDocParserV1 {

  private final Document doc;

  public LotteGlogisDocParserV1(final Document doc) {
    this.doc = doc;
  }

  public DeliveryLastStatusV1 parse() {
    return getResult(doc);
  }

  private DeliveryLastStatusV1 getResult(final Document doc) {
    Elements statusTableRows = doc.select("div.contArea > table:nth-of-type(2) > tbody > tr");
    if (CollectionUtils.isEmpty(statusTableRows)) {
      throw new DocumentParseExceptionV1("statusTableTd IS EMPTY");
    }

    Element firstRow = statusTableRows.get(0);

    Elements cells = firstRow.getElementsByTag("td");
    if (cells.size() < 4) {
      throw new DocumentParseExceptionV1("[롯데글로벌로지스]미등록운송장");
    }

    final Element statusCell = cells.get(0);

    String statusCellText = statusCell.text();
    if (statusCellText.contains("미등록운송장") || statusCellText.contains("상품 발송 준비중")) {
      throw new DocumentParseExceptionV1("[롯데글로벌로지스]미등록운송장");
    }
    if (statusCellText.contains("배달 완료")) {
      return parseLastStatus(statusTableRows.get(1));
    }
    return parseLastStatus(firstRow);
  }

  private DeliveryLastStatusV1 parseLastStatus(final Element lastRow) {
    Elements lastRowCells = lastRow.getElementsByTag("td");
    if (lastRowCells.size() < 4) {
      throw new DocumentParseExceptionV1("cell count is less than 4");
    }

    final Element statusCell = lastRowCells.get(0);
    if (!statusCell.hasText()) {
      throw new DocumentParseExceptionV1("status cell has no text");
    }

    final DeliveryStatusV1 lastStatus = statusCell.text().contains("배달 완료") ?
        DeliveryStatusV1.COMPLETED : DeliveryStatusV1.IN_PROGRESS;

    String parsedLastStatusTime = lastRowCells.get(1).text();
    try {
      LocalDateTime lastStatusTime = LocalDateTime.parse(parsedLastStatusTime,
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
      return new DeliveryLastStatusV1(lastStatus, lastStatusTime);
    } catch (DateTimeParseException e) {
      throw new DocumentParseExceptionV1(e.getMessage(), e);
    }
  }
}

