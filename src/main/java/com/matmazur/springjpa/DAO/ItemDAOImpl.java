package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Repository
@Transactional
public class ItemDAOImpl extends GenericDAO<Item, Long> {

public List<Item> getAll(){
    TypedQuery<Item> getAllQuery = entityManager.createQuery("SELECT i FROM Item i ",Item.class);
    return getAllQuery.getResultList();
}

public void deleteAll(){
    TypedQuery<Item> query = entityManager.createQuery("DELETE FROM Item i",Item.class);
    query.executeUpdate();

}

public List<Item> customGet(String yourQuery){

    TypedQuery<Item> query = entityManager.createQuery(yourQuery,Item.class);
    return query.getResultList();
}
}
