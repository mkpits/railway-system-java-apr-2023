package com.mkpits.railway.controller;
import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.model.State_Form;
import com.mkpits.railway.model.State_Master;
import com.mkpits.railway.service.CountryMasterService;
import com.mkpits.railway.service.StateMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/states")
public class StateMaster {
    private StateMasterService stateMasterService;
    private CountryMasterService countryMasterService;

    @Autowired
    public StateMaster(StateMasterService stateMasterService, CountryMasterService countryMasterService) {
        this.stateMasterService = stateMasterService;
        this.countryMasterService = countryMasterService;
    }

//        public StateMaster(StateMasterService stateMasterService) {
//        this.stateMasterService = stateMasterService;
//    }

//    --------------------------- Display all the State records -------------------------------------------
    @GetMapping("/list")
    public String findAllState(Model model) {
        List<State_Master> stateMasterList=stateMasterService.findAllState();
        model.addAttribute("stateMasterList",stateMasterList);
        return "/admin/displayStateList";
    }
    //    --------------------- Add State records -------------------------------------------

//    ---------------------------State crud operation by using Many to one mapping ----------------
    @GetMapping("/add")
    public String insertData(Model model){
        List<Country_Master> countryMasterList=countryMasterService.findAllCountry();
        model.addAttribute("countryMasterList",countryMasterList);
        State_Form stateForm=new State_Form();
        model.addAttribute("stateMaster",stateForm);
        for (Country_Master countries:countryMasterList) {
            System.out.println(countries.getCountry_Id()+" "+countries.getCountry_Name());
        }
        //return "/admin/addState";
        return "/admin/addState";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ("stateMaster") State_Form stateForm) {
        System.out.println("Before : "+stateForm.getState_Name()+" "+stateForm.getCountry_Id());
        stateMasterService.save(stateForm);
//        System.out.println("Before : "+stateForm.getState_Name()+" "+stateForm.getCountry_Id());
        return "redirect:/states/list";
    }
//-----------------------------State crud operation save-------------------------------------
//    @GetMapping("/add")
//    public String insertData(Model model){
//        State_Master stateMaster=new State_Master();
//        model.addAttribute("stateMaster",stateMaster);
//        return "/admin/addState";
//}

//    @PostMapping("/save")
//    public String save(@ModelAttribute ("stateMaster") State_Master stateMaster) {
//        stateMasterService.save(stateMaster);
//        return "redirect:/states/list";
//}
    //    --------------------- Update single State record by using state_id ---------------------
    @GetMapping("/update")
    public String update(@RequestParam ("state_id") Integer stateId,Model model) {
        State_Master stateMaster=stateMasterService.update(stateId);
        model.addAttribute("stateMaster",stateMaster);
        return "/admin/addState";
    }
    //    --------------------- Delete single State record by using state_id ---------------------

    @GetMapping("/delete")
    public String delete(@RequestParam ("state_id") Integer state_id) {
        stateMasterService.delete(state_id);
        return "redirect:/states/list";
    }
}
