package com.aula.livraria.model.book;

import com.aula.livraria.model.author.AuthorDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
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


    public static Book toEntity(BookDTO bookDTO) {
        return Book.builder()
                .id(bookDTO.getId())
                .name(bookDTO.getName())
                .category(bookDTO.getCategory())
                .quantity(bookDTO.getQuantity())
                .price(bookDTO.getPrice())
                .publishCompany(bookDTO.getPublishCompany())
                .forSale(bookDTO.getForSale())
                .author(AuthorDTO.toEntity(bookDTO.getAuthor()))
                .build();
    }

    public static BookDTO fromEntity(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .category(book.getCategory())
                .quantity(book.getQuantity())
                .price(book.getPrice())
                .publishCompany(book.getPublishCompany())
                .forSale(book.getForSale())
                .author(AuthorDTO.fromEntityWithoutBooks(book.getAuthor()))
                .build();
    }

    public static BookDTO fromEntityWithoutAuthor(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .category(book.getCategory())
                .quantity(book.getQuantity())
                .price(book.getPrice())
                .publishCompany(book.getPublishCompany())
                .forSale(book.getForSale())
                .build();
    }

}
