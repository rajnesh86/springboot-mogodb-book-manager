package com.learning.mongodb.bookmanager.repository;

import com.learning.mongodb.bookmanager.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    // 1. Find books by country name
    @Query("{'author.publisher.address.country.name': ?0}")
    List<Book> findByCountryName(String countryName);

    // 2. Find books by author's name and city
    @Query("{'author.name': ?0, 'author.publisher.address.city': ?1}")
    List<Book> findByAuthorNameAndCity(String authorName, String city);

    // 3. Find books by publisher name
    List<Book> findByAuthor_Publisher_Name(String publisherName);
}
