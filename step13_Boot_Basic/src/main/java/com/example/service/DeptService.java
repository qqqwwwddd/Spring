package com.example.service;

import java.util.List;

import com.example.model.Dept;

public interface DeptService {

	// 모든 dept
	public List<Dept> getDeptAll();

	// 부서번호로 dept 검색
	public Dept getDeptByDeptno(Long deptno);

	// dept 추가
	public void insertDept(Dept dept);

	// 부서번호로 dept 수정
	public void updateDeptByDeptno(Long deptno, Dept dept);

	// 부서번호로 dept 삭제
	public void deleteDeptByDeptno(Long deptno);
}
