package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBConnection {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	void getConnection() {

		if (conn == null) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				String url = "jdbc:mysql://localhost/scott";
				String username = "root";
				String password = "12345";

				conn = DriverManager.getConnection(url, username, password);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
