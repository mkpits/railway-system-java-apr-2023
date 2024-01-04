package com.mkpits.railway.service;

import com.mkpits.railway.model.User;
import com.mkpits.railway.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplimentation implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImplimentation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public User saveData(User user) {
        return userRepository.save(user);
    }
    @Override
    public List<User> findAllUserList() {
        return userRepository.findAll();
    }
}
