package me.hoonti06.deliverytracker.step2.deilverytracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import me.hoonti06.deliverytracker.step2.DeliveryLastStatusV2;
import me.hoonti06.deliverytracker.step2.DeliveryStatusV2;
import me.hoonti06.deliverytracker.step2.exception.DocumentParseExceptionV2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

public class LotteGlogisDocParserV2 {

  private final Document doc;

  public LotteGlogisDocParserV2(final Document doc) {
    this.doc = doc;
  }

  public DeliveryLastStatusV2 parse() {
    return getResult(doc);
  }

  private DeliveryLastStatusV2 getResult(final Document doc) {
    Elements statusTableRows = doc.select("div.contArea > table:nth-of-type(2) > tbody > tr");
    if (CollectionUtils.isEmpty(statusTableRows)) {
      throw new DocumentParseExceptionV2("statusTableTd IS EMPTY");
    }

    Element firstRow = statusTableRows.get(0);

    Elements cells = firstRow.getElementsByTag("td");
    if (cells.size() < 4) {
      throw new DocumentParseExceptionV2("[롯데글로벌로지스]미등록운송장");
    }

    final Element statusCell = cells.get(0);

    String statusCellText = statusCell.text();
    if (statusCellText.contains("미등록운송장") || statusCellText.contains("상품 발송 준비중")) {
      throw new DocumentParseExceptionV2("[롯데글로벌로지스]미등록운송장");
    }
    if (statusCellText.contains("배달 완료")) {
      return parseLastStatus(statusTableRows.get(1));
    }
    return parseLastStatus(firstRow);
  }

  private DeliveryLastStatusV2 parseLastStatus(final Element lastRow) {
    Elements lastRowCells = lastRow.getElementsByTag("td");
    if (lastRowCells.size() < 4) {
      throw new DocumentParseExceptionV2("cell count is less than 4");
    }

    final Element statusCell = lastRowCells.get(0);
    if (!statusCell.hasText()) {
      throw new DocumentParseExceptionV2("status cell has no text");
    }

    final DeliveryStatusV2 lastStatus = statusCell.text().contains("배달 완료") ?
        DeliveryStatusV2.COMPLETED : DeliveryStatusV2.IN_PROGRESS;

    String parsedLastStatusTime = lastRowCells.get(1).text();
    try {
      LocalDateTime lastStatusTime = LocalDateTime.parse(parsedLastStatusTime,
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
      return new DeliveryLastStatusV2(lastStatus, lastStatusTime);
    } catch (DateTimeParseException e) {
      throw new DocumentParseExceptionV2(e.getMessage(), e);
    }
  }
}

