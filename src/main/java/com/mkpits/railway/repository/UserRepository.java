package com.mkpits.railway.repository;

import com.mkpits.railway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
