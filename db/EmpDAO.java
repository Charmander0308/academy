/*
 * 기능 : 전체조회, 선택조회, 추가, 수정, 삭제 (DAO : Data Access Object)
 * DBConnection - 접속(), close() 따로
 * 1. 전체 - List<EmpBean> listAll();
 * 2. 선택조회 - EmpBean selectOne(int emp);
 * 3. int insert(EmpBean eb);
 * 4. int update(EmpBean eb);
 * 5. int delete(int empno);
 * EmpControl -> 메뉴구성
 */

package kr.co.dong.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	List<EmpBean> list = new ArrayList<EmpBean>();
	DBConnection dbc = new DBConnection();

	 public List<EmpBean> listAll() {
		 dbc.getConnection();
		try {
			String sql = "SELECT empno,ename,job,mgr,hireDate,sal,comm,deptno FROM emp";
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.rs = dbc.pstmt.executeQuery();

			while (dbc.rs.next()) {
				EmpBean eb = new EmpBean();
				eb.setEmpno(dbc.rs.getInt("empno"));
				eb.setEname(dbc.rs.getString("ename"));
				eb.setJob(dbc.rs.getString("job"));
				eb.setMgr(dbc.rs.getInt("mgr"));
				eb.setHireDate(dbc.rs.getString("hireDate"));
				eb.setSal(dbc.rs.getInt("sal"));
				eb.setComm(dbc.rs.getInt("comm"));
				eb.setDeptno(dbc.rs.getInt("deptno"));
				list.add(eb);
				
//				System.out.println(eb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	EmpBean selectOne(int empno) {
		EmpBean eb = null;
		String sql = "SELECT empno,ename,job,mgr,hireDate,sal,comm,deptno FROM emp WHERE empno = ?";
		try {
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setInt(1, empno);
			dbc.rs = dbc.pstmt.executeQuery();

			if (dbc.rs.next()) {
				eb = new EmpBean();
				
				eb.setEmpno(dbc.rs.getInt("empno"));
				eb.setEname(dbc.rs.getString("ename"));
				eb.setJob(dbc.rs.getString("job"));
				eb.setMgr(dbc.rs.getInt("mgr"));
				eb.setHireDate(dbc.rs.getString("hireDate"));
				eb.setSal(dbc.rs.getInt("sal"));
				eb.setComm(dbc.rs.getInt("comm"));
				eb.setDeptno(dbc.rs.getInt("deptno"));
				
//				System.out.println(eb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eb;
	}

	int insert(EmpBean eb) {
		String sql = "INSERT INTO emp(empno,ename,job,mgr,hireDate,sal,comm,deptno)";
		sql +="VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setInt(1, eb.getEmpno());
			dbc.pstmt.setString(2, eb.getEname());
			dbc.pstmt.setString(3, eb.getJob());
			dbc.pstmt.setInt(4, eb.getMgr());
			dbc.pstmt.setString(5, eb.getHireDate());
			dbc.pstmt.setDouble(6, eb.getSal());
			dbc.pstmt.setDouble(7, eb.getComm());
			dbc.pstmt.setInt(8, eb.getDeptno());
			list.add(eb);
			
			int result = dbc.pstmt.executeUpdate();
			
			System.out.println("추가완료 : " + eb);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0; 
		} 
		return 1; 
	}

	int update(EmpBean eb) {
		String sql = "UPDATE emp SET ename = ?, job = ?, mgr = ?, "
				+ "hireDate = ?, sal = ?, comm = ?, deptno = ? WHERE empno = ?";
		
		try {
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setString(1, eb.getEname());
			dbc.pstmt.setString(2, eb.getJob());
			dbc.pstmt.setInt(3, eb.getMgr());
			dbc.pstmt.setString(4, eb.getHireDate());
			dbc.pstmt.setDouble(5, eb.getSal());
			dbc.pstmt.setDouble(6, eb.getComm());
			dbc.pstmt.setInt(7, eb.getDeptno());
			dbc.pstmt.setInt(8, eb.getEmpno());
			
			int result = dbc.pstmt.executeUpdate();
			
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getEmpno()==eb.getEmpno()) {
					list.set(i, eb);
					break;
				}
			}
			
			System.out.println("수정완료 : "+ eb);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0; 
		} 
		return 1;
	}

	int delete(int empno) {
		String sql = "DELETE FROM emp WHERE empno = ?";
		
		try {
			EmpBean eb = new EmpBean();
			dbc.pstmt.setInt(1, eb.getEmpno());
			
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getEmpno()==empno) {
					list.remove(i);
				}
			}
			System.out.println("삭제됨");
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
		return 0; 
	}
}
