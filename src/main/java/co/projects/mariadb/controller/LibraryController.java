package co.projects.mariadb.controller;

import co.projects.mariadb.entity.Book;
import co.projects.mariadb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }
}
