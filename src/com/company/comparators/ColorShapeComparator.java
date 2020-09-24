package com.company.comparators;

import com.company.shapes.Shape;

import java.util.Comparator;

public class ColorShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getShapeColor().compareTo(o2.getShapeColor());
    }
}
