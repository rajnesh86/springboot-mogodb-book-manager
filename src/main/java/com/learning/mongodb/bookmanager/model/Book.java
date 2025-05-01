package com.learning.mongodb.bookmanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String title;
    private String isbn;
    private double price;
    private Author author;

}
