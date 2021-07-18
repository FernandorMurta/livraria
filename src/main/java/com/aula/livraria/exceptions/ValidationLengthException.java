package com.aula.livraria.exceptions;

public class ValidationLengthException extends Exception {

    private static final String _DEFAULT_MSG = "%s have limit of %d characters!";

    public ValidationLengthException(String field, String size) {
        super(_DEFAULT_MSG.replace("%s", field).replace("%d", size));
    }
}
