package com.example.controller.comment;

import java.io.IOException;
import java.sql.SQLException;

import com.example.model.comment.CommentDAO;
import com.example.model.comment.CommentDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/views/writeComment.do")
public class WriteCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("UserId");
        if (userId == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int postId = Integer.parseInt(req.getParameter("post_id"));
        String content = req.getParameter("content");

        CommentDTO comment = new CommentDTO();
        comment.setPostId(postId);
        comment.setUserId(userId);
        comment.setContent(content);

        CommentDAO commentDAO = new CommentDAO(getServletContext());
        try {
            commentDAO.writeComment(comment.getPostId(), comment.getUserId(), comment.getContent());
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        // 댓글 작성 후 QABoardCommentServlet으로 리다이렉트
        resp.sendRedirect("qa_board_comment.do?post_id=" + postId);
    }
}