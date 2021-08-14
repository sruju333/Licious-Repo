package com.licious.practice.deptemploy.Emp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.licious.practice.deptemploy.Dept.Dept;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping("/dept/{id}/emp")
	public List<Emp> getAllEmpFields(@PathVariable String id) {
		return empService.getAllEmpFields(id);
	}
	
	@RequestMapping("/dept/{deptId}/emp/{id}")
	public Optional<Emp> getEmpId(@PathVariable String id) {
		return empService.getEmpId(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/dept/{deptId}/emp")
	public void addEmp(@RequestBody Emp emp, @PathVariable String deptId) {
		emp.setDept(new Dept(deptId, ""));
		empService.addEmp(emp);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/dept/{deptId}/emp/{id}")
	public void updateEmp(@RequestBody Emp emp, @PathVariable String deptId, @PathVariable String id) {
		emp.setDept(new Dept(deptId, ""));
		empService.updateEmp(emp);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/dept/{deptId}/emp/{id}")
	public void deleteEmpId(@PathVariable String id) {
		empService.deleteEmpId(id);
	}

}
