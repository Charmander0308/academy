<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
		
		//오늘 날짜 정보를 컴퓨터에서 받아올 객체 선언
		Timestamp today_date = new Timestamp(System.currentTimeMillis());
		
		//파라미터를 통해 전해진 작성자, 제목, 내용 정보를 받아와 각 문자열 변수에 저장
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//게시글 번호를 결정하기 위한 임시 정수형 변수 선언
		int num = 0;
		
		//MySQL로 전송하기 위한 쿼리문인 insertQuery 문자열 선언 (현재 등록된 게시글의 갯수를 파악)
		String insertQuery = "SELECT MAX(num) FROM practice_board.post";
		
		//SQL 쿼리문을 실행(MySQL로 전송)하기 위한 객체 선언
		PreparedStatement pstmt = connection.prepareStatement(insertQuery);
		
		//조회된 결과물들을 저장하기 위한 ResultSet 객체 선언
		ResultSet rs = pstmt.executeQuery();
		
		//받아온 정보가 있을 때
		while(rs.next()){
			//앞서 임시 선언한 num 변수에, 가져온 MAX(num) 칼럼값 + 1을 하여 저장
			num = rs.getInt("MAX(num)")+1;
		}
		
		//MySQL로 전송하기 위한 쿼리문인 insertQuery 문자열 선언(사용자가 post_new.jsp 폼에서 작성한 정보를 전송)
		insertQuery = "INSERT INTO practice_board.post(num, title, writer, content, reg_date) VALUES (?,?,?,?,?)";
		
		//SQL 쿼리문을 새로운 내용을 토대로 재실행
		pstmt = connection.prepareStatement(insertQuery);
		
		//VALUES ? 값에 하나씩 삽입하여 전송
		pstmt.setInt(1, num);
		pstmt.setString(2, title);
		pstmt.setString(3, writer);
		pstmt.setString(4, content);
		pstmt.setTimestamp(5, today_date);
		
		//INSERT 하여 반영된 레코드의 건수결과를 반환
		pstmt.executeUpdate();
		
		//모두 완료되면 post_list.jsp(글 목록) 폼으로 되돌아온다.
		response.sendRedirect("post_list.jsp");
    }
    catch(Exception ex){
    	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }
    
    %>
    
    