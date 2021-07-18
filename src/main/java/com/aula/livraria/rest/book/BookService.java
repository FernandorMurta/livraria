package com.aula.livraria.rest.book;

import com.aula.livraria.exceptions.BookNotFoundException;
import com.aula.livraria.exceptions.MalformedBodyException;
import com.aula.livraria.model.author.Author;
import com.aula.livraria.model.book.Book;
import com.aula.livraria.model.book.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Interface representing the contract needed to the Business Logic for the Entity book
 */
public interface BookService {

    Page<BookDTO> findByParams(String name, String category, Pageable pageable);

    BookDTO create(BookDTO book);

    BookDTO findBookById(Long id) throws BookNotFoundException;

    void deleteBookById(Long id) throws BookNotFoundException;

    void deleteBookByAuthorId(Author author);

    Book updateBook(Book book, Long id) throws BookNotFoundException, MalformedBodyException;

}
