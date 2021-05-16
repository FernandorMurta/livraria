package com.aula.livraria.rest.author;

import com.aula.livraria.model.author.Author;

import java.util.List;

public interface AuthorService {

    Author findById(Long id);

    List<Author> findAll();

    Author createAuthor(Author author);

    Author updateAuthor(Author author, Long id);
}
