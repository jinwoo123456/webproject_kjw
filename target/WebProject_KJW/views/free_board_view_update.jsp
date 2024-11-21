<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 수정</title>
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
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        label {
            font-size: 14px;
            color: #555;
        }
        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            resize: none;
            height: 200px;
        }
        .button-group {
            display: flex;
            justify-content: flex-end;
            gap: 10px;
        }
        .button {
            padding: 10px 15px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .cancel-button {
            background-color: #6c757d;
        }
        .cancel-button:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>게시물 수정</h1>
        
        <form onsubmit="return validateForm(this);" action="free_board_update.do" method="post">
            <!-- 게시물 제목 -->
            <label for="title">제목</label>
            <input type="text" id="title" name="title" value="${param.title}" required>
            
            <!-- 작성자 (읽기 전용) -->
            <label for="id">작성자</label>
            <input type="text" id="id" name="id" value="${param.id}" style=" background-color: rgba(0, 0, 0, 0.1);" readonly>
            
            <!-- 게시물 내용 -->
            <label for="content">내용</label>
            <textarea id="content" name="content" required>${param.content}</textarea>
            
            <!-- 버튼 그룹 -->
            <div class="button-group">
                <!-- 취소 버튼 -->
                <a href="boardList.jsp" class="button cancel-button">취소</a>
                
                <!-- 수정 제출 버튼 -->
                <button type="submit" class="button">수정 완료</button>
            </div>
        </form>
    </div>
</body>
</html>
