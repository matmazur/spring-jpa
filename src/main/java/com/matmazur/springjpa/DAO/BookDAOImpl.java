package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BookDAOImpl implements BookDAO {


    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Long addBook(Book book) {

        entityManager.persist(book);

        return book.getId();
    }

    @Override
    public Book getById(Long id) {

        return entityManager.find(Book.class, id);
    }
}
