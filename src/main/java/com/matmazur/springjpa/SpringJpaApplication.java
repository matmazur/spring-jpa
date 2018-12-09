package com.matmazur.springjpa;

import com.matmazur.springjpa.DAO.ItemDAOImpl;
import com.matmazur.springjpa.DAO.OrderDAOImpl;
import com.matmazur.springjpa.DAO.UserDAOImpl;
import com.matmazur.springjpa.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);

//        UserDAOImpl userDAO = context.getBean(UserDAOImpl.class);
//
//        User user = new User("mikael", "BIG80082", "Mike@gmail.gov");
//        UserDetails details = new UserDetails("Mike", "Broftlotzki");
//        Product p1 = new Product("Drugs", 44.6, "nothing much");
//        Product p2 = new Product("fries", 4.6, "oily much");
//        Product p3 = new Product("Alcohol", 24.6, "Drunken much");
//        Product p4 = new Product("cheetos", 1.6, "oily");
//
//        Order order1 = new Order("this is first order details");
//        Order order2 = new Order("this is second order details");
//
//        order1.setProducts(List.of(p1, p2));
//        order2.setProducts(List.of(p3, p4));
//
//        user.setUserDetails(details);
//        user.addOrder(order1);
//
//        userDAO.add(user);
//        userDAO.addOrder(user, order2);
//
//        User usertest = userDAO.get(1L);
//        usertest.getOrders().get(0).setOrderDetails("Changed stuff here!");
//        userDAO.update(usertest);
//
////        userDAO.removeOrders(user);
//
//
//        System.out.println(userDAO.get(1L));
//        System.out.println(userDAO.get(1L).getOrders());
//        System.out.println(userDAO.get(1L).getUserDetails().getUser().getPassword());
//
//
//        Item someItem = Item.builder().withName("Doug").withProducer("Producer").withPrice(1000d).build();
//        System.out.println(someItem);


        ItemDAOImpl itemDao = context.getBean(ItemDAOImpl.class);
        Item chocolate = Item.builder().withName("Chocolate").withProducer("Wedel").withPrice(4d).build();
        Item ciggaretes = Item.builder().withName("Ciggaretes").withProducer("Marlboro").withPrice(14d).build();
        Item drugs = Item.builder().withName("Mucosolvin").withProducer("Some pharm company").withPrice(12d).build();

        itemDao.add(chocolate);
        itemDao.add(ciggaretes);
        itemDao.add(drugs);
        System.out.println(itemDao.getAll());

        System.out.println("using :name parameter in named query findByName");
        System.out.println(itemDao.findByName("chocolate"));
        System.out.println("--------");
        System.out.println(itemDao.customGet("SELECT i FROM Item i WHERE i.price>5 order by i.price ASC"));
        itemDao.deleteAll();
        System.out.println(itemDao.getAll());
    }
}
