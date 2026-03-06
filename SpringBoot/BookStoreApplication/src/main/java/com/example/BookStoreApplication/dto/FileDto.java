package com.example.BookStoreApplication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {
    private Long id;

    private String fileName;
    private String fileType;
    private Long fileSize;

    private LocalDateTime localDateTime;
}
