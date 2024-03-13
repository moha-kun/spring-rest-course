package fr.norsys.technomaker.springrestcourse.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "book.title should not be null")
    @Size(min = 1, max = 20, message = "book.title should be of size between 1 to 20 letter")
    private String title;

    @ManyToOne
    private Author author;

}
