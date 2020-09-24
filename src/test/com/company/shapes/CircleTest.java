package com.company.shapes;

import com.company.exceptions.IncorrectShapeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTest {

    @ParameterizedTest
    @MethodSource("circleObjectAndActualProvider")
    void testCalcAreaWithNumbers(Circle form, double actual) {
        double expected = form.calcArea();
        assertEquals(expected, actual);
    }

    static Stream<Arguments> circleObjectAndActualProvider() throws IncorrectShapeException {
        return Stream.of(
                Arguments.of(new Circle("color", 1), 3.141592653589793),
                Arguments.of(new Circle("color", 5.89), 108.98844649760245)
        );
    }

    @Test
    void testCalcAreaWithWrongNumbers() {
        Assertions.assertThrows(IncorrectShapeException.class,
                () -> new Circle("color", -1));
        Assertions.assertThrows(IncorrectShapeException.class,
                () -> new Circle("color", 0));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Circle(null, 1));

    }
}