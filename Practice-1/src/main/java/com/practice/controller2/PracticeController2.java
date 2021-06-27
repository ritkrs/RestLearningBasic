package com.practice.controller2;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Employee;
import com.practice.model.ReadEmployeeDetails;

@RestController
@RequestMapping("/users2")
public class PracticeController2 {
	
	@GetMapping(path = "/{xml}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Employee jsonOrXmlFormat() {
		Employee employee2=new Employee();
		employee2.setAddress("abc");
		employee2.setFirstName("Ritesh");
		employee2.setLastName("tiwari K");
		employee2.setId(1);
		return employee2;
		
	}
	
	
	//(6) Reading HTTP POST Request Body from Postman.
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			     produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Employee> readingJsonPayload(@RequestBody ReadEmployeeDetails readEmployeeDetails){
		Employee e3=new Employee();
		e3.setAddress(readEmployeeDetails.getAddress());
		e3.setFirstName(readEmployeeDetails.getAddress());
		e3.setLastName(readEmployeeDetails.getLastName());
		e3.setId(readEmployeeDetails.getId());
		return new ResponseEntity<Employee>(e3,HttpStatus.OK);
		
	}
	

}
