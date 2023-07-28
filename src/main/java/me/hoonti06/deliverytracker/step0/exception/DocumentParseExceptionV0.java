package me.hoonti06.deliverytracker.step0.exception;

public class DocumentParseExceptionV0 extends RuntimeException {

  public DocumentParseExceptionV0(final String message) {
    super(message);
  }

  public DocumentParseExceptionV0(final String message, final Throwable cause) {
    super(message, cause);
  }
}
