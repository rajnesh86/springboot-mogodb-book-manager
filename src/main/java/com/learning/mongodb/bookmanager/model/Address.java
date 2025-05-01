package com.learning.mongodb.bookmanager.model;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private Country country;
}
