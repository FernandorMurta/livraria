package com.aula.livraria.repository.book;

import com.aula.livraria.model.book.Book;
import com.aula.livraria.model.book.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<BookDTO> findAllByNameContainsIgnoreCaseAndCategoryContainsIgnoreCase(String name, String category, Pageable pageable);
}
