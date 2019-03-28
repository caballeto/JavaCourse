package com.kpi.lab2;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class Viewer {
  static void header(double a, double b, double c) {
    System.out.println("Generated line equation: " + a + "*x + " + b + "*y + " + c);
    System.out.println("Generated set of points:");
  }

  static void println(@NotNull Set<Point> points) {
    points.forEach(System.out::println);
  }

  static void println(@NotNull List<Point> points, double a, double b, double c) {
    for (var point : points) {
      System.out.println(point + " " + Model.distance(point, a, b, c));
    }
  }

  static void closest() {
    System.out.println();
    System.out.println("Top closest points:");
  }

  static void furthest() {
    System.out.println();
    System.out.println("Top furthest points:");
  }
}
