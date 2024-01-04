package com.mkpits.railway.service;

import com.mkpits.railway.model.Country_Master;
import com.mkpits.railway.model.State_Master;
import com.mkpits.railway.repository.StateRepository;

import java.util.List;

public interface StateMasterService {
    List<State_Master> findAllState();

}
