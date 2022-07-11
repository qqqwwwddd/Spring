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

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Emp;
import com.example.service.EmpServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
@RestController
public class EmpRestController {

	@Autowired
	EmpServiceImpl empService;

	// 모든 emp
//	@GetMapping(value = "/emps")
//	public List<EmpDTO> getEmps() {
//		return empService.getEmpAll();
//	}
	// 페이징
	@GetMapping(value = "/emps")
	public PageResultDTO<EmpDTO, Emp> getEmps(PageRequestDTO pageDTO) {
		System.out.println(pageDTO);
		System.out.println("=================");
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(pageDTO.getPage()).size(5).build();
		PageResultDTO<EmpDTO, Emp> pageResultDTO = empService.getList(pageRequestDTO);
		return pageResultDTO;
	}

	// 사원번호로 emp 검색
	@GetMapping(value = "/emp/{empno}")
	public EmpDTO getEmpByEmpno(@PathVariable Long empno) {
		System.out.println(empno);
		return empService.getEmpByEmpno(empno);
	}

	// emp 추가
	@PostMapping(value = "/emp", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public List<EmpDTO> insertEmp(@ModelAttribute EmpDTO empDTO) {
		System.out.println(empDTO);
		empService.insertEmp(empDTO);
		return empService.getEmpAll();

	}

	// emp 수정
	@PutMapping(value = "/emp/{empno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<EmpDTO> updateEmpByEmpno(@PathVariable("empno") Long empno, @RequestBody EmpDTO empDTO) {
		System.out.println(empDTO);
		empDTO.setEmpno(empno);
		empService.updateEmpByEmpno(empDTO);
		return empService.getEmpAll();
	}

	// emp 삭제
	@DeleteMapping(value = "/emp/{empno}")
	public List<EmpDTO> deleteEmpByEmpno(@PathVariable Long empno) {
		empService.deleteEmpByEmpno(empno);
		return empService.getEmpAll();
	}

}
