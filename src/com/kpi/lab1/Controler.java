package com.kpi.lab1;

import java.util.Scanner;

public final class Controler implements Runnable {
  private Scanner scanner;
  private Book[] data;

  public Controler() {
    this.scanner = new Scanner(System.in);
    this.data = Datasource.data();
  }

  @Override
  public void run() {
    Viewer.println(data);
    int option;

    while (true) {
      Viewer.choice();

      try {
        option = Integer.parseInt(readLine());
      } catch (NumberFormatException e) {
        Viewer.noFormat();
        continue;
      }

      if (option == 3) break;

      try {
        Validator.validateOption(option);
        execute(option);
      } catch (OptionOutOfRange e) {
        Viewer.noOption();
      }
    }
  }

  private void execute(int query) {
    switch (query) {
      case 0: {
        Viewer.insert("author");
        Book[] books = Model.getByAuthor(data, readLine());
        if (books.length == 0) {
          Viewer.noAuthor();
        } else {
          Viewer.println(books);
          System.out.println();
        }

        break;
      }
      case 1: {
        Viewer.insert("publisher");
        Book[] books = Model.getByPublisher(data, readLine());
        if (books.length == 0) {
          Viewer.noPublisher();
        } else {
          Viewer.println(books);
          System.out.println();
        }

        break;
      }
      case 2: {
        Viewer.insert("year");
        int year;

        try {
          year = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
          Viewer.noFormat();
          return;
        }

        Book[] books = Model.getByYearMoreThan(data, year);
        if (books.length == 0) {
          Viewer.noYear();
        } else {
          Viewer.println(books);
          System.out.println();
        }

        break;
      }
    }
  }

  private String readLine() {
    return scanner.nextLine().trim();
  }
}
