package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
      User User1 = new User("User1", "Lastname1", "user1@mail.ru");
      User User2 = new User("User2", "Lastname2", "user2@mail.ru");
      User User3 = new User("User3", "Lastname3", "user3@mail.ru");
      User User4 = new User("User4", "Lastname4", "user4@mail.ru");

      Car car1 = new Car("Car1", 1);
      Car car2 = new Car("Car2", 2);
      Car car3 = new Car("Car3", 3);
      Car car4 = new Car("Car4", 4);


      userService.add(User1.setCar(car1).setUser(User1));
      userService.add(User2.setCar(car2).setUser(User2));
      userService.add(User3.setCar(car3).setUser(User3));
      userService.add(User4.setCar(car4).setUser(User4));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("User: " + user.getFirstName() + ", Car: "
                 + (user.getCar() != null ? user.getCar().getModel() : ""));


      }
   }
}
