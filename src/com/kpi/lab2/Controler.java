package com.kpi.lab2;

import java.util.List;

public class Controler implements Runnable {
  private Model model;

  public Controler() {
    Datasource source = new Datasource();
    double a = source.a();
    double b = source.b();
    double c = source.c();
    this.model = new Model(source.data(), a, b, c);
  }

  @Override
  public void run() {
    Viewer.header(model.a(), model.b(), model.c());
    Viewer.println(model.data());

    List<Point> closest = model.closest();
    Viewer.closest();
    Viewer.println(closest, model.a(), model.b(), model.c());

    List<Point> furthest = model.furthest();
    Viewer.furthest();
    Viewer.println(furthest, model.a(), model.b(), model.c());
  }
}
