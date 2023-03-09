package com.earthnp.dbtestearth.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.earthnp.dbtestearth.Model.LoginCheckPersonal;
import com.earthnp.dbtestearth.Model.Personal;

public interface  PersonalService {
	
	List<Personal> findAll();
	
	List<Personal> findCategory(String role);
	
	Personal detailUser(Integer id);
	
	ResponseEntity<String> create(Personal personal);
	
	ResponseEntity<String> loginUser(LoginCheckPersonal logincheckpersonal);
	
	ResponseEntity<String> updateUser(Personal personal);
	
	void delpersonal(Integer id);
	
}

