package com.spring.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dto.Dept;

public interface DeptMapper {

	// resultType
	// String
	public String getDeptNameByDeptno(int deptno);

	// 객체
	public Dept getDeptByDeptno(int deptno);

	// HashMap
	public HashMap<String, Object> getDeptMap(int deptno);

	// List
	public List<Dept> getAllDepts();

	// List<HashMap<String, Object>>
	public List<HashMap<String, Object>> getAllDeptsMap();

	// parameter
	// 객체
	public void insertDept(Dept dept);

	public void insertDepts(List<Dept> deptList);

	// update : where deptno = 50 and dname = "PROGRAMMING" -> loc : "MOON"
	// 1. param
	// public void updateDeptByDeptnoAndDname(int deptno, String dname);
	// 2. map
	public void updateDeptByDeptnoAndDname(Map data);

	public void updateDeptByDeptno(Dept dept);

	// delete : where loc = "MOON"

	public void deleteDeptByLoc(String loc);

	public void deleteDeptByDeptno(int deptno);

}
