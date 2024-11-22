package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;


//회원정보
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
        String query = "INSERT INTO member (ID, PASSWORD, EMAIL, NAME, PHONE_NUMBER, HIRE_DATE) VALUES (?, ?, ?, ?, ?, ?)"; // SQL 쿼리문 정의, 수정된 부분
        try {
            psmt = con.prepareStatement(query); // PreparedStatement 객체 생성
            psmt.setString(1, id); // 첫 번째 매개변수에 id 설정
            psmt.setString(2, pw); // 두 번째 매개변수에 pw 설정
            rs = psmt.executeQuery(); // 쿼리 실행 및 결과 반환
            if(rs.next()) { // 결과가 존재하면
                dto.setId(rs.getString("ID")); // ID 설정
                dto.setPw(rs.getString("PASSWORD")); // 비밀번호 설정
                dto.setEmail(rs.getString("EMAIL")); // 이메일 설정
                dto.setName(rs.getString("NAME")); // 이름 설정
                dto.setPnum(rs.getInt("PHONE_NUMBER")); // 전화번호 설정
                dto.setHdate(rs.getDate("HIRE_DATE")); // 가입일 설정


                System.out.println("DAO ~ DTO Connect - 70line success"); //디버깅용 출력문
            }
        }

        //오류 출력
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL error - MemberDAO - login");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("General error - MemberDAO - login");
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
    
    public MemberDTO login(String id, String pw) {
        MemberDTO dto = null; // MemberDTO 객체를 null로 초기화
        String query = "SELECT ID, PASSWORD, EMAIL, NAME, PHONE_NUMBER, HIRE_DATE FROM member WHERE id=? AND PASSWORD=?"; // SQL 쿼리문 정의
        try (PreparedStatement psmt = con.prepareStatement(query)) { // try-with-resources를 사용하여 PreparedStatement 객체 생성
            psmt.setString(1, id); // 첫 번째 매개변수에 id 설정
            psmt.setString(2, pw); // 두 번째 매개변수에 pw 설정
            try (ResultSet rs = psmt.executeQuery()) { // try-with-resources를 사용하여 ResultSet 객체 생성
                if (rs.next()) { // 결과가 존재하면
                    dto = new MemberDTO(); // 새로운 MemberDTO 객체 생성
                    dto.setId(rs.getString("ID")); // ID 설정
                    dto.setPw(rs.getString("PASSWORD")); // 비밀번호 설정
                    dto.setEmail(rs.getString("EMAIL")); // 이메일 설정
                    dto.setName(rs.getString("NAME")); // 이름 설정
                    dto.setPnum(rs.getInt("PHONE_NUMBER")); // 전화번호 설정
                    dto.setHdate(rs.getDate("HIRE_DATE")); // 가입일 설정
                }
            }
        } catch (Exception e) { // 예외 처리
            e.printStackTrace(); // 스택 트레이스 출력
            System.out.println("error - MemberDAO - login line91"); // 에러 메시지 출력
        }
        return dto; // MemberDTO 객체 반환
    }
    /*
     * member테이블 열
     * 
    /*
    ID , PASSWORD, EMAIL, NAME, PHONE_NUMBER, HIRE_DATE
     
     * 
     */
   
    public int join(MemberDTO dto) {
        int result = 0; // 결과를 저장할 변수를 0으로 초기화
        String query = "INSERT INTO member (ID, PASSWORD, EMAIL, NAME, PHONE_NUMBER, HIRE_DATE) VALUES (?, ?, ?, ?, ?, ?)"; // SQL 쿼리문 정의, 수정된 부분
        try (PreparedStatement psmt = con.prepareStatement(query)) { // try-with-resources를 사용하여 PreparedStatement 객체 생성
            psmt.setString(1, dto.getId()); // 첫 번째 매개변수에 ID 설정
           
            psmt.setString(2, dto.getPw()); // 두 번째 매개변수에 비밀번호 설정
            psmt.setString(3, dto.getEmail()); // 세 번째 매개변수에 이메일 설정
            psmt.setString(4, dto.getName()); // 네 번째 매개변수에 이름 설정
            psmt.setInt(5, dto.getPnum()); // 다섯 번째 매개변수에 전화번호 설정
            psmt.setDate(6, dto.getHdate()); // 여섯 번째 매개변수에 가입일 설정
            result = psmt.executeUpdate(); // 쿼리 실행 및 결과 반환



            System.out.println("=======================회원가입값====================/////");
            System.out.println("dto.id    "+dto.getId());
            System.out.println("dto.pw    "+dto.getPw());
            System.out.println("dto.email    "+dto.getEmail());
            System.out.println("dto.name    "+dto.getName());
            System.out.println("dto.pnum    "+dto.getPnum());
            System.out.println("dto.hdate    "+dto.getHdate());
            System.out.println("===============================================/////");


        } catch (Exception e) { // 예외 처리
            e.printStackTrace(); // 스택 트레이스 출력
            System.out.println("error - MemberDAO - join line110"); // 에러 메시지 출력
        }
        return result; // 결과 반환
    }

    public boolean isIdExist(String id) {
        boolean result = false;
        String query = "SELECT COUNT(*) FROM member WHERE ID=?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, id);
            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error - MemberDAO - isIdExist");
        }
        return result;
    }


  //수정용
    public int update(MemberDTO dto) {
        int result = 0; // 결과를 저장할 변수를 0으로 초기화
        String query = "UPDATE MEMBER SET PASSWORD=?, EMAIL=?, NAME=?, PHONE_NUMBER=? WHERE ID=?";
         // SQL 쿼리문 정의, 수정된 부분
        try (PreparedStatement psmt = con.prepareStatement(query)) { // try-with-resources를 사용하여 PreparedStatement 객체 생성
            psmt.setString(1, dto.getPw()); // 1 번째 매개변수에 비밀번호 설정
            psmt.setString(2, dto.getEmail()); // 2 번째 매개변수에 이메일 설정
            psmt.setString(3, dto.getName()); // 3 번째 매개변수에 이름 설정
            psmt.setInt(4, dto.getPnum()); // 4 번째 매개변수에 전화번호 설정
            psmt.setString(5, dto.getId()); // 5 번째 매개변수에 ID 설정
           // 여섯 번째 매개변수에 가입일 설정
           result = psmt.executeUpdate(); // 쿼리 실행 및 결과 반환




           
           System.out.println("update line 167");
            System.out.println("====================dao update method====================/////");
           System.out.println("dto.id     "+dto.getId());
            System.out.println("dto.pw     "+dto.getPw());
            System.out.println("dto.email     "+dto.getEmail());
            System.out.println("dto.name     "+dto.getName());
            System.out.println("dto.pnum     "+dto.getPnum());
            
            System.out.println("===============================================/////");
            System.out.println("dao.update success");
        } catch (Exception e) { // 예외 처리
            e.printStackTrace(); // 스택 트레이스 출력
            System.out.println("error - MemberDAO - update line174"); // 에러 메시지 출력
        }
        return result; // 결과 반환
    }
 
}