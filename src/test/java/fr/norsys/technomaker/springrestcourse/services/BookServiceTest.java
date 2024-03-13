package fr.norsys.technomaker.springrestcourse.services;

import fr.norsys.technomaker.springrestcourse.entities.Book;
import fr.norsys.technomaker.springrestcourse.exceptions.BookNotFoundException;
import fr.norsys.technomaker.springrestcourse.repositories.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void shouldThrowBookNotFoundExceptionWhenTheBookIsNotFound() {
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(BookNotFoundException.class,
                () -> bookService.findBookById(1L));
    }

    @Test
    public void shouldReturnABookIfExists() {
        Book expectedBook = Book.builder()
                .id(1L)
                .title("title")
                .build();
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(expectedBook));

        Book actualBook = bookService.findBookById(1L);

        Assertions.assertEquals(expectedBook, actualBook);
    }
}