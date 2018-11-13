package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Book;
import com.matmazur.springjpa.qualifiers.DAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@DAO(type = DAO.DAOType.BOOK)
public class BookDAOImpl extends GenericDAO<Book,Long> {

}
