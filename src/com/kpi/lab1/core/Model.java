package com.kpi.lab1.core;

import com.kpi.lab1.representation.Book;

public final class Model {
  public static Book[] getByAuthor(Book[] books, String author) {
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

  public static Book[] getByPublisher(Book[] books, String publisher) {
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

  public static Book[] getByYearMoreThan(Book[] books, int year) {
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
}
