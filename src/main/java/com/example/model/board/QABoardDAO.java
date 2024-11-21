package com.example.model.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.JDBConnect;

import jakarta.servlet.ServletContext;


//자유게시판
public class QABoardDAO extends JDBConnect{

        // 데이터베이스 연결 설정을 상속
        public QABoardDAO(String drv, String url, String id, String pw) { 
            super(drv, url, id, pw); //super()를 통해 부모클래스의 생성자를 호출한다.
            
        }
        //ServletContext 객체를 매개변수로 받는 생성자
        public QABoardDAO(ServletContext application) {
            super(application); // 부모 클래스의 생성자를 호출하여 데이터베이스 연결을 초기화한다.
        }
        


        //게시물 정보 가져오는 메서드
        public QABoardDTO getQABoardDTO(int postId) {
            QABoardDTO dto = new QABoardDTO();
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
                    System.out.println("qaboarddao - getQABoardDTO - 70line success");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL error - QABoardDAO - getQABoardDTO");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("General error - QABoardDAO - getQABoardDTO");
            }
            return dto; // QABoardDTO 객체 반환
        }





    // 조회수 증가 메서드
    public void updateVisitCount(int postId) {
        String query = "UPDATE FREE_BOARD SET VISIT_COUNT = VISIT_COUNT + 1 WHERE POST_ID = ?"; // SQL 쿼리문 정의
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
    public int qaBoardWrite(QABoardDTO dto) {
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

    
   
     // 게시글 목록을 가져오는 메서드
     public List<QABoardDTO> getQABoardList() {
        List<QABoardDTO> boardList = new ArrayList<>();
        /* 열 목록
         * POST_ID,   TITLE, CONTENT, ID,  POST_DATE, VISIT_COUNT, LIKE_COUNT, UPDATED_AT //
         * 게시물순서 , 제목 , 내용 ,  아디,   작성일 ,    조회수 ,      좋아요수 , 수정일
         */
        String query = "SELECT * FROM FREE_BOARD ORDER BY POST_ID DESC"; // SQL 쿼리문 정의
        try {
            psmt = con.prepareStatement(query); // PreparedStatement 객체 생성
            rs = psmt.executeQuery(); // 쿼리 실행 및 결과 반환
            while (rs.next()) { // 결과가 존재하면
                QABoardDTO dto = new QABoardDTO();
                dto.setPost_id(rs.getInt("POST_ID")); // 게시글 번호 설정
                dto.setTitle(rs.getString("TITLE")); // 제목 설정
                dto.setContent(rs.getString("CONTENT")); // 내용 설정
                dto.setId(rs.getString("ID")); // 작성자 설정
                dto.setPost_date(rs.getDate("POST_DATE")); // 작성일 설정
                dto.setVisit_count(rs.getInt("VISIT_COUNT")); // 조회수 설정
                dto.setLike_count(rs.getInt("LIKE_COUNT")); // 좋아요 수 설정
                dto.setUpdated_at(rs.getDate("UPDATED_AT")); // 수정일 설정
                boardList.add(dto); // 리스트에 추가

                
              
            }
            //디버깅
            System.out.println("==============QABoardDAO - getQABoardList - 140line================");
            System.out.println("게시글 번호: " + rs.getInt("POST_ID"));
            System.out.println("제목: " + rs.getString("TITLE"));
            System.out.println("내용: " + rs.getString("CONTENT"));
            System.out.println("작성자: " + rs.getString("ID"));
            System.out.println("작성일: " + rs.getDate("POST_DATE"));
            System.out.println("조회수: " + rs.getInt("VISIT_COUNT"));
            System.out.println("좋아요 수: " + rs.getInt("LIKE_COUNT"));
            System.out.println("수정일: " + rs.getDate("UPDATED_AT"));
            System.out.println("=======================================================================");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL error - QABoardDAO - getQABoardList");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("General error - QABoardDAO - getQABoardList");
        }
        return boardList; // 게시글 목록 반환
    }


    //http://localhost:8980/WebProject_KJW/views/qa_board_view.do?postId=22
    //게시물 상세페이지 메서드
    public QABoardDTO getQABoardView(int postId) {
        QABoardDTO dto = new QABoardDTO();
        String query = "SELECT * FROM FREE_BOARD WHERE POST_ID = ?"; // SQL 쿼리문 정의
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
                System.out.println("qaboarddao - getQABoardView - 70line success");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL error - QABoardDAO - getQABoardView");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("General error - QABoardDAO - getQABoardView");
        }
        return dto; // QABoardDTO 객체 반환
    }       
//String query = "UPDATE FREE_BOARD SET TITLE = ?, CONTENT = ?, UPDATED_AT = ? WHERE POST_ID = ?";
    //게시물 수정 메서드
    public int qaBoardUpdate(QABoardDTO dto) {
        int result = 0;
        try {
            String query = "UPDATE FREE_BOARD SET TITLE = ?, CONTENT = ?, UPDATED_AT = ? WHERE POST_ID = ?";
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getContent());
            psmt.setDate(3, dto.getUpdated_at());
            psmt.setInt(4, dto.getPost_id());

            result = psmt.executeUpdate();

            System.out.println("qaboarddao - qaBoardUpdate - 70line success");
            System.out.println("=====================dao - qaBoardUpdate - 70line=====================");
            System.out.println("제목: " + dto.getTitle());
            System.out.println("내용: " + dto.getContent());
            System.out.println("수정일: " + dto.getUpdated_at());
            System.out.println("게시글 번호: " + dto.getPost_id());
            System.out.println("=======================================================================");
        } catch (Exception e) {
            System.out.println("게시물 업데이트 중 예외 발생");
            e.printStackTrace();
        }
        return result;
    }
}
