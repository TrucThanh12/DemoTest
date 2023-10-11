package com.example.demospring.controller;

import com.example.demospring.service.BookService;
import com.example.demospring.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable String id){
        return bookService.getBookById(id);
    }

    @PostMapping("/createBook")
    public void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
    }
//<<<<<<< HEAD
    @PutMapping("/{id}")
    public void updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        bookService.updateBook(id, updatedBook);
    }
//=======

    @DeleteMapping("/deleteAllBook")
    public void deleteAllBook(){
        bookService.deleteAllBook();
    }
    //>>>>>>> e9aaa14ddfbc1ec5eaaae8da62d6ef5eb32ddbdb
    }
