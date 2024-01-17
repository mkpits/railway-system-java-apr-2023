package com.mkpits.railway.controller;

import com.mkpits.railway.model.City_Form;
import com.mkpits.railway.model.City_Master;
import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.model.State_Master;
import com.mkpits.railway.service.CityMasterService;
import com.mkpits.railway.service.StateMasterService;
import com.mkpits.railway.service.StationMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityMaster {
    private CityMasterService cityMasterService;
    private StateMasterService stateMasterService;
    @Autowired
    public CityMaster(CityMasterService cityMasterService, StateMasterService stateMasterService) {
        this.cityMasterService = cityMasterService;
        this.stateMasterService = stateMasterService;
    }

    //    ------------------------ Display all city records -------------------------------
    @GetMapping("/list")
    public String findAllCity(Model model) {
       List<City_Master> cityMasterList= cityMasterService.findAllCity();
        model.addAttribute("cityMasterList",cityMasterList);
        return "/admin/displayCityList";
    }
//    ----------------------- Insert city records ---------------------------
    @GetMapping("/add")
    public String insertData(Model model){
        List<State_Master> stateMasterList= stateMasterService.findAllState();
        model.addAttribute("stateMasterList",stateMasterList);
        City_Form cityForm=new City_Form();
        model.addAttribute("cityMaster",cityForm);
        return "/admin/addCity";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ("cityMaster") City_Form cityForm) {
         cityMasterService.save(cityForm);
        return "redirect:/cities/list";
    }
//    ----------------------- Update single City record by using city_id ------------------------------------
    @GetMapping("/update")
    public String update(@RequestParam ("city_Id") Integer city_Id,Model model) {
        List<State_Master> stateMasterList=stateMasterService.findAllState();
        model.addAttribute("stateMasterList",stateMasterList);

       City_Master cityMaster=cityMasterService.findById(city_Id);
       City_Form cityForm=new City_Form();
       cityForm.setCity_Id(cityMaster.getCity_Id());
       cityForm.setCity_Name(cityMaster.getCity_Name());
       cityForm.setState_Id(cityMaster.getStateMaster().getState_Id());
        model.addAttribute("cityMaster",cityForm);
        return "/admin/addCity";
    }
//    ----------------------------Delete single city record by using city_id ----------------------------------
    @GetMapping("/delete")
    public String delete(@RequestParam ("city_Id") Integer city_Id) {
        cityMasterService.delete(city_Id);
        return "redirect:/cities/list";
    }
}
