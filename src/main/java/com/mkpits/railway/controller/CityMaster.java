package com.mkpits.railway.controller;

import com.mkpits.railway.model.City_Master;
import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.service.CityMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityMaster {
    private CityMasterService cityMasterService;
    @Autowired
    public CityMaster(CityMasterService cityMasterService) {
        this.cityMasterService = cityMasterService;
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
        City_Master cityMaster=new City_Master();
        model.addAttribute("cityMaster",cityMaster);
        return "admin/addCity";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ("cityMaster") City_Master cityMaster) {
         cityMasterService.save(cityMaster);
        return "redirect:/cities/list";
    }
//    ----------------------- Update single City record by using city_id ------------------------------------
    @GetMapping("/update")
    public String update(@RequestParam ("city_Id") Integer city_Id,Model model) {
       City_Master cityMaster=cityMasterService.update(city_Id);
        model.addAttribute("cityMaster",cityMaster);
        return "admin/addCity";
    }
//    ----------------------------Delete single city record by using city_id ----------------------------------
    @GetMapping("/delete")
    public String delete(@RequestParam ("city_Id") Integer city_Id) {
        cityMasterService.delete(city_Id);
        return "redirect:/cities/list";
    }
}
