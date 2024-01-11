package com.mkpits.railway.controller;

import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.model.State_Form;
import com.mkpits.railway.model.State_Master;
import com.mkpits.railway.service.CountryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountryMasterController {
    private CountryMasterService countryMasterService;
    @Autowired
    public CountryMasterController(CountryMasterService countryMasterService) {
        this.countryMasterService = countryMasterService;
    }
//    --------------------- Display all the country records -------------------------------
    @GetMapping("/list")
    public String findAllCountry(Model model) {
         List<Country_Master> countryMasterList=countryMasterService.findAllCountry();
         model.addAttribute("countryMasterList",countryMasterList);
         return "/admin/displayCountryList";
    }
//    ----------------------- Save the country record --------------------------
    @GetMapping("/add")
    public String insertData(Model model){
        Country_Master countryMaster=new Country_Master();
        model.addAttribute("countryMaster",countryMaster);
        return "/admin/addCountry";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ("countryMaster") Country_Master countryMaster) {
         countryMasterService.save(countryMaster);
        return "redirect:/countries/list";
    }
//    ----------------------- Update the record by using country_id ----------------------

    @GetMapping("/update")
    public String update(@RequestParam ("country_Id") Integer country_Id,Model model) {
        Country_Master countryMaster= countryMasterService.update(country_Id);
        model.addAttribute("countryMaster",countryMaster);
         return "/admin/addCountry";
    }

    //    ----------------------- Delete the record by using country_id ----------------------
    @GetMapping("/delete")
    public String delete(@RequestParam ("country_Id") Integer country_Id) {
        countryMasterService.delete(country_Id);
        return "redirect:/countries/list";

    }

}
