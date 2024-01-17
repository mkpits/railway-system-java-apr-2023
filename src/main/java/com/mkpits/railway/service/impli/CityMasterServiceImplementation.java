package com.mkpits.railway.service.impli;
import com.mkpits.railway.model.City_Form;
import com.mkpits.railway.model.City_Master;
import com.mkpits.railway.model.State_Master;
import com.mkpits.railway.repository.CityRepository;
import com.mkpits.railway.repository.StateRepository;
import com.mkpits.railway.service.CityMasterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityMasterServiceImplementation implements CityMasterService {
    private CityRepository cityRepository;
    private StateRepository stateRepository;
    @Autowired
//    public CityMasterServiceImplementation(CityRepository cityRepository) {
//        this.cityRepository = cityRepository;
//    }

    public CityMasterServiceImplementation(CityRepository cityRepository, StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    @Override
    public List<City_Master> findAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public City_Master findById(Integer city_id) {
        return cityRepository.findById(city_id).get();
    }

    @Override
    @Transactional
    public void save(City_Form cityForm) {
        if(cityForm.getCity_Id()!=0){
           City_Master existingCityMaster=cityRepository.findById(cityForm.getCity_Id()).orElse(null);
           if(existingCityMaster!=null) {
               existingCityMaster.setCity_Name(cityForm.getCity_Name());
               State_Master stateMaster = stateRepository.findById(cityForm.getState_Id()).orElse(null);
               existingCityMaster.setStateMaster(stateMaster);

               cityRepository.save(existingCityMaster);
           }
        }else {
            City_Master cityMaster = new City_Master();

            cityMaster.setCity_Name(cityForm.getCity_Name());

            State_Master stateMaster = stateRepository.findById(cityForm.getState_Id()).orElse(null);
            cityMaster.setStateMaster(stateMaster);

            cityRepository.save(cityMaster);
        }
    }
    @Override
    public void delete(Integer city_Id) {
        cityRepository.deleteById(city_Id);
    }
}
