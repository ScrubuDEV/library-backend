package com.scrub.web.controllers;

import com.scrub.library.dto.BookDTO;
import com.scrub.library.mappers.BookMapper;
import com.scrub.library.model.BookEntity;
import com.scrub.library.services.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/library/web/books")
public class BookController {
    private final BookMapper bookMapper;
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookRepository, BookMapper bookMapper) {
        this.bookService = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Transactional(readOnly = true)
    @GetMapping(path = "/{book_id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> getBook(@PathVariable("book_id") final long bookId) {
        BookEntity bookEntity = bookService.getBookById(bookId);
        if (bookEntity == null) {
            return ResponseEntity.notFound().build();
        }
        BookDTO searchedBookDto = bookMapper.toBookDTO(bookEntity);
        return ResponseEntity.ok(searchedBookDto);
    }

    @Transactional(readOnly = true)
    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookEntity> bookEntities = bookService.getAllBooks();
        List<BookDTO> transformedBooks = bookMapper.toBookDTOList(bookEntities);
        return ResponseEntity.ok(transformedBooks);
    }

    @PostMapping(path = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO bookDto) {
        BookEntity bookEntity = bookMapper.toBook(bookDto);

        BookEntity savedBook = bookService.createBook(bookEntity);

        BookDTO savedBookDto = bookMapper.toBookDTO(savedBook);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedBookDto);
    }

}
