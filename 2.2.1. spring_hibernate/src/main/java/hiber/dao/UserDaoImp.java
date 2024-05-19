package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.security.Signature;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public void getUser(String model, int series) {
      Query<User> us = sessionFactory.getCurrentSession().createQuery("FROM User user JOIN FETCH user.car car where car.model= : model AND car.series= : series", User.class);
      us.setParameter("model", model);
      us.setParameter("series", series);
      List<User> users = us.getResultList();
      System.out.println(users);
   }



}
