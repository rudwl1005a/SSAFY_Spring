package com.mycom.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface DBDao {
	public EmpDto empDetail(int employeeId);
	public List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empUpdate(EmpDto dto);
	public int empDelete(int employeeId);
	
	public List<EmpDto> empListParameterMap(Map<String, String> map); // Map
	public List<EmpDto> empListParameterMap2(@Param("firstName") String firstName, @Param("lastName") String lastName); // @Param
	public List<EmpDto> empListParameterMap3(EmpDto dto); // DTO
	
	public List<EmpDto> empListLike(String searchWord);
	
	public List<EmpDto> empListWhereIf(@Param("firstName") String firstName, @Param("lastName") String lastName); // where if
}
