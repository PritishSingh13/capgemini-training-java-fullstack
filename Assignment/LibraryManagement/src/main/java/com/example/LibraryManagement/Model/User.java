package com.example.LibraryManagement.Model;

import jakarta.validation.constraints.*;

public class User {

    private Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 3,message="name must be a min 3 char")
    private String name;
    @NotBlank(message = "email is required")
    @Email(message = "must be a valid email format")
    private String email;
    @NotNull(message = "password must not be null")
    @Size(min = 6,message = "password must be min 6 char")
    private String password;

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
