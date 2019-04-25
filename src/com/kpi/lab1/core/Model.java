package com.kpi.lab1.core;

import com.kpi.lab1.exceptions.InvalidEntryException;
import com.kpi.lab1.representation.Book;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public final class Model {
  private static final Logger LOGGER = LogManager.getLogger(Model.class.getName());

  private Book[] books;
  private int length;

  public Model(Book[] books) {
    LOGGER.debug("Instantiating model.");
    this.books = books;
    this.length = books.length;
  }

  public Book[] getByAuthor(String author) {
    LOGGER.info("Getting books by author: " + author + ".");
    int count = 0;
    for (Book book : books) {
      if (book.getAuthor().equals(author)) {
        count++;
      }
    }

    Book[] selected = new Book[count];
    count = 0;
    for (Book book : books) {
      if (book.getAuthor().equals(author)) {
        selected[count++] = book;
      }
    }

    LOGGER.debug("Selected " + count + " books.");
    return selected;
  }

  public Book[] getByPublisher(String publisher) {
    LOGGER.info("Getting books by publisher: " + publisher + ".");
    int count = 0;
    for (Book book : books) {
      if (book.getPublisher().equals(publisher)) {
        count++;
      }
    }

    Book[] selected = new Book[count];
    count = 0;
    for (Book book : books) {
      if (book.getPublisher().equals(publisher)) {
        selected[count++] = book;
      }
    }

    LOGGER.debug("Selected " + count + " books.");
    return selected;
  }

  public Book[] getByYearMoreThan(int year) {
    LOGGER.info("Getting books published after year: " + year + ".");
    int count = 0;
    for (Book book : books) {
      if (book.getYear() > year) {
        count++;
      }
    }

    Book[] selected = new Book[count];
    count = 0;
    for (Book book : books) {
      if (book.getYear() > year) {
        selected[count++] = book;
      }
    }

    LOGGER.debug("Selected " + count + " books.");
    return selected;
  }

  public void addEntry(String entry) {
    LOGGER.info("Trying to add entry to data.");
    String[] parts = entry.split(",");

    LOGGER.debug("Validating if entry has right number of columns.");
    if (parts.length != 6) {
      throw new InvalidEntryException("Input entry has invalid number of columns.");
    }

    try {
      LOGGER.debug("Parsing title, author, publisher fields.");
      String title     = parts[0].trim();
      String author    = parts[1].trim();
      String publisher = parts[2].trim();

      LOGGER.debug("Parsing year, pages, price fields.");
      int year  = Integer.parseInt(parts[3].trim());
      int pages = Validator.validatePositive(Integer.parseInt(parts[4].trim()));
      int price = Validator.validatePositive(Integer.parseInt(parts[5].trim()));

      Book book = new Book(length++, title, author, publisher, year, pages, price);
      if (length > books.length)
        books = Arrays.copyOf(books, length);
      books[length - 1] = book;
      LOGGER.info("Added entry successfully.");
    } catch (Exception e) {
      LOGGER.error("Invalid entry format: " + e.getMessage());
      throw new InvalidEntryException(e);
    }
  }

  public Book[] data() {
    return books;
  }

  public void setData(Book[] books) {
    this.books = books;
  }
}
