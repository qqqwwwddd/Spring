package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Emp;
import com.example.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepository;

	// 모든 emp
	@Override
	public List<Emp> getEmpAll() {

		return empRepository.findAll();
	}

	// 사원번호로 emp 검색
	@Override
	public Emp getEmpByEmpno(Long empno) {
		return empRepository.getEmpByEmpno(empno);
	}

	// emp 추가
	@Override
	public void insertEmp(Emp emp) {
		empRepository.save(emp);
	}

	// 사원번호로 emp 수정
	@Override
	public void updateEmpByEmpno(Emp emp) {
		Emp empFind = empRepository.getEmpByEmpno(emp.getEmpno());

		if (empFind != null) {
			empRepository.save(emp);
		}

	}

	// 사원번호로 emp 삭제
	@Override
	public void deleteEmpByEmpno(Long empno) {
		empRepository.deleteById(empno);
	}

}
