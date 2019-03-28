package com.kpi.lab1;

import static com.kpi.lab1.Viewer.FORMAT_2;
import static com.kpi.lab1.Viewer.FORMAT_6;
import static com.kpi.lab1.Viewer.FORMAT_20;

public final class Book {
  private final int id;
  private final String title;
  private final String author;
  private final String publisher;
  private final int year;
  private final int pages;
  private final int price;

  public Book(int id, String title, String author, String publisher, int year, int pages, int price) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.year = year;
    this.pages = pages;
    this.price = price;
  }

  @Override
  public String toString() {
    return String.format(FORMAT_2, id + "")
      + String.format(FORMAT_20, title)
      + String.format(FORMAT_20, author)
      + String.format(FORMAT_20, publisher)
      + String.format(FORMAT_6, year + "")
      + String.format(FORMAT_6, pages + "")
      + String.format(FORMAT_6, price + "");
  }

  public int getId() {
    return id;
  }

  public int getYear() {
    return year;
  }

  public int getPages() {
    return pages;
  }

  public int getPrice() {
    return price;
  }

  public String getPublisher() {
    return publisher;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }
}
