package com.mkpits.railway.service;

import com.mkpits.railway.model.User;

import java.util.List;

public interface UserService {
    User saveData(User user);
    List<User> findAllUserList();
}
