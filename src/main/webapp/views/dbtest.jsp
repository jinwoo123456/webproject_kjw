<%@page import="common.DBConnPool"%> <%@ page import="common.JDBConnect" %> <%@
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>

<html>
  <head>
    <title>JDBC</title>
  </head>
  <body>
    <h2>JDBC 테스트 1</h2>
    <% JDBConnect jdbc1 = new JDBConnect(); jdbc1.close(); %>
    <h2>JDBC 테스트 2</h2>
    <% String driver = application.getInitParameter("OraclaDriver"); String url
    = application.getInitParameter("OracleURL"); String id =
    application.getInitParameter("OracleId"); String pwd =
    application.getInitParameter("OraclePwd"); JDBConnect jdbc2 = new
    JDBConnect(driver, url, id, pwd); jdbc2.close(); %>
    <h2>JDBC 테스트 3</h2>
    <% /* Java클래스에 정의된 생성자에서 내장객체를 사용하기 위해서는 반드시
    JSP에서 내장객체를 매개변수로 전달해야한다. */ JDBConnect jdbc3 = new
    JDBConnect(); jdbc3.close(); %>
    <h2>커넥션 풀 테스트</h2>
    <% DBConnPool pool = new DBConnPool(); pool.close(); %>
  </body>
</html>
