package com.company.comparators;

import com.company.shapes.Shape;

import java.util.Comparator;

public class AreaShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        double difference = o1.calcArea() - o2.calcArea();
        return difference > 0 ? 1
               : (difference == 0 ? 0 : -1);
    }
}
