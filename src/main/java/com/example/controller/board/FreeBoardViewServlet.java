package com.example.controller.board;

import java.io.IOException;

import com.example.model.board.FreeBoardDAO;
import com.example.model.board.FreeBoardDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



//자유게시판 보여주기(DB에서 데이터를 가져와서 보여준다.)

@WebServlet("/views/free_board_view.do") // 서블릿 매핑 추가
public class FreeBoardViewServlet extends HttpServlet {

     
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //

    FreeBoardDAO dao = new FreeBoardDAO(getServletContext());
    /* "http://localhost:8980/WebProject_KJW/views/free_board_view.do?postId=22"
     * 이 주소값에서 postId=22 << 22부분 가져오기*/
    String postIdQueryString = req.getParameter("postId");
    String postIdStr = postIdQueryString.substring(postIdQueryString.indexOf("=") + 1);
    int postId = Integer.parseInt(postIdStr);
    System.out.println("Post ID int = : " + postId);

    /**
     * FreeBoardDAO 객체를 사용하여 게시물의 세부 정보를 가져온다.
     * post_id를 사용하여 게시물의 세부 정보를 가져온다.
     */
    FreeBoardDTO freeBoardView = dao.getFreeBoardView(postId);


    //게시물 데이터를 요청 속성에 추가
    req.setAttribute("freeBoardView", freeBoardView);

    //JSP 페이지로 포워드
    req.getRequestDispatcher("/views/free_board_view.jsp").forward(req, resp);

}

    
}

