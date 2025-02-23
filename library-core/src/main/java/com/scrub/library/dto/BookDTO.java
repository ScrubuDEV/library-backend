package com.scrub.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@SuperBuilder
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
