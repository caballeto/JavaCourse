package com.kpi.lab1.core;

import com.kpi.lab1.representation.Book;

public final class Viewer {
  public static final String FORMAT_20 = "%20s|";
  public static final String FORMAT_6 = "%6s|";
  public static final String FORMAT_2 = "%2s|";

  private static final String LINE = "------------------------------" +
    "---------------------------------------------------------";

  private static final String HEADER = String.format(FORMAT_2, "Id")
    + String.format(FORMAT_20, "Title")
    + String.format(FORMAT_20, "Author")
    + String.format(FORMAT_20, "Publisher")
    + String.format(FORMAT_6, "Year")
    + String.format(FORMAT_6, "Pages")
    + String.format(FORMAT_6, "Price");

  public static void println(Book[] books) {
    if (books == null) return;

    System.out.println(HEADER);
    System.out.println(LINE);
    for (var book : books) {
      System.out.println(book);
    }
  }

  public static void insert(String s) {
    System.out.print("Insert " + s + ". \n> ");
  }

  public static void insertEntry() {
    System.out.println("Add entry to the database in the format:");
    System.out.println("[ title, author, publisher, year, pages, price ]");
  }

  public static void noFormat() {
    System.out.println("Illegal number format. Please try again.");
  }

  public static void noEntryFormat() {
    System.out.println("Invalid entry format.");
  }

  public static void noFileFormat() {
    System.out.println("Incorrect file formatting. Please see reference data file for correct format.");
  }

  public static void noUppercase() {
    System.out.println("The author/publisher should start with uppercase letter.");
  }

  public static void noFile() {
    System.out.println("Data file wasn't found.");
  }

  public static void noOption() {
    System.out.println("No such option available. Please try again.");
  }

  public static void noAuthor() {
    System.out.println("No books with such author. Please try again.");
  }

  public static void noPublisher() {
    System.out.println("No books with such publisher. Please try again.");
  }

  public static void noYear() {
    System.out.println("No books were published after that year. Please try again.");
  }

  public static void choice() {
    System.out.println("Insert query type.");
    System.out.println("0. Get books of given author.");
    System.out.println("1. Get books of given publisher.");
    System.out.println("2. Get books published after given year.");
    System.out.println("3. Add entry to the data.");
    System.out.println("4. Exit.");
    System.out.print("> ");
  }
}
