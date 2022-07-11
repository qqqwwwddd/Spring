package com.example.service;

import java.util.List;

import com.example.dto.DeptDTO;

public interface DeptService {

	// 모든 dept
	public List<DeptDTO> getDeptAll();

	// 부서번호로 dept 검색
	public DeptDTO getDeptByDeptno(Long deptno);

	// dept 추가
	public void insertDept(DeptDTO deptDTO);

	// 부서번호로 dept 수정
	public void updateDeptByDeptno(Long deptno, DeptDTO newDeptDTO);

	// 부서번호로 dept 삭제
	public void deleteDeptByDeptno(Long deptno);
}
