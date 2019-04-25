package com.kpi.lab2;

import java.util.*;

public class Model {
  private static final int TOP = 5;

  private Set<Point> data;
  private double a, b, c;

  public Comparator<Point> MIN = Comparator.comparingDouble(point -> -distance(point, a, b, c));
  public Comparator<Point> MAX = Comparator.comparingDouble(point -> distance(point, a, b, c));

  public Model(Set<Point> data, double a, double b, double c) {
    this.data = data;
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public Set<Point> data() {
    return data;
  }

  public double a() {
    return a;
  }

  public double b() {
    return b;
  }

  public double c() {
    return c;
  }

  public List<Point> closest() {
    return selectTop(data, MIN);
  }

  public List<Point> furthest() {
    return selectTop(data, MAX);
  }

  private List<Point> selectTop(Set<Point> points, Comparator<Point> comparator) {
    PriorityQueue<Point> queue = new PriorityQueue<>(TOP + 1, comparator);

    for (var point : points) {
      queue.add(point);
      if (queue.size() > TOP) queue.poll();
    }

    return new ArrayList<>(queue);
  }

  public Point min() {
    return select(MIN);
  }

  public Point max() {
    return select(MAX);
  }

  private Point select(Comparator<Point> comparator) {
    var iterator = data.iterator();
    Point point = iterator.next();
    while (iterator.hasNext()) {
      Point that = iterator.next();
      if (comparator.compare(that, point) > 0) {
        point = that;
      }
    }

    return point;
  }

  static double distance(Point point, double a, double b, double c) {
    return Math.abs(a*point.x() + b*point.y() + c)/Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
  }
}
