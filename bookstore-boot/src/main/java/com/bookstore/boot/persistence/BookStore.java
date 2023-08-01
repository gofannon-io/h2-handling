package com.bookstore.boot.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStore extends JpaRepository<Book,String> {
}
