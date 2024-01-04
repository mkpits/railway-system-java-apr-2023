package com.mkpits.railway.controller;

import com.mkpits.railway.model.StationMaster;
import com.mkpits.railway.service.StationMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/showrecord";

    }
    @GetMapping("/showrecord")
    public String showRecordDetails(Model model){
    model.addAttribute("station",stationMasterService.getAllList());
    return "stationInformation/StationMasterShowPage";
    }

    @GetMapping("/stationInformation/StationMasterShowPage/delete/{station_id}")
    public String deleterecord(@PathVariable int station_id){
        stationMasterService.deleteById(station_id);
        return"redirect:/showrecord";
    }

    @GetMapping("/updatestudent")
    public String updaterecord(@RequestParam("station_id") int station_id, Model model){
    StationMaster stationMaster=stationMasterService.updateById(station_id);
    model.addAttribute("master", stationMaster);
    return"stationInformation/StationMasterAddForm";

    }
}
