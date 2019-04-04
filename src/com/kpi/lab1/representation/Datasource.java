package com.kpi.lab1.representation;

import com.kpi.lab1.core.Validator;
import com.kpi.lab1.core.Viewer;
import com.kpi.lab1.exceptions.InvalidEntryException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public final class Datasource {
  private static final String FILE_NAME = "books.txt";
  private static Book[] books;
  private static int length;

  private Datasource() { }

  public static Book[] data() {
    if (books != null) return books;

    try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
      int n = Integer.parseInt(scanner.nextLine().trim()), i = 0;
      length = n;
      books = new Book[n];
      while (scanner.hasNextLine()) {
        String[] parts = scanner.nextLine().split(",");
        int id = Integer.parseInt(parts[0].trim());
        String title     = parts[1].trim();
        String author    = parts[2].trim();
        String publisher = parts[3].trim();
        int year  = Integer.parseInt(parts[4].trim());
        int pages = Integer.parseInt(parts[5].trim());
        int price = Integer.parseInt(parts[6].trim());
        books[i++] = new Book(id, title, author, publisher, year, pages, price);
      }

      return books;
    } catch (FileNotFoundException e) {
      Viewer.noFile();
    } catch (Exception e) {
      Viewer.noFileFormat();
      System.out.println(e.getMessage());
    }

    books = null;
    length = 0;
    return null;
  }

  public static void save() {
    if (books == null) return;

    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
      writer.println(length);
      for (int i = 0; i < length; i++) {
        writer.println(books[i].asCsv());
      }
    } catch (IOException e) {
      Viewer.noFile();
    }
  }

  public static void addEntry(String entry) {
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
        books = Arrays.copyOfRange(books, 0, length);
      books[length - 1] = book;
    } catch (Exception e) {
      throw new InvalidEntryException(e);
    }
  }
}
