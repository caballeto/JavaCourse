package com.kpi.lab1;

import java.util.Scanner;

public class Runner {
  private Scanner scanner;
  private Book[] data;

  public Runner() {
    this.scanner = new Scanner(System.in);
    this.data = Datasource.data();
  }

  public void prompt() {
    System.out.println("Data");
    Viewer.println(data);
    int query;
    while (true) {
      Viewer.choice();

      try {
        query = Integer.parseInt(readLine());
      } catch (Exception e) {
        Viewer.noFormat();
        continue;
      }

      if (query == 3) break;
      execute(query);
    }
  }

  private void execute(int query) {
    switch (query) {
      case 0: {
        Viewer.insert("author");
        Book[] books = Controler.getByAuthor(data, readLine());
        if (books.length == 0) {
          Viewer.noAuthor();
        } else {
          Viewer.println(books);
        }

        break;
      }
      case 1: {
        Viewer.insert("publisher");
        Book[] books = Controler.getByPublisher(data, readLine());
        if (books.length == 0) {
          Viewer.noPublisher();
        } else {
          Viewer.println(books);
        }

        break;
      }
      case 2: {
        Viewer.insert("year");
        int year;

        try {
          year = Integer.parseInt(readLine());
        } catch (Exception e) {
          Viewer.noFormat();
          return;
        }

        Book[] books = Controler.getByYearLessThan(data, year);
        if (books.length == 0) {
          Viewer.noYear();
        } else {
          Viewer.println(books);
        }

        break;
      }

      default:
        Viewer.noOption();
    }
  }

  private String readLine() {
    return scanner.nextLine().trim();
  }
}
