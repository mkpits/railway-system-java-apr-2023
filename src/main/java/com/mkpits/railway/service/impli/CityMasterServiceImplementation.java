package com.mkpits.railway.service.impli;
import com.mkpits.railway.model.City_Master;
import com.mkpits.railway.repository.CityRepository;
import com.mkpits.railway.service.CityMasterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityMasterServiceImplementation implements CityMasterService {
    private CityRepository cityRepository;
    @Autowired
    public CityMasterServiceImplementation(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City_Master> findAllCity() {
        return cityRepository.findAll();
    }
    @Override
    @Transactional
    public City_Master save(City_Master cityMaster) {
        return cityRepository.save(cityMaster);
    }
}
