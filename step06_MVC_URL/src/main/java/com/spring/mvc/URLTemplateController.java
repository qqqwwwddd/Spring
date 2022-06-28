package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class URLTemplateController {

	// http://localhost:8080/mvc/urlTest.do/1
	@GetMapping(value = "urlTest.do/{id}")
	public String urlTest1(@PathVariable String id) { // int -> String
		System.out.println("value - " + id);
		return "forward:/view.jsp";
	}

	// Model API 활용하기
	// http://localhost:8080/mvc/urlTest.do/1/home/27 -> id/age -> view.jsp
	@GetMapping(value = "urlTest.do/{id}/home/{age}")
	public String urlTest2(@PathVariable String id, @PathVariable String age, Model model) {
		model.addAttribute("value - " + id);
		model.addAttribute("value - " + age);
		String forward = "forward:/view.jsp";

		return forward;

	}
}
