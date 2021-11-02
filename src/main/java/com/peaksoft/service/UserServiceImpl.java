package com.peaksoft.service;

import com.peaksoft.dao.UserDao;
import com.peaksoft.dao.UserDaoImpl;
import com.peaksoft.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
    return userDao.getAllUser();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
