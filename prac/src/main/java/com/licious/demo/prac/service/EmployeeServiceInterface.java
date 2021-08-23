package com.licious.demo.prac.service;

import java.util.List;

import com.licious.demo.prac.entity.Employee;

public interface EmployeeServiceInterface {

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmpById(Long empidL);

	void deleteEmpById(Long empidL);

}
