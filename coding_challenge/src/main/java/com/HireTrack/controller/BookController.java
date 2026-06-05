package com.HireTrack.controller;

import com.HireTrack.dto.BookDto;
import com.HireTrack.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/book")
public class BookController {
    private final    BookService bookService;
    @PostMapping("/addBook/{authorId}")
    public void postBook(@PathVariable int authorId , @RequestBody BookDto bookDto){
        bookService.postBook(bookDto,authorId);
    }
}
