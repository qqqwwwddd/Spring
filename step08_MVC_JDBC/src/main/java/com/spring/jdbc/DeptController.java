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
	public String dept(Model model, @RequestParam int deptno) {
		System.out.println(deptService.getDeptByDeptno(deptno));
		model.addAttribute("deptno", deptService.getDeptByDeptno(deptno));
		return "forward:home.jsp";
	}
}
