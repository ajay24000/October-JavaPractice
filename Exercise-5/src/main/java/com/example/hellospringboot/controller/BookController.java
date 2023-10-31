package com.example.hellospringboot.controller;

import com.example.hellospringboot.entity.Book;
import com.example.hellospringboot.service.BookService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BookController {

    @Autowired
    private BookService bookService;
    @RequestMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping("/books/{id}")
    public Book getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/books")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/books/{id}")
    public void updateBook(@RequestBody Book book , @PathVariable int id) {
        bookService.updateBook(id,book);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

}
