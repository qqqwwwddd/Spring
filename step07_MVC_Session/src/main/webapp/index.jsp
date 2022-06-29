<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	Cookie cookie1 = new Cookie("id", "test");
	cookie1.setMaxAge(60 * 60);
	response.addCookie(cookie1);
	
	// Customer : String id, int age
/* 	session.setAttribute("id", "spring-session");
	session.setAttribute("age", 29); */
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h2>index.jsp</h2>
	
	<h3>Cookie API Test</h3>
	<a href="cookieTest.do">cookieTest.do</a>
	
	<hr>
	<h3>Session API Test</h3>
	<a href="session/sessionTest1.do">1. session/sessionTest1.do</a> <br/>
	
	<a href="session/sessionTest2.do?id=spring&age=29">
	 2. session/sessionTest2.do : DTO 객체를 세션에 저장</a>
	
	<hr>
	<h3>로그인 하러 가기</h3>
	<a href="session/loginForm.do">로그인 하러 가기</a>
	
	<c:if test="${sessionScope.pwd != null}">
	<a href="session/logout.do">로그아웃</a>
	</c:if>
	
</body>
</html>