<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World!!</title>
<link rel="stylesheet" href="../resources/style_html02.css">


</head>
<body>
	<%
	try {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost/member_data";
		String id = "root";
		String password = "12345";
		Connection connection = DriverManager.getConnection(url, id, password);

		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("membercode");
		String insertQuery = "SELECT * FROM member_data.member WHERE membercode=?";
		PreparedStatement pstmt = connection.prepareStatement(insertQuery);
		pstmt.setString(1, code);
		ResultSet rs = pstmt.executeQuery();

		out.println("연결 성공^_^");

	} catch (Exception ex) {
		out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
	}
	%>



	<div>
		<h2>회원 정보 입력</h2>
		<h5>(*표시된 항목은 필수 입력)</h5>

		<h4>사용할 ID를 입력하세요. *</h4>
		ID : <input type="text" id="id" name="myid" size="15"
			placeholder="아이디" required> <input type="button" value="중복확인"
			onclick="idCheck()">
		<script type="text/javascript">
			function idCheck() {
				var id = document.getElementById("id").value;

				if (id === "") {
					alert("아이디를 입력하세요.");
					return;
				}

				var xhr = new XMLHttpRequest();
				xhr.open("GET", "/testjsp/IdCheckServlet?id="
						+ encodeURIComponent(id), true);
				xhr.onreadystatechange = function() {
					 if (xhr.readyState === 4 && xhr.status === 200) {
			                var response = xhr.responseText.trim();
			                console.log("서버 응답: " + response); // 서버 응답 확인 (디버깅)

			                if (response === "duplicate") {
			                    alert("중복된 아이디가 있습니다.");
			                } else if (response === "available") {
			                    alert("사용 가능한 아이디입니다.");
			                } else {
			                    alert("예상치 못한 응답: " + response);
			                }
			            }
				};
				xhr.send();
			}
		</script>
		<br>
		<h4>사용할 비밀번호를 입력하세요. *</h4>
		비밀번호 : <input type="password" id="password1" name="mypassword"
			size="15" placeholder="비밀번호" required><br>
		<h4>한 번 더 입력하세요. *</h4>
		비밀번호 : <input type="password" id="password2" name="mypassword"
			size="15" placeholder="비밀번호" required> <span id="message"
			style="margin-left: 10px;"></span>
		<script type="text/javascript">
			// 비밀번호 입력란 요소
			const password1 = document.getElementById('password1');
			const password2 = document.getElementById('password2');
			const message = document.getElementById('message');

			// 이벤트 리스너 추가: 비밀번호 입력시 비교
			password2.addEventListener('input',
					function() {
						if (password1.value == password2.value
								&& password2.value != "") {
							message.textContent = "일치";
							message.style.color = "green"; // 글자 색을 초록으로 변경
						} else if (password1.value != password2.value
								&& password2.value != "") {
							message.textContent = "일치하지 않음";
							message.style.color = "red"; // 글자 색을 빨간색으로 변경
						} else if (password1.value != ""
								|| password2.value == "") {
							message.textContent = "";
						}
					});
		</script>
		<br>

		<h4>이메일을 입력하세요. *</h4>
		이메일 : <input type="text" id="myemail" name="myemail" size="25"
			placeholder="example@xxx.com" required> <input type="submit"
			value="인증" onclick="emailClick()"><br>
		<script>
			function emailClick() {
				if (myemail.value.indexOf('@') == -1) {
					alert('이메일 형식이 아닙니다. 다시 입력하세요.')
				} else {
					alert('이메일로 인증코드를 전송하였습니다.')
				}
			}
		</script>

		<h4>휴대폰번호를 입력하세요. *</h4>
		휴대폰번호 : <input type="tel" id="myphonenumber" name="myphonenumber"
			size="15" placeholder="'-' 없이 입력" required> <input
			type="submit" value="인증" onclick="phoneNumberClick()"><br>
		<script>
			function phoneNumberClick() {
				if (myphonenumber.value.indexOf('-') == 1) {
					alert('')
				} else {
					alert('인증되었습니다.')
				}
			}
		</script>
		<br>
		<br>
		<br>
		<br>
		<br>


		<h4>성별?</h4>
		<select name="sex">
			<option value="1">남성</option>
			<option value="2">여성</option>
			<option value="3">비공개</option>
		</select>
		<h4>생년월일?</h4>
		생년월일 : <input type="date" name="birth">

		<h4>MBTI?</h4>
		<select name="mbti_1">
			<option value="1">I</option>
			<option value="2">E</option>
		</select> <select name="mbti_2">
			<option value="3">N</option>
			<option value="4">S</option>
		</select> <select name="mbti_3">
			<option value="5">F</option>
			<option value="6">T</option>
		</select> <select name="mbti_4">
			<option value="7">P</option>
			<option value="8">J</option>
		</select>
		<h4>취미?</h4>
		<input type="text" name="hobby" size="20" placeholder="ex) 독서, 야구">

		<br>
		<br>
		<br>
		<button type="submit">가입 완료</button>
	</div>
</body>
</html>