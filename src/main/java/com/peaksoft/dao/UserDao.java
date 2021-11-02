package com.peaksoft.dao;

import com.peaksoft.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getAllUser();

    User getById(int id);

    void removeUser(int id);
}
