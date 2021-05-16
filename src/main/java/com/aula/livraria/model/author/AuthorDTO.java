package com.aula.livraria.model.author;


import com.aula.livraria.model.book.BookDTO;
import com.aula.livraria.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Object created to represent the Entity Author in the transition of data from the Data Layer to the Controller Layer
 * With this class we can handle better with witch data we want to share and can manipulate the data without impact the real Entity
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private Long id;

    private String name;

    private Gender gender;

    private List<BookDTO> books;

    public AuthorDTO(Long id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public static Author toEntity(AuthorDTO authorDTO) {
        Author author = new Author();

        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setGender(authorDTO.getGender());

        return author;
    }
}
