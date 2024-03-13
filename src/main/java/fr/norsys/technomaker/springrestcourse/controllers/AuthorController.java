package fr.norsys.technomaker.springrestcourse.controllers;

import fr.norsys.technomaker.springrestcourse.entities.Author;
import fr.norsys.technomaker.springrestcourse.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<Page<Author>> findAllAuthors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Page<Author> result = authorService.findAllAuthors(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> finAuthorById(@PathVariable long id) {
        Author result = authorService.findAuthorById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable long id, @RequestBody Author author) {
        authorService.updateAuthor(id, author);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok(null);
    }

}
