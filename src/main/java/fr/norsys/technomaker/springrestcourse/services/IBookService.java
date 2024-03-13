package fr.norsys.technomaker.springrestcourse.services;

import fr.norsys.technomaker.springrestcourse.controllers.BookRequest;
import fr.norsys.technomaker.springrestcourse.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IBookService {
    Page<Book> findAllBooks(int page, int size);

    Book findBookById(long id);

    void createBook(BookRequest bookRequest);

    void updateBook(long id, Book newBook);

    void deleteBookById(long id);
}
