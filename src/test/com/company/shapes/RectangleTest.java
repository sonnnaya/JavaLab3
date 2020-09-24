package com.company.shapes;

import com.company.exceptions.IncorrectShapeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RectangleTest {

    @ParameterizedTest
    @MethodSource("rectangleObjectAndActualProvider")
    void testCalcAreaWithCorrectSides(Rectangle form, double actual) {
        double expected = form.calcArea();
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> rectangleObjectAndActualProvider() throws IncorrectShapeException {
        return Stream.of(
                Arguments.of(new Rectangle("color", 1, 2), 1 * 2),
                Arguments.of(new Rectangle("color", 0.46, 0.34), 0.46 * 0.34)
        );
    }

    @Test
    void testCalcAreaWithIncorrectSides() {
        Assertions.assertThrows(IncorrectShapeException.class,
                                () -> new Rectangle("color", -1, 25));
        Assertions.assertThrows(IncorrectShapeException.class,
                                () -> new Rectangle("color", 0, 0));
        Assertions.assertThrows(IncorrectShapeException.class,
                                () -> new Rectangle("color", 2, -2));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(null, 2, 2));
    }

}