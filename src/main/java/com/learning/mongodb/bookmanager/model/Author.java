package com.learning.mongodb.bookmanager.model;

import lombok.Data;

@Data
public class Author {
    private String name;
    private Publisher publisher;
}
