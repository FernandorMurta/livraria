package com.aula.livraria.model.book;

import com.aula.livraria.model.author.Author;

import javax.persistence.*;
import java.util.Objects;

@Entity
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

    public Book() {
    }

    public Book(Long id, String name, String category, String publishCompany, Author author, Double price, Integer quantity, Boolean forSale) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.publishCompany = publishCompany;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.forSale = forSale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishCompany() {
        return publishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean isForSale() {
        return forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(category, book.category) && Objects.equals(publishCompany, book.publishCompany) && Objects.equals(author, book.author) && Objects.equals(price, book.price) && Objects.equals(quantity, book.quantity) && Objects.equals(forSale, book.forSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, publishCompany, author, price, quantity, forSale);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", publishCompany='" + publishCompany + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", quantity=" + quantity +
                ", forSale=" + forSale +
                '}';
    }
}
