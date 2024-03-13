package fr.norsys.technomaker.springrestcourse.services;

import fr.norsys.technomaker.springrestcourse.entities.Author;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAuthorService {
    Page<Author> findAllAuthors(int page, int size);

    Author findAuthorById(long id);

    void createAuthor(Author author);

    void updateAuthor(long id, Author newAuthor);

    void deleteAuthorById(long id);
}
