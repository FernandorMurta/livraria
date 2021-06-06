package com.aula.livraria.exceptions;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Exception Created to be threw when the Entity Book was researched but not found any match with the parameters
 */
public class MalformedBodyException extends Exception {

    private static final String _DEFAULT_MSG = "Body ID does not match with selected resource";

    public MalformedBodyException() {
        super(_DEFAULT_MSG);
    }
}

