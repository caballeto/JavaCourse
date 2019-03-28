package com.kpi.lab2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Model {
  private static final int TOP = 5;

  @NotNull
  static List<Point> closest(Set<Point> points, double a, double b, double c) {
    return selectTop(points, a, b, c, false);
  }

  @NotNull
  static List<Point> furthest(Set<Point> points, double a, double b, double c) {
    return selectTop(points, a, b, c, true);
  }

  static double distance(Point point, double a, double b, double c) {
    return Math.abs(a*point.x() + b*point.y() + c)/Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
  }

  private static List<Point> selectTop(Set<Point> points, double a, double b, double c, boolean ordering) {
    Comparator<Point> comparator = (Point p1, Point p2) -> {
      double dist1 = distance(p1, a, b, c), dist2 = distance(p2, a, b, c);
      return ordering ? Double.compare(dist1, dist2) : -Double.compare(dist1, dist2);
    };

    PriorityQueue<Point> queue = new PriorityQueue<>(TOP + 1, comparator);

    for (var point : points) {
      queue.add(point);
      if (queue.size() > TOP) queue.poll();
    }

    return new ArrayList<>(queue);
  }
}
