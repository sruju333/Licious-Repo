package com.licious.demo.prac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licious.demo.prac.custom.exception.BusinessException;
import com.licious.demo.prac.custom.exception.EmptyInputException;
import com.licious.demo.prac.entity.Employee;
import com.licious.demo.prac.repository.EmployeeRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
			if(employee.getName().isEmpty() || employee.getName().length()==0) {
				throw new EmptyInputException("601", "Input fields are empty.");
			}
		try {
			Employee savedemployee = employeeRepository.save(employee);
			return savedemployee;
		}catch (IllegalArgumentException e) {
			throw new BusinessException("602", "given employee is null" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in Service Layer while saving the employee" + e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> empList = null;
		try {
			empList = employeeRepository.findAll();
		} catch (Exception e) {
			throw new BusinessException("605","Something went wrong in Service Layer while fetching all employees" + e.getMessage());
		}
		if (empList.isEmpty())
			throw new BusinessException("604", "Hey list is completely empty, we have nothing to return");
		return empList;
		
	}

	@Override
	public Employee getEmpById(Long empidL) {
		try {
			return employeeRepository.findById(empidL).get();
		}catch (IllegalArgumentException e) {
			throw new BusinessException("606", "Given employee id is null, please send some id to be searched" + e.getMessage());
		}catch (java.util.NoSuchElementException e) {
			throw new BusinessException("607", "Given employee id does not exist in database" + e.getMessage());
		}		
		
	}

	@Override
	public void deleteEmpById(Long empidL) {
		try {
			employeeRepository.deleteById(empidL);
		}catch (IllegalArgumentException e) {
			throw new BusinessException("608", "Given employee id is null, please send some id to be searched" + e.getMessage());
		}
		
	}
	
	
}
