package com.bookstore.boot.persistence;

import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Named
public class BookStoreImpl implements BookStore {

    private final EntityManager entityManager;

    public BookStoreImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Book save(Book toCreate) {
        EntityTransaction transaction = entityManager.getTransaction();
        boolean cancelTransaction = true;
        try {
            transaction.begin();
            entityManager.persist(toCreate);
            entityManager.flush();
            transaction.commit();
            cancelTransaction = false;
            return entityManager.find(Book.class, toCreate.getIsbn());
        } finally {
            if (cancelTransaction)
                transaction.rollback();
        }
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.of(entityManager.find(Book.class, isbn));
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT a FROM Book as a", Book.class);
        return query.getResultList();
    }
}
