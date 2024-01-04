package com.mkpits.railway.service;
import com.mkpits.railway.model.State_Master;
import java.util.List;

public interface StateMasterService {
    List<State_Master> findAllState();
    State_Master findById(Integer state_id);
    State_Master save(State_Master stateMaster);
    State_Master update(Integer state_id);
    State_Master delete(Integer state_id);

}
