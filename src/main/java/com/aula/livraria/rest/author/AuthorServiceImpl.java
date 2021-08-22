package com.aula.livraria.rest.author;

import com.aula.livraria.exceptions.*;
import com.aula.livraria.model.author.Author;
import com.aula.livraria.model.author.AuthorDTO;
import com.aula.livraria.repository.author.AuthorRepository;
import com.aula.livraria.rest.book.BookService;
import com.aula.livraria.rest.book.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final BookService bookService;

    @Autowired
    AuthorServiceImpl(AuthorRepository authorRepository,
                      BookServiceImpl bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }


    @Override
    public AuthorDTO findById(Long id) throws AuthorNotFoundException {
        Author author = this.authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        return AuthorDTO.fromEntity(author, true);
    }


    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) throws ValidationNullableException, ValidationLengthException {
        //TODO RTI - Reparo Tecnico Improvisado
        if (authorDTO.getGender() == null) {
            throw new ValidationNullableException("Gender");
        }

        if (authorDTO.getName() == null) {
            throw new ValidationNullableException("Name");
        }

        if (authorDTO.getName().length() > 20) {
            throw new ValidationLengthException("Name", "20");
        }

        Author entity = this.authorRepository.save(AuthorDTO.toEntity(authorDTO));
        return AuthorDTO.fromEntity(entity, false);
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO author, Long id) throws MalformedBodyException, AuthorNotFoundException {
        if (!author.getId().equals(id)) {
            throw new MalformedBodyException();
        }

        Author entity = this.authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);

        entity.setName(author.getName());
        entity.setGender(author.getGender());
        entity = this.authorRepository.save(entity);

        return AuthorDTO.fromEntity(entity, false);
    }

    @Override
    public void deleteAuthorById(Long id, Boolean deleteWithBooks) throws AuthorNotFoundException, AuthorContainsBooksException {
        Author entity = this.authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        if (entity.getBooks() != null && !deleteWithBooks) {
            throw new AuthorContainsBooksException();
        } else if (entity.getBooks() != null) {
            this.bookService.deleteBookByAuthorId(entity);
        }
        this.authorRepository.delete(entity);
    }

    @Override
    public Page<AuthorDTO> findByParams(String name, Pageable pageable) {
        return this.authorRepository.findAllByNameContainsIgnoreCase(name, pageable);
    }
}
