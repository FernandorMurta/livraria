package com.aula.livraria.model.book;

import com.aula.livraria.model.author.Author;
import com.aula.livraria.model.author.AuthorDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public BookDTO() {
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

    public static BookDTO fromEntity(Book book){
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setForSale(book.isForSale());
        bookDTO.setQuantity(book.getQuantity());
        bookDTO.setPublishCompany(book.getPublishCompany());

        Author author = book.getAuthor();
        AuthorDTO authorDTO = new AuthorDTO(author.getId(), author.getName(), author.getGender());

        bookDTO.setAuthor(authorDTO);

        return bookDTO;
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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
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

    public Boolean getForSale() {
        return forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
    }
}
