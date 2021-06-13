package com.aula.livraria.exceptions;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 *
 * Exception Created to be threw when the Entity Author tries to delete but they have books related to the entity
 */
public class AuthorContainsBooksException extends Exception {

    private static final String _DEFAULT_MSG = "Author have books related to him ";

    public AuthorContainsBooksException() {
        super(_DEFAULT_MSG);
    }

}
