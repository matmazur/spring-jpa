package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Long add(Book book) {
        System.out.println("Transaction passes");
        entityManager.persist(book);
        return book.getBookId();
    }

    @Override
    public Book get(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public Long update(Book book) {
        entityManager.merge(book);
        return book.getBookId();
    }

    @Override
    public Long delete(Long id) {
        Book book = entityManager.find(Book.class,id);
        entityManager.remove(book);
        return book.getBookId();
    }
}
