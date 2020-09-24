package com.company.mvc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapesViewTest {

    @Test
    void testPrintInstances() {
        var view = new ShapesView();
        assertThrows(NullPointerException.class, () -> view.printInstances("hi", null));
    }
}