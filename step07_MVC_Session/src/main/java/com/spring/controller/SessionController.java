package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.domain.Customer;

@Controller
//@RequestMapping("session")
@SessionAttributes({ "id", "age", "job", "customer" })
public class SessionController {

	// Cookie
	@RequestMapping("/cookieTest.do")
	public String cookieTest(@CookieValue String id) {
		System.out.println("Cookie : " + id);
		return "redirect:/cookieView.jsp";
	}

	// Session
	@GetMapping("session/sessionTest1.do")
	public String sessionTest1(HttpSession session) {
//		System.out.println(session.getAttribute("id"));
		session.setAttribute("job", "programmer");
		return "redirect:/sessionView1.jsp";
	}

	// job 세션 데이터 삭제
	@GetMapping("session/jobDelete.do")
	public String jobDelete(@ModelAttribute("job") String job, SessionStatus status) {
//		System.out.println("jobDlete.do : " + job);
		// 세션 무효화
		status.setComplete();
		return "redirect:/sessionView1.jsp";
	}

	// 세션 자체를 삭제
	@GetMapping("session/sessionDelete.do")
	public String sessionDelete(@ModelAttribute("id") String id, SessionStatus status) {
		status.setComplete();
		return "redirect:/sessionView1.jsp";
	}

	// 두번째 페이지 만들어서리턴
	@GetMapping("session/sessionTest2.do")
	public String sessinTest2DTO(Model model, Customer customer) {
		System.out.println(customer);
		model.addAttribute("customer", customer);
		return "redirect:/sessionView2.jsp";
	}

	// job 세션 데이터 삭제
	@GetMapping("customerDelete.do")
	public String sessionCustomerDelete(SessionStatus status) {
		// 세션 무효화
		status.setComplete();
		return "redirect:/sessionView2.jsp";
	}

	@GetMapping("session/loginForm.do")
	public String moveLoginForm() {
		return "loginForm";
	}

	@PostMapping("session/login.do")
//	@RequestMapping(value = "session/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("password") String pwd, HttpSession session) {
		// 조건 : pw가 1234 일때, admin 인정
		// 만약 아니라면, index.jsp 로 화면 전환
		System.out.println(pwd);
		if (pwd.equals("1234")) {
			session.setAttribute("pwd", pwd);

			return "redirect:/index.jsp";
		}

		return "loginForm";
	}

	@RequestMapping("session/logout.do")
	public String logout(HttpSession session) {

		// index.jsp의 로그아웃 버튼 클릭시
		// 해당 세션은 해제 후 -> index.jsp로 화면전환
		session.removeAttribute("pwd");
		return "redirect:/index.jsp";
	}
}
