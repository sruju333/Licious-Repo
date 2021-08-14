package com.licious.practice.deptemploy.Emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return emprepository.findById(id);
	}

	public void addEmp(Emp emp) {
		emprepository.save(emp);
	}

	public void updateEmp(Emp emp) {
		emprepository.save(emp);
	}

	public void deleteEmpId(String id) {
		emprepository.deleteById(id);
	}

}
