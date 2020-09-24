package com.company.comparators;

import com.company.exceptions.IncorrectShapeException;
import com.company.shapes.Circle;
import com.company.shapes.Shape;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class AreaShapeComparatorTest {
    @ParameterizedTest()
    @MethodSource("twoCorrectShapeObjectsAndActualProvider")
    void testCompareWithCorrectObjects(Shape o1, Shape o2, int actual) {
        AreaShapeComparator comparator = new AreaShapeComparator();
        int expected = comparator.compare(o1, o2);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> twoCorrectShapeObjectsAndActualProvider() throws IncorrectShapeException {
        return Stream.of(
                Arguments.of(new Circle("c", 0.5), new Circle("c", 1), -1),
                Arguments.of(new Circle("c", 1), new Circle("c", 1), 0),
                Arguments.of(new Circle("c", 0.5), new Circle("c", 0.25), 1)
        );
    }
}