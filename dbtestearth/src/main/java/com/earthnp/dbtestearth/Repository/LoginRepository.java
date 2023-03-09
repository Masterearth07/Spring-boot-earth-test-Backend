package com.earthnp.dbtestearth.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.earthnp.dbtestearth.Model.Personal;

public interface LoginRepository extends JpaRepository<Personal , String> {
	
	Personal findByUsername(String username);
	Personal findByPassword(String password);

}
