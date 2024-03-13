package fr.norsys.technomaker.springrestcourse.repositories;

import fr.norsys.technomaker.springrestcourse.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
