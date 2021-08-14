package com.licious.practice.deptemploy.Emp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Emp, String>{
	
	public List<Emp> findByDeptId(String deptId);

}
