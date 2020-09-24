package com.company.shapes;

import com.company.exceptions.IncorrectShapeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void testShapeWithNullValue() throws IncorrectShapeException {
        assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(null, 1, 2));
    }

    @Test
    void testSetShapeColorWithNullValue() throws IncorrectShapeException {
        var form = new Rectangle("color", 1, 2);
        assertThrows(IllegalArgumentException.class, () -> form.setShapeColor(null));
    }
}