package me.hoonti06.deliverytracker.step3.exception;

public class DocumentParseExceptionV3 extends RuntimeException {

  public DocumentParseExceptionV3(final String message) {
    super(message);
  }

  public DocumentParseExceptionV3(final String message, final Throwable cause) {
    super(message, cause);
  }
}
