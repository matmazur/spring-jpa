package com.matmazur.springjpa;

import com.matmazur.springjpa.DAO.BookDAOImpl;
import com.matmazur.springjpa.DAO.UserDAOImpl;
import com.matmazur.springjpa.model.Book;
import com.matmazur.springjpa.model.User;
import com.matmazur.springjpa.model.UserDetails;
import com.matmazur.springjpa.qualifiers.DAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);

        UserDAOImpl dao = context.getBean(UserDAOImpl.class);

        User user = new User("mikael","BIG80082","Mike@gmail.gov");
        UserDetails details = new UserDetails("Mike","Broftlotzki");
        user.setUserDetails(details);

        dao.add(user);

        System.out.println(dao.get(1L));

        System.out.println(dao.get(1L).getUserDetails().getUser().getPassword());




     /*   BookDAOImpl dao = context.getBean(BookDAOImpl.class);
        Book book1 = new Book("Red Dead Redemption", "Sergio Leone", "324567");
        Book book2 = new Book("Red Dead Redemption 2", "Sergio Canzano", "12456743");
        book2.setBookId(1L);

        dao.add(book1);
        System.out.println(dao.get(1L));
        dao.update(book2);
        System.out.println(dao.get(1L));
        dao.delete(1L);
        System.out.println(dao.get(1L));
*/
    }
}
