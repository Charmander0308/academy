package kr.co.dong.good;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import static kr.co.dong.good.JDBCTemplate.*;  <== 타 클래스에서 이 import문을 쓰면 JDBCTemplate의 모든 메서드를 자유롭게 사용 가능.

public class JDBCTemplate {
//	mysql JDBC 연결
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "";
			String user = "root";
			String password = "12345";

			conn = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("콘솔 및 로그 저장 : 연결 성공!");
		return conn;
	}

//	conn, stmt, pstmt, rs   => close()

	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) { // 예외처리 확실하게
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	commit(), rollback() 메서드 예시 - 입력받는 변수는 conn이 아닐 수도 있음
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
