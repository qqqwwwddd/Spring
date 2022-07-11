package com.example.controller;

import java.util.List;

import javax.transaction.Transactional;

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

import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Dept;
import com.example.service.DeptServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
@RestController
public class DeptRestController {

	@Autowired
	DeptServiceImpl deptService;

	// 모든 dept
//	@GetMapping(value = "/depts")
//	public List<DeptDTO> getDepts() {
//		return deptService.getDeptAll();
//	}
	// 페이즹
	@GetMapping(value = "/depts")
	public PageResultDTO<DeptDTO, Dept> getDepts(PageRequestDTO pageDTO) {
		System.out.println(pageDTO);
		System.out.println("=================");
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(pageDTO.getPage()).size(5).build();
		PageResultDTO<DeptDTO, Dept> pageResultDTO = deptService.getList(pageRequestDTO);
		return pageResultDTO;
	}

	// deptno로 검색
	@GetMapping(value = "/dept/{deptno}")
	public DeptDTO getDeptByDeptno(@PathVariable Long deptno) {
		System.out.println(deptno);
		return deptService.getDeptByDeptno(deptno);
	}

	// Dept 추가
	@PostMapping(value = "/dept", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public List<DeptDTO> insertDept(@ModelAttribute DeptDTO dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
		return deptService.getDeptAll();
	}

	// deptno로 수정
	@PutMapping(value = "/dept/{deptno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public List<DeptDTO> updateDeptByDeptno(@PathVariable Long deptno, @RequestBody DeptDTO deptDTO) {
		System.out.println(deptno);
//		dept.setDeptno(deptno);
		deptService.updateDeptByDeptno(deptno, deptDTO);
		return deptService.getDeptAll();
	}

	// deptno로 삭제
	@DeleteMapping(value = "/dept/{deptno}")
	public List<DeptDTO> deleteDepByDeptno(@PathVariable Long deptno) {
		deptService.deleteDeptByDeptno(deptno);
		return deptService.getDeptAll();
	}

}
