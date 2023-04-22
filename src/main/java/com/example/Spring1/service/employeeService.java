package com.example.Spring1.service;



import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring1.entity.Employee;
import com.example.Spring1.repository.employeeRepository;
import com.example.Spring1.exception.*;
import com.example.Spring1.dto.*;

@Service
@Transactional

public class employeeService implements IEmployeeService{
	
	@Autowired
	private employeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	
	 public Employee getEmployeeById(Long id) {
		 Employee employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
		    return employee;
		  }
//	@Override
//	 public Employee getEmployeeById(Long id) {
//		 	return employeeRepository.findById(id).orElse(null);
//  }

	@Override
	public Employee createEmployee(Employee employee) throws UserAlreadyExistException {
		System.out.println(employee.getFirstName());
		List<Employee>employeelist= employeeRepository.findByfirstName(employee.getFirstName());
		if(employeelist.size()==0) {
			return employeeRepository.save(employee);
		}else {
			throw new UserAlreadyExistException("User Already Exist"+employee.getFirstName());
		} 
 }
	
//	public List<Employee> createEmployeeByChecking(EmployeeDTO employeeDto)throws UserAlreadyExistException {
//		//System.out.println(employee.getFirstName());
//	    if(employeeRepository.findByfirstName(employeeDto.getEmail())==null) {
//	    	BeanUtils.copyProperties(employeeDto, employeeDto);
//	    	return employeeRepository.save(employeeDto);
//	    }else
//	    	throw new UserAlreadyExistException("User Already Exist",employeeDto.getEmail());
//	  }
	@Override
	public void deleteEmployee(Long id) {
		Employee employee=employeeRepository.findById(id).orElse(null);
		if(employee!=null) {
			employeeRepository.deleteById(id);
		}else
			 throw new UserNotFoundException("User Not Found with ID : "+id);
	}
	
	@Override
	public Employee updateEmployee(Long id,Employee employee) {
		Employee existingEmployee=employeeRepository.findById(id).orElse(null);
		if(existingEmployee!=null) {
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setAge(employee.getAge());
			return employeeRepository.save(existingEmployee);
		}else
			return null;
	}
	
	@Override
	public List<Employee> getTopFiveBySalary(){
		return employeeRepository.findAll().stream().sorted(Comparator.comparing(Employee::getAge)
				).limit(5).collect(Collectors.toList());
	}
     
	@Override
	public List<Employee> findByfirstName(String firstName){
		return employeeRepository.findByfirstName(firstName);
	}
	
	@Override
	public List<Employee> findByfirstNameAndAge(String firstName,String age){
		return employeeRepository.findByfirstNameAndAge(firstName,age);
	}
}
