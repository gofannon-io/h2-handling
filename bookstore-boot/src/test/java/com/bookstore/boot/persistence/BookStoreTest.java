package com.bookstore.boot.persistence;

import com.bookstore.boot.BookstoreBootApplication;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@DataJpaTest(properties = {
//        "spring.sql.init.mode=always",
//        "spring.jpa.defer-datasource-initialization=true",
//        "spring.jpa.hibernate.ddl-auto=none"})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@TestConfiguration
//@ComponentScan(basePackages = {"com.bookstore.boot.persistence"})
//@EntityScan(basePackages = {"com.bookstore.bookstore.persistence"})
@SpringBootTest(classes = {BookstoreBootApplication.class, TestConfiguration.class})
public class BookStoreTest {

    @Autowired
    private BookStore store;

//    @Test
//    public void create() {
//        var book = new Book("01", "Guerre et paix");
//        Book createdBook = store.save(book);
//
//        assertThat(createdBook)
//                .extracting("isbn", "title")
//                .containsOnly("01", "Guerre et paix");
//    }

//    @Test
//    public void find() {
//        var book = new Book("01", "Guerre et paix");
//        store.save(book);
//
//        Book foundBook = store.findById("01").orElseThrow();
//        assertThat(foundBook)
//                .extracting("isbn", "title")
//                .containsOnly("01", "Guerre et paix");
//    }


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
