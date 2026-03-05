package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Exception.BookNotFoundException;
import com.example.LibraryManagement.Model.Book;
import com.example.LibraryManagement.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        long totalBooks = bookService.getAllBooks().stream().count();
        model.addAttribute("totalBooks", totalBooks);
        return "dashboard";
    }

    @GetMapping
    public String viewAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "view-books";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String viewBook(@PathVariable Long id, Model model) {
        try {
            Book book = bookService.getBookById(id);
            model.addAttribute("book", book);
            return "book-details";
        } catch (BookNotFoundException e) {
            model.addAttribute("errorMessage", "Book not found: " + id);
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
        } catch (BookNotFoundException e) {
        }
        return "redirect:/books";
    }
}
