package com.scrub.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String title;
    private String author;
    private String isbn;
    private long publicationYear;
    private String description;
}
