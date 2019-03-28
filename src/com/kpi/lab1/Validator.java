package com.kpi.lab1;

public final class Validator {
  private static final int N = 4;

  public static void validateOption(int option) {
    if (option < 0 || option >= N) {
      throw new OptionOutOfRange();
    }
  }
}
