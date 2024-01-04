package com.mkpits.railway.controller;

import com.mkpits.railway.model.City_Master;
import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.service.CityMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityMaster {
    private CityMasterService cityMasterService;
    @Autowired
    public CityMaster(CityMasterService cityMasterService) {
        this.cityMasterService = cityMasterService;
    }
    @GetMapping("/list")
    public String findAllCity(Model model) {
       List<City_Master> cityMasterList= cityMasterService.findAllCity();
        model.addAttribute("cityMasterList",cityMasterList);
        return "/admin/displayCityList";
    }
}
