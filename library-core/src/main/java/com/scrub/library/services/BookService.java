package com.scrub.library.services;

import com.scrub.library.model.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity createBook(BookEntity bookEntity);

    List<BookEntity> getAllBooks();

    BookEntity getBookById(Long id);
}
