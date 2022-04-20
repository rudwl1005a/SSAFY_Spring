package com.mycom.mydb.dao;

import java.util.List;

import com.mycom.mydb.dto.EmpDto;

public interface DBDao {
	public EmpDto empDetail(int employeeId);
	public List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empUpdate(EmpDto dto);
	public int empDelete(int employeeId);
}
