package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Book;

public interface BookDAO {

    Long addBook(Book book);

    Book getById(Long id);
}
