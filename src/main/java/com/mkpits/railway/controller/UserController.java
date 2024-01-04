package com.mkpits.railway.controller;

import com.mkpits.railway.model.User;
import com.mkpits.railway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @GetMapping("/")
//    public String insertData(){
//        return "null";
//    }
//    @GetMapping("/signUp")
//    public String saveData(User user) {
//        return "null";
//    }
    @GetMapping("/list")
    public String findAllUserList(Model model) {
       List<User> userList=userService.findAllUserList();
       model.addAttribute("userList",userList);
         return "index";
    }
}
