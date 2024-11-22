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
            <a href="boardList.jsp" class="button-link">목록으로 돌아가기</a>
            
            <!-- 수정하기 -->
            <c:if test="${sessionScope.id == qaBoardView.id}">
            <a href="qa_board_view_update.jsp?post_id=${qaBoardView.post_id}&id=${qaBoardView.id}&content=${qaBoardView.content}&title=${qaBoardView.title}" class="button-link">수정하기</a>
            </c:if>
            
        </div>
    </div>
<!-- 댓글 창 -->
<div class="comment-section">
    <h3>댓글</h3>
    <form action="comment_write.do" method="post">
        <input type="hidden" name="post_id" value="${qaBoardView.post_id}">
        <textarea name="comment" rows="4" style="width: 100%;" placeholder="댓글을 입력하세요..."></textarea>
        <button type="submit" class="button-link" style="margin-top: 10px;">댓글 달기</button>
    </form>
    
    <!-- 댓글 리스트 -->
    <div class="comment-list">
        <c:forEach var="comment" items="${commentList}">
            <div class="comment-item" style="border-top: 1px solid #ddd; padding: 10px 0;">
                <div class="comment-meta" style="font-size: 14px; color: #777;">
                    작성자: ${comment.id} | 작성일: ${comment.post_date}
                </div>
                <div class="comment-content" style="font-size: 16px; color: #555; margin-top: 5px;">
                    ${comment.content}
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="comment-section">
    <h3>댓글</h3>
    <form action="addComment.jsp" method="post">
        <input type="hidden" name="post_id" value="${qaBoardView.post_id}">
        <textarea name="comment" rows="4" style="width: 100%;" placeholder="댓글을 입력하세요..."></textarea>
        <button type="submit" class="button-link" style="margin-top: 10px;">댓글 달기</button>
    </form>
    
    <!-- 댓글 리스트 -->
    <div class="comment-list">
        <c:forEach var="comment" items="${commentList}">
            <div class="comment-item" style="border-top: 1px solid #ddd; padding: 10px 0;">
                <div class="comment-meta" style="font-size: 14px; color: #777;">
                    작성자: ${comment.id} | 작성일: ${comment.post_date}
                </div>
                <div class="comment-content" style="font-size: 16px; color: #555; margin-top: 5px;">
                    ${comment.content}
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
