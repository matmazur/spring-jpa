package com.matmazur.springjpa;

import com.matmazur.springjpa.DAO.OrderDAOImpl;
import com.matmazur.springjpa.DAO.UserDAOImpl;
import com.matmazur.springjpa.model.Order;
import com.matmazur.springjpa.model.Product;
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


        Product p1 = new Product("Drugs",44.6,"nothing much");
        Product p2 = new Product("fries",4.6,"oily much");
        List<Product> products1 = new ArrayList<>(Arrays.asList(p1,p2));

        Product p3 = new Product("Alcohol",24.6,"Drunken much");
        Product p4 = new Product("cheetos",1.6,"oily");
        List<Product> products2 = new ArrayList<>(Arrays.asList(p3,p4));


        Order order1 = new Order( "details of first order");
        order1.setProducts(products1);

        Order order2 = new Order( "details of second order");
        order2.setProducts(products2);


        user.setUserDetails(details);
        user.setOrders(new ArrayList<>());
        user.addOrder(order1);
        user.addOrder(order2);

        userDAO.add(user);
        orderDAO.delete(1L);
        userDAO.delete(1L);


        System.out.println(userDAO.get(1L));
        System.out.println(userDAO.get(1L).getOrders());
        System.out.println(userDAO.get(1L).getUserDetails().getUser().getPassword());

    }
}
