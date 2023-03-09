package com.earthnp.dbtestearth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earthnp.dbtestearth.Model.LoginCheckPersonal;
import com.earthnp.dbtestearth.Model.Personal;
import com.earthnp.dbtestearth.Service.PersonalService;

@RestController
@RequestMapping("/personal")
public class PersonalController {
	
	@Autowired
	private PersonalService personalService;
	
	
	@CrossOrigin(origins = "http://localhost:3000/")
	@GetMapping(value = "/getpersonal")
	public ResponseEntity<List<Personal>> findAll(){
		List<Personal> list =personalService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000/")
	@GetMapping(value = "/getpersonal/{role}")
	public ResponseEntity<List<Personal>> findCategory(@PathVariable("role") String role){
		List<Personal> category =personalService.findCategory(role);
		if(category == null) {
			return new ResponseEntity<List<Personal>>(category, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000/")
	@GetMapping(value = "/detailUser/{id}")
	public ResponseEntity<Personal> detailUser(@PathVariable("id") int id){
		
		Personal result = personalService.detailUser(id);
		if(result == null) {
			return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000/")
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginCheckPersonal logincheckpersonal) {
		return personalService.loginUser(logincheckpersonal);
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000/")
	@PostMapping("/register")
	public ResponseEntity<String> create(@RequestBody Personal personal) {
		return personalService.create(personal);
	}
	
	
	//update 
	@CrossOrigin(origins = "http://localhost:3000/")
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id,@RequestBody Personal personal) {
		personal.setId(id);
		return personalService.updateUser(personal);
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000/")
	@DeleteMapping("/delete/{id}")
	public void deletePersonal(@PathVariable("id") int id) {
		personalService.delpersonal(id);
	}
	
	
}
