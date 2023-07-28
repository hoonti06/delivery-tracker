package me.hoonti06.deliverytracker.step0.exception;

public class DocumentParseException extends RuntimeException {

  public DocumentParseException(final String message) {
    super(message);
  }

  public DocumentParseException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
