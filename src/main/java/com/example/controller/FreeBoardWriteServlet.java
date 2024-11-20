package com.example.controller;

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


@WebServlet("/views/free_board_write.do")
public class FreeBoardWriteServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if(session.getAttribute("UserId")==null) {
			JSFunction.alertLocation(resp, "로그인 후 이용해주세요", "../views/free_board.jsp");
			return;
		}
		/*  글쓴 날짜,시간을 가져옴.timeStamp타입이지만 Date타입으로 변환함.
		(밀리초 단위는 자동으로 삭제).*/
		
		
		String id = req.getParameter("id");
		String title = req.getParameter("title"); // 클라이언트로부터 title 데이터를 가져옵니다.
        String content = req.getParameter("content"); // 클라이언트로부터 content 데이터를 가져옵니다.
		long currentTimeMillis = System.currentTimeMillis(); // timeStampe를 가져옴
		Date post_date = new Date(currentTimeMillis); //posta date에 timstamp를 date타입으로 변환하여 저장

		



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
			JSFunction.alertLocation(resp, "글이 성공적으로 작성되었습니다.", "../views/free_board.jsp");
            System.out.println("FreeBoardWriteServlet   write success");
        } else {
			JSFunction.alertBack(resp, "글 작성에 실패했습니다. 다시 시도해주세요.");
            System.out.println("FreeBoardWriteServlet   write false");
        }


	}
	
	

}


