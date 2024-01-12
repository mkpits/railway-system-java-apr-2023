package com.mkpits.railway.service.impli;
import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.model.State_Form;
import com.mkpits.railway.model.State_Master;
import com.mkpits.railway.repository.CountryRepository;
import com.mkpits.railway.repository.StateRepository;
import com.mkpits.railway.service.StateMasterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class StateMasterServiceImplementation implements StateMasterService {
    private StateRepository stateRepository;
    private CountryRepository countryRepository;

    @Autowired
    public StateMasterServiceImplementation(StateRepository stateRepository, CountryRepository countryRepository){
        this.stateRepository = stateRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<State_Master> findAllState() {
        return stateRepository.findAll();
    }
    @Override
    public State_Master findById(Integer state_id) {
        return stateRepository.findById(state_id).get();
    }
    @Override
    @Transactional
    public void save(State_Form stateForm) {
        if (stateForm.getState_Id()!= 0) {
            // Update existing entity
            State_Master existingState = stateRepository.findById(stateForm.getState_Id()).orElse(null);
            if (existingState != null) {
                // Update fields based on stateForm
                existingState.setState_Name(stateForm.getState_Name());
                existingState.setCountryMaster(countryRepository.findById(stateForm.getCountry_Id()).orElse(null));
                // Update other fields as needed
                stateRepository.save(existingState);
            }
        } else {
            State_Master stateMaster = new State_Master();

//        set the state_Name into the state_Master but it will be get from the state_form
            stateMaster.setState_Name(stateForm.getState_Name());

//     If we want to find the country id it will be fetched from state_Form entity
            Country_Master countryMaster = countryRepository.findById(stateForm.getCountry_Id()).get();

//        the country_Master object can be set into the stateMaster
            stateMaster.setCountryMaster(countryMaster);
             stateRepository.save(stateMaster);
        }
    }

    @Override
    public void delete(Integer state_id) {
       stateRepository.deleteById(state_id);
    }
}
