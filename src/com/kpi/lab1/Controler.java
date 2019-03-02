package com.kpi.lab1;

public class Controler {
  public static Book[] getByAuthor(Book[] books, String author) {
    int count = 0;
    for (Book book : books) {
      if (book.getAuthor().equals(author)) {
        count++;
      }
    }
    int end = count;
    Book[] selected = new Book[count];
    for (Book book : books) {
      if (book.getAuthor().equals(author)) {
        selected[end - count--] = book;
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
    int end = count;
    Book[] selected = new Book[count];
    for (Book book : books) {
      if (book.getPublisher().equals(publisher)) {
        selected[end - count--] = book;
      }
    }

    return selected;
  }

  public static Book[] getByYearLessThan(Book[] books, int year) {
    int count = 0;
    for (Book book : books) {
      if (book.getYear() > year) {
        count++;
      }
    }
    int end = count;
    Book[] selected = new Book[count];
    for (Book book : books) {
      if (book.getYear() > year) {
        selected[end - count--] = book;
      }
    }

    return selected;
  }
}
