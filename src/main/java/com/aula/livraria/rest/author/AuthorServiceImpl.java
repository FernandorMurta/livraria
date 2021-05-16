package com.aula.livraria.rest.author;

import com.aula.livraria.model.author.Author;
import com.aula.livraria.repository.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Class who implements the contract (interface) for the Author Entity where all the Business Logic is built.
 * All Integration need with the Data Layer or other system (by REST API or other method) for the book entity will be built in this class.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author findById(Long id) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Author createAuthor(Author author) {
        return null;
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        return null;
    }
}
