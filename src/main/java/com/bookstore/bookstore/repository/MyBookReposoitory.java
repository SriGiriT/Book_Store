package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entities.MyBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookReposoitory extends JpaRepository<MyBooks, Integer> {
}
