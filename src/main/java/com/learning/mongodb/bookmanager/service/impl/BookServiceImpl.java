package com.learning.mongodb.bookmanager.service.impl;

import com.learning.mongodb.bookmanager.model.Book;
import com.learning.mongodb.bookmanager.repository.BookRepository;
import com.learning.mongodb.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createOrUpdateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBooksByCountryName(String countryName) {
        return bookRepository.findByCountryName(countryName);
    }

    @Override
    public List<Book> findBooksByAuthorNameAndCity(String authorName, String city) {
        return bookRepository.findByAuthorNameAndCity(authorName, city);
    }

    @Override
    public List<Book> findBooksByPublisherName(String publisherName) {
        return bookRepository.findByAuthor_Publisher_Name(publisherName);
    }
}