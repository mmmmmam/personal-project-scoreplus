package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.CstVO;
import util.DBUtil;


public class CstDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	//로그인 정합성확인
	//ID, PW일치
	public CstVO selectById(String cst_id, String cst_pw) {
		CstVO cst = null;
		String sql = "select * from customers where cst_id ='"+ cst_id +"'and cst_pw = '"+ cst_pw + "'";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				cst = getCstID(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return cst;
	}
	
	private CstVO getCstID(ResultSet rs) throws SQLException {
		CstVO cst = new CstVO();
		cst.setCst_id(rs.getString(1));
		cst.setCst_pw(rs.getString(2));
		cst.setCst_name(rs.getString(3));
		cst.setCst_birth(rs.getString(4));
		cst.setCst_rgsdate(rs.getDate(5));

		return cst;
	}
	
	//회원가입
	//insert
	public int insertCst(CstVO cst) {
		String sql = "insert into customers values(?,?,?,?,?)";
		int count = 0;
	    Long datetime = System.currentTimeMillis();
	    Date timestamp = new Date(datetime);
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cst.getCst_id());
			pst.setString(2, cst.getCst_pw());
			pst.setString(3, cst.getCst_name());
			pst.setString(4, cst.getCst_birth());
			pst.setDate(5, timestamp);
			count = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return count;
	}
	
	//회원정보조회
	//select
	public CstVO selectCst(String cst_id) {
		CstVO cst = null;
		String sql = "select * from customers where cst_id ='"+ cst_id +"'";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				cst = getCstID(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return cst;
	}
	
	//중복id체크
	//select
	public int selectCheckCst(String cst_id) {
		int cnt = 0;
		String sql = "select * from customers where cst_id ='" + cst_id + "'";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				cnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return cnt;
	}
	
	//비밀번호변경
	//update
	public int updateCst(String cst_id, String cst_pw) {
		String sql = "update customers set cst_pw = ? where cst_id = ?";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cst_pw);
			pst.setString(2, cst_id);
			count = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return count;
	}
	
	//회원탈퇴
	//delete
	public int deleteCst(String cst_id) {
		String sql = "delete customers where cst_id=? ";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql); 
			pst.setString(1, cst_id);
			count = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return count;
	}

}
