package com.kpi.lab1.core;

import com.kpi.lab1.exceptions.InvalidEntryException;
import com.kpi.lab1.exceptions.NotUppercaseException;
import com.kpi.lab1.exceptions.OptionOutOfRangeException;
import com.kpi.lab1.representation.Book;
import com.kpi.lab1.representation.Datasource;

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
    if (data == null) return;

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

      if (option == 4) {
        Datasource.save();
        break;
      }

      try {
        Validator.validateOption(option);
        execute(option);
      } catch (OptionOutOfRangeException e) {
        Viewer.noOption();
      } catch (NotUppercaseException e) {
        Viewer.noUppercase();
      } catch (InvalidEntryException e)  {
        Viewer.noEntryFormat();
        System.out.println(e.getMessage());
      }
    }
  }

  private void execute(int query) {
    switch (query) {
      case 0: {
        Viewer.insert("author");
        Book[] books = Model.getByAuthor(data, Validator.validateQuery(readLine()));
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
        Book[] books = Model.getByPublisher(data, Validator.validateQuery(readLine()));
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
      case 3: {
        Viewer.insertEntry();
        Datasource.addEntry(readLine());
        data = Datasource.data();
      }
    }
  }

  private String readLine() {
    return scanner.nextLine().trim();
  }
}
