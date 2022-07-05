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
		if (getEmpByEmpno(emp.getEmpno()) == null) {
			empRepository.save(emp);
		}
	}

	// 사원번호로 emp 수정
//	@Override
//	public void updateEmpByEmpno(Emp emp) {
//		Emp empFind = empRepository.getEmpByEmpno(emp.getEmpno());
//
//		if (empFind != null) {
//			empRepository.save(emp);
//		}
//
//	}

	@Override
	public void updateEmpByEmpno(Emp newEmp) {
		Emp preEmp = empRepository.getEmpByEmpno(newEmp.getEmpno());

		if (preEmp != null) {

			preEmp.setEname(newEmp.getEname() == null ? preEmp.getEname() : newEmp.getEname());
			preEmp.setJob(newEmp.getJob() == null ? preEmp.getJob() : newEmp.getJob());
			preEmp.setMgr(newEmp.getMgr() == null ? preEmp.getMgr() : newEmp.getMgr());
			preEmp.setHiredate(newEmp.getHiredate() == null ? preEmp.getHiredate() : newEmp.getHiredate());
			preEmp.setSal(newEmp.getSal() == null ? preEmp.getSal() : newEmp.getSal());
			preEmp.setComm(newEmp.getComm() == null ? preEmp.getComm() : newEmp.getComm());
			preEmp.setDept(newEmp.getDept() == null ? preEmp.getDept() : newEmp.getDept());

			empRepository.save(preEmp);
		}

	}

	// 사원번호로 emp 삭제
	@Override
	public void deleteEmpByEmpno(Long empno) {
		empRepository.deleteById(empno);
	}

}
