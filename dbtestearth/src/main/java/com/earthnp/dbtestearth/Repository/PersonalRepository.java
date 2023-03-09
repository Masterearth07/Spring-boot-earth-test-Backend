package com.earthnp.dbtestearth.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.earthnp.dbtestearth.Model.Personal;

public interface PersonalRepository extends JpaRepository<Personal , Integer>{
	
	List<Personal> findByRole(String role);
} 
