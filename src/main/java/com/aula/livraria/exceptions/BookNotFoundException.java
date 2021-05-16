package com.aula.livraria.exceptions;

public class BookNotFoundException extends Exception {

    private static final String _DEFAULT_MSG = "Book not Found";

    public BookNotFoundException() {
        super(_DEFAULT_MSG);
    }

}
