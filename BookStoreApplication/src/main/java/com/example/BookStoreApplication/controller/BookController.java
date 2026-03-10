package com.example.BookStoreApplication.controller;

import com.example.BookStoreApplication.dto.BookDto;
import com.example.BookStoreApplication.dto.PageResponse;
import com.example.BookStoreApplication.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jdk.jfr.Description;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Descriptor;
import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookService bookService;
//    CREATE BOOK
    @PostMapping
    @Operation(summary = "Add a new book",description = "Creates a new book")
    @ApiResponse(responseCode = "200",description = "Book Added Successfully")
    public ResponseEntity<BookDto> createBook(@RequestBody @Valid BookDto dto){
        BookDto savedBook =bookService.createBook(dto);
        return ResponseEntity.ok(savedBook);
    }
//    FETCH BOOK BY ID
    @GetMapping("/getBook/{id}")
    @Operation(summary = "Get book",description = "Get Book by id")
    @ApiResponse(responseCode = "200",description = "Book Fetched by id")
    public ResponseEntity<BookDto> getBookbyId(@PathVariable long id){
        BookDto bookDto = bookService.getBookById(id);
        return  ResponseEntity.ok(bookDto);
    }
//    UPDATE BOOK BY ID
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id,@Valid @RequestBody BookDto bookDto){
        BookDto updatedBook = bookService.updateBookById(id,bookDto);
        return ResponseEntity.ok(updatedBook);

    }
//    DELETE BOOK BY ID
    @DeleteMapping("/deleteBook/{id}")
    @Operation(summary = "Delete a Book",description = "To Remvove a book")
    @ApiResponse(responseCode = "200",description = "Deleted Successfully")
    public ResponseEntity<BookDto> deletebyID(@PathVariable Long id){
        BookDto delete = bookService.deletebyId(id);
        return ResponseEntity.ok(delete);
    }
//      GET ALL BOOKS
    @GetMapping("/getAllBooks")
    @Operation(summary = "Get All Books", description="To fetch all books")
    @ApiResponse(responseCode = "200",description = "Fetched All Books Successfully")
    public ResponseEntity<List<BookDto>> getallBooks(){
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }


    //GET ALL BOOKS WITH PAGINATION AND SORTING
    @Operation(summary = "Get all books", description = "Fetch a paginated and sorted list of books from the inventory")
    @GetMapping()
    public ResponseEntity<PageResponse<BookDto>> getBooks(
            @Parameter(description = "Zero-based page index (0, 1, 2...)")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "Number of items per page")
            @RequestParam(defaultValue = "5") int size,

            @Parameter(description = "Field to sort by (e.g., 'title', 'price', 'author')")
            @RequestParam(defaultValue = "id") String sortBy,

            @Parameter(description = "Sorting direction ('asc' for ascending, 'desc' for descending)")
            @RequestParam(defaultValue = "asc") String direction) {

        PageResponse<BookDto> books = bookService.getBooks(page, size, sortBy, direction);
        return ResponseEntity.ok(books);
    }

}
