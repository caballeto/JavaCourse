package com.kpi.lab1;

public class Viewer {
  static final String FORMAT_20 = "%20s";
  static final String FORMAT_6 = "%6s";
  static final String FORMAT_2 = "%2s";

  private static final String HEADER = String.format(FORMAT_2, "Id")
    + String.format(FORMAT_20, "Title")
    + String.format(FORMAT_20, "Author")
    + String.format(FORMAT_20, "Publisher")
    + String.format(FORMAT_6, "Year")
    + String.format(FORMAT_6, "Pages")
    + String.format(FORMAT_6, "Price");

  static void println(Book[] books) {
    System.out.println(HEADER);
    for (Book book : books) {
      System.out.println(book);
    }
  }

  static void insert(String s) {
    System.out.print("Insert " + s + ". \n> ");
  }

  static void noFormat() {
    System.out.println("Illegal format. Please try again.");
  }

  static void noOption() {
    System.out.println("No such option available. Please try again.");
  }

  static void noAuthor() {
    System.out.println("No books with such author. Please try again.");
  }

  static void noPublisher() {
    System.out.println("No books with such publisher. Please try again.");
  }

  static void noYear() {
    System.out.println("No books were published after that year. Please try again.");
  }

  static void choice() {
    System.out.print(
      "Insert query type. [" +
        "0 - get books of given author, " +
        "1 - get books of given publisher, " +
        "2 - get books published after given year, " +
        "3 - exit" +
        "] \n> "
    );
  }
}
