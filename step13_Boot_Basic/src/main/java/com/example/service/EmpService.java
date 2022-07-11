package com.example.service;

import java.util.List;

import com.example.dto.EmpDTO;

public interface EmpService {

	// 모든 emp
	public List<EmpDTO> getEmpAll();

	// 사원번호로 emp 검색
	public EmpDTO getEmpByEmpno(Long empno);

	// emp 추가
	public void insertEmp(EmpDTO empDTO);

	// 사원번호로 emp 수정
	public void updateEmpByEmpno(EmpDTO empDTO);

	// emp 삭제
	public void deleteEmpByEmpno(Long empno);
}
