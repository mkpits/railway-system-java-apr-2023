package com.mkpits.railway.service.impli;
import com.mkpits.railway.model.State_Master;
import com.mkpits.railway.repository.StateRepository;
import com.mkpits.railway.service.StateMasterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StateMasterServiceImplementation implements StateMasterService {
    private StateRepository stateRepository;
    @Autowired
    public StateMasterServiceImplementation(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
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
    public State_Master save(State_Master stateMaster) {
        return stateRepository.save(stateMaster);
    }

    @Override
    public State_Master update(Integer state_id) {
         return findById(state_id);
    }

    @Override
    public void delete(Integer state_id) {
       stateRepository.deleteById(state_id);
    }
}
