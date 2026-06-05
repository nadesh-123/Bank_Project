package com.HireTrack.mapper;

import com.HireTrack.dto.BookDto;
import com.HireTrack.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book mapDtoToBook(BookDto bookDto){
        Book book=new Book();
        book.setSummary(bookDto.summary());
        book.setTitle(bookDto.title());
        return book;
    }
}
