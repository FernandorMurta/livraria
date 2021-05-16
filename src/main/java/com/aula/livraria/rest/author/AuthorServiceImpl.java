package com.aula.livraria.rest.author;

import com.aula.livraria.model.author.Author;
import com.aula.livraria.repository.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
