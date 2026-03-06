package com.example.BookStoreApplication.repository;

import com.example.BookStoreApplication.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository <FileEntity,Long> {
}
