package org.example.ProductApp.Exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleGlobalException(Exception ex, Model model){
        model.addAttribute("errorMessage","Something went wrong");
        return "error-page";
    }
}