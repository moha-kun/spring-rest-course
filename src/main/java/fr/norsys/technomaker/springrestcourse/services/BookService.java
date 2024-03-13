package fr.norsys.technomaker.springrestcourse.services;

import fr.norsys.technomaker.springrestcourse.controllers.BookRequest;
import fr.norsys.technomaker.springrestcourse.entities.Author;
import fr.norsys.technomaker.springrestcourse.entities.Book;
import fr.norsys.technomaker.springrestcourse.exceptions.BookNotFoundException;
import fr.norsys.technomaker.springrestcourse.repositories.AuthorRepository;
import fr.norsys.technomaker.springrestcourse.repositories.BookRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Page<Book> findAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findBookById(long id) {
      Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
            throw new BookNotFoundException("There is no Book with such ID");
        return optionalBook.get();
    }

    @Override
    public void createBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.title());
        if (bookRequest != null) {
            Author author = authorRepository.findById(bookRequest.authorId()).get();
            book.setAuthor(author);
        }
        bookRepository.save(book);
    }

    @Override
    public void updateBook(long id, Book newBook) {
        if (!bookRepository.existsById(id))
            throw new BookNotFoundException("There is no Book with such ID");
        newBook.setId(id);
        bookRepository.save(newBook);
    }

    @Override
    public void deleteBookById(long id) {
        if (!bookRepository.existsById(id))
            throw new BookNotFoundException("There is no Book with such ID");
        bookRepository.deleteById(id);
    }

}