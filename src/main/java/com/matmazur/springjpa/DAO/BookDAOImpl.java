package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Book;
import com.matmazur.springjpa.qualifiers.DAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
@DAO(type = DAO.DAOType.BOOK)
public class BookDAOImpl implements GenericDAO<Book,Long> {

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
