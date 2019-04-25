package com.kpi.lab1.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public final class Reader {
  private static final Logger LOGGER = LogManager.getLogger(Reader.class.getName());

  private Scanner scanner;

  public Reader() {
    scanner = new Scanner(System.in);
  }

  public String readLine() {
    LOGGER.debug("Reading line.");
    return scanner.nextLine().trim();
  }
}
