<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionView1.jsp</title>
</head>
<body>
	<h2> sessionView1.jsp </h2>
	
	<div>id : ${sessionScope.id} </div>
	<div>age : ${sessionScope.age} </div>
	<div>job : ${sessionScope.job}</div>
	
	<hr>
	<h3>삭제 요청</h3>
	<a href="session/jobDelete.do">job 삭제</a> <br/>
	<a href="session/sessionDelete.do">id, age 삭제</a> <br/>
	<a href="index.jsp">index.jsp 돌아가기</a>
</body>
</html>