package com.company.shapes;

import com.company.interfaces.Drawable;

import java.io.Serializable;

public abstract class Shape implements Drawable, Serializable {

    private String shapeColor;

    public Shape(String shapeColor) {
        if (shapeColor == null)
            throw new IllegalArgumentException();
        else
            this.shapeColor = shapeColor;
    }

    public final String getShapeColor() { return shapeColor; }

    public final void setShapeColor(String shapeColor) {
        if (shapeColor == null)
            throw new IllegalArgumentException();
        else
            this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return shapeColor;
    }
}
