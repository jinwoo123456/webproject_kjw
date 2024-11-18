<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 확인 완료</title>
</head>
<body>
<h1>로그인 성공</h1>
<p>환영합니다, <%= session.getAttribute("UserName") %>님!</p>
    <%-- <a href="logout.do">로그아웃</a> --%>
</body>
</html>
