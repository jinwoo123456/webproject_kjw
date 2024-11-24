package com.example.controller.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.example.model.board.QABoardDAO;
import com.example.model.board.QABoardDTO;
import com.example.model.comment.CommentDAO;
import com.example.model.comment.CommentDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/views/qa_board_comment.do")
public class QABoardCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("post_id"));

        // 게시물 정보 로드
        QABoardDAO qaBoardDAO = new QABoardDAO(getServletContext());
        QABoardDTO qaBoardView = qaBoardDAO.getQABoardView(postId);

        // 댓글 목록 로드
        CommentDAO commentDAO = new CommentDAO(getServletContext());
        List<CommentDTO> commentList = null;
        try {
            commentList = commentDAO.getCommentsByPostId(postId);
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        req.setAttribute("qaBoardView", qaBoardView);
        req.setAttribute("commentList", commentList);

        req.getRequestDispatcher("/views/qa_board_comment.jsp").forward(req, resp);
    }
}