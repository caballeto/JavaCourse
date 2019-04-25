package com.kpi.lab1.core;

import com.kpi.lab1.exceptions.InvalidEntryException;
import com.kpi.lab1.exceptions.NotUppercaseException;
import com.kpi.lab1.exceptions.OptionOutOfRangeException;
import com.kpi.lab1.representation.Book;
import com.kpi.lab1.representation.Datasource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class Controler implements Runnable {
  private static final Logger LOGGER = LogManager.getLogger(Controler.class.getName());

  private Model model;
  private Reader reader;

  public Controler() {
    this.reader = new Reader();
    this.model = new Model(Datasource.data());
  }

  @Override
  public void run() {
    if (model.data() == null) {
      LOGGER.fatal("Failed to retrieve data from datasource. Exiting.");
      return;
    }

    LOGGER.info("Starting controler.");
    Viewer.println(model.data());
    int option;
    while (true) {
      LOGGER.info("Waiting for option to process.");
      Viewer.choice();

      try {
        option = Integer.parseInt(reader.readLine());
      } catch (NumberFormatException e) {
        Viewer.noFormat();
        LOGGER.error("Invalid option format.");
        continue;
      }

      LOGGER.debug("Processing query: " + option + ".");

      if (option == 4) {
        LOGGER.debug("Trying to save data.");
        Datasource.save(model.data());
        break;
      }

      try {
        LOGGER.debug("Validating option.");
        Validator.validateOption(option);
        execute(option);
      } catch (OptionOutOfRangeException e) {
        LOGGER.error("Option is out of range.");
        Viewer.noOption();
      } catch (NotUppercaseException e) {
        LOGGER.error("First letter is not uppercase.");
        Viewer.noUppercase();
      } catch (InvalidEntryException e)  {
        LOGGER.error("Invalid format of entry: " + e.getMessage());
        Viewer.noEntryFormat();
        System.out.println(e.getMessage());
      }
    }
    LOGGER.info("Exiting controler.");
  }

  private void execute(int query) {
    switch (query) {
      case 0: {
        LOGGER.info("Executing option 'Get books by author'.");
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
        LOGGER.info("Executing option 'Get books by publisher'.");
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
        LOGGER.info("Executing option 'Get books published after given year'.");
        Viewer.insert("year");
        int year;

        LOGGER.debug("Reading and validating year.");
        try {
          year = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
          Viewer.noFormat();
          LOGGER.error("Invalid year format.");
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
        LOGGER.debug("Executing option 'Add entry'.");
        Viewer.insertEntry();
        model.addEntry(reader.readLine());
      }
    }
  }
}
