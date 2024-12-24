/*
 * 1. DB연결 : Connection
 * 2. 질의문 작성 -> 실행 : Statement
 * 3. 실행한 결과를 보관 : ResultSet
 */
package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectAllTest2 {
	public static void main(String[] args) {
		List<EmpBean> list = new ArrayList<EmpBean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/scott"; //검색해서 복붙하자
			String username = "root";
			String password = "12345";
			
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("연결 성공!!");
			
			String sql = "select empno, ename from emp";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			System.out.println("사원번호 : 사원명");
			while(rs.next()) {
				EmpBean eb = new EmpBean(rs.getInt(1), rs.getString(2), null, 0, null, 0, 0, 0);
				list.add(eb);
			}
			for(EmpBean eb : list) {
				System.out.println(eb);
			}
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
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
