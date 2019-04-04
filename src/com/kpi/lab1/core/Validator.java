package com.kpi.lab1.core;

import com.kpi.lab1.exceptions.NotUppercaseException;
import com.kpi.lab1.exceptions.OptionOutOfRangeException;

public final class Validator {
  private static final int N = 4;

  public static void validateOption(int option) {
    if (option < 0 || option >= N) {
      throw new OptionOutOfRangeException();
    }
  }

  public static String validateQuery(String string) {
    if (string.matches("[A-Z].*")) {
      return string;
    } else {
      throw new NotUppercaseException();
    }
  }

  public static int validatePositive(int value) {
    if (value < 0) {
      throw new RuntimeException("Value '" + value + "' can't be negative.");
    }

    return value;
  }
}
