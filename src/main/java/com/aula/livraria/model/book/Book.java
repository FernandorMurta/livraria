package com.aula.livraria.model.book;

import com.aula.livraria.model.author.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Represents a entity Book
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private String publishCompany;

    @ManyToOne
    private Author author;

    private Double price;

    private Integer quantity;

    private Boolean forSale;
}
