package com.learning.mongodb.bookmanager.controller;

import com.learning.mongodb.bookmanager.model.Book;
import com.learning.mongodb.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createOrUpdateBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
        book.setId(id);
        Book updatedBook = bookService.createOrUpdateBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // 1. Find books by country name
    @GetMapping("/country/{countryName}")
    public List<Book> getBooksByCountryName(@PathVariable String countryName) {
        return bookService.findBooksByCountryName(countryName);
    }

    // 2. Find books by author's name and city
    @GetMapping("/author")
    public List<Book> getBooksByAuthorAndCity(@RequestParam String name, @RequestParam String city) {
        return bookService.findBooksByAuthorNameAndCity(name, city);
    }

    // 3. Find books by publisher name
    @GetMapping("/publisher/{publisherName}")
    public List<Book> getBooksByPublisherName(@PathVariable String publisherName) {
        return bookService.findBooksByPublisherName(publisherName);
    }
}
