package com.mkpits.railway.service.impli;

import com.mkpits.railway.model.User;
import com.mkpits.railway.repository.UserRepository;
import com.mkpits.railway.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplimentation implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImplimentation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findAllUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer user_Id) {
        return userRepository.findById(user_Id).get();
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(Integer user_Id) {
        findById(user_Id);
    }

    @Override
    public void delete(Integer user_Id) {
        userRepository.deleteById(user_Id);
    }
}
