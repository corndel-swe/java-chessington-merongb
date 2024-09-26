package com.corndel.exercises;

public class Circle implements Shape {
  private double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public double getArea() {
    return radius * radius * 3.14;
  }

  public double getPerimeter() {
    return 2 * 3.14 * radius;
  }
}
