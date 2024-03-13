package fr.norsys.technomaker.springrestcourse.controllers;

import fr.norsys.technomaker.springrestcourse.entities.Book;
import fr.norsys.technomaker.springrestcourse.services.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BookController {

    private final IBookService bookService;

    @GetMapping
    public ResponseEntity<Page<Book>> findAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Page<Book> result = bookService.findAllBooks(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable long id) {
        Book result = bookService.findBookById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody BookRequest bookRequest) {
        bookService.createBook(bookRequest);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Done!");
    }

}
