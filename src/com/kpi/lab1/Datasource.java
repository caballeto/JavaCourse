package com.kpi.lab1;

import java.io.*;
import java.util.Scanner;

public final class Datasource {
  private static final String FILE_NAME = "books.txt";
  private static Book[] books;

  static Book[] data() {
    if (books != null) return books;

    try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
      int n = Integer.parseInt(scanner.nextLine().trim()), i = 0;
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

    return null;
  }

  static void save() {
    if (books == null) return;

    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
      writer.println(books.length);
      for (var book : books) {
        writer.println(book.asCsv());
      }
    } catch (IOException e) {
      Viewer.noFile();
    }
  }
}
