package com.mkpits.railway.service;
import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.model.State_Form;

import java.util.List;

public interface CountryMasterService {
    List<Country_Master> findAllCountry();
    Country_Master findById(Integer country_id);
//    Country_Master findById(State_Form stateForm );
//    Country_Master findById(State_Form stateForm,Integer country);


    Country_Master save(Country_Master countryMaster);
    Country_Master update(Integer country_Id);
    void delete(Integer country_Id);
}
