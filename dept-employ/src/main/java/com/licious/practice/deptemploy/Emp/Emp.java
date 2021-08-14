package com.licious.practice.deptemploy.Emp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.licious.practice.deptemploy.Dept.Dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Emp {
	
	@Id
	private String empId;
	private String fName, lName;
	private String mail;
	private String dateOfJoin;
	private long mobile;
	private String id;
	
	@ManyToOne
	private Dept dept;
	
	public Emp(String empId, String fName, String lName, String mail, String dateOfJoin, long mobile, String id, String deptId) {
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
