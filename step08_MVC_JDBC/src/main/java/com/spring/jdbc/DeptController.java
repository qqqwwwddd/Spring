package com.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.service.DeptServiceImpl;

@Controller
public class DeptController {

	@Autowired
	private DeptServiceImpl deptService;

//	@RequestMapping(value = "dept.do", method = RequestMethod.GET)
	@RequestMapping("dept.do")
	public String dept(Model model) {

		System.out.println(deptService.getDeptMap(10).get("dname"));
		System.out.println(deptService.getDeptByDeptno(10));
		System.out.println(deptService.getDeptNameByDeptno(10));
		System.out.println(deptService.getAllDepts());
		System.out.println(deptService.getAllDeptsMap());

		// insert
//		deptService.insertDept(new Dept(50, "PROGRAMMING", "SEOUL"));

		// update : where deptno = 50 and dname = "PROGRAMMING" -> loc : "MOON"
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("deptno", 50);
//		data.put("dname", "PROGRAMMING");
//		data.put("loc", "MOON");

//		deptService.updateDeptByDeptnoAndDname(data);

		// delete : where loc = "MOON"
//		deptService.deleteDeptByLoc("MOON");

		// 검색
		model.addAttribute("deptno", deptService.getDeptByDeptno(10));
		return "forward:home.jsp";
	}

	// SEARCH.JSP //

	@RequestMapping("deptsearch.do")
	public String dept(Model model, @RequestParam int deptno) {

		System.out.println(deptService.getDeptMap(10).get("dname"));
		System.out.println(deptService.getDeptByDeptno(deptno));
		System.out.println(deptService.getDeptNameByDeptno(deptno));
		System.out.println(deptService.getAllDepts());
		System.out.println(deptService.getAllDeptsMap());

		// 검색
		model.addAttribute("deptno", deptService.getDeptByDeptno(deptno));
		return "forward:search.jsp";
	}
}
