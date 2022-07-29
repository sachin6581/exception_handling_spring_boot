package com.bootcamp.bookshop.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    List<BookResponse> list() {
        List<Book> books = bookService.fetchAll();
        return books.stream()
                .map(book -> book.toResponse())
                .collect(Collectors.toList());
    }
}
