package com.mkpits.railway.repository;

import com.mkpits.railway.model.City_Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City_Master,Integer> {
}
