package com.aula.livraria.model.book;

import com.aula.livraria.core.AbstractEntity;
import com.aula.livraria.model.author.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book extends AbstractEntity {

    private String name;

    private String category;

    private String publishCompany;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private Double price;

    private Integer quantity;

    private Boolean forSale;

}
