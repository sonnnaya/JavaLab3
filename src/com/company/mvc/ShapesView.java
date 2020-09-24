package com.company.mvc;

import com.company.shapes.Shape;

import java.util.ArrayList;

public class ShapesView {

    public final String SHAPES_DATA = "All shapes: ";
    public final String SHAPES_SUM_ARES = "All areas sum is ";
    public final String CERTAIN_SHAPE_SUM_ARES = "s' areas sum is ";
    public final String SHAPES_SORTED_BY = "Shapes sorted by ";

    public void printInstances(String message, ArrayList<Shape> shapes)
    {
        if (shapes == null)
            throw new NullPointerException();

        System.out.println("\n" + message);
        for (Shape shape : shapes)
            System.out.println(shape + " :\t" + String.format("%.2f", shape.calcArea()) + "\t:\t" + shape.getShapeColor());
    }

    public void printMessageAndResult(String message, double result) {
        System.out.println("\n" + message + String.format("%.2f", result));
    }
}
