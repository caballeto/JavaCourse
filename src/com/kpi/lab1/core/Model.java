package com.kpi.lab1.core;

import com.kpi.lab1.exceptions.InvalidEntryException;
import com.kpi.lab1.representation.Book;

import java.util.Arrays;

public final class Model {
  private Book[] books;
  private int length;

  public Model(Book[] books) {
    this.books = books;
    this.length = books.length;
  }

  public Book[] getByAuthor(String author) {
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

    return selected;
  }

  public Book[] getByPublisher(String publisher) {
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

    return selected;
  }

  public Book[] getByYearMoreThan(int year) {
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

    return selected;
  }

  public void addEntry(String entry) {
    String[] parts = entry.split(",");

    if (parts.length != 6) {
      throw new InvalidEntryException("Input entry has invalid number of columns.");
    }

    try {
      String title     = parts[0].trim();
      String author    = parts[1].trim();
      String publisher = parts[2].trim();
      int year  = Integer.parseInt(parts[3].trim());
      int pages = Validator.validatePositive(Integer.parseInt(parts[4].trim()));
      int price = Validator.validatePositive(Integer.parseInt(parts[5].trim()));

      Book book = new Book(length++, title, author, publisher, year, pages, price);
      if (length > books.length)
        books = Arrays.copyOf(books, length);
      books[length - 1] = book;
    } catch (Exception e) {
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
