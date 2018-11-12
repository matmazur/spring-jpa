package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class UserDAOImpl implements GenericDAO<User,Long> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Long add(User user) {
        entityManager.persist(user);
        return user.getId();
    }

    @Override
    public User get(Long id) {

        return entityManager.find(User.class,id);
    }

    @Override
    public Long update(User user) {

        entityManager.merge(user);

        return user.getId();
    }

    @Override
    public Long delete(Long id) {

        User user = entityManager.find(User.class,id);
        entityManager.remove(user);

        return user.getId();
    }
}
