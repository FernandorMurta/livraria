package com.aula.livraria.rest.author;

import com.aula.livraria.exceptions.AuthorNotFoundException;
import com.aula.livraria.model.author.Author;
import com.aula.livraria.model.author.AuthorDTO;

import java.util.List;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Interface representing the contract needed to the Business Logic for the Entity Author
 */
public interface AuthorService {

    AuthorDTO findAuthorById(Long id) throws AuthorNotFoundException;

    List<Author> findAll();

    Author createAuthor(Author author);

    Author updateAuthor(Author author, Long id);
}
