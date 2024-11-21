<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.model.JDBConnect"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
   <h2>JDBC 테스트 1</h2>
	<%
	/* 기본생성자를 통한 인스턴스 생성 */
	JDBConnect jdbc1 = new JDBConnect();
	/* DB연결 해제 */
	jdbc1.close();
	%>
	<h2>JDBC 테스트 2</h2>
	<%
	/* web.xml에 설정한 컨텍스트 초기화 파라미터를 application 내장객체를 통해 읽어온다. */
	String driver = application.getInitParameter("OracleDriver");
	String url = application.getInitParameter("OracleURL");
	String id = application.getInitParameter("OracleId");
	String pwd = application.getInitParameter("OraclePwd");
	/* 매개변수 4개로 구성된 인자생성자를 통해 인스턴스를 생성한다. */
	JDBConnect jdbc2 = new JDBConnect(driver, url, id, pwd);
	jdbc2.close();
	%>
	<h3>JDBC 테스트 3	</h3>
	<%
	/*
	Java클래스에 정의된 생성자에서 내장객체를 사용하기 위해서는 반드시 JSP에서
	내장객체를 매개변수로 전달해야 한다.
	*/
	JDBConnect jdbc3 = new JDBConnect(application);
	jdbc3.close();
	%>
</body>
</html>