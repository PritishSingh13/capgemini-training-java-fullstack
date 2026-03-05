package com.example.LibraryManagement.Service;
import com.example.LibraryManagement.Exception.BookNotFoundException;
import com.example.LibraryManagement.Model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public  void addBook(Book book){
        books.add(book);
    }

    public  List<Book> getAllBooks(){
        return  new ArrayList<>(books);
    }

    public  Book getBookById(Long id) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        throw new BookNotFoundException("Book with ID " + id + " not found");
    }

    public void deleteBook(Long id) throws BookNotFoundException {
        Book book = getBookById(id);
        books.remove(book);
    }

}
