package com.example.controller.board;

import com.example.utils.JSFunction;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet("/views/free_board_update.do")
public class IsUpdateServlet extends HttpServlet {
      HttpSession session = req.getSession();
        
		//작성자 아이디와 동일해야지만 수정 가능.
		String userId = (String) session.getAttribute("UserId");
		String authorId = req.getParameter("id");
		if (userId == null || !userId.equals(authorId)) {
			
			JSFunction.alertLocation(resp, "작성자 본인만 수정이 가능합니다.", "../views/free_board.do");
			return;
		}
		
    
}