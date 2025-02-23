package com.scrub.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LIB_BOOK")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_NSQ")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "ISBN", nullable = false)
    @Size(min = 10, max = 13, message = "ISBN must be either 10 or 13 characters long")
    private String isbn;

    @Column(name = "PUBLICATION_YEAR")
    private Long publicationYear;

    @Column(name = "DESCRIPTION")
    private String description;
}
