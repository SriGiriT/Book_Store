package com.bookstore.bookstore.controllers;

import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.entities.MyBooks;
import com.bookstore.bookstore.services.BookService;
import com.bookstore.bookstore.services.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookService myBookService;
    @GetMapping("/")
    public String homePage(){
        return "home";
    }
    @GetMapping("/add_book")
    public String addBook(){
        return "add_book";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<Book> list = bookService.getAllBook();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("bookList");
//        modelAndView.addObject("book", list);
//        return modelAndView;
        return new ModelAndView("available_books", "book", list);
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBooks> list = myBookService.getAllBook();
        model.addAttribute("book", list);
        return "my_books";
    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        MyBooks myBooks =new MyBooks(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        myBookService.saveMyBooks(myBooks);
        return "redirect:/my_books";
    }
    @RequestMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
    @RequestMapping("editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit_book";
    }
}
