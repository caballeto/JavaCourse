package com.kpi.lab1.representation;

import com.kpi.lab1.core.Viewer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class Datasource {
  private static final Logger LOGGER = LogManager.getLogger(Datasource.class.getName());
  private static final String FILE_NAME = "books.txt";
  private static Book[] books;

  private Datasource() { }

  @NotNull
  public static Book[] data() {
    LOGGER.info("Retrieving data from data source.");
    if (books != null) return books;

    try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
      LOGGER.debug("Reading file: " + FILE_NAME + ".");
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

      LOGGER.debug("Read file successfully. Number of entries: " + books.length + ".");
      return books;
    } catch (FileNotFoundException e) {
      LOGGER.error("File '" + FILE_NAME + "' was not found.");
      Viewer.noFile();
    } catch (Exception e) {
      LOGGER.error("Invalid file format: " + e.getMessage());
      Viewer.noFileFormat();
      System.out.println(e.getMessage());
    }

    return null;
  }

  public static void save(Book[] data) {
    if (data == null) return;

    LOGGER.info("Trying to save data.");

    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
      LOGGER.debug("Saving data to '" + FILE_NAME + "'.");
      writer.println(data.length);
      for (var book : data) {
        writer.println(book.asCsv());
      }
    } catch (IOException e) {
      LOGGER.error("Caught IOException: " + e.getMessage());
      Viewer.noFile();
    }
  }
}
