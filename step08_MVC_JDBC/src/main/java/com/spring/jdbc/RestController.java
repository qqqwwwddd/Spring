package com.spring.jdbc;

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

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@org.springframework.web.bind.annotation.RestController
// @Controller + @ResponseBody
@CrossOrigin(origins = { "http://localhost:3000" })
public class RestController {

	@Autowired
	private DeptServiceImpl deptService;

//	@GetMapping(value = "/api/test")
//	public String apiTest() {
//		return "test2";
//	}

//	// 추가하기
//	@PostMapping(value = "/api/dept")
//	public void insertDept(Dept dept) {
//		System.out.println(dept);
//		deptService.insertDept(dept);
//
//	}

//	// json 타입으로 전달해서 매핑
//	@PostMapping(value = "/api/deptjson", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void insertDeptJSON(@RequestBody Dept dept) {
//		System.out.println(dept);
//		deptService.insertDept(dept);
//	}
	// jackson 라이브러리 추가 !

	// 모든 출력
	@GetMapping(value = "/api/depts")
	public List<Dept> getAllDepts() {
		return deptService.getAllDepts();
	}

	// deptno로 검색
	@GetMapping(value = "/api/dept/{deptno}")
	public Dept getDeptByDeptno(@PathVariable int deptno) {
		deptService.getDeptByDeptno(deptno);
		return deptService.getDeptByDeptno(deptno);
	}

	// deptForm
	@PostMapping(value = "/api/dept", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public List<Dept> insertDeptForm(@ModelAttribute Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
		return deptService.getAllDepts();
	}

	// updateDept
	@PutMapping(value = "/api/dept/{deptno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Dept> updateDeptForm(@RequestBody Dept dept) {
		System.out.println(dept);
		deptService.updateDeptByDeptno(dept);
		return deptService.getAllDepts();
	}

	// deleteDept
	@DeleteMapping(value = "/api/dept/{deptno}")
	public List<Dept> deleteDept(@PathVariable int deptno) {
		deptService.deleteDeptByDeptno(deptno);
		return deptService.getAllDepts();
	}

	// react연동
	@GetMapping(value = "/api/no-proxy")
	public String noProxy() {
		System.out.println("/no-proxy");
		return "no-proxy";
	}

	@GetMapping(value = "/api/proxy")
	public String Proxy() {
		System.out.println("/proxy");
		return "proxy";
	}

//	@CrossOrigin(origins = { "http://localhost:3000" })
	@GetMapping(value = "/api/no-cors")
	public String noCors() {
		System.out.println("/no-cors");
		return "no-cors";
	}

	@CrossOrigin(origins = { "http://localhost:3000" })
	@GetMapping(value = "/api/cors")
	public String cors() {
		System.out.println("/cors");
		return "api/cors";
	}

}
