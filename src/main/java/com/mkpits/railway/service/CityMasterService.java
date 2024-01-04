package com.mkpits.railway.service;
import com.mkpits.railway.model.City_Master;
import java.util.List;

public interface CityMasterService {
    List<City_Master> findAllCity();
    City_Master save(City_Master cityMaster);

}
