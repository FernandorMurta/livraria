package com.aula.livraria.rest.book;

import com.aula.livraria.exceptions.BookNotFoundException;
import com.aula.livraria.exceptions.MalformedBodyException;
import com.aula.livraria.model.book.Book;
import com.aula.livraria.model.book.BookDTO;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    BookDTO create(BookDTO book);

    BookDTO findBookById(Long id) throws BookNotFoundException;

    void deleteBookById(Long id) throws BookNotFoundException;

    Book updateBook(Book book, Long id) throws BookNotFoundException, MalformedBodyException;
}
