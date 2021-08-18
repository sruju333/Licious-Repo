package com.licious.practice.deptemploy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licious.practice.deptemploy.model.Dept;
import com.licious.practice.deptemploy.repository.DeptRepository;

@Service
public class DeptService {
	
	@Autowired
	private DeptRepository deptrepository;
	
	public List<Dept> getAllDeptFields(){
		List<Dept> depts = new ArrayList<>();
		deptrepository.findAll()
		.forEach(depts::add);
		return depts;
	}
	
	public Optional<Dept> getDeptId(String id) {
		return deptrepository.findById(id);
	}

	public void addDept(Dept dept) {
		deptrepository.save(dept);
		
	}

	public void updateDept(Dept dept, String id) {
		deptrepository.save(dept);

	}

	public void deleteDeptId(String id) {
		deptrepository.deleteById(id);
	}

}
