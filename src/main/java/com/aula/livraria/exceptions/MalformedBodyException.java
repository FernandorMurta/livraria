package com.aula.livraria.exceptions;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Exception Created to be threw when the client wants to update a entity but
 * the ID from the path and the ID from the body request is different
 */
public class MalformedBodyException extends Exception {

    private static final String _DEFAULT_MSG = "Body ID does not match with selected resource";

    public MalformedBodyException() {
        super(_DEFAULT_MSG);
    }
}

