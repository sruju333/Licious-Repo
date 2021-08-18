package com.licious.practice.deptemploy.dto;

import javax.persistence.Id;

import com.licious.practice.deptemploy.model.Dept;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empdto {
	
	@Id
	private String empId;
	private String fName, lName;
	private String mail;
	private String dateOfJoin;
	private long mobile;
	private String id;
	private Dept dept;
	
	public Empdto(String empId, String fName, String lName, String mail, String dateOfJoin, long mobile, String id, String deptId) {
		super();
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
		this.mail = mail;
		this.dateOfJoin = dateOfJoin;
		this.mobile = mobile;
		this.id = id;
		this.dept = new Dept(deptId, "");
		
	}

}
