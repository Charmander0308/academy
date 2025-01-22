<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
try
{
	//JDBC 드라이버 연결
	Class.forName("com.mysql.cj.jdbc.Driver");
	String db_address = "jdbc:mysql://localhost/practice_board";
	String db_username = "root";
	String db_pwd = "12345";
	Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
	
	//문자열의 인코딩 방식 결정
	request.setCharacterEncoding("UTF-8");
	
	//파라미터를 통해 전해진 게시글 번호를 받아와 num 변수에 저장
	String num = request.getParameter("num");
	
	//MySQL로 전송하기 위한 쿼리문인 insertQuery 문자열 선언(읽어온 게시글 번호를 통해, 수정할 게시글을 다시 한 번 결정(확인)함)
	String insertQuery = "DELETE FROM practice_board.post WHERE num=" + num;
	
	//SQL 쿼리문을 실행(MySQL로 전송)하기 위한 객체 선언
	PreparedStatement pstmt = connection.prepareStatement(insertQuery);
	
	//DELETE 하여 반영된 레코드의 건수결과를 반환
	pstmt.executeUpdate();
	
	//모두 완료되면 post_list.jsp(글 목록) 폼으로 되돌아 온다.
	response.sendRedirect("post_list.jsp");
} catch(Exception ex){
	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>