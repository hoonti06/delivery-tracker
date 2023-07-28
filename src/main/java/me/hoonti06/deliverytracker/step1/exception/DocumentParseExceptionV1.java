package me.hoonti06.deliverytracker.step1.exception;

public class DocumentParseExceptionV1 extends RuntimeException {

  public DocumentParseExceptionV1(final String message) {
    super(message);
  }

  public DocumentParseExceptionV1(final String message, final Throwable cause) {
    super(message, cause);
  }
}
