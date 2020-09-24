package com.company.shapes;

import com.company.exceptions.IncorrectShapeException;

public class Rectangle extends Shape {

    private final double a;
    private final double b;

    public Rectangle(String shapeColor, double a, double b) throws IncorrectShapeException {
        super(shapeColor);
        if (a <= 0 || b <= 0)
            throw new IncorrectShapeException();
        else {
            this.a = a;
            this.b = b;
        }
    }

    @Override
    public double calcArea() {
        return a * b;
    }

    @Override
    public void draw() {    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}
