package fr.norsys.technomaker.springrestcourse.db_filling_for_test;

import fr.norsys.technomaker.springrestcourse.entities.Author;
import fr.norsys.technomaker.springrestcourse.entities.Book;
import fr.norsys.technomaker.springrestcourse.services.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DBFilling implements CommandLineRunner {

    private final IAuthorService authorService;

    @Override
    public void run(String... args) {
        for (int i = 1; i <= 20; i++) {
            Author author = new Author();
            author.setFirstName("firstName" + i);
            author.setLastName("lastName" + i);
            for (int j = 1; j <= 5; j++) {
                Book book = new Book();
                book.setTitle("book" + j + " for author" + i);
                book.setAuthor(author);
                author.addBook(book);
            }
            authorService.createAuthor(author);
        }
    }

    @Bean
    public CommandLineRunner setUp() {
        return this;
    }
}
