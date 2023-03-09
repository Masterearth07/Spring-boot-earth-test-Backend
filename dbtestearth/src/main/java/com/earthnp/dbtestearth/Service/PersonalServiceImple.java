package com.earthnp.dbtestearth.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.earthnp.dbtestearth.Model.LoginCheckPersonal;
import com.earthnp.dbtestearth.Model.Personal;
import com.earthnp.dbtestearth.Repository.LoginRepository;
import com.earthnp.dbtestearth.Repository.PersonalRepository;

@Service
public class PersonalServiceImple implements PersonalService{
	
	@Autowired
	private PersonalRepository repository;
//	
	@Autowired
	private LoginRepository loginRepository;

	
	//Method
	@Override
	public List<Personal> findAll(){
		return repository.findAll(); 
	}
	
	//Method
	@Override
	public List<Personal> findCategory(String role){
		return repository.findByRole(role);
	}
		
		
	@Override
	public Personal detailUser(Integer id){
		Personal detailP = repository.findById(id).orElse(null);
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public ResponseEntity<String> loginUser(LoginCheckPersonal logincheckpersonal) {
		
		Personal personal = loginRepository.findByUsername(logincheckpersonal.getUsername());
		if(personal == null) {
			return new ResponseEntity<String>("Login failed wrong username.",HttpStatus.NOT_FOUND);
		}
		if(!personal.getPassword().equals(logincheckpersonal.getPassword())) {
			return new ResponseEntity<String>("Login failed wrong password.",HttpStatus.NOT_FOUND);
		}
		int id = personal.getId();
		String convertId = Integer.toString(id);
		return new ResponseEntity<String>(convertId,HttpStatus.OK);
		
	}
	
	//SignUp // Register // Create Acc
	@Override
	public ResponseEntity<String> create(Personal personal) {
		if(personal.getEmail() == null || personal.getEmail().isEmpty()) {
			return new ResponseEntity<String>("pls fill Email ",HttpStatus.BAD_REQUEST);

		}
		if(personal.getName()== null || personal.getName().isEmpty()) {
			return new ResponseEntity<String>("pls fill Name ",HttpStatus.BAD_REQUEST);

		}
		if(personal.getRole() == null || personal.getRole().isEmpty()) {
			return new ResponseEntity<String>("pls fill Role ",HttpStatus.BAD_REQUEST);

		}
		if(personal.getUsername() == null || personal.getUsername().isEmpty()) {
			return new ResponseEntity<String>("pls fill username ",HttpStatus.BAD_REQUEST);

		}
		if(personal.getPassword() == null || personal.getPassword().isEmpty()) {
			return new ResponseEntity<String>("pls fill Password ",HttpStatus.BAD_REQUEST);

		}
		repository.save(personal);
		return new ResponseEntity<String>("Register success ! ",HttpStatus.OK);

	}
	
	@Override
	public ResponseEntity<String> updateUser(Personal personal) {
		if(personal.getEmail() == null || personal.getEmail().isEmpty()) {
			return new ResponseEntity<String>("pls fill Email ",HttpStatus.BAD_REQUEST);

		}
		if(personal.getName()== null || personal.getName().isEmpty()) {
			return new ResponseEntity<String>("pls fill Name ",HttpStatus.BAD_REQUEST);

		}
		if(personal.getRole() == null || personal.getRole().isEmpty()) {
			return new ResponseEntity<String>("pls fill Role ",HttpStatus.BAD_REQUEST);

		}
		if(personal.getUsername() == null || personal.getUsername().isEmpty()) {
			return new ResponseEntity<String>("pls fill username ",HttpStatus.BAD_REQUEST);

		}
		if(personal.getPassword() == null || personal.getPassword().isEmpty()) {
			return new ResponseEntity<String>("pls fill Password ",HttpStatus.BAD_REQUEST);

		}
		repository.save(personal);
		return new ResponseEntity<String>("update! success ! ",HttpStatus.OK);

	}
	
	@Override
	public void delpersonal(Integer id) {
		repository.deleteById(id);
		
	}
	
	
	
	
	
	
	
	
	
}
