package com.aula.livraria.repository.author;

import com.aula.livraria.model.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fernando Murta
 * @version 0.0.1
 * @since 0.0.1
 * <p>
 * Is the main Data Layer to use with the Entity Author
 * This interface contains all default methods from JPA Repository to the Entity.
 * Simple queries created with Spring Data will be created here
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
