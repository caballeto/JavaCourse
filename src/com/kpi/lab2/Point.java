package com.kpi.lab2;

import java.util.Objects;

public class Point {
  private double x;
  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double x() {
    return x;
  }

  public double y() {
    return y;
  }

  @Override
  public String toString() {
    return "(" + String.format("%.2f", x) + "," + String.format("%.2f", y) + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    if (this.getClass() != obj.getClass()) return false;
    Point that = (Point) obj;
    return Double.compare(this.x, that.x) == 0 &&
      Double.compare(this.y, that.y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
