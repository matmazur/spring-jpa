package com.matmazur.springjpa.DAO;

import com.matmazur.springjpa.model.Order;
import com.matmazur.springjpa.model.User;
import com.matmazur.springjpa.qualifiers.DAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@DAO(type = DAO.DAOType.USER)
public class UserDAOImpl extends GenericDAO<User, Long> {

    public void addOrder(User user, Order order) {
        User managedUser = get(user.getId());
        managedUser.addOrder(order);
    }

    public void removeOrders(User user) {
        User managedUser = get(user.getId());
        managedUser.getOrders().clear();
    }

    public void removeOrder(User user, Integer id) {
        User managedUser = get(user.getId());
        managedUser.getOrders().remove(1);
    }

}
