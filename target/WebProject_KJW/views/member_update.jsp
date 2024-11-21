<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.model.MemberDTO"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보 수정</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f3f4f6;              
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: #ffffff;
            width: 400px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-size: 14px;
            margin-bottom: 5px;
            color: #555;
        }

        .form-group input, .form-group button {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 5px;
            transition: border-color 0.3s ease;
        }

        .form-group input:focus {
            outline: none;
            border-color: #007bff;
        }

        .form-group .error {
            color: red;
            font-size: 12px;
        }

        .btn {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background: #0056b3;
        }

        .form-footer {
            text-align: center;
            margin-top: 10px;
            font-size: 12px;
            color: #555;
            
        }
        .id-input{
            background-color: rgba(0, 0, 0, 0.1);
        }
    </style>
    <script>
        function validateForm() {
            let isValid = true;

            // Get form elements
            const id = document.getElementById('id').value.trim();
            const pw = document.getElementById('pw').value.trim();
            const email = document.getElementById('email').value.trim();
            const name = document.getElementById('name').value.trim();
            const pnum = document.getElementById('pnum').value.trim();
            const hdate = document.getElementById('hdate').value.trim();

            // Clear previous error messages
            document.querySelectorAll('.error').forEach(error => error.textContent = '');

            // Validate ID
            if (id === '') {
                document.getElementById('idError').textContent = '아이디를 입력해주세요.';
                isValid = false;
            }

            // Validate password
            if (pw.length < 6) {
                document.getElementById('pwError').textContent = '비밀번호는 6자 이상이어야 합니다.';
                isValid = false;
            }

            // Validate email
            const emailRegex = /^\S+@\S+\.\S+$/;
            if (!email.match(emailRegex)) {
                document.getElementById('emailError').textContent = '유효한 이메일을 입력해주세요.';
                isValid = false;
            }

            // Validate name
            if (name === '') {
                document.getElementById('nameError').textContent = '이름을 입력해주세요.';
                isValid = false;
            }

            // Validate phone number
            if (!pnum.match(/^\d+$/)) {
                document.getElementById('pnumError').textContent = '전화번호는 숫자만 입력 가능합니다.';
                isValid = false;
            }

            // Validate hire date
            if (hdate === '') {
                document.getElementById('hdateError').textContent = '입사일을 입력해주세요.';
                isValid = false;
            }

            return isValid;
        }
        const inputOff = document.querySelector('.input-off');
        inputOff.addEventListener('click', function() {
            this.remove();
        });


    </script>
</head>
<body>
    <div class="form-container">
        <h2>정보 수정</h2>
        <%--
                private String id;
                private String pw;
                private String email;
                private String name;
                private int pnum;
                private String hdate;
        
         --%>
        <form onsubmit="return validateForm(this);" action="memberUpdate.do" method="POST">
       
            <div class="form-group">
            <label for="id">아이디</label>
            <input type="" id="id" name="id" class="id-input" value="${sessionScope.UserId}" readonly>
            <span id="idError" class="error"></span>
            </div>
             
            <div class="form-group">
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw" value="${sessionScope.UserPw}" >
            <span id="pwError" class="error"></span>
            </div>
             
            <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" value="${sessionScope.UserEmail}">
            <span id="emailError" class="error"></span>
            </div>
           
             
            <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" value="${sessionScope.UserName}">
            <span id="nameError" class="error"></span>
            </div>
           
             
            <div class="form-group">
            <label for="pnum">전화번호(숫자만 입력)</label>
            <input type="number" id="pnum" name="pnum" value="${sessionScope.UserPnum}">
            <span id="pnumError" class="error"></span>
            </div>
            
            
           
            <button type="submit" class="btn">저장</button>
        </form>
       
    </div>
</body>
</html>
