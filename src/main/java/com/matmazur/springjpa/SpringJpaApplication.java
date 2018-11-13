package com.matmazur.springjpa;

import com.matmazur.springjpa.DAO.OrderDAOImpl;
import com.matmazur.springjpa.DAO.UserDAOImpl;
import com.matmazur.springjpa.model.Order;
import com.matmazur.springjpa.model.User;
import com.matmazur.springjpa.model.UserDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);

        UserDAOImpl userDAO = context.getBean(UserDAOImpl.class);
        OrderDAOImpl orderDAO = context.getBean(OrderDAOImpl.class);


        User user = new User("mikael", "BIG80082", "Mike@gmail.gov");
        UserDetails details = new UserDetails("Mike", "Broftlotzki");

        Order order1 = new Order("shrooms", "a lot");
        order1.setTheUser(user);
        Order order2 = new Order("cocoa", "not so much");
        order2.setTheUser(user);


        user.setUserDetails(details);
        userDAO.add(user);


        orderDAO.add(order1);
        orderDAO.add(order2);

        System.out.println(userDAO.get(1L));
        System.out.println(userDAO.get(1L).getOrders());



        System.out.println(userDAO.get(1L).getUserDetails().getUser().getPassword());

    }
}
