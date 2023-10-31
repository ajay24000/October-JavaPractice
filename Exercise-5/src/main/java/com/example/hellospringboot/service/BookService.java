package com.example.hellospringboot.service;

import com.example.hellospringboot.dao.BookRepo;
import com.example.hellospringboot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBook(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public void updateBook(int id, Book book) {
        bookRepo.save(book);
    }

    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }
}
