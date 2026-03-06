package com.example.BookStoreApplication.service;

import com.example.BookStoreApplication.dto.BookDto;
import com.example.BookStoreApplication.dto.PageResponse;
import com.example.BookStoreApplication.entity.Book;

import com.example.BookStoreApplication.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor  // add constructor for all final fields
@Service
public class BookService {

    private final ModelMapper modelMapper;//used to convert dto to entity
    private final BookRepository bookRepository;//jpa repository to handle CRUD

    public BookDto createBook(BookDto bookDto){
        Book book = modelMapper.map(bookDto,Book.class);    //converting bookdto to entity
        Book saved = bookRepository.save(book);                 //save the book(Temp)
        return modelMapper.map(saved,BookDto.class);        //coverting back to dto
    }

    public BookDto updateBookById(Long id,BookDto bookDto){
        Book existingbook = bookRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Book id not found"));

        existingbook.setTitle(bookDto.getTitle());
        existingbook.setAuthor(bookDto.getAuthor());
        existingbook.setPrice(bookDto.getPrice());

        Book updatedBook = bookRepository.save(existingbook);
        return modelMapper.map(updatedBook,BookDto.class);
    }

    public BookDto getBookById(Long id){
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Book not found"));
        return modelMapper.map(book,BookDto.class);
    }

    public BookDto deletebyId(Long id){
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.deleteById(id);
        return modelMapper.map(book,BookDto.class);
    }

    public List<BookDto> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream().map(b -> modelMapper.map(b,BookDto.class))
                .toList(); // mapping the list to entity class and collecting it to list
    }

    //pagination and sorting
    //2 pages 5 size = 10 records
    public PageResponse<BookDto> getBooks(int page,int size,String sortBy,String direction){
        Sort sort  = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page,size,sort); // pagination configuration
        Page<Book> bookPage = bookRepository.findAll(pageable); // fetch all data

        List<BookDto> dtoList = bookPage.getContent().stream()
                .map(book -> modelMapper.map(book,BookDto.class)).toList();
        return new PageResponse<>(dtoList,
                bookPage.getNumber(),
                bookPage.getSize(),
                bookPage.getTotalElements(),
                bookPage.getTotalPages()
                );
    }
}

//http://localhost:8080/swagger-ui/index.html#/ (api testing)without postman