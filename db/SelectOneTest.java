/*
 * 데이터베이스 연결테스트 : MySQL
 * jar 파일 : mysql-connector-j-버전.jar
 * 
 * [필요한 클래스]
 * Connection 클래스 : URL(주소 : port), 사용자, 패스워드
 * DriverManager 클래스
 * Class.forName("구동드라이브");
 * 
 */
package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectOneTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		
		
//		검색할 사원명
		System.out.print("검색할 사원명 : ");
		String ename = scan.nextLine();
		

		try {
//		구동드라이브 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/scott"; 
			String username = "root";
			String password = "12345";
			
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("연결 성공!!");
			
//			String sql = "select empno, ename from emp where ename = " + ename; //이걸 아래처럼 쓸 수 있음
			String sql = "select empno, ename from emp where ename = ?";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);  //타입 맞아야함
			
			rs = pstmt.executeQuery();
			
			EmpBean eb = null;
			if(rs.next()) {
				eb = new EmpBean(rs.getInt(1), rs.getString(2), null, 0, null, 0, 0, 0);
			}
			System.out.println(eb);
			System.out.println("출력완료");	
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("연결(구동) 드라이브가 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 실패..");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
