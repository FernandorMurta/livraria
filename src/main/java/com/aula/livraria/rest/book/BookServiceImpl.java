package com.aula.livraria.rest.book;

import com.aula.livraria.exceptions.BookNotFoundException;
import com.aula.livraria.exceptions.MalformedBodyException;
import com.aula.livraria.model.book.Book;
import com.aula.livraria.model.book.BookDTO;
import com.aula.livraria.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Class who implements the contract (interface) for the Book Entity where all the Business Logic is built.
 * All Integration need with the Data Layer or other system (by REST API or other method) for the book entity will be built in this class.
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public BookDTO create(BookDTO book) {
        Book entity = BookDTO.toEntity(book);
        entity = this.bookRepository.save(entity);

        return BookDTO.fromEntity(entity);
    }

    @Override
    public BookDTO findBookById(Long id) throws BookNotFoundException {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return BookDTO.fromEntity(book);
    }

    @Override
    public void deleteBookById(Long id) throws BookNotFoundException {
        Book entity = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        this.bookRepository.delete(entity);
    }

    @Override
    public Book updateBook(Book book, Long id) throws BookNotFoundException, MalformedBodyException {
        if (!book.getId().equals(id)) {
            throw new MalformedBodyException();
        }

        Book entity = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        entity.setName(book.getName());
        entity.setAuthor(book.getAuthor());
        entity.setPublishCompany(book.getPublishCompany());
        entity.setForSale(book.getForSale());
        entity.setQuantity(book.getQuantity());
        entity.setPrice(book.getPrice());
        entity.setCategory(book.getCategory());

        return this.bookRepository.save(entity);
    }
}

