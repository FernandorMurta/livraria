package com.aula.livraria.exceptions;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 *
 * Exception Created to be threw when the Entity Author was researched but not found any match with the parameters
 */
public class AuthorNotFoundException extends Exception {

    private static final String _DEFAULT_MSG = "Author not Found";

    public AuthorNotFoundException() {
        super(_DEFAULT_MSG);
    }

}
