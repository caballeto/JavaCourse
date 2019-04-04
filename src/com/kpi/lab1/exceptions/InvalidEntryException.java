package com.kpi.lab1.exceptions;

public final class InvalidEntryException extends RuntimeException {
  public InvalidEntryException() {
    super();
  }

  public InvalidEntryException(String message) {
    super(message);
  }

  public InvalidEntryException(Throwable throwable) {
    super(throwable);
  }

  public InvalidEntryException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
