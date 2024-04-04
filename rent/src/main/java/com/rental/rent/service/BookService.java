package com.rental.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.rent.entity.Book;
import com.rental.rent.exception.NoDataFound;
import com.rental.rent.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) throws NoDataFound {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoDataFound("No book found with id: " + id));
    }

    public Book updateBookById(Long id, Book book) throws NoDataFound {
        Book existingBook = getBookById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        existingBook.setAvailable(book.isAvailable());
        return bookRepository.save(existingBook);
    }

    public void deleteBookById(Long id) throws NoDataFound {
        if (!bookRepository.existsById(id)) {
            throw new NoDataFound("Invalid book ID: " + id);
        }
        bookRepository.deleteById(id);
    }
}
