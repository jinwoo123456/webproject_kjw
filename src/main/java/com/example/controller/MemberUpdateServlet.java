package com.example.controller;

import java.io.IOException;

import com.example.model.MemberDAO;
import com.example.model.MemberDTO;
import com.example.utils.JSFunction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;





@WebServlet("/views/memberUpdate.do")// 회원정보 수정 서블릿
public class MemberUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 요청의 인코딩을 UTF-8로 설정합니다.
        
        
        String id = req.getParameter("id");
        String pw = req.getParameter("pw"); // 클라이언트로부터 pw 데이터를 가져옵니다.
        String email = req.getParameter("email"); // 클라이언트로부터 email 데이터를 가져옵니다.
        String name = req.getParameter("name"); // 클라이언트로부터 name 데이터를 가져옵니다.
        int pnum = Integer.parseInt(req.getParameter("pnum")); // 클라이언트로부터 pnum 데이터를 가져와서 정수로 변환합니다.



        MemberDTO dto = new MemberDTO(); // MemberDTO 객체를 생성합니다.
        dto.setId(id); // MemberDTO 객체에 id 데이터를 설정합니다.
        dto.setPw(pw); // MemberDTO 객체에 pw 데이터를 설정합니다.
        dto.setEmail(email); // MemberDTO 객체에 email 데이터를 설정합니다.
        dto.setName(name); // MemberDTO 객체에 name 데이터를 설정합니다.
        dto.setPnum(pnum); // MemberDTO 객체에 pnum 데이터를 설정합니다.

        System.out.println("=================MemberUpdateServlet dto=======================");
        System.out.println("pw    "+dto.getPw());
        System.out.println("email    "+dto.getEmail());
        System.out.println("name    "+dto.getName());
        System.out.println("pnume   "+dto.getPnum());
        System.out.println("=================MemberUpdateServlet dto=======================");

        MemberDAO dao = new MemberDAO(getServletContext()); // MemberDAO 객체를 생성합니다.
        int result = dao.update(dto); // 정보수정 처리를 수행하고 결과를 반환받습니다.
        dao.close(); // 데이터베이스 연결을 종료합니다.
        if (result > 0) {
            
            JSFunction.alertLocation(resp, "정보 수정이 완료 되었습니다.", "file_board.jsp"); // 수정 성공 시 경고창을 띄운 후 파일 보드 페이지로 리다이렉트
            System.out.println("MemberUpdateServlet update success");
        } else {
            req.setAttribute("errorMessage", "Update error, please try again."); // 정보수정  실패 시 에러 메시지를 설정합니다.
            req.getRequestDispatcher("file_board.jsp").forward(req, resp); // 정보수정  페이지로 포워드합니다.
            JSFunction.alertLocation(resp, "Update error, please try again.", "file_board.jsp");
            System.out.println("MemberUpdateServlet update fail");
        }
    }
}