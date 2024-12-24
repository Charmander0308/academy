package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/scott"; 
			String username = "root";
			String password = "12345";
			
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("연결 성공!!");
			
			System.out.print("변경할 사원의 사번 입력 : ");
			int empno = Integer.parseInt(scan.nextLine()); 
			
			String s = "select empno,ename,job,mgr,hiredate,sal from emp where empno = ?";
			pstmt = conn.prepareStatement(s);
			pstmt.setInt(1,empno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("사번 : "+rs.getInt("empno")+" 사원명 : "+rs.getString("ename")+" 부서명 : "+rs.getString("job")+
						" 사수번호 : "+ rs.getInt("mgr")+" 입사일 : "+rs.getString("hiredate")+" 급여 : "+rs.getInt("sal"));
			} else {
				System.out.println("해당하는 사원이 없습니다.");
			}
			
			
			System.out.println("1.사원명, 2.부서명, 3.사수번호, 4.입사일, 5.급여");
			System.out.print("변경할 항목 선택 : ");
			String sel = scan.nextLine();
			

			String sql = "";
			switch(sel) {
		
			case "1" :
				System.out.print("사원명 : ");
				String ename = scan.nextLine();
				sql = "UPDATE emp SET ename = ? WHERE empno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ename);
                pstmt.setInt(2, empno);
				break;
			case "2" :
				System.out.print("부서명 : ");
				String job = scan.nextLine();
				sql = "UPDATE emp SET job = ? WHERE empno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, job);
                pstmt.setInt(2, empno);
				break;
			case "3" :
				System.out.print("사수번호 : ");
				int mgr = Integer.parseInt(scan.nextLine());
				sql = "UPDATE emp SET mgr = ? WHERE empno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mgr);
                pstmt.setInt(2, empno);
				break;
			case "4" : 
				System.out.print("입사일(2023-00-00) : ");
				String hiredate = scan.nextLine();
				sql = "UPDATE emp SET hiredate = ? WHERE empno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, hiredate);
                pstmt.setInt(2, empno);
				break;
			case "5" :
				System.out.print("급여 : ");
				int sal = Integer.parseInt(scan.nextLine());
				sql = "UPDATE emp SET sal = ? WHERE empno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sal);
                pstmt.setInt(2, empno);
				break;
				
			default : 
				System.out.println("잘못된 입력입니다.");
				return;
			}
			
			int result = pstmt.executeUpdate();
			
			if(result <= 0) {
				System.out.println("데이터 수정 실패");
			} else {
				System.out.println("사원데이터 수정 성공!");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("연결(구동) 드라이브가 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 실패..");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
