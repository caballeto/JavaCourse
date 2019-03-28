package com.kpi.lab2;

import java.util.HashSet;
import java.util.List;

public class Controler implements Runnable {
  private HashSet<Point> data;
  private double a, b, c;

  public Controler() {
    Datasource source = new Datasource();
    this.data = source.data();
    this.a = source.a();
    this.b = source.b();
    this.c = source.c();
  }

  @Override
  public void run() {
    if (data == null) return;
    Viewer.header(a, b, c);
    Viewer.println(data);

    List<Point> pclosest = Model.closest(data, a, b, c);
    Viewer.closest();
    Viewer.println(pclosest, a, b, c);

    List<Point> pfurthest = Model.furthest(data, a, b, c);
    Viewer.furthest();
    Viewer.println(pfurthest, a, b, c);
  }
}
