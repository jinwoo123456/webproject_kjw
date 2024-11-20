package com.example.model.board;

import java.sql.SQLException;

import com.example.model.JDBConnect;

import jakarta.servlet.ServletContext;

public class FreeBoardDAO extends JDBConnect{

    
        public FreeBoardDAO(String drv, String url, String id, String pw) {
            super(drv, url, id, pw); //super()를 통해 부모클래스의 생성자를 호출한다.
            
        }
      
        public FreeBoardDAO(ServletContext application) {
            super(application); // 부모 클래스의 생성자를 호출하여 데이터베이스 연결을 초기화한다.
        }
        


        //게시물 정보 가져오는 메서드
        public FreeBoardDTO getFreeBoardDTO(int postId) {
            FreeBoardDTO dto = new FreeBoardDTO();
            String query = "SELECT * FROM FREE_BOARD WHERE POST_ID = ?"; // SQL 쿼리문 정의, 수정된 부분
            try {
                psmt = con.prepareStatement(query); // PreparedStatement 객체 생성
                psmt.setInt(1, postId); // 첫 번째 매개변수에 postId 설정
                rs = psmt.executeQuery(); // 쿼리 실행 및 결과 반환
                if(rs.next()) { // 결과가 존재하면
                    dto.setPost_id(rs.getInt("POST_ID")); // 게시글 번호 설정
                    dto.setTitle(rs.getString("TITLE")); // 제목 설정
                    dto.setContent(rs.getString("CONTENT")); // 내용 설정
                    dto.setId(rs.getString("ID")); // 작성자 설정
                    dto.setPost_date(rs.getDate("POST_DATE")); // 작성일 설정
                    dto.setVisit_count(rs.getInt("VISIT_COUNT")); // 조회수 설정
                    dto.setLike_count(rs.getInt("LIKE_COUNT")); // 좋아요 수 설정
                    dto.setUpdated_at(rs.getDate("UPDATED_AT")); // 수정일 설정
                    System.out.println("freeboarddao - getFreeBoardDTO - 70line success");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL error - FreeBoardDAO - getFreeBoardDTO");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("General error - FreeBoardDAO - getFreeBoardDTO");
            }
            return dto; // FreeBoardDTO 객체 반환
        }





    // 조회수 증가 메서드
    public void updateVisitCount(int postId) {
        String query = "UPDATE FREE_BOARD SET VISIT_COUNT = VISIT_COUNT + 1 WHERE POST_ID = ?"; // SQL 쿼리문 정의, 수정된 부분
        try {
            psmt = con.prepareStatement(query);
            psmt.setInt(1, postId);
            psmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("게시물 조회수 증가 중 예외 발생");
            e.printStackTrace();
        }
    }




    //글쓰는 메서드
    public int freeBoardWrite(FreeBoardDTO dto) {
        int result = 0;
        try {
            String query = "INSERT INTO FREE_BOARD( "
                         + " POST_ID, TITLE, CONTENT, ID, POST_DATE, VISIT_COUNT, LIKE_COUNT, UPDATED_AT )"
                         + " VALUES ( "
                         + " SEQ_FREE_BOARD_NUM.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
             
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getContent());
            psmt.setString(3, dto.getId());
            psmt.setDate(4, dto.getPost_date());
            psmt.setInt(5, dto.getVisit_count());
            psmt.setInt(6, dto.getLike_count());
            psmt.setDate(7, dto.getUpdated_at());

            result = psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("게시물 입력 중 예외 발생");
            e.printStackTrace();
        }
        return result;
    }
}
