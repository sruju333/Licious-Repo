package com.licious.practice.deptemploy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licious.practice.deptemploy.custom.exception.BusinessException;
import com.licious.practice.deptemploy.model.Emp;
import com.licious.practice.deptemploy.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository emprepository;
	
	public List<Emp> getAllEmpFields(String deptId){
		List<Emp> emps = new ArrayList<>();
		emprepository.findByDeptId(deptId)
		.forEach(emps::add);
		return emps;
	}
	
	public Optional<Emp> getEmpId(String id) {
		try {
			return emprepository.findById(id);
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("604","given employee ID does not exist in Database" + e.getMessage());
		}
		
	}

	public void addEmp(Emp emp) {
		try {
			if(emp.getFName().isEmpty() || emp.getFName().length()==0) {
				throw new BusinessException("601", "Please send proper name, it's blank");
			}
			emprepository.save(emp);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("602","given employee is null, don't leave it blank" + e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("603", "Something went wrong in service layer" + e.getMessage());
		}
		
	}

	public void updateEmp(Emp emp) {
		emprepository.save(emp);
	}

	public void deleteEmpId(String id) {
		emprepository.deleteById(id);
	}

}
