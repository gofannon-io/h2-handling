package com.bookstore.boot.persistence;

import com.bookstore.boot.BookstoreBootApplication;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BookstoreBootApplication.class, TestConfiguration.class})
public class BookStoreTest {

    @Autowired
    private BookStore store;

    @Test
    public void create() {
        //This test proves that the books table is created from SQL test script and not deduced from Book parsing
        var book = new Book("01", "Guerre et paix");

        assertThatThrownBy(
                () -> store.save(book)
        ).isInstanceOf(DataIntegrityViolationException.class);

//        Book createdBook = store.save(book);
//
//        assertThat(createdBook)
//                .extracting("isbn", "title")
//                .containsOnly("01", "Guerre et paix");
    }

    @Test
    public void find() {
        Book foundBook = store.findById("10").orElseThrow();
        assertThat(foundBook)
                .extracting("isbn", "title")
                .containsOnly("10", "Les Cosaques");
    }


    @Test
    public void getAll() {
        List<Book> books = store.findAll();
        assertThat(books)
                .extracting("isbn", "title")
                .containsOnly(
                        new Tuple("10", "Les Cosaques"),
                        new Tuple("11", "La Mort d'Ivan Ilitch")
                );
    }
}
