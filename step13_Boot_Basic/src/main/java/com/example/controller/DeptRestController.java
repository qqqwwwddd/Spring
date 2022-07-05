package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dept;
import com.example.service.DeptServiceImpl;

@RestController
public class DeptRestController {

	@Autowired
	DeptServiceImpl deptService;

	// 모든 dept
	@GetMapping(value = "/depts")
	public List<Dept> getDepts() {
		return deptService.getDeptAll();
	}

	// deptno로 검색
	@GetMapping(value = "/dept/{deptno}")
	public Dept getDeptByDeptno(@PathVariable Long deptno) {
		System.out.println(deptno);
		return deptService.getDeptByDeptno(deptno);
	}

	// Dept 추가
	@PostMapping(value = "/dept", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public List<Dept> insertDept(@ModelAttribute Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
		return deptService.getDeptAll();
	}

	// deptno로 수정
	@PutMapping(value = "/dept/{deptno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Dept> updateDeptByDeptno(@PathVariable Long deptno, @RequestBody Dept dept) {
		System.out.println(deptno);
//		dept.setDeptno(deptno);
		deptService.updateDeptByDeptno(deptno, dept);
		return deptService.getDeptAll();
	}

	// deptno로 삭제
	@DeleteMapping(value = "/dept/{deptno}")
	public List<Dept> deleteDepByDeptno(@PathVariable Long deptno) {
		deptService.deleteDeptByDeptno(deptno);
		return deptService.getDeptAll();
	}

}
