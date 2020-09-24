package com.company.shapes;

import com.company.exceptions.IncorrectShapeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    @ParameterizedTest
    @MethodSource("triangleObjectAndActualProvider")
    void testCalcAreaWithCorrectSides(Triangle form, double actual) {
        double expected = form.calcArea();
        assertEquals(expected, actual);
    }

    static Stream<Arguments> triangleObjectAndActualProvider() throws IncorrectShapeException {
        return Stream.of(
                Arguments.of(new Triangle("color", 2, 2, 3), 1.984313483298443),
                Arguments.of(new Triangle("color", 0.46, 0.34, 0.75), 0.05152532750987618)
        );
    }

    @Test
    void testCalcAreaWithIncorrectParameters() {
        assertThrows(IncorrectShapeException.class,
                () -> new Triangle("color", 1, 2, 3));
        assertThrows(IncorrectShapeException.class,
                () -> new Triangle("color", 3, 1, 2));
        assertThrows(IncorrectShapeException.class,
                () -> new Triangle("color", 2, 3, 1));
        assertThrows(IncorrectShapeException.class,
                () -> new Triangle("color", 0, 0, 0));
        assertThrows(IncorrectShapeException.class,
                () -> new Triangle("color", -2, 2, 3));
        assertThrows(IncorrectShapeException.class,
                () -> new Triangle("color", 2, -2, 3));
        assertThrows(IncorrectShapeException.class,
                () -> new Triangle("color", 2, 2, -3));
        assertThrows(IllegalArgumentException.class,
                () -> new Triangle(null, 1, 1, 1));
    }
}