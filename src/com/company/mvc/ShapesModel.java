package com.company.mvc;

import com.company.comparators.AreaShapeComparator;
import com.company.comparators.ColorShapeComparator;
import com.company.shapes.Shape;

import java.util.ArrayList;
import java.util.Collections;

public class ShapesModel {

    private final ArrayList<Shape> shapes;

    public ShapesModel(Shape ... shapes) {
        if (shapes == null)
            throw new IllegalArgumentException();

        this.shapes = new ArrayList<>();
        Collections.addAll(this.shapes, shapes);
    }

    public ArrayList<Shape> getShapes() { return shapes; }

    public double calcAreasSum() {
        double sum = 0;
        for (Shape shape : shapes)
            sum += shape.calcArea();

        return sum;
    }

    public double calcAreasSum(Class clazz) {
        double sum = 0;
        for (Shape shape : shapes) {
            if (shape.getClass() == clazz)
                sum += shape.calcArea();
        }

        return sum;
    }

    public void sortByArea() {
        var comparator = new AreaShapeComparator();
        shapes.sort(comparator);
    }

    public void sortByColor() {
        var comparator = new ColorShapeComparator();
        shapes.sort(comparator);
    }
}
