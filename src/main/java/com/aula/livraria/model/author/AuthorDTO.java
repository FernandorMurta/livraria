package com.aula.livraria.model.author;


import com.aula.livraria.model.book.BookDTO;
import com.aula.livraria.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {

    private Long id;

    private String name;

    private Gender gender;

    private List<BookDTO> books;

    public AuthorDTO(Author author) {
        this.setId(author.getId());
        this.setName(author.getName());
        this.setGender(author.getGender());

        if (author.getBooks() != null) {
            this.setBooks(
                    author.getBooks()
                            .stream()
                            .map(book -> BookDTO.fromEntity(book, false))
                            .collect(Collectors.toList()));
        } else {
            this.setBooks(new ArrayList<>());
        }
    }

    public static Author toEntity(AuthorDTO authorDTO) {
        Author author = new Author();

        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setGender(authorDTO.getGender());

        return author;
    }

    public static AuthorDTO fromEntity(Author author, Boolean withBooks) {
        return AuthorDTO.builder()
                .name(author.getName())
                .gender(author.getGender())
                .id(author.getId())
                .books(withBooks && author.getBooks() != null ?
                        author.getBooks()
                                .stream()
                                .map(entity -> BookDTO.fromEntity(entity, false))
                                .collect(Collectors.toList())
                        : null)
                .build();
    }

}
