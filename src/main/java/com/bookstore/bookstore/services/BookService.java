package com.bookstore.bookstore.services;

import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void save(Book book){
        bookRepository.save(book);
    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }
    public void deleteById(int id){
        bookRepository.deleteById(id);
    }
}
