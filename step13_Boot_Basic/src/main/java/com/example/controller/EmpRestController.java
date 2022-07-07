package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Emp;
import com.example.service.EmpServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
@RestController
public class EmpRestController {

	@Autowired
	EmpServiceImpl empService;

	// 모든 emp
	@GetMapping(value = "/emps")
	public List<Emp> getEmps() {
		return empService.getEmpAll();
	}

	// 사원번호로 emp 검색
	@GetMapping(value = "/emp/{empno}")
	public Emp getEmpByEmpno(@PathVariable Long empno) {
		System.out.println(empno);
		return empService.getEmpByEmpno(empno);
	}

	// emp 추가
	@PostMapping(value = "/emp", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public List<Emp> insertEmp(@ModelAttribute Emp emp) {
		System.out.println(emp);
		empService.insertEmp(emp);
		return empService.getEmpAll();

	}

	// emp 수정
	@PutMapping(value = "/emp/{empno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> updateEmpByEmpno(@PathVariable("empno") Long empno, @RequestBody Emp emp) {
		System.out.println(emp);
		emp.setEmpno(empno);
		empService.updateEmpByEmpno(emp);
		return empService.getEmpAll();
	}

	// emp 삭제
	@DeleteMapping(value = "/emp/{empno}")
	public List<Emp> deleteEmpByEmpno(@PathVariable Long empno) {
		empService.deleteEmpByEmpno(empno);
		return empService.getEmpAll();
	}

}
