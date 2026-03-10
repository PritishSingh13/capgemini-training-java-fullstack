package com.example.BookStoreApplication.repository;

import com.example.BookStoreApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}