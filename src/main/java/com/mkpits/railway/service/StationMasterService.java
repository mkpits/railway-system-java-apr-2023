package com.mkpits.railway.service;

import com.mkpits.railway.model.StationMaster;

import java.util.List;

public interface StationMasterService {
    public String saveStation(StationMaster stationMaster);
    public List<StationMaster>getAllList();

    public String deleteById(int station_id);

    StationMaster updateById(Integer station_id);
}
