package com.example.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/views/logout.do")
public class LogoutServlet extends HttpServlet{



    /**
     * HTTP GET 요청을 처리하는 메서드로, 부모 클래스의 doGet() 메서드를 호출한다.
     * 이 메서드는 일반적으로 요청을 부모 클래스에 위임하기 전에 필요한 전처리를 수행하는 데 사용된다.
     *
     * @param req  클라이언트가 서블릿에 보낸 요청을 포함하는 HttpServletRequest 객체
     * @param resp 서블릿이 클라이언트에게 보내는 응답을 포함하는 HttpServletResponse 객체
     * @throws ServletException GET 요청을 처리할 수 없는 경우 발생
     * @throws IOException      서블릿이 GET 요청을 처리할 때 입력 또는 출력 오류가 감지된 경우 발생
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       // 세션 무효화
       req.getSession().invalidate();
       // 로그인 페이지로 리다이렉트
       resp.sendRedirect("file_board.jsp");
    }
}
