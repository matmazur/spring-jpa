package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Order;
import com.matmazur.springjpa.qualifiers.DAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@DAO(type = DAO.DAOType.ORDER)
public class OrderDAOImpl extends GenericDAO<Order,Long> {
}
