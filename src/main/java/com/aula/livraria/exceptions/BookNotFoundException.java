package com.aula.livraria.exceptions;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 *
 * Exception Created to be threw when the Entity Book was researched but not found any match with the parameters
 */
public class BookNotFoundException extends Exception {

    private static final String _DEFAULT_MSG = "Book not Found";

    public BookNotFoundException() {
        super(_DEFAULT_MSG);
    }

}
