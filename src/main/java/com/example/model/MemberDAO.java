package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

public class MemberDAO extends JDBConnect {//JDBC를 위한 클래스를 상속하여 DB에 연결한다.
    //생성자1 : 드라이버, 커넥션URL 등 4개의 매개변수로 정의
    public MemberDAO(String drv, String url, String id, String pw) {
        super(drv, url, id, pw); //super()를 통해 부모클래스의 생성자를 호출한다.
        
    }
     //생성자2 : application 내장객체를 매개변수로 정의 
     /*
      * 
      이 생성자는 서블릿의 ServletContext 객체를 이용하여 데이터베이스 연결 정보를 전달받고,
       이를 부모 클래스 JDBConnect의 생성자로 넘기는 역할을 합니다. 즉,
       이 생성자를 호출하면 ServletContext에 저장된 설정 정보로 데이터베이스 연결이 이루어집니다.
      */
     public MemberDAO(ServletContext application) {
        super(application);
    }
    
  
    /**
     * 주어진 ID와 비밀번호를 사용하여 데이터베이스에서 회원 정보를 조회합니다.
     *
     * @param id 조회할 회원의 ID
     * @param pw 조회할 회원의 비밀번호
     * @return 조회된 회원 정보를 담고 있는 MemberDTO 객체
     * @throws SQLException 데이터베이스 접근 오류가 발생한 경우
     * @throws NullPointerException 데이터베이스 연결 객체가 null인 경우
     */
    /**
     * Retrieves a MemberDTO object containing member information from the database.
     *
     * @param id The member's ID.
     * @param pw The member's password.
     * @return A MemberDTO object populated with the member's information if found, otherwise an empty MemberDTO object.
     */
    /**
     * Retrieves a MemberDTO object from the database based on the provided id and password.
     *
     * @param id The ID of the member to retrieve.
     * @param pw The password of the member to retrieve.
     * @return A MemberDTO object containing the member's details if found, otherwise an empty MemberDTO object.
     */


    /*
    DTO 종류-
            * private String id;
            private String pw;
            private String email;
            private String name;
            private int pnum;
            private String hdate;
     */
    public MemberDTO getMemberDTO(String id, String pw,String email,String name,int pnum,String hdate) {
        MemberDTO dto = new MemberDTO();
        try {
            String query = "SELECT id, pw, email, name, pnum, hdate FROM member WHERE id=? AND pw=?"; // SQL 쿼리문 정의
            psmt = con.prepareStatement(query); // PreparedStatement 객체 생성
            psmt.setString(1, id); // 첫 번째 매개변수에 id 설정
            psmt.setString(2, pw); // 두 번째 매개변수에 pw 설정
            rs = psmt.executeQuery(); // 쿼리 실행 및 결과 반환
            if(rs.next()) { // 결과가 존재하면
                dto.setId(rs.getString(1)); // ID 설정
                dto.setPw(rs.getString(2)); // 비밀번호 설정
                dto.setEmail(rs.getString(3)); // 이메일 설정
                dto.setName(rs.getString(4)); // 이름 설정
                dto.setPnum(rs.getInt(5)); // 전화번호 설정
                dto.setHdate(rs.getString(6)); // 가입일 설정
                System.out.println("DAO ~ DTO Connect - 70line success");
            }
        }
        catch (Exception e) { // 예외 처리
            e.printStackTrace(); // 스택 트레이스 출력]
            System.out.println("DAO - 75line error");
        }
        return dto; // MemberDTO 객체 반환
    }
      /**
     * 주어진 ID와 비밀번호를 사용하여 데이터베이스에서 회원 정보를 조회합니다.
     *
     * @param id 조회할 회원의 ID
     * @param pw 조회할 회원의 비밀번호
     * @return 조회된 회원 정보를 담고 있는 MemberDTO 객체
     */
    /**
     * Authenticates a user by their ID and password.
     *
     * @param id the user's ID
     * @param pw the user's password
     * @return a MemberDTO object containing the user's details if authentication is successful, null otherwise
     * @throws SQLException if a database access error occurs
     * @throws NullPointerException if the connection object is null
     */
    public MemberDTO login(String id, String pw) {
        MemberDTO dto = null; // MemberDTO 객체를 null로 초기화
        String query = "SELECT id, pw, email, name, pnum, hdate FROM member WHERE id=? AND pw=?"; // SQL 쿼리문 정의
        try (PreparedStatement psmt = con.prepareStatement(query)) { // try-with-resources를 사용하여 PreparedStatement 객체 생성
            psmt.setString(1, id); // 첫 번째 매개변수에 id 설정
            psmt.setString(2, pw); // 두 번째 매개변수에 pw 설정
            try (ResultSet rs = psmt.executeQuery()) { // try-with-resources를 사용하여 ResultSet 객체 생성
                if (rs.next()) { // 결과가 존재하면
                    dto = new MemberDTO(); // 새로운 MemberDTO 객체 생성
                    dto.setId(rs.getString("id")); // ID 설정
                    dto.setPw(rs.getString("pw")); // 비밀번호 설정
                    dto.setEmail(rs.getString("email")); // 이메일 설정
                    dto.setName(rs.getString("name")); // 이름 설정
                    dto.setPnum(rs.getInt("pnum")); // 전화번호 설정
                    dto.setHdate(rs.getString("hdate")); // 가입일 설정
                }
            }
        } catch (Exception e) { // 예외 처리
            e.printStackTrace(); // 스택 트레이스 출력
            System.out.println("error - MemberDAO - login line91"); // 에러 메시지 출력
        }
        return dto; // MemberDTO 객체 반환
    }
 
}