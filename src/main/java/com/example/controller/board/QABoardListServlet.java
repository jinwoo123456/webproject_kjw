package com.example.controller.board;

import java.io.IOException;
import java.util.List;

import com.example.model.board.QABoardDAO;
import com.example.model.board.QABoardDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//자유게시판 보여주기(DB에서 데이터를 가져와서 보여준다.)
@WebServlet("/views/qa_board.do") // 서블릿 매핑 추가
public class QABoardListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //debugging
        System.out.println("QABoardListViewServlet doGet() 호출");

        // QABoardDAO 객체 생성 (아래 생성자를 멤버변수로 설정)
        QABoardDAO dao = new QABoardDAO(getServletContext());
        
        // 게시글 목록 가져오기
        List<QABoardDTO> freeBoardList = dao.getQABoardList();

        //debuging
        System.out.println("============QABoardListViewServlet 게시물 목록 가져오기 확인.line32========");
        System.out.println("QABoardListViewServlet   freeBoardList.size() : " + freeBoardList.size());

        // 게시글 목록을 request 객체에 저장
        req.setAttribute("freeBoardList", freeBoardList);

        // 게시글 목록을 출력할 JSP 페이지로 포워드
        req.getRequestDispatcher("/views/free_board.jsp").forward(req, resp);
    }
}