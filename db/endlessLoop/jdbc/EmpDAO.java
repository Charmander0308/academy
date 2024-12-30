package kr.co.dong.jdbc2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	List<EmpBean> list = new ArrayList<EmpBean>();
	DBConnection dbc = new DBConnection();
	
	List<EmpBean> listAll(){
		dbc.getConnection();
		EmpBean eb = null;
		String sql = "SELECT * FROM emp";
		try {
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.rs = dbc.pstmt.executeQuery();
			
			while(dbc.rs.next()) {
				eb = new EmpBean();
				eb.setEmpno(dbc.rs.getInt("empno"));
				eb.setEname(dbc.rs.getString("ename"));
				eb.setJob(dbc.rs.getString("job"));
				eb.setMgr(dbc.rs.getInt("mgr"));
				eb.setSal(dbc.rs.getDouble("sal"));
				eb.setComm(dbc.rs.getDouble("comm"));
				eb.setHiredate(dbc.rs.getString("hiredate"));
				eb.setDeptno(dbc.rs.getInt("deptno"));
				list.add(eb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	EmpBean selectOne(int empno) {
		EmpBean eb = null;
		
		String sql = "SELECT * FROM emp WHERE empno=?";
		try {
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setInt(1, empno);
			dbc.rs = dbc.pstmt.executeQuery();
			
			while(dbc.rs.next()) {
				eb = new EmpBean();
				eb.setEmpno(dbc.rs.getInt("empno"));
				eb.setEname(dbc.rs.getString("ename"));
				eb.setJob(dbc.rs.getString("job"));
				eb.setMgr(dbc.rs.getInt("mgr"));
				eb.setSal(dbc.rs.getDouble("sal"));
				eb.setComm(dbc.rs.getDouble("comm"));
				eb.setHiredate(dbc.rs.getString("hiredate"));
				eb.setDeptno(dbc.rs.getInt("deptno"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return eb;
	}

	int insert(EmpBean eb) {
		String sql = "INSERT INTO emp(empno,ename,job,mgr,sal,comm,hiredate,deptno) VALUES(?,?,?,?,?,?,?,?)";
		try {
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setInt(1, eb.getEmpno());
			dbc.pstmt.setString(2, eb.getEname());
			dbc.pstmt.setString(3, eb.getJob());
			dbc.pstmt.setInt(4, eb.getMgr());
			dbc.pstmt.setDouble(5, eb.getSal());
			dbc.pstmt.setDouble(6, eb.getComm());
			dbc.pstmt.setString(7, eb.getHiredate());
			dbc.pstmt.setInt(8, eb.getDeptno());
			
			int result = dbc.pstmt.executeUpdate();
			if(result>0) {
				list.add(eb);
			}
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	int update(EmpBean eb) {
		String sql = "UPDATE emp SET ename=?,job=?,mgr=?,sal=?,comm=?,hiredate=?,deptno=? WHERE empno=?";
		try {
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setString(1, eb.getEname());
			dbc.pstmt.setString(2, eb.getJob());
			dbc.pstmt.setInt(3, eb.getMgr());
			dbc.pstmt.setDouble(4, eb.getSal());
			dbc.pstmt.setDouble(5, eb.getComm());
			dbc.pstmt.setString(6, eb.getHiredate());
			dbc.pstmt.setInt(7, eb.getDeptno());
			dbc.pstmt.setInt(8, eb.getEmpno());
			
			int result = dbc.pstmt.executeUpdate();
			if(result>0) {
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getEmpno()==eb.getEmpno()) {
						list.set(i, eb);
						break;
					}
				}
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	int delete(int empno) {
		String sql = "DELETE FROM emp WHERE empno=?";
		try {
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setInt(1, empno);
			
			int result = dbc.pstmt.executeUpdate();
			if(result>0) {
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getEmpno()==empno) {
						list.remove(i);
						break;
					}
				}
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
