package me.hoonti06.deliverytracker.step3.exception;

public class DocumentParsingException extends RuntimeException {

  public DocumentParsingException(final String message) {
    super(message);
  }

  public DocumentParsingException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
