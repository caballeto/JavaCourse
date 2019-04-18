package com.kpi.lab1.core;

import com.kpi.lab1.exceptions.InvalidEntryException;
import com.kpi.lab1.exceptions.NotUppercaseException;
import com.kpi.lab1.exceptions.OptionOutOfRangeException;
import com.kpi.lab1.representation.Book;
import com.kpi.lab1.representation.Datasource;

public final class Controler implements Runnable {
  private Model model;
  private Reader reader;

  public Controler() {
    this.reader = new Reader();
    this.model = new Model(Datasource.data());
  }

  @Override
  public void run() {
    if (model.data() == null) return;
    Viewer.println(model.data());
    int option;
    while (true) {
      Viewer.choice();

      try {
        option = Integer.parseInt(reader.readLine());
      } catch (NumberFormatException e) {
        Viewer.noFormat();
        continue;
      }

      if (option == 4) {
        Datasource.save(model.data());
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
        Book[] books = model.getByAuthor(Validator.validateQuery(reader.readLine()));
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
        Book[] books = model.getByPublisher(Validator.validateQuery(reader.readLine()));
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
          year = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
          Viewer.noFormat();
          return;
        }

        Book[] books = model.getByYearMoreThan(year);
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
        model.addEntry(reader.readLine());
      }
    }
  }
}
