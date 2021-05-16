package com.aula.livraria.repository.book;

import com.aula.livraria.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Is the main Data Layer to use with the Entity Book
 * This interface contains all default methods from JPA Repository to the Entity.
 * Simple queries created with Spring Data will be created here
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
