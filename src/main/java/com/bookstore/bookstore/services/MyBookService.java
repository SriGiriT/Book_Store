package com.bookstore.bookstore.services;

import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.entities.MyBooks;
import com.bookstore.bookstore.repository.MyBookReposoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookReposoitory myBookReposoitory;
    public void saveMyBooks(MyBooks myBook){
        myBookReposoitory.save(myBook);
    }
    public List<MyBooks> getAllBook(){
        return myBookReposoitory.findAll();
    }
    public void deleteById(int id){
        myBookReposoitory.deleteById(id);
    }
}
