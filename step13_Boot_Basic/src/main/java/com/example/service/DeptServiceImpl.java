package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Dept;
import com.example.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired // 의존성 주입
	private DeptRepository deptRepository;

	// 모든 dept
	@Override
	public List<Dept> getDeptAll() {

		return deptRepository.findAll(); // DeptRepository 통해 -> Dao -> Service 전달
	}

	// 부서번호로 검색
	@Override
	public Dept getDeptByDeptno(Long deptno) {
		return deptRepository.findDeptByDeptno(deptno);
	}

	// dept 추가
	@Override
	public void insertDept(Dept dept) {

		if (getDeptByDeptno(dept.getDeptno()) == null) {

			deptRepository.save(dept);

		}
	}

	// 부서번호로 dept 수정
	@Override
//	public void updateDeptByDeptno(Dept dept) {
//		System.out.println(dept);
//		Dept deptFind = deptRepository.findDeptByDeptno(dept.getDeptno());

	public void updateDeptByDeptno(Long deptno, Dept newDept) {
		System.out.println(deptno);
		Dept deptFind = deptRepository.findDeptByDeptno(deptno);

		if (deptFind != null) {

			deptFind.setDname(newDept.getDname());
			deptFind.setLoc(newDept.getLoc());
			deptRepository.save(deptFind);
		}

	}

	// 부서번호로 dept 삭제
	@Override
	public void deleteDeptByDeptno(Long deptno) {
		deptRepository.deleteById(deptno);
	}

}
