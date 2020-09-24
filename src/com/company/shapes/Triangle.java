package com.company.shapes;

import com.company.exceptions.IncorrectShapeException;

public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(String shapeColor, double a, double b, double c) throws IncorrectShapeException {
        super(shapeColor);
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IncorrectShapeException();
        else if (a + b <= c || a + c <= b || b + c <= a)
            throw new IncorrectShapeException("Such triangle can not exist.");
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    @Override
    public double calcArea() {
        double p = halfPerimeter(a, b, c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void draw() {  }

    @Override
    public String toString() {
        return "Triangle";
    }

    private static double halfPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }
}
