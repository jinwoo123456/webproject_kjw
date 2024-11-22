package com.example.controller.comment;

import java.io.IOException;

import com.example.model.comment.CommentDAO;
import com.example.model.comment.CommentDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/views/comment_write.do")
public class CommentWriteServlet extends HttpServlet{

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String content = request.getParameter("content");
    String userId = (String) request.getSession().getAttribute("UserId");
    int postId = Integer.parseInt(request.getParameter("postId"));

    CommentDTO comment = new CommentDTO();
    comment.setContent(content);
    comment.setId(userId);
    comment.setPost_id(postId);

    CommentDAO dao = new CommentDAO(getServletContext());
    boolean result = dao.writeComment(comment);

    if (result) {
        response.sendRedirect("free_board_view.do?postId=" + postId);
    } else {
        response.sendRedirect("error.jsp");
    }
}


}
