package com.kpi.lab1.core;

import com.kpi.lab1.exceptions.NotUppercaseException;
import com.kpi.lab1.exceptions.OptionOutOfRangeException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class Validator {
  private static final Logger LOGGER = LogManager.getLogger(Validator.class.getName());
  private static final int N = 4;

  public static void validateOption(int option) {
    LOGGER.debug("Validating option range: " + option + ".");
    if (option < 0 || option >= N) {
      throw new OptionOutOfRangeException();
    }
  }

  public static String validateQuery(String string) {
    LOGGER.debug("Validating first uppercase letter: " + string + ".");
    if (string.matches("[A-Z].*")) {
      return string;
    } else {
      throw new NotUppercaseException();
    }
  }

  public static int validatePositive(int value) {
    LOGGER.debug("Validating for positivity: " + value + ".");
    if (value < 0) {
      throw new RuntimeException("Value '" + value + "' can't be negative.");
    }

    return value;
  }
}
