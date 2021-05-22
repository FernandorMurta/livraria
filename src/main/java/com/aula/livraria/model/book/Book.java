package com.aula.livraria.model.book;

import com.aula.livraria.model.author.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
