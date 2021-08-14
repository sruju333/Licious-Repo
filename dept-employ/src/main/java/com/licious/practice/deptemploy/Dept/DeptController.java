package com.licious.practice.deptemploy.Dept;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/dept")
	public List<Dept> getAllDeptFields() {
		return deptService.getAllDeptFields();
	}
	
	@RequestMapping("/dept/{id}")
	public Optional<Dept> getDeptId(@PathVariable String id) {
		return deptService.getDeptId(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/dept")
	public void addDept(@RequestBody Dept dept) {
		deptService.addDept(dept);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/dept/{id}")
	public void updateDept(@RequestBody Dept dept, @PathVariable String id) {
		deptService.updateDept(dept,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/dept/{id}")
	public void deleteDeptId(@PathVariable String id) {
		deptService.deleteDeptId(id);
	}

}
