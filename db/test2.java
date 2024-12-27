package kr.co.dong.jdbc;

import java.sql.*;

public class test2 {
	public static void main(String[] args) {

		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String ename = "TOTORO";
//		String ename = "TOM";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/scott";
			String username = "root";
			String password = "12345";

			conn = DriverManager.getConnection(url, username, password);

			String sql = "SELECT empno,mgr FROM emp WHERE ename = ?";

//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ename);

//			rs = stmt.executeQuery(sql);
			rs = pstmt.executeQuery();
			int result = 0;
			
			while (rs.next()) {
				System.out.println(ename + "의 사원번호는 " + rs.getInt(2) + "입니다!");
				result++;
			}
			if(result == 0) {
				System.out.println("그런사람 없어요");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
