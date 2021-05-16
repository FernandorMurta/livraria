package com.aula.livraria.model.book;

import com.aula.livraria.model.author.Author;
import com.aula.livraria.model.author.AuthorDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Object created to represent the Entity Book in the transition of data from the Data Layer to the Controller Layer
 * With this class we can handle better with witch data we want to share and can manipulate the data without impact the real Entity
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String category;

    private String publishCompany;

    private AuthorDTO author;

    private Double price;

    private Integer quantity;

    private Boolean forSale;


    public static Book toEntity(BookDTO bookDTO) {
        Book book = new Book();

        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        book.setQuantity(bookDTO.getQuantity());
        book.setPrice(bookDTO.getPrice());
        book.setPublishCompany(bookDTO.getPublishCompany());

        book.setAuthor(AuthorDTO.toEntity(bookDTO.getAuthor()));

        return book;
    }

    public static BookDTO fromEntity(Book book) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setForSale(book.getForSale());
        bookDTO.setQuantity(book.getQuantity());
        bookDTO.setPublishCompany(book.getPublishCompany());

        Author author = book.getAuthor();
        AuthorDTO authorDTO = new AuthorDTO(author.getId(), author.getName(), author.getGender());

        bookDTO.setAuthor(authorDTO);

        return bookDTO;
    }

}
