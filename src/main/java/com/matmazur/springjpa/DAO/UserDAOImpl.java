package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.User;
import com.matmazur.springjpa.qualifiers.DAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@DAO(type = DAO.DAOType.USER)
public class UserDAOImpl extends GenericDAO<User, Long> {
}
