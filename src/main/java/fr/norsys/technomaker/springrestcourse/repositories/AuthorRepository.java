package fr.norsys.technomaker.springrestcourse.repositories;

import fr.norsys.technomaker.springrestcourse.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
