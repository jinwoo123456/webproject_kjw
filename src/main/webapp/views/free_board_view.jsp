<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${freeBoardView.title}</title>
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
            ${freeBoardView.title}
        </h2>
        
        <!-- 게시물 작성자 및 날짜 -->
        <div class="detail-meta">
            작성자: ${freeBoardView.id} | 작성일: ${freeBoardView.post_date}
        </div>
        
        <!-- 게시물 내용 -->
        <div class="detail-content">
            ${freeBoardView.content}
        </div>
        
        <!-- 버튼 그룹 -->
        <div class="button-group">
            <!-- 목록으로 돌아가기 -->
            <a href="boardList.jsp" class="button-link">목록으로 돌아가기</a>
            
            <!-- 수정하기 -->
            <a href="free_board_view_update.jsp?title=${freeBoardView.title}&id=${freeBoardView.id}&content=${freeBoardView.content}&post_date=${freeBoardView.post_date}" class="button-link">수정하기</a>
        </div>
    </div>
</body>
</html>
