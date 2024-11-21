package com.example.controller.board;

import java.io.IOException;
import java.sql.Date;

import com.example.model.board.FreeBoardDAO;
import com.example.model.board.FreeBoardDTO;
import com.example.utils.JSFunction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/views/free_board_update.do")
public class FreeBoardUpdateServlet extends HttpServlet{
    
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // TODO Auto-generated method stub
       
      HttpSession session = req.getSession();
        
		//작성자 아이디와 동일해야지만 수정 가능.
		String userId = (String) session.getAttribute("UserId");
		String authorId = req.getParameter("id");
		if (userId == null || !userId.equals(authorId)) {
			
			JSFunction.alertLocation(resp, "작성자 본인만 수정이 가능합니다.", "../views/free_board.do");
			return;
		}
		
		
		

		
		String id = req.getParameter("id");
		String title = req.getParameter("title"); // 클라이언트로부터 title 데이터를 가져옵니다.
        String content = req.getParameter("content"); // 클라이언트로부터 content 데이터를 가져옵니다.
		long currentTimeMillis = System.currentTimeMillis(); // timeStampe를 가져옴
		Date post_date = new Date(currentTimeMillis); //post_date에 timstamp를 date타입으로 변환하여 저장
		/*timstamp는 밀리초 단위까지 저장,하지만 date 자료형에 넣으면 밀리초는 삭제됌. */





		FreeBoardDTO dto = new FreeBoardDTO();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPost_date(post_date); // 현재 날짜 설정
        dto.setVisit_count(0); // 기본값 설정
        dto.setLike_count(0); // 기본값 설정
        dto.setUpdated_at(null); // 수정일은 초기값 NULL

		FreeBoardDAO dao = new FreeBoardDAO(getServletContext()); // FreeBoardDAO 객체를 생성합니다.
        int result = dao.freeBoardWrite(dto); // 회원가입 처리를 수행하고 결과를 반환받습니다.

        if (result > 0) {
			JSFunction.alertLocation(resp, "글이 성공적으로 수정되었습니다.", "../views/free_board.do");
            System.out.println("FreeBoardWriteServlet   write success");
        } else {
			JSFunction.alertBack(resp, "글 수정에 실패했습니다. 다시 시도해주세요.");
            System.out.println("FreeBoardWriteServlet   write false");
        }


	}
   }
    

