package com.example.demospring.service;

import com.example.demospring.model.Book;
import com.example.demospring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    @Autowired
    public void setBookRepository(BookRepository bookRepository){

        this.bookRepository = bookRepository;
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(String id){
        return bookRepository.findById(id).orElse(null);
    }
    public void saveBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }
    public void updateBook(String id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (existingBook != null) {
            existingBook.setName(updatedBook.getName());
            existingBook.setPrice(updatedBook.getPrice());

            bookRepository.save(existingBook);
        }
    }


    public void deleteAllBook(){
        bookRepository.deleteAll();
    }

}
