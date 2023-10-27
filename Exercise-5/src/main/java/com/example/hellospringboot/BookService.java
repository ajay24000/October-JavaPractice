package com.example.hellospringboot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("1" , "ABC" , "A" , 2000),
            new Book("2" , "DEF" , "B",2001),
            new Book("3" , "GHI" , "C" , 2002)
    ));

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBook(String id) {
        return books.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(String id, Book book) {
        for (int i=0 ; i< books.size() ; i++) {
            Book t = books.get(i);
            if (t.getId().equals(id)) {
                books.set(i, book);
                return;
            }
        }
    }

    public void deleteBook(String id) {
        books.removeIf(t -> t.getId().equals(id));
    }
}
