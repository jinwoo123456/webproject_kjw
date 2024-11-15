<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.example.model.DataSourceConfig
javax.sql.DataSource java.sql.Connection" %>

<html>
  <head>
    <title>데이터베이스 연결 테스트</title>
  </head>
  <body>
    <h2>데이터베이스 연결 테스트</h2>
    <% try { DataSource dataSource = DataSourceConfig.getDataSource(); try
    (Connection conn = dataSource.getConnection()) { if (conn != null &&
    !conn.isClosed()) { out.println("
    <p>데이터베이스에 성공적으로 연결되었습니다.</p>
    "); } else { out.println("
    <p>데이터베이스 연결에 실패했습니다.</p>
    "); } } } catch (Exception e) { e.printStackTrace(out); out.println("
    <p>데이터베이스 연결 중 오류 발생: " + e.getMessage() + "</p>
    "); } %>
  </body>
</html>
