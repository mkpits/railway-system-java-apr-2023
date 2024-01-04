package com.mkpits.railway.service.impli;
import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.repository.CountryRepository;
import com.mkpits.railway.service.CountryMasterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CountryMasterServiceImpli implements CountryMasterService {
    private CountryRepository countryRepository;
    @Autowired
    public CountryMasterServiceImpli(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @Override
    public List<Country_Master> findAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    @Transactional
    public Country_Master save(Country_Master countryMaster) {
        return countryRepository.save(countryMaster);
    }
}
