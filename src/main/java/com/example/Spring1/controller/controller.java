package com.example.Spring1.controller;

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

import com.example.Spring1.dto.ResponseDTO;
import com.example.Spring1.entity.Employee;
import com.example.Spring1.exception.UserAlreadyExistException;
import com.example.Spring1.exception.UserNotFoundException;
import com.example.Spring1.service.IEmployeeService;
import com.example.Spring1.service.employeeService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

//testing features-prasad

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
@Slf4j
//main cntroller
public class controller {
	
	@Autowired
	private IEmployeeService iemployeeService;
	
	@GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
		return iemployeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
	    return iemployeeService.getEmployeeById(id);
	}

	@PostMapping("/add")
	public Employee createEmployee(@RequestBody Employee employee) throws UserAlreadyExistException {
		Employee emp=iemployeeService.createEmployee(employee);
//		log.debug(emp.getFirstName());
		//System.out.println(emp.getFirstName());
		//return new ResponseEntity<>(new ResponseDTO<>("Success",emp),HttpStatus.OK);

		return emp;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) throws UserNotFoundException{
		iemployeeService.deleteEmployee(id);
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		return iemployeeService.updateEmployee(id,employee);
	}
	
	@GetMapping("/topFiveByAge")
	public List<Employee> getTopFiveBySalary(){
		return iemployeeService.getTopFiveBySalary();
	}
	
	@GetMapping("/get/{firstName}")
	public List<Employee> getByfirstName(@PathVariable String firstName){
		return iemployeeService.findByfirstName(firstName);
	}
	
	@GetMapping("/getNameAndAge/{firstName}/{age}")
	public List<Employee> getByfirstNameAndAge(@PathVariable String firstName,@PathVariable String age){
		return iemployeeService.findByfirstNameAndAge(firstName,age);
	}
}