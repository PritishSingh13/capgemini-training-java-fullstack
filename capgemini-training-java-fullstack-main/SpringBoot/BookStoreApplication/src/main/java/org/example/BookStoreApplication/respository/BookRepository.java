package org.example.BookStoreApplication.respository;

import org.example.BookStoreApplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long>{}
