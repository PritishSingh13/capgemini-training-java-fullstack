package com.example.BookStoreApplication;

import com.example.BookStoreApplication.entity.Book;

public class LombokTest {
    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPrice(45.0);

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getPrice());
        System.out.println(book.getId());
    }
}