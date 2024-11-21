package com.example.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import com.example.model.MemberDAO;
import com.example.model.MemberDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/views/join.do") //회원가입 서블릿
public class JoinServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 요청의 인코딩을 UTF-8로 설정합니다.
        LocalDate localDate = LocalDate.now();// 현재 날짜 가져오기
        
        String id = req.getParameter("id"); // 클라이언트로부터 id 데이터를 가져옵니다.
        String pw = req.getParameter("pw"); // 클라이언트로부터 pw 데이터를 가져옵니다.
        String email = req.getParameter("email"); // 클라이언트로부터 email 데이터를 가져옵니다.
        String name = req.getParameter("name"); // 클라이언트로부터 name 데이터를 가져옵니다.
        int pnum = Integer.parseInt(req.getParameter("pnum")); // 클라이언트로부터 pnum 데이터를 가져와서 정수로 변환합니다.
        Date hdate = Date.valueOf(localDate); // LocalDate를 java.sql.Date로 변환



        MemberDTO dto = new MemberDTO(); // MemberDTO 객체를 생성합니다.
        dto.setId(id); // MemberDTO 객체에 id 데이터를 설정합니다.
        dto.setPw(pw); // MemberDTO 객체에 pw 데이터를 설정합니다.
        dto.setEmail(email); // MemberDTO 객체에 email 데이터를 설정합니다.
        dto.setName(name); // MemberDTO 객체에 name 데이터를 설정합니다.
        dto.setPnum(pnum); // MemberDTO 객체에 pnum 데이터를 설정합니다.
        dto.setHdate(hdate); // MemberDTO 객체에 hdate 데이터를 설정합니다. 

        MemberDAO dao = new MemberDAO(getServletContext()); // MemberDAO 객체를 생성합니다.
        int result = dao.join(dto); // 회원가입 처리를 수행하고 결과를 반환받습니다.

        if (result > 0) {
            resp.sendRedirect("login.jsp"); // 회원가입 성공 시 로그인 페이지로 리다이렉트합니다.
            System.out.println("joinservlet 회원가입 성공");
        } else {
            req.setAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요."); // 회원가입 실패 시 에러 메시지를 설정합니다.
            req.getRequestDispatcher("join.jsp").forward(req, resp); // 회원가입 페이지로 포워드합니다.
            System.out.println("joinservlet 회원가입 실패");
        }
    }
}
