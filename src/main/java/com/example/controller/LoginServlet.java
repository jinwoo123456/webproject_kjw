package com.example.controller;

import java.io.IOException;

import com.example.model.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("views/login.do")
public class LoginServlet extends HttpServlet {
    
    
    /**
     * 사용자의 로그인 요청을 처리합니다.
     *
     * @param req  클라이언트가 서블릿에 요청한 내용을 포함하는 HttpServletRequest 객체
     * @param resp 서블릿이 클라이언트에게 보내는 응답을 포함하는 HttpServletResponse 객체
     * @throws ServletException POST 요청을 처리할 수 없는 경우 발생
     * @throws IOException      서블릿이 POST 요청을 처리할 때 입력 또는 출력 오류가 감지된 경우 발생
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 서블릿 컨텍스트를 사용하여 MemberDAO 인스턴스를 생성합니다.
         * MemberDAO 객체는 회원 데이터베이스와 상호 작용하는 데 사용됩니다.
         */
        MemberDAO dao = new MemberDAO(getServletContext());
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        


       
        
        
        



        
    }
}


/*
 * <%@ page import="com.example.model.MemberDAO,com.example.model.MemberDTO"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 요청에서 'id'와 'pw' 매개변수를 가져옵니다.
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

    // 애플리케이션 컨텍스트에서 데이터베이스 연결 매개변수를 가져옵니다.
    String orcDrv = application.getInitParameter("OracleDriver");
    String orcUrl = application.getInitParameter("OracleURL");
    String orcUser = application.getInitParameter("OracleId");
    String orcPw = application.getInitParameter("OraclePwd");

    // 데이터베이스 연결 매개변수로 새로운 MemberDAO 객체를 생성합니다.
    MemberDAO dao = new MemberDAO(orcDrv, orcUrl, orcUser, orcPw);
    // 제공된 'id'와 'pw'로 로그인 시도를 합니다.
    MemberDTO dto = dao.getMemberDTO(id, pw);
    // 데이터베이스 리소스를 해제하기 위해 DAO를 닫습니다.
    dao.close();
//${pageContext.request.contextPath}/loginProcess.jsp
    // 로그인 결과에 따라 적절한 페이지로 리다이렉트합니다.
    if (dto != null) { // 로그인 성공 시
        session.setAttribute("UserId", dto.getId()); // 세션에 사용자 ID 저장
        session.setAttribute("UserName", dto.getName()); // 세션에 사용자 이름 저장
        response.sendRedirect("login.jsp"); // 로그인 성공 후 login.jsp로 리다이렉트
    <%-- 
        이 블록은 로그인 실패 시나리오를 처리합니다.
        로그인 자격 증명(ID 또는 비밀번호)이 일치하지 않으면 
        "아이디 또는 비밀번호가 일치하지 않습니다."라는 메시지와 함께 
        오류 메시지 속성 "LoginErrmsg"를 설정합니다.
        그런 다음, 요청과 응답을 "login.jsp"로 전달하여 오류 메시지를 표시합니다.
    --%>
    } else {
        // 실패 시
        request.setAttribute("LoginErrmsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인프로세스     스?</h2>
</body>
</html>

 * 
 */