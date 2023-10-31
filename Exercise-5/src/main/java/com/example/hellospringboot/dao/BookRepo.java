package com.example.hellospringboot.dao;

import com.example.hellospringboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
