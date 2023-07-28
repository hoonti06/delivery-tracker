package me.hoonti06.deliverytracker.step3;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DocumentStepsV3 {

  public static Document DOC_생성(final String htmlFilePath) {
    try {
      File in = new File(htmlFilePath);
      return Jsoup.parse(in, null);
    } catch (IOException e) {
      throw new RuntimeException("IOException", e);
    }
  }
}