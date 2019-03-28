package com.kpi.lab1;

public class OptionOutOfRange extends RuntimeException {
  public OptionOutOfRange() {
    super();
  }

  public OptionOutOfRange(String message) {
    super(message);
  }

  public OptionOutOfRange(Throwable throwable) {
    super(throwable);
  }

  public OptionOutOfRange(String message, Throwable throwable) {
    super(message, throwable);
  }
}
