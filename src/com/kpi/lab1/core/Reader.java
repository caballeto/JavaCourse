package com.kpi.lab1.core;

import java.util.Scanner;

public final class Reader {
  private Scanner scanner;

  public Reader() {
    scanner = new Scanner(System.in);
  }

  public String readLine() {
    return scanner.nextLine().trim();
  }
}
