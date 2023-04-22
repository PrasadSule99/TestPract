package com.example.Spring1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring1.entity.Employee;

@Repository
public interface employeeRepository extends JpaRepository<Employee,Long> {
	public List<Employee> findByfirstName(String firstName);
	public List<Employee> findByfirstNameAndAge(String firstName,String age);
}
