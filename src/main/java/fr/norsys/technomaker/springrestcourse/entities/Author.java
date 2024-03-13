package fr.norsys.technomaker.springrestcourse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "author.firstName should not be null")
    @Size(min = 5, max = 15, message = "author.firstName should be of size between 5 to 15 letter")
    private String firstName;

    @NotNull(message = "author.lastName should not be null")
    @Size(min = 5, max = 15, message = "author.lastName should be of size between 5 to 15 letter")
    private String LastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Book> books;

    public void addBook(Book book) {
        if (books == null)
            books = new ArrayList<>();
        books.add(book);
    }

    public void removeBook(Book book) {
        if (books == null)
            books = new ArrayList<>();
        books.remove(book);
    }

}
