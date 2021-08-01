package com.aula.livraria.model.author;

import com.aula.livraria.core.AbstractEntity;
import com.aula.livraria.model.book.Book;
import com.aula.livraria.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author extends AbstractEntity {

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;

}
