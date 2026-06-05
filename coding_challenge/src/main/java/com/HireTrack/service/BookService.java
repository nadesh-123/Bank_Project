package com.HireTrack.service;

import com.HireTrack.dto.BookDto;
import com.HireTrack.mapper.BookMapper;
import com.HireTrack.model.Author;
import com.HireTrack.model.Book;
import com.HireTrack.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
    private final AuthorService authorService;
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    public void postBook(BookDto bookDto, int authorId) {
        Author author=authorService.getAuthorByID(authorId);
      Book book=  bookMapper.mapDtoToBook(bookDto);
      book.setAuthor(author);
      bookRepository.save(book);

    }
}
