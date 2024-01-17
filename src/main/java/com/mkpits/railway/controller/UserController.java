package com.mkpits.railway.controller;

import com.mkpits.railway.model.User;
import com.mkpits.railway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
//    -------------------------Display all user list--------------------------------
    @GetMapping("/list")
    public String findAllUserList(Model model) {
       List<User> userList=userService.findAllUserList();
       model.addAttribute("userList",userList);
         return "/admin/displayUserList";
    }
//    ----------------------- save new user records ----------------------------
    @GetMapping("/add")
    public String insertData(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "/admin/addUser";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ("user") User user){
        userService.save(user);
        return "redirect:/users/list";
    }
//    ----------------------- update existing user record by using user_id ----------------------------
//    ----------------------- delete user record by using user_id ----------------------------
    @GetMapping("/delete")
    public String delete(Integer user_Id) {
        userService.delete(user_Id);
        return "redirect:/users/list";
}

}
