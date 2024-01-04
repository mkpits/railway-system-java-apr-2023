package com.mkpits.railway.service.impli;

import com.mkpits.railway.model.StationMaster;
import com.mkpits.railway.repository.StationMasterRepository;
import com.mkpits.railway.service.StationMasterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class StationMasterImplimentation implements StationMasterService {
        private StationMasterRepository stationMasterRepository;
    @Autowired
    public StationMasterImplimentation(StationMasterRepository stationMasterRepository) {
        this.stationMasterRepository = stationMasterRepository;
    }

    @Override
    @Transactional
    public String saveStation(@ModelAttribute("master") StationMaster stationMaster) {
        stationMasterRepository.save(stationMaster);
        return "Data Inserted";
    }
}
