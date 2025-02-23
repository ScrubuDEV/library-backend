package com.scrub.library.mappers;

import com.scrub.library.dto.BookDTO;
import com.scrub.library.model.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toBookDTO(BookEntity bookEntity);
    BookEntity toBook(BookDTO bookDTO);
    List<BookEntity> toBookList(List<BookDTO> bookDTOList);
    List<BookDTO> toBookDTOList(List<BookEntity> bookEntityList);
}
