package com.licious.practice.deptemploy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.licious.practice.deptemploy.dto.Empdto;
import com.licious.practice.deptemploy.model.Emp;

@Mapper
public interface EmpMapper {
	
DeptMapper INSTANCE = Mappers.getMapper(DeptMapper.class);
	
	Empdto modelTOdto(Emp emp);
	Emp dtoTOmodel(Empdto empdto);

}
