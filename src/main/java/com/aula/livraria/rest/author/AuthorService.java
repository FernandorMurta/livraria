package com.aula.livraria.rest.author;

import com.aula.livraria.exceptions.*;
import com.aula.livraria.model.author.AuthorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AuthorService {

    AuthorDTO findById(Long id) throws AuthorNotFoundException;

    AuthorDTO createAuthor(AuthorDTO author) throws ValidationNullableException, ValidationLengthException;

    AuthorDTO updateAuthor(AuthorDTO author, Long id) throws MalformedBodyException, AuthorNotFoundException;

    void deleteAuthorById(Long id, Boolean deleteWithBooks) throws AuthorNotFoundException, AuthorContainsBooksException;

    Page<AuthorDTO> findByParams(String name, Pageable pageable);

}
