package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.RgsVO;
import util.DBUtil;

public class RgsDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	//시험접수
	//insert
	public int insertRgs(String testId,String userId) {
		String sql = "insert into registrations values(rgs_no.nextval,?,?,?)";
		int count = 0;
	    Long datetime = System.currentTimeMillis();
	    Date timestamp = new Date(datetime);
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, testId);
			pst.setString(2, userId);
			pst.setDate(3, timestamp);
			count = pst.executeUpdate(); 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return count;
	}
	
	//접수내역조회 
	//select
	public List<RgsVO> selectRgsList(String userId) {
		List<RgsVO> rgslist = new ArrayList<>();
		String sql = "select rgs_no,ta.test_id,test_name,test_round,test_date "
				+ ",case when TO_CHAR(SYSDATE, 'YYYYMMDD') < test_date then 'Y'\r\n"
				+ "else 'N'\r\n"
				+ "end as cancel_yn\r\n"
				+ "from registrations ta,testtypes tb "
				+ "where ta.test_id = tb.test_id and ta.cst_id ='"+ userId +"'"
				+ "order by test_round desc ";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				RgsVO rgs = makeRgs(rs);
				rgslist.add(rgs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return rgslist;
	}
	
	//접수취소
	//delete
	public int deleteRgs(int rgsNo) {
		String sql = "delete registrations where rgs_no = ?";
		int count = 0;
	    Long datetime = System.currentTimeMillis();
	    Date timestamp = new Date(datetime);
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, rgsNo);
			count = pst.executeUpdate(); 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return count;
	}
	
	
	private RgsVO makeRgs(ResultSet rs) throws SQLException {
		RgsVO rgs = new RgsVO();
		rgs.setRgs_no(rs.getInt(1));
		rgs.setTest_id(rs.getString(2));
		rgs.setTest_name(rs.getString(3));
		rgs.setTest_round(rs.getInt(4));
		rgs.setTest_date(rs.getString(5));
		rgs.setCancel_yn(rs.getString(6));
		return rgs;
	}
}
