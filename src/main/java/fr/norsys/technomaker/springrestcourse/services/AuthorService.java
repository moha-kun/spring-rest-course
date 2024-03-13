package fr.norsys.technomaker.springrestcourse.services;

import fr.norsys.technomaker.springrestcourse.entities.Author;
import fr.norsys.technomaker.springrestcourse.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Page<Author> findAllAuthors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return authorRepository.findAll(pageable);
    }

    @Override
    public Author findAuthorById(long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isEmpty())
            throw new RuntimeException("There is no author with such ID");
        return optionalAuthor.get();
    }

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(long id, Author newAuthor) {
        if (!authorRepository.existsById(id))
            throw new RuntimeException("There is no author with such ID");
        newAuthor.setId(id);
        authorRepository.save(newAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        if (!authorRepository.existsById(id))
            throw new RuntimeException("There is no author with such ID");
        authorRepository.deleteById(id);
    }

}
