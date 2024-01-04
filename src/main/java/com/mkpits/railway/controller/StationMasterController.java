package com.mkpits.railway.controller;

import com.mkpits.railway.model.StationMaster;
import com.mkpits.railway.service.StationMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StationMasterController {
    private StationMasterService stationMasterService;
    @Autowired
    public StationMasterController(StationMasterService stationMasterService) {
        this.stationMasterService = stationMasterService;
    }
    @GetMapping("/login")
    public String welcomePage(){
        return"stationInformation/StationMasterLoginPage";
    }
    @GetMapping("/addmaster")
    public String getMasterDetails(Model model){
        StationMaster stationMaster= new StationMaster();
        model.addAttribute("master",stationMaster);
        return"stationInformation/StationMasterAddForm";
    }
    @PostMapping("/addmaster")
    public String postMasterDetails(@ModelAttribute("master") StationMaster stationMaster){
        stationMasterService.saveStation(stationMaster);
        return "stationInformation/StationMasterAddForm";

    }
}
