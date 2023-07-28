package me.hoonti06.deliverytracker.step3.deliverytracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import me.hoonti06.deliverytracker.step3.DeliveryLastStatusV3;
import me.hoonti06.deliverytracker.step3.DeliveryStatusV3;
import me.hoonti06.deliverytracker.step3.exception.DocumentParseExceptionV3;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

public class LotteGlogisDocParserV3 {

  private final Document doc;

  public LotteGlogisDocParserV3(final Document doc) {
    this.doc = doc;
  }

  public DeliveryLastStatusV3 parse() {
    return getResult(doc);
  }

  private DeliveryLastStatusV3 getResult(final Document doc) {
    Elements statusTableRows = doc.select("div.contArea > table:nth-of-type(2) > tbody > tr");
    if (CollectionUtils.isEmpty(statusTableRows)) {
      throw new DocumentParseExceptionV3("statusTableTd IS EMPTY");
    }

    Element firstRow = statusTableRows.get(0);

    Elements cells = firstRow.getElementsByTag("td");
    if (cells.size() < 4) {
      throw new DocumentParseExceptionV3("[롯데글로벌로지스]미등록운송장");
    }

    final Element statusCell = cells.get(0);

    String statusCellText = statusCell.text();
    if (statusCellText.contains("미등록운송장") || statusCellText.contains("상품 발송 준비중")) {
      throw new DocumentParseExceptionV3("[롯데글로벌로지스]미등록운송장");
    }
    if (statusCellText.contains("배달 완료")) {
      return parseLastStatus(statusTableRows.get(1));
    }
    return parseLastStatus(firstRow);
  }

  private DeliveryLastStatusV3 parseLastStatus(final Element lastRow) {
    Elements lastRowCells = lastRow.getElementsByTag("td");
    if (lastRowCells.size() < 4) {
      throw new DocumentParseExceptionV3("cell count is less than 4");
    }

    final Element statusCell = lastRowCells.get(0);
    if (!statusCell.hasText()) {
      throw new DocumentParseExceptionV3("status cell has no text");
    }

    final DeliveryStatusV3 lastStatus = statusCell.text().contains("배달 완료") ?
        DeliveryStatusV3.COMPLETED : DeliveryStatusV3.IN_PROGRESS;

    String parsedLastStatusTime = lastRowCells.get(1).text();
    try {
      LocalDateTime lastStatusTime = LocalDateTime.parse(parsedLastStatusTime,
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
      return new DeliveryLastStatusV3(lastStatus, lastStatusTime);
    } catch (DateTimeParseException e) {
      throw new DocumentParseExceptionV3(e.getMessage(), e);
    }
  }
}

