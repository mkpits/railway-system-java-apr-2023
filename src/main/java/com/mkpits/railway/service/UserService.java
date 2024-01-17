package com.mkpits.railway.service;

import com.mkpits.railway.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUserList();
    User findById(Integer user_Id);
    void save(User user);
    void update(Integer user_Id);
    void delete(Integer user_Id);

}
