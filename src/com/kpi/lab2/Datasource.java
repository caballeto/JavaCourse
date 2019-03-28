package com.kpi.lab2;

import java.util.HashSet;

public class Datasource {
  private static final int N = 20;
  private static final double MAX = 20.0;
  private static final double MIN = 1.0;

  private HashSet<Point> data;
  private double a, b, c;

  public Datasource() {
    this.data = new HashSet<>();
    this.a = rand();
    this.b = rand();
    this.c = rand();
    for (int i = 0; i < N; i++) {
      double x = rand();
      double y = rand();
      this.data.add(new Point(x, y));
    }
  }

  private double rand() {
    return Math.random() * (MAX - MIN + 1) + MIN;
  }

  HashSet<Point> data() {
    return data;
  }

  double a() {
    return a;
  }

  double b() {
    return b;
  }

  double c() {
    return c;
  }
}
