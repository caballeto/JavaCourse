package com.kpi.lab1;

public final class Datasource {
  static Book[] data() {
    return new Book[] {
      new Book(0, "Lord of the Rings", "Tolkien", "Allen & Unwin", 1954, 820, 25),
      new Book(1, "Second World War", "Winston Churchill", "Bantnam", 1946, 3000, 90),
      new Book(2, "Quo Vadis", "Henryk Sienkiewicz", "Poland press", 1895, 555, 40),
      new Book(3, "Design patterns", "Robert Nystrom", "GB", 2015, 270, 25),
      new Book(4, "Hobbit", "Tolkien", "Allen & Unwin", 1937, 310, 18),
      new Book(5, "Gulag Archipelago", "Solzhenitsyn", "Samisdat", 1973, 2000, 50),
      new Book(6, "Principles", "Ray Dalio", "Amazon", 2018, 650, 35),
      new Book(7, "Memoirs", "Saharov", "Samisdat", 1987, 920, 45),
      new Book(8, "Path to power", "Thatcher", "London press", 1992, 870, 60),
      new Book(9, "Portrait of courage", "Kennedy", "Harvard press", 1958, 325, 37)
    };
  }
}
