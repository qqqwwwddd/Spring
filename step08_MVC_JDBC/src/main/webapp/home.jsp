<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="UTF-8"/>
<title>Home</title>
</head>
<body>
	<h1>부서 정보 검색</h1>

	<form action="dept.do">
	<input type="text" name="deptno" placeholder="부서 번호를 입력하세요"/>
	<input type="submit" value="검색"/>
	<br>
	</form>
	${requestScope.deptno}

</body>
</html>
