package com.aula.livraria.model.author;


import com.aula.livraria.model.book.BookDTO;
import com.aula.livraria.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    public static Author toEntity(AuthorDTO authorDTO) {
        Author author = new Author();

        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setGender(authorDTO.getGender());

        return author;
    }

}
