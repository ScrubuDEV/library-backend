package com.scrub.library.services;

import com.scrub.library.model.BookEntity;
import com.scrub.library.repositories.BookRepository;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Slf4j
@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(BookEntity bookEntity) {
        if (bookEntity.getId() != null) {
            throw new ValidationException("Book id found on create: " + bookEntity.getId());
        }

        bookRepository.save(bookEntity);
        return bookEntity;
    }

    @Override
    public BookEntity getBookById(Long id) {
        System.out.println("Printed ${id}");
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }
}
