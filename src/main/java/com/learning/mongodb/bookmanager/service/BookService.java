package com.learning.mongodb.bookmanager.service;

import com.learning.mongodb.bookmanager.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(String id);
    Book createOrUpdateBook(Book book);
    void deleteBook(String id);

    List<Book> findBooksByCountryName(String countryName);

    List<Book> findBooksByAuthorNameAndCity(String name, String city);

    List<Book> findBooksByPublisherName(String publisherName);
}