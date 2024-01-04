package com.mkpits.railway.controller;

import com.mkpits.railway.model.City_Master;
import com.mkpits.railway.model.State_Master;
import com.mkpits.railway.service.StateMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/states")
public class StateMaster {
    private StateMasterService stateMasterService;
    @Autowired
    public StateMaster(StateMasterService stateMasterService) {
        this.stateMasterService = stateMasterService;
    }
    @GetMapping("/list")
    public String findAllState(Model model) {
        List<State_Master> stateMasterList=stateMasterService.findAllState();
        model.addAttribute("stateMasterList",stateMasterList);
        return "/admin/displayStateList";
    }
}
