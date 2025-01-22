<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 열람</title>
</head>
<body>
	<h1>게시글 상세 열람</h1>
	<%
	try
	{
		//JDBC 드라이버 연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		String db_address = "jdbc:mysql://localhost/practice_board";
		String db_username = "root";
		String db_pwd = "12345";
		Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
		
		//받아오는 문자열의 인코딩 방식 결정
		request.setCharacterEncoding("UTF-8");
		
		//파라미터를 통해 전해진 게시글 번호를 받아와 num 변수에 저장
		String num = request.getParameter("num");
		
		//MySQL로 전송하기 위한 쿼리문인 insertQuery 문자열 선언(읽어온 게시글 번호를 통해 불러올 게시글을 결정함)
		String insertQuery = "SELECT * FROM practice_board.post WHERE num=" + num;
		
		//SQL 쿼리문을 실행(MySQL로 전송)하기 위한 객체 선언
		PreparedStatement pstmt = connection.prepareStatement(insertQuery);
		
		//조회된 결과물들을 저장하기 위한 ResultSet 객체 선언
		ResultSet rs = pstmt.executeQuery();%>
		
		<table border="1">
			<%
			//받아온 정보가 있을때
			while(rs.next()){
			%>
				<tr>
					<!-- 번호 <td> 옆에 DB에서 받아온 num 칼럼값 삽입 -->
					<td>번호</td>
					<td><%=rs.getInt("num") %></td>
				</tr>
				<tr>
					<!-- 작성일 <td> 옆에 DB에서 받아온 reg_date 칼럼값 삽입 -->
					<td>작성일</td>
					<td><%=rs.getTimestamp("reg_date") %></td>
				</tr>
				<tr>
					<!-- 작성자 <td> 옆에 DB에서 받아온 writer 칼럼값 삽입 -->
					<td>작성자</td>
					<td><%=rs.getString("writer") %></td>
				</tr>
				<tr>
					<!-- 제목 <td> 옆에 DB에서 받아온 title 칼럼값 삽입 -->
					<td>제목</td>
					<td><%=rs.getString("title") %></td>
				</tr>
				<tr>
					<!-- 내용 <td> 옆에 DB에서 받아온 content 칼럼값 삽입 -->
					<td>내용</td>
					<td><%=rs.getString("content") %></td>
				</tr>
				<tr>
					<td colspan="2">
						<!-- 목록으로 버튼을 누르면 post_list.jsp로 연결됨 -->
						<button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
					</td>
				</tr>
				<%} %>
		</table>
		<%
		} catch(Exception ex){
			out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
		}
		%>
</body>
</html>