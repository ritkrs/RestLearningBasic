package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Employee;

@RestController
@RequestMapping("/users")
public class PracticeController {
	
	//(1)   Read By id
	@GetMapping("/api/{userId}")
	public String getUserById(@PathVariable String userId) {
		return "id is returning here"+userId;	
	}
	
	//(2)   Query String and Query Param
	/*  NOTE:-It is also known as PAGINATION.
	 *  Def:-It is used for bind the web request parameter to a method parameter.
	 *  Real time example:-If we are faetching the records from DB that contains more than 50 pages record but i want to fetch   
	 *  the records only from 1 to 10 page records then we can use the @QueryParam for fetch the page records based on condition.
	 *  Url:-http://localhost:8080/users?page=1&limit=5665
	*/
	@GetMapping
	public String queryParam(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {
		return "page"+page+","+"limit="+limit;
		
	}
	
	//(3)   Returning Java object as a value.(Video=22)
	@GetMapping("/obj")
	public Employee returnJavaObjAsValue() {
		Employee employee=new Employee();
		employee.setAddress("abc");
		employee.setFirstName("Ritesh");
		employee.setId(25);
		employee.setLastName("kumar");
		return employee;
	}
	
	//(4)  Returning Java Object as Json or Xml format both.
	
	/* 1. Add produces with path Mapping.
	 * 2. Add the jackson-dataformat-xml dependency in pom.xml
	 * 3. Change the Headers in Postman(key=Accept, value=application/xml)
	*/
	@GetMapping(path = "/{xml}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Employee jsonOrXmlFormat() {
		Employee employee2=new Employee();
		employee2.setAddress("abc");
		employee2.setFirstName("Ritesh");
		employee2.setLastName("tiwari");
		employee2.setId(1);
		return employee2;
		
	}
	//(5)  Response status code
	/* If we will return only HttpStatus code in the constructor of ResponseEntity obje then we will get BAD_REQUEST
	*/
	@GetMapping("/statuscode")
	public ResponseEntity<Employee> setReesponseStatusCode(){
		Employee e2=new Employee();
		e2.setAddress("qwe");
		e2.setFirstName("rty");
		e2.setId(1);
		e2.setLastName("uio");
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<Employee>(e2,HttpStatus.BAD_REQUEST);
	}
	
	
	

}
