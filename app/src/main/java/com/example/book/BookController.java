package com.example.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Book> getBook() {
        return List.of(
                bookRepository.getByIsbn("isbn-1234"),
                bookRepository.getByIsbn("isbn-2345"),
                bookRepository.getByIsbn("isbn-3456")
        );
    }
}
