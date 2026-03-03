package com.example.SpringMvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringMvc.Model.Student;

public interface StudentDao extends JpaRepository<Student, Long> {
}