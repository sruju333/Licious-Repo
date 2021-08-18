package com.licious.practice.deptemploy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.licious.practice.deptemploy.dto.Deptdto;
import com.licious.practice.deptemploy.model.Dept;

@Mapper
public interface DeptMapper {
	
	DeptMapper INSTANCE = Mappers.getMapper(DeptMapper.class);
	
	Deptdto modelTOdto(Dept dept);
	Dept dtoTOmodel(Deptdto deptdto);


}
