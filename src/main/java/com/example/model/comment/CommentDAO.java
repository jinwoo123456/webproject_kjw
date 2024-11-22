package com.example.model.comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.JDBConnect;

import jakarta.servlet.ServletContext;

public class CommentDAO extends JDBConnect {
    
   // 데이터베이스 연결 설정을 상속
        public CommentDAO(String drv, String url, String id, String pw) { 
            super(drv, url, id, pw); //super()를 통해 부모클래스의 생성자를 호출한다.
            
        }
        //ServletContext 객체를 매개변수로 받는 생성자
        public CommentDAO(ServletContext application) {
            super(application); // 부모 클래스의 생성자를 호출하여 데이터베이스 연결을 초기화한다.
        }
        

        //게시물 정보 가져오는 메서드
        public CommentDTO getCommentDTO(int postId) {
            /*      private int post_id; // 게시물 ID
                    private String content; // 댓글 내용
                    private String id; // 작성자 ID
                    private Date post_date; // 댓글 작성일
                    private int like_count; // 좋아요 수
                    private Date updated_at; // 댓글 수정일

                */
            CommentDTO dto = new CommentDTO();
            String query = "SELECT * FROM COMMENT WHERE POST_ID = ?"; // SQL 쿼리문 정의,
            try {
                psmt = con.prepareStatement(query); // PreparedStatement 객체 생성
                psmt.setInt(1, postId); // 첫 번째 매개변수에 postId 설정
                rs = psmt.executeQuery(); // 쿼리 실행 및 결과 반환
                if(rs.next()) { // 결과가 존재하면
                    dto.setPost_id(rs.getInt("POST_ID")); // 댓글 번호
                
                    dto.setContent(rs.getString("CONTENT")); // 댓글내용 설정
                    dto.setId(rs.getString("ID")); // 작성자 id
                    dto.setPost_date(rs.getDate("POST_DATE")); // 댓글 작성일 설정
                    
                    dto.setLike_count(rs.getInt("LIKE_COUNT")); // 댓글 좋아요 수 설정
                    dto.setUpdated_at(rs.getDate("UPDATED_AT")); // 댓글 수정일 설정
                    System.out.println("commentdao - getCommentDTO - 70line success");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL error - CommentDAO - getCommentDTO");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("General error - CommentDAO - getCommentDTO");
            }
            return dto; // CommentDTO 객체 반환
        }

    //댓글 목록을 가져오는 메서드
    public List<CommentDTO> getCommentList(int postId,int qaPostId) {
        
        List<CommentDTO> list = new ArrayList<CommentDTO>();
        String query = "SELECT * FROM COMMENTS WHERE POST_ID = ? AND POST_ID IN (SELECT POST_ID FROM QA_BOARD WHERE POST_ID = ?)"; // SQL 쿼리문 정의
        try {
            psmt = con.prepareStatement(query); // PreparedStatement 객체 생성
            psmt.setInt(1, postId); // 첫 번째 매개변수에 postId 설정
            psmt.setInt(2, qaPostId); // 두 번째 매개변수에 postId 설정
            rs = psmt.executeQuery(); // 쿼리 실행 및 결과 반환
            while(rs.next()) { // 결과가 존재하면
                CommentDTO dto = new CommentDTO(); // CommentDTO 객체 생성
                dto.setPost_id(rs.getInt("POST_ID")); // 댓글 번호 설정
                dto.setContent(rs.getString("CONTENT")); // 댓글 내용 설정
                dto.setId(rs.getString("ID")); // 작성자 ID 설정
                dto.setPost_date(rs.getDate("POST_DATE")); // 댓글 작성일 설정
                dto.setLike_count(rs.getInt("LIKE_COUNT")); // 댓글 좋아요 수 설정
                dto.setUpdated_at(rs.getDate("UPDATED_AT")); // 댓글 수정일 설정
                list.add(dto); // 리스트에 CommentDTO 객체 추가
            }
            //디버깅

        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL error - CommentDAO - getCommentList");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("General error - CommentDAO - getCommentList");
        }
        return list; // CommentDTO 객체 리스트 반환
    }
    public CommentDTO getCommentView(int postId) {
        CommentDTO dto = new CommentDTO();
        String query = "SELECT * FROM COMMENTS WHERE POST_ID = ?"; // SQL 쿼리문 정의
        try {
            psmt = con.prepareStatement(query); // PreparedStatement 객체 생성
            psmt.setInt(1, postId); // 첫 번째 매개변수에 postId 설정
            rs = psmt.executeQuery(); // 쿼리 실행 및 결과 반환
            if(rs.next()) { // 결과가 존재하면
                dto.setPost_id(rs.getInt("POST_ID")); // 댓글 번호 설정
                dto.setContent(rs.getString("CONTENT")); // 댓글 내용 설정
                dto.setId(rs.getString("ID")); // 작성자 ID 설정
                dto.setPost_date(rs.getDate("POST_DATE")); // 댓글 작성일 설정
                dto.setLike_count(rs.getInt("LIKE_COUNT")); // 댓글 좋아요 수 설정
                dto.setUpdated_at(rs.getDate("UPDATED_AT")); // 댓글 수정일 설정
                System.out.println("Commentdao - getCommentView - 70line success");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL error - CommentDAO - getCommentView");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("General error - CommentDAO - getCommentView");
        }
        return dto; // CommentDTO 객체 반환
    }     

    //댓글 작성 메서드
    public boolean writeComment(CommentDTO dto) {
        String query = "INSERT INTO COMMENTS VALUES(?, ?, ?, SYSDATE, 0, NULL)"; // SQL 쿼리문 정의
        try {
            psmt = con.prepareStatement(query); // PreparedStatement 객체 생성
            psmt.setInt(1, dto.getPost_id()); // 첫 번째 매개변수에 post_id 설정
            psmt.setString(2, dto.getContent()); // 두 번째 매개변수에 content 설정
            psmt.setString(3, dto.getId()); // 세 번째 매개변수에 id 설정
            int result = psmt.executeUpdate(); // 쿼리 실행 및 결과 반환
            if(result > 0) { // 결과가 존재하면
                System.out.println("CommentDAO - writeComment - 70line success");
                return true; // true 반환
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL error - CommentDAO - writeComment");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("General error - CommentDAO - writeComment");
        }
        return false; // false 반환
    }
}