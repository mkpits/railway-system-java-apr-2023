package com.mkpits.railway.service;

import com.mkpits.railway.model.City_Master;
import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.repository.CityRepository;

import java.util.List;

public interface CityMasterService {
    List<City_Master> findAllCity();

}
