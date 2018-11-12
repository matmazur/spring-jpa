package com.matmazur.springjpa;

import com.matmazur.springjpa.DAO.BookDAO;
import com.matmazur.springjpa.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);

        BookDAO dao = context.getBean(BookDAO.class);

        Book book1 = new Book("Red Dead Redemption", "Sergio Leone", "324567");
        Book book2 = new Book("Red Dead Redemption", "Sergio Leone", "324567");


        System.out.println(dao.addBook(book1));
        System.out.println(dao.addBook(book2));

        System.out.println("STEETE");
//        Book b1 = dao.getById(1L);
//        Book b2 = dao.getById(2L);
//
//        if (b1==null){
//            System.out.println(b1);
//        }
//        if (b2==null){
//            System.out.println(b2);
//        }
    }
}
