package com.example.LibraryManagement.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionhandler {
    @ExceptionHandler(BookNotFoundException.class)
    public  String handleBookNotFound(BookNotFoundException ex, Model model){
        model.addAttribute("error",ex.getMessage());
        return "error";
    }
    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex,Model model){
        model.addAttribute("error","something went wrong");
        return "error";
    }

}