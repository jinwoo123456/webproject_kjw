# webproject-kjw

KDT 빅데이터 융합&인공지능 과정 JSP 게시판 만들기 개인 프로젝트



# Db 정보

테이블명 : member
설명 : 회원가입한 회원들의 정보

<!-- # 회원의 id정보 -->

id VARCHAR2(20) PRIMARY_KEY

<!-- password정보  -->

password VARCHAR2(30) 회원의

<!-- email 정보 -->

email VARCHAR2(25) 회원의

<!-- 회원의 이름 -->

name VARCHAR2(25) NOT NULL

<!-- 회원의 전화번호(휴대폰) -->

phone_number NUMBER(20)

<!-- 회원의 가입일 -->

hire_date DATE NOT NULL

<!-- =========================================== -->

테이블명 : free_board
설명 : 게시판의 정보를 저장

<!-- 게시판이 만들어진 순서 -->

POST_ID NUMBER PRIMARY KEY

<!-- 게시판 제목 -->

TITLE VARCHAR2(200) NOT NULL

<!-- 게시판 내용 -->

CONTENT VARCHAR2(5000) NOT NULL

<!-- 작성자의 ID -->

ID VARCHAR2(20)

<!-- SYSDATE	게시판이 만들어진 날짜 -->

POST_DATE DATE NOT NULL

<!-- 게시판 방문횟수 -->

VISIT_COUNT NUMBER 0

<!-- 게시판 좋아요 수 -->

LIKE_COUNT NUMBER 0

<!-- 게시판 수정된 날짜 -->

UPDATED_AT DATE
