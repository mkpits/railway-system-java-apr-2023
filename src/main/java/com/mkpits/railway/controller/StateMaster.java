package com.mkpits.railway.controller;
import com.mkpits.railway.model.State_Master;
import com.mkpits.railway.service.StateMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/add")
    public String insertData(Model model){
        State_Master stateMaster=new State_Master();
        model.addAttribute("stateMaster",stateMaster);
        return "/admin/addState";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ("stateMaster") State_Master stateMaster) {
        stateMasterService.save(stateMaster);
        return "redirect:/states/list";
    }
}
