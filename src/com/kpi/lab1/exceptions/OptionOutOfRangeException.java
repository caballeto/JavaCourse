package com.kpi.lab1.exceptions;

public class OptionOutOfRangeException extends RuntimeException {
  public OptionOutOfRangeException() {
    super();
  }

  public OptionOutOfRangeException(String message) {
    super(message);
  }

  public OptionOutOfRangeException(Throwable throwable) {
    super(throwable);
  }

  public OptionOutOfRangeException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
