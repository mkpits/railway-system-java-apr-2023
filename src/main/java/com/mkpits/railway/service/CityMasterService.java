package com.mkpits.railway.service;
import com.mkpits.railway.model.City_Form;
import com.mkpits.railway.model.City_Master;
import java.util.List;

public interface CityMasterService {
    List<City_Master> findAllCity();
    City_Master findById(Integer city_id);

//    City_Master save(City_Master cityMaster);
//    City_Master update(Integer city_Id);
    void save(City_Form cityForm);
    void delete(Integer city_Id);

}
