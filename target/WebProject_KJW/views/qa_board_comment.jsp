<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${qaBoardView.title}</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .detail-title {
            font-size: 24px;
            margin: 20px 0;
            color: #007BFF;
        }
        .detail-meta {
            font-size: 14px;
            color: #777;
            margin-bottom: 20px;
        }
        .detail-content {
            font-size: 16px;
            color: #555;
            line-height: 1.6;
        }
        .button-group {
            margin-top: 20px;
            display: flex;
            gap: 10px;
        }
        .button-link {
            display: inline-block;
            padding: 10px 15px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            text-align: center;
        }
        .button-link:hover {
            background-color: #0056b3;
        }
        .comment-form {
            margin-top: 30px;
        }
        .comment-list {
            margin-top: 20px;
        }
        .comment-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
        .comment-item p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>게시물 상세보기</h1>
        
        <!-- 게시물 제목 -->
        <h2 class="detail-title">
            ${qaBoardView.title}
        </h2>
        
        <!-- 게시물 작성자 및 날짜 -->
        <div class="detail-meta">
            작성자: ${qaBoardView.id} | 작성일: ${qaBoardView.post_date}
        </div>
        
        <!-- 게시물 내용 -->
        <div class="detail-content">
            ${qaBoardView.content}
        </div>
        
        <!-- 버튼 그룹 -->
        <div class="button-group">
            <!-- 목록으로 돌아가기 -->
            <a href="qa_board.do" class="button-link">목록으로 돌아가기</a>
            
            <!-- 수정하기 -->
            <c:if test="${sessionScope.id == qaBoardView.id}">
            <a href="qa_board_view_update.jsp?post_id=${qaBoardView.post_id}&id=${qaBoardView.id}&content=${qaBoardView.content}&title=${qaBoardView.title}" class="button-link">수정하기</a>
            </c:if>
            
        </div>
    </div>
 <!-- 댓글 입력 폼 -->
<div class="comment-form">
    <h3>댓글 작성</h3>
    <form action="writeComment.do" method="post">
        <input type="hidden" name="post_id" value="${qaBoardView.post_id}">
        <textarea name="content" rows="4" cols="50" required></textarea>
        <br>
        <button type="submit">댓글 작성</button>
    </form>
</div>
<!-- 댓글 목록 -->
<div class="comment-list">
    <h3>댓글 목록</h3>
    <c:forEach var="comment" items="${commentList}">
        <div class="comment-item">
            <p><strong>${comment.userId}</strong> (${comment.postDate})</p>
            <p>${comment.content}</p>
        </div>
    </c:forEach>
</div>
</div>
</body>
</html>