package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.security.Signature;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   void getUser(String model, int series);

}
