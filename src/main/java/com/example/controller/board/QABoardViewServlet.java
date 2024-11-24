package com.example.controller.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

@WebServlet("/views/qa_board_view.do")
public class QABoardViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String postIdStr = req.getParameter("postId"); // post_id에서 이름 수정.(파라미터값 받기)
        if (postIdStr == null || postIdStr.isEmpty()) {//http400 뜸 (웹상에서 출력)
            // post_id가 null이거나 비어있는 경우 예외 처리'
            System.out.println(postIdStr+"     postidstr");
            System.out.println("post_id is null or empty");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid post_id");
            return;
        }

        try {
            int postId = Integer.parseInt(postIdStr);

            // 게시물 정보 로드
            QABoardDAO dao = new QABoardDAO(getServletContext());
            QABoardDTO qaBoardView = dao.getQABoardView(postId);

            // 댓글 목록 로드
            CommentDAO commentDAO = new CommentDAO(getServletContext());
            List<CommentDTO> commentList = new ArrayList<>();
            try {
                commentList = commentDAO.getCommentsByPostId(postId);
            } catch (SQLException e) {
                throw new ServletException(e);
            }

            req.setAttribute("qaBoardView", qaBoardView);
            req.setAttribute("commentList", commentList);
            req.getRequestDispatcher("/views/qa_board_view.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            // post_id가 숫자가 아닌 경우 예외 처리
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid post_id format");
        }
    }
}