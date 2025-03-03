package com.amazoneEcomApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.amazoneEcomApp.model.Employee;
import com.amazoneEcomApp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
//	---------------------------------------------------------------------------------------------------------
//	save
	
	public ResponseEntity<Employee> createUser(Employee emp){
		  
	Employee savedUser=employeeRepo.save(emp);	
		return ResponseEntity.ok(savedUser);
	}

//	---------------------------------------------------------------------------------------------------------
//	Update
	public ResponseEntity<Employee> updateUser(Employee empUpdate, Long id){
		
//		 .map() takes an input, applies some changes (transformation), and returns a new value.
         return employeeRepo.findById(id).map(exists ->{exists.setName(empUpdate.getName());
         
         Employee update=employeeRepo.save(exists);
         return ResponseEntity.ok(update);
         }).orElse(ResponseEntity.notFound().build());
	}
	
//	--------------------------------------------------------------------------------------------------------------
	
// Get All Details
	
	public ResponseEntity<List<Employee>>getAllDetails(){
		
		List<Employee> getAll=  employeeRepo.findAll();
		
		return ResponseEntity.ok(getAll);
	}
	
//	------------------------------------------------------------------------------------------------------------
//	Get Details By Id
	
	
	public ResponseEntity<Employee> getUserById(Long id){		
		return employeeRepo.findById(id)
				.map(ResponseEntity::ok)// जर Employee सापडला, तर ResponseEntity.ok(employee) परत करेल.
				.orElse(ResponseEntity.noContent().build());// जर Employee सापडला नाही, तर 204 No Content परत करेल. 
		}
	
//	-----------------------------------------------------------------------------------------------------------
	
//	delete by id
	public ResponseEntity<Void> deleteUser(Long id){
		
		if(employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.noContent().build();
		}
	}
//	-------------------------------------------------------------------------------------------------

}
