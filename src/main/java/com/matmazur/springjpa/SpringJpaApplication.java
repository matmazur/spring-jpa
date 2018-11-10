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

        Book book = new Book("Red Dead Redemption","Sergio Leone","324567");

        System.out.println(dao.addBook(book));
        System.out.println(dao.getById(1L));

    }
}
