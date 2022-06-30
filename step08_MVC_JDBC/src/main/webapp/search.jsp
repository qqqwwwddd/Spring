<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>		
<h1>DEPT 검색하기</h1>

	<form action="deptsearch.do">
            <input
                type="text"
                name="deptno"
                placeholder="부서 번호를 입력하세요"
            />
            <input type="submit" value="검색" />
            <br />
        </form>
        ${requestScope.deptno}
</body>
</html>