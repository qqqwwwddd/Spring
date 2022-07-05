package com.example.service;

import java.util.List;

import com.example.model.Emp;

public interface EmpService {

	// 모든 emp
	public List<Emp> getEmpAll();

	// 사원번호로 emp 검색
	public Emp getEmpByEmpno(Long empno);

	// emp 추가
	public void insertEmp(Emp emp);

	// 사원번호로 emp 수정
	public void updateEmpByEmpno(Emp emp);

	// emp 삭제
	public void deleteEmpByEmpno(Long empno);
}
