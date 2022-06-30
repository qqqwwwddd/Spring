package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@org.springframework.web.bind.annotation.RestController
// @Controller + @ResponseBody
public class RestController {

	@Autowired
	private DeptServiceImpl deptService;

	@GetMapping(value = "/api/test")
	public String apiTest() {
		return "test2";
	}

	// 추가하기
	@PostMapping(value = "/api/dept")
	public void insertDept(Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);

	}

	// jackson 라이브러리 추가 !
	@GetMapping(value = "/api/depts")
	public List<Dept> getAllDepts() {
		return deptService.getAllDepts();
	}

	// json 타입으로 전달해서 매핑
	@PostMapping(value = "/api/deptjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDeptJSON(@RequestBody Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
	}

	// deptForm
	@PostMapping(value = "/api/deptform", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void insertDeptForm(@ModelAttribute Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
	}

}
