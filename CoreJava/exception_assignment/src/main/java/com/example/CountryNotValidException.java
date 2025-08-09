package com.example;

public class CountryNotValidException extends Exception {
    public CountryNotValidException(String message) {
        super(message);
    }
}