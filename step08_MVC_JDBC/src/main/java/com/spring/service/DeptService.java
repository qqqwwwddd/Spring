package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dto.Dept;

public interface DeptService {

	public Dept getDeptByDeptno(int deptno);

	public String getDeptNameByDeptno(int deptno);

	public HashMap<String, Object> getDeptMap(int deptno);

	public List<Dept> getAllDepts();

	// List<HashMap<String, Object>>
	List<HashMap<String, Object>> getAllDeptsMap();

	public void insertDept(Dept dept);

	// update 1.param
//	public void updateDeptByDeptnoAndDname(int deptno, String dname);

	// update 2. Map
	public void updateDeptByDeptnoAndDname(Map<String, Object> data);

	public void updateDeptByDeptno(Dept dept);

	// delete
	public void deleteDeptByLoc(String loc);

	public void deleteDeptByDeptno(int deptno);
}
