package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Book;

public interface BookDAO {

    Long add(Book book);
    Book get(Long id);
    Long update(Book book);
    Long delete(Long id);

}
