package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;

	@Override
	public Dept getDeptByDeptno(int deptno) {
		return deptMapper.getDeptByDeptno(deptno);
	}

	@Override
	public String getDeptNameByDeptno(int deptno) {
		return deptMapper.getDeptNameByDeptno(deptno);
	}

	@Override
	public HashMap<String, Object> getDeptMap(int deptno) {
		return deptMapper.getDeptMap(deptno);
	}

	@Override
	public List<Dept> getAllDepts() {
		return deptMapper.getAllDepts();
	}

	@Override
	public List<HashMap<String, Object>> getAllDeptsMap() {
		return deptMapper.getAllDeptsMap();
	}

	@Override
	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
	}

	@Override
	// update 1. Param
//	public void updateDeptByDeptnoAndDname(@RequestParam("deptno") int deptno, String dname) {
	// update 2. Map
	public void updateDeptByDeptnoAndDname(Map<String, Object> data) {
		deptMapper.updateDeptByDeptnoAndDname(data);
	}

	@Override
	public void deleteDeptByLoc(String loc) {
		deptMapper.deleteDeptByLoc(loc);
	}

}