package com.example.controller.board;

import java.io.IOException;
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



//자유게시판 보여주기(DB에서 데이터를 가져와서 보여준다.)

@WebServlet("/views/qa_board_view.do") // 서블릿 매핑 추가
public class QABoardViewServlet extends HttpServlet {

     
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    

    QABoardDAO dao = new QABoardDAO(getServletContext());
    
    //댓글작업
    CommentDAO cdao = new CommentDAO(getServletContext());



    /* "http://localhost:8980/WebProject_KJW/views/free_board_view.do?postId=22"
     * 이 주소값에서 postId=22 << 22부분 가져오기*/
    // postId 쿼리 문자열을 가져온다.
    String postIdQueryString = req.getParameter("postId");
    
    // postId 쿼리 문자열에서 '=' 다음 부분을 추출한다.
    String postIdStr = postIdQueryString.substring(postIdQueryString.indexOf("=") + 1);
    
    // 추출한 문자열을 정수로 변환한다.
    int postId = Integer.parseInt(postIdStr);
    
    // 변환된 postId를 출력한다.
    System.out.println("Post ID int = : " + postId);

    /**
     * QABoardDAO 객체를 사용하여 게시물의 세부 정보를 가져온다.
     * post_id를 사용하여 게시물의 세부 정보를 가져온다.
     */

    QABoardDTO qaBoardView = dao.getQABoardView(postId);
    //게시물 상세정보 밑에 있을 댓글 리스트
    List<CommentDTO> commentList = cdao.getCommentList(postId);

    
   //CommentDTO commentview = dao.getCommentDTO(postId);


    //게시물 데이터를 요청 속성에 추가
    req.setAttribute("freeBoardView", qaBoardView);
    //댓글 데이터 요청속성에 추가
    req.setAttribute("commentList", commentList);

    //JSP 페이지로 포워드
    req.getRequestDispatcher("/views/qa_board_view.jsp").forward(req, resp);

}

    
}

