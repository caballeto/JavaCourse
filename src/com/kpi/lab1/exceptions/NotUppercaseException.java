package com.kpi.lab1.exceptions;

public class NotUppercaseException extends RuntimeException {
  public NotUppercaseException() {
    super();
  }

  public NotUppercaseException(String message) {
    super(message);
  }

  public NotUppercaseException(Throwable throwable) {
    super(throwable);
  }

  public NotUppercaseException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
