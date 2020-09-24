package com.company.mvc;

import com.company.exceptions.IncorrectShapeException;

import com.company.shapes.Circle;
import com.company.shapes.Rectangle;
import com.company.shapes.Shape;
import com.company.shapes.Triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ShapesModelTest {

    ShapesModel shapesModel;

    @BeforeEach
    void setUp() throws IncorrectShapeException {
        shapesModel = new ShapesModel(new Circle("red", 2.4),
                          new Rectangle("blue", 15, 2),
                          new Triangle("yellow", 3, 4,5),
                          new Circle("green", 4.89),
                          new Rectangle("brown", 3.5, 2.35),
                          new Triangle("white", 7, 2,6.4),
                          new Circle("orange", 8.9),
                          new Rectangle("pink", 1, 5.3),
                          new Triangle("grey", 3.02, 7.02,5.36),
                          new Circle("black", 8.5),
                          new Rectangle("blue", 6, 7),
                          new Triangle("yellow", 15, 10,6));
    }

    @Test
    void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new ShapesModel(null));
    }

    @Test
    void testGetShapes() {
        var expected = shapesModel.getShapes();

        var actual = new ArrayList<Shape>(expected);

        assertEquals(expected, actual);
    }

    @Test
    void testCalcAreasSum() {
        var expected = shapesModel.calcAreasSum();

        double actual = 0;
        for (Shape shape : shapesModel.getShapes())
            actual += shape.calcArea();

        assertEquals(expected, actual);
    }

    @Test
    void testCalcAreasSumOfNotShapeClass() {
        assertEquals(shapesModel.calcAreasSum(String.class), 0);
    }

    @ParameterizedTest
    @MethodSource("ExpectedClassAndModelProvider")
    void TestCalcAreasSumOfCertainShape(Class clazz) {
        var expected = shapesModel.calcAreasSum(clazz);

        double actual = 0;
        for (Shape shape : shapesModel.getShapes()) {
            if (shape.getClass() == clazz)
                actual += shape.calcArea();
        }

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("ExpectedClassAndModelProvider")
    void TestCalcAreasSumOfNotCreatedShape(Class clazz, ShapesModel shapesModel) {
        var expected = shapesModel.calcAreasSum(clazz);
        double actual = 0;
        assertEquals(expected, actual);
    }

    static Stream<Arguments> ExpectedClassAndModelProvider() throws IncorrectShapeException {
        return Stream.of(
                Arguments.of(Rectangle.class, new ShapesModel(new Circle("d", 1),
                        new Triangle("d", 1, 1, 1))),
                Arguments.of(Triangle.class, new ShapesModel(new Circle("d", 1),
                        new Rectangle("a", 1, 2))),
                Arguments.of(Circle.class, new ShapesModel(new Triangle("d", 1, 1, 1),
                        new Rectangle("a", 1, 2)))
        );
    }

    @Test
    void testSortByArea() {
        shapesModel.sortByArea();
        var expected = new ArrayList<Double>();
        for (Shape shape : shapesModel.getShapes())
            expected.add(shape.calcArea());

        shapesModel.sortByColor();
        var actual = new ArrayList<Double>();
        for (Shape shape : shapesModel.getShapes())
            actual.add(shape.calcArea());
        Collections.sort(actual);

        assertEquals(expected, actual);
    }

    @Test
    void testSortByColor() {
        shapesModel.sortByColor();
        var expected = new ArrayList<String>();
        for (Shape shape : shapesModel.getShapes())
            expected.add(shape.getShapeColor());

        shapesModel.sortByArea();
        var actual = new ArrayList<String>();
        for (Shape shape : shapesModel.getShapes())
            actual.add(shape.getShapeColor());
        Collections.sort(actual);

        assertEquals(expected, actual);
    }
}