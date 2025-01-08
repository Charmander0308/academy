package kr.co.dong.good;

import static kr.co.dong.good.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO {
//	JDBC 연결

	@Override
	public List<GoodsBean> listAll() {
		// 상품전체목록
		List<GoodsBean> list = new ArrayList<GoodsBean>();

		String sql = "Select * from goods";

		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				GoodsBean g = new GoodsBean();
				g.setGid(rs.getInt("gid"));
				g.setGname(rs.getString("gname"));
				g.setGcontent(rs.getString("gcontent"));
				g.setGcnt(rs.getInt("gcnt"));
				g.setGetc(rs.getString("getc"));
				list.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(GoodsBean g) {
		String sql = "INSERT INTO goods(gid,gname,gcontent,gcnt,getc) VALUES(?,?,?,?,?)";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, g.getGid());
			pstmt.setString(2, g.getGname());
			pstmt.setString(3, g.getGcontent());
			pstmt.setInt(4, g.getGcnt());
			pstmt.setString(5, g.getGetc());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public GoodsBean selectOne(int gid) {
		String sql = "SELECT gid,gname,gcontent,gcnt,getc FROM goods WHERE gid=?";
		GoodsBean g = null;

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, gid);

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					g = new GoodsBean();
					g.setGid(rs.getInt("gid"));
					g.setGname(rs.getString("gname"));
					g.setGcontent(rs.getString("gcontent"));
					g.setGcnt(rs.getInt("gcnt"));
					g.setGetc(rs.getString("getc"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	@Override
	public void update(GoodsBean g) {
		String sql = "UPDATE goods SET gname=?,gcontent=?,gcnt=?,getc=? WHERE gid=?";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, g.getGname());
			pstmt.setString(2, g.getGcontent());
			pstmt.setInt(3, g.getGcnt());
			pstmt.setString(4, g.getGetc());
			pstmt.setInt(5, g.getGid());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int gid) {
		String sql = "DELETE FROM goods WHERE gid=?";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, gid);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
