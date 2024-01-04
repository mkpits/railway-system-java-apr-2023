package com.mkpits.railway.repository;

import com.mkpits.railway.model.Country_Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country_Master,Integer> {
}
