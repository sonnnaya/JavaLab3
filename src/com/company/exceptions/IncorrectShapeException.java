package com.company.exceptions;

public class IncorrectShapeException extends Exception {

    public IncorrectShapeException() {
        super("Such shape can not exist.");
    }

    public IncorrectShapeException(String message) {
        super(message);
    }
}

