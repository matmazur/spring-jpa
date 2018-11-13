package com.matmazur.springjpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;

@Transactional
public abstract class GenericDAO<C, Long> {

    @PersistenceContext
    EntityManager entityManager;
    private Class<C> type;

    @SuppressWarnings("unchecked")
    GenericDAO() {
        type = (Class<C>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void add(C someClass) {
        entityManager.persist(someClass);
    }

    public C get(Long id) {
        return entityManager.find(type, id);
    }

    public void update(C someClass) {
        entityManager.merge(someClass);
    }

    public void delete(Long id) {
        C someClass = entityManager.find(type, id);
        entityManager.remove(someClass);
    }
}
