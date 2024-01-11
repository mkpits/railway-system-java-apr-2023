package com.mkpits.railway.service;
import com.mkpits.railway.model.State_Form;
import com.mkpits.railway.model.State_Master;
import org.springframework.ui.Model;

import java.util.List;

public interface StateMasterService {
    List<State_Master> findAllState();
    State_Master findById(Integer state_id);
    void save(State_Form stateForm);
//    State_Master save(State_Master stateMaster);
//    State_Master update(Integer state_id);
//    void update(State_Form stateForm);
//    void deleteByCityName(State_Form stateMaster,Integer stateId);

    void delete(Integer state_id);

}
