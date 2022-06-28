package com.spring.aop;

// 로그인 할때 사용하는 클래스
public class User {
	public String login(String user) throws Exception {
		String name = null;

		if ("test".equals(user) || "admin".equals(user)) {
			name = user;
		} else {
			throw new Exception("아이디를 확인 해 주세요");
		}

		return name;
	}

}
