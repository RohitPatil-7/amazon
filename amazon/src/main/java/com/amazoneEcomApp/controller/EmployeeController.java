package com.amazoneEcomApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazoneEcomApp.model.Employee;
import com.amazoneEcomApp.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee emp){
		
		return empService.createUser(emp);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateUser( @RequestBody Employee empUpdate, @PathVariable Long id){
		
		return empService.updateUser(empUpdate, id);
	}

	
	@GetMapping("/getallDeatils")
	public ResponseEntity<List<Employee>> getAllUsers(){
		
		return empService.getAllDetails();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee> getById (@PathVariable Long id){
		
		return empService.getUserById(id);
	}
	
	
	@DeleteMapping("/deleteByid/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		return empService.deleteUser(id);
	}
	
	

}
