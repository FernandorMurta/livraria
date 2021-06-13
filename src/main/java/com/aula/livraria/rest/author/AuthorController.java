package com.aula.livraria.rest.author;

import com.aula.livraria.exceptions.AuthorContainsBooksException;
import com.aula.livraria.exceptions.AuthorNotFoundException;
import com.aula.livraria.exceptions.MalformedBodyException;
import com.aula.livraria.model.author.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = AuthorController._PATH)
public class AuthorController {

    public static final String _PATH = "/author";

    private final AuthorService authorService;

    @Autowired
    AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    public ResponseEntity<Page<AuthorDTO>> findByParams(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                                                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "qtd", defaultValue = "10") Integer qtd) {

        return ResponseEntity.status(HttpStatus.OK).body(this.authorService.findByParams(name, PageRequest.of(page, qtd)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> saveAuthor(@RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.authorService.createAuthor(authorDTO));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.authorService.findById(id));
        } catch (AuthorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> updateAuthor(@RequestBody AuthorDTO authorDTO, @PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.authorService.updateAuthor(authorDTO, id));
        } catch (AuthorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (MalformedBodyException malformedBodyException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, malformedBodyException.getMessage(), malformedBodyException);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(value = "id") Long id,
                                               @RequestParam(name = "deleteWithBooks") Boolean deleteWithBooks) {
        try {
            this.authorService.deleteAuthorById(id, deleteWithBooks);
            return ResponseEntity.status(HttpStatus.OK).body("Resource Deleted");
        } catch (AuthorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (AuthorContainsBooksException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
        }
    }

}
