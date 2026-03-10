package com.example.BookStoreApplication.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDto {
    @NotBlank(message = "Book should have a title")
    private String title;
    @NotBlank(message = "Book should have an author")
    private String author;
    @NotNull
    @Min(value =100,message = "Minimum price should be 100")
    private Double price;


}
