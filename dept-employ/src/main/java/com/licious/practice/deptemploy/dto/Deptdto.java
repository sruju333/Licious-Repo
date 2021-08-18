package com.licious.practice.deptemploy.dto;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Deptdto {
	
	@Id
	private String id;
	private String name;

}
