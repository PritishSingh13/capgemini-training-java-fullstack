package org.example.BookStoreApplication.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BookDto {

    @NotBlank(message = "Book should have a Title")
    private String title;

    @NotBlank(message = "Book should have author")
    private String author;

    @NotBlank
    @Min(value = 100, message = "Minimum price should be 100")
    private double price;
}

