package com.aula.livraria.exceptions;

public class ValidationNullableException extends Exception {

    private static final String _DEFAULT_MSG = "%s can not be null!";

    public ValidationNullableException(String field) {
        super(_DEFAULT_MSG.replace("%s", field));
    }
}
