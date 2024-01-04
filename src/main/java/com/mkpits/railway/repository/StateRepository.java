package com.mkpits.railway.repository;

import com.mkpits.railway.model.State_Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State_Master,Integer> {

}
