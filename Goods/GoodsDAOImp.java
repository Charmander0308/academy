package kr.co.dong.good2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static kr.co.dong.good2.JDBCtemplate.*;

public class GoodsDAOImp implements GoodsDAO{
	Connection conn = getConnection();

	@Override
	public List<GoodsBean> listAll() {
		Statement stmt = null;
		ResultSet rs = null;
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		
		String sql = "SELECT * FROM goods";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new GoodsBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return list;
	}

	@Override
	public GoodsBean selectOne(int gid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsBean g = null;
		
		String sql = "SELECT * FROM goods WHERE gid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,gid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				g = new GoodsBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return g;
	}

	@Override
	public int insert(GoodsBean g) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO goods(gname,gcontent,gcnt,getc) VALUES (?,?,?,?)";
		int r = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getGname());
			pstmt.setString(2, g.getGcontent());
			pstmt.setInt(3, g.getGcnt());
			pstmt.setString(4, g.getGetc());
			
			r = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return r;
	}
	
	@Override
	public int update(GoodsBean g) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE goods SET gname=?,gcontent=?,gcnt=?,getc=? WHERE gid=?";
		int r = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getGname());
			pstmt.setString(2, g.getGcontent());
			pstmt.setInt(3, g.getGcnt());
			pstmt.setString(4, g.getGetc());
			
			r = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return r;
	}

	@Override
	public int delete(int gid) {
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM goods WHERE gid=?";
		int r = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			r = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public void prnState() {
		System.out.println("동작을 진행합니다 . . . ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("동작합니다.");
	}
	

	

}
