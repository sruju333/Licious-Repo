package com.licious.practice.deptemploy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.licious.practice.deptemploy.model.Emp;

public interface EmpRepository extends CrudRepository<Emp, String>{
	
	public List<Emp> findByDeptId(String deptId);

}
