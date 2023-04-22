package com.example.Spring1.service;

import java.util.List;

import com.example.Spring1.entity.Employee;
import com.example.Spring1.exception.UserAlreadyExistException;

public interface IEmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Long id);
	public Employee createEmployee(Employee employee) throws UserAlreadyExistException;
	public void deleteEmployee(Long id);
	public Employee updateEmployee(Long id,Employee employee);
	public List<Employee> getTopFiveBySalary();
	public List<Employee> findByfirstName(String firstName);
	public List<Employee> findByfirstNameAndAge(String firstName,String age);
}
