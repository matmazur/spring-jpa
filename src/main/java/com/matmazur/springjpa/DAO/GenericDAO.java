package com.matmazur.springjpa.DAO;

public interface GenericDAO<C,Long> {

    Long add(C someClass);
    C get(Long id);
    Long update(C someClass);
    Long delete(Long id);

}
