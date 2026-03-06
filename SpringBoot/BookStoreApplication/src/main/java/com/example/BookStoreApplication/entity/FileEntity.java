package com.example.BookStoreApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "files")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    private Long fileSize;

    @Lob  //Large Object -stores binary data(file content) in database
    @Column(name = "file_data", columnDefinition = "LONGBLOB")
    private byte[] fileData; // Actual ile content as byte array

    private LocalDateTime uploadedAt;

    @PrePersist // Automatically called before saving to database
    public void prePersist(){
        uploadedAt = LocalDateTime.now();
    }
}
