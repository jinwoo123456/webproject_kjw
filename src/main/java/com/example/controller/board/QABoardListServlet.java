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

@WebServlet("/views/qa_board.do")
public class QABoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QABoardDAO dao = new QABoardDAO(getServletContext());
        List<QABoardDTO> qaBoardList = dao.getQABoardList();

        // 디버깅
        System.out.println("============QABoardListViewServlet 게시물 목록 가져오기 확인.line32========");
        System.out.println("QABoardListViewServlet qaBoardList.size() : " + qaBoardList.size());

        // 게시글 목록을 request 객체에 저장
        req.setAttribute("qaBoardList", qaBoardList);

        // 게시글 목록을 출력할 JSP 페이지로 포워드
        req.getRequestDispatcher("/views/qa_board.jsp").forward(req, resp);
    }
}