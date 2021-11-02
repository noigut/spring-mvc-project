package com.peaksoft.dao;

import com.peaksoft.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);


    }

    @Override
    public List<User> getAllUser() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User ")
                .getResultList();
    }

    @Override
    public User getById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.remove(user);

    }


}


