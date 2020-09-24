package com.company.shapes;

import com.company.exceptions.IncorrectShapeException;

public class Circle extends Shape {

    private final double radius;

    public Circle(String shapeColor, double radius) throws IncorrectShapeException {
        super(shapeColor);
        if (radius <= 0)
            throw new IncorrectShapeException();
        else
            this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void draw() {   }

    @Override
    public String toString() {
        return "Circle";
    }
}
