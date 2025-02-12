package com.licious.practice.deptemploy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.licious.practice.deptemploy.custom.exception.BusinessException;
import com.licious.practice.deptemploy.custom.exception.ControllerException;
import com.licious.practice.deptemploy.model.Dept;
import com.licious.practice.deptemploy.model.Emp;
import com.licious.practice.deptemploy.service.EmpService;

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
		
		try {
			emp.setDept(new Dept(deptId, ""));
			empService.addEmp(emp);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			
		}catch(Exception e) {
			ControllerException ce = new ControllerException("605", "Something went wrong in controller");

		}
		
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
