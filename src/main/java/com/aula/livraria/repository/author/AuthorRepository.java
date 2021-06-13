package com.aula.livraria.repository.author;

import com.aula.livraria.model.author.Author;
import com.aula.livraria.model.author.AuthorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Page<AuthorDTO> findAllByNameContainsIgnoreCase(String name, Pageable pageable);

}
