package com.bookstore.boot.persistence;


import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface BookStore  {
    @Transactional(Transactional.TxType.REQUIRED)
    Book save(Book toCreate);

    Optional<Book> findById(String isbn);

    List<Book> findAll();
}
