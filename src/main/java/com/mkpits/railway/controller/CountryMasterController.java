package com.mkpits.railway.controller;

import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.service.CountryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountryMasterController {
    private CountryMasterService countryMasterService;
    @Autowired
    public CountryMasterController(CountryMasterService countryMasterService) {
        this.countryMasterService = countryMasterService;
    }
    @GetMapping("/list")
    public String findAllCountry(Model model) {
         List<Country_Master> countryMasterList=countryMasterService.findAllCountry();
         model.addAttribute("countryMasterList",countryMasterList);
         return "/admin/displayCountryList";
    }
}
