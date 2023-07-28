package me.hoonti06.deliverytracker.step2.exception;

public class DocumentParseExceptionV2 extends RuntimeException {

  public DocumentParseExceptionV2(final String message) {
    super(message);
  }

  public DocumentParseExceptionV2(final String message, final Throwable cause) {
    super(message, cause);
  }
}
