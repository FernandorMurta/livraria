package com.aula.livraria.model.book;

import com.aula.livraria.model.author.Author;
import com.aula.livraria.model.author.AuthorDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public BookDTO(Book book) {
        this.setId(book.getId());
        this.setName(book.getName());
        this.setCategory(book.getCategory());
        this.setPrice(book.getPrice());
        this.setForSale(book.getForSale());
        this.setQuantity(book.getQuantity());
        this.setPublishCompany(book.getPublishCompany());

        Author author = book.getAuthor();

        AuthorDTO authorDTO = AuthorDTO.builder()
                .id(author.getId())
                .name(author.getName())
                .gender(author.getGender())
                .build();

        this.setAuthor(authorDTO);
    }

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

    public static BookDTO fromEntity(Book book, Boolean withAuthor) {
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .category(book.getCategory())
                .price(book.getPrice())
                .forSale(book.getForSale())
                .quantity(book.getQuantity())
                .publishCompany(book.getPublishCompany())
                .author(withAuthor ? AuthorDTO.fromEntity(book.getAuthor(), false) : null)
                .build();
    }
}
