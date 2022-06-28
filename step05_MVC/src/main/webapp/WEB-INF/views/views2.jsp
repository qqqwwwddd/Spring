<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view2.jsp</title>
</head>
<body>
	<h2>view2</h2>
	
	<br><hr>
	1. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.msg} <br/>
	2. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.name} <br/>
	3. ${requestScope.name} - ${requestScope.age}
</body>
</html>
