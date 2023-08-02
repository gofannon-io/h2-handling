package com.bookstore.boot.persistence;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.transaction.Transactional;
import org.assertj.core.groups.Tuple;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {H2Configuration.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@Transactional
public class BookStoreTest {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager em;

    @Inject
    private BookStore store;


    @Test
    public void create() {
        //This test proves that the books table is created from SQL test script and not deduced from Book parsing
        var book = new Book("01", "Guerre et paix");

        assertThatThrownBy(
                () -> store.save(book)
        ).isInstanceOf(ConstraintViolationException.class);

//        Book createdBook = store.save(book);
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