package co.projects.mariadb.service;

import co.projects.mariadb.entity.Author;
import co.projects.mariadb.entity.Book;
import co.projects.mariadb.repository.BookRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class BookService {
    private  List<Book> bookList = new ArrayList<>();
@Autowired
    private BookRepo bookRepo;

    public void saveBook(Book book){
        this.bookList.add(book);
    }
    public List<Book> getAllBooks() {
        if(bookRepo.findAll()==null){
            //bookList.add(new Book(0,"Dummy","Dummy",new Author(0,"Dummy","Dummy")));
            bookRepo.save(new Book(0,"Dummy","Dummy",new Author(0,"Dummy","Dummy")));
        }
     return  bookRepo.findAll();
    }
}
