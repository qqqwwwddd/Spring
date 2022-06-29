package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.domain.Customer;

@Controller
public class APIController {

	// id, age 로 파라미터 전송하는 web query 데이터 처리

	@RequestMapping("getData1.do")
	public ModelAndView getOne(@RequestParam("id") String id, @RequestParam("age") int age) {
		System.out.println(id + " " + age);
		ModelAndView model = new ModelAndView();
		//
		model.setViewName("view2");
		return model;

	}

	// Model API
	// - Model 클래스는 getParmeter로 추출 할 수 없는 데이터를 request 객체에 저장 하고자 할때 사용 가능
	// model.addAttribute() = request.setAttribute()

	// http://localhost:8080/mvc/getData2.do?id=busan&age=29
	@RequestMapping("getData2.do")
	public String getTwo(Model model, Customer customer) {
		System.out.println(customer);
		model.addAttribute("msg", "치킨");
//		model.addAttribute("id", customer.getName());
//		model.addAttribute("age", customer.getAge());

		model.addAttribute("customer", customer);
		return "view2";

	}

	// Customer customer = new Customer("busan", 29)
	//

	// http://localhost:8080/mvc/getData3.do?name=busan&age=29
	@GetMapping(value = "getData3.do")
	public String getThree(@ModelAttribute("customer") Customer customer) {
		return "view2";
	}

	// 예외처리 확인을 위한 test 메소드
	@GetMapping(value = "getData4.do")
	public String getFour() throws Exception {
		if (true) {
			throw new Exception("URL Exception");

		}
		return null;
	}

	@ExceptionHandler
	public String exceptionHandling(Exception e) {
		return "redirect:failView.jsp?msg=" + e.getMessage();
	}
	// 따로 메소드를 뺀 이유 : 다른데서도 쓰려고
	// redirect / forward 를 하지 않으면 servlet-context.xml 로 찾아 가지만
	// redirect / forward 하면 webapp 으로 감

}
