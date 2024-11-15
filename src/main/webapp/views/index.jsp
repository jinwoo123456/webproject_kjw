<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ page
import="com.example.utils.Test" %>
<!--응답의 Content-Type을 UTF-8로 명시-->

<html>
  <body>
    <h2>Hello World!</h2>
    <h2><% Test test = new Test(); out.println(test.getMessage()); %></h2>
  </body>
</html>
