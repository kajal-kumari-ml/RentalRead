package com.rental.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.rental.rent.entity.Book;
import com.rental.rent.exception.NoDataFound;
import com.rental.rent.service.BookService;
import com.rental.rent.service.UserService;

@Controller
public class BookController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;
    
    @PostMapping("/books")
    public ResponseEntity<Book> getBooks(@RequestBody Book book) {
        Book createdBook=bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PostMapping("/books")
    public ResponseEntity<?> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @PostMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@RequestBody Long id) throws NoDataFound {
        Book book=bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBookById(@RequestBody Long id, @RequestBody Book book) throws NoDataFound {
        Book updatedBook=bookService.updateBookById(id, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBookById(@RequestBody Long id) throws NoDataFound {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
