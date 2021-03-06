package com.aula.livraria.rest.book;

import com.aula.livraria.exceptions.BookNotFoundException;
import com.aula.livraria.exceptions.MalformedBodyException;
import com.aula.livraria.model.author.Author;
import com.aula.livraria.model.book.Book;
import com.aula.livraria.model.book.BookDTO;
import com.aula.livraria.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<BookDTO> findByParams(String name, String category, Pageable pageable) {
        return this.bookRepository.findAllByNameContainsIgnoreCaseAndCategoryContainsIgnoreCase(name, category, pageable);
    }

    @Override
    public BookDTO create(BookDTO book) {
        Book entity = BookDTO.toEntity(book);
        entity = this.bookRepository.save(entity);

        return BookDTO.fromEntity(entity, true);
    }

    @Override
    public BookDTO findBookById(Long id) throws BookNotFoundException {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return BookDTO.fromEntity(book, true);
    }

    @Override
    public void deleteBookById(Long id) throws BookNotFoundException {
        Book entity = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        this.bookRepository.delete(entity);
    }

    @Override
    public void deleteBookByAuthorId(Author author) {
        List<Book> listOfBooksFromAuthor = this.bookRepository.findAllByAuthor(author);
        this.bookRepository.deleteAll(listOfBooksFromAuthor);
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

