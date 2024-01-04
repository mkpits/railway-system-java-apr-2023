package com.mkpits.railway.service.impli;

import com.mkpits.railway.model.StationMaster;
import com.mkpits.railway.repository.StationMasterRepository;
import com.mkpits.railway.service.StationMasterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<StationMaster> getAllList() {
        return stationMasterRepository.findAll();
    }

    @Override
    @Transactional
    public String deleteById(int station_id) {
        stationMasterRepository.deleteById(station_id);
        return "deleted";
    }

    @Override
    public StationMaster updateById(Integer station_id) {
        Optional<StationMaster> optionalStationMaster=stationMasterRepository.findById(station_id);
        return optionalStationMaster.get();
    }
}
