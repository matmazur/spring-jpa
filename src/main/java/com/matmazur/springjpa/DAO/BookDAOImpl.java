package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Book;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Long addBook(Book book) {
        entityManager.persist(book);
        return book.getBookId();
    }

    @Override
    public Book getById(Long id) {

        return entityManager.find(Book.class, id);
    }
}
