package com.aula.livraria.rest.author;

import com.aula.livraria.exceptions.AuthorNotFoundException;
import com.aula.livraria.model.author.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = AuthorController._PATH)
public class AuthorController {

    public static final String _PATH = "/authors";

    private final AuthorService authorService;

    @Autowired
    AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> findAuthorById(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.authorService.findAuthorById(id));
        } catch (AuthorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
