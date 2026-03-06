package com.example.BookStoreApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import  java.util.*;

@Data
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;


}
