package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ScoreVO;
import util.DBUtil;

public class ScoreDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	//성적조회
	//select
	public List<ScoreVO> selectScoreList(String userId) {
		List<ScoreVO> scoreList = new ArrayList<>();
		String sql = "select score,test_name,test_round,test_date "
				+ "from scores ta,testtypes tb "
				+ "where ta.test_id = tb.test_id and ta.cst_id ='"+ userId +"'";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ScoreVO score = makeScore(rs);
				scoreList.add(score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return scoreList;
	}
	
	private ScoreVO makeScore(ResultSet rs) throws SQLException {
		ScoreVO score = new ScoreVO();
		score.setScore(rs.getInt(1));
		score.setTest_name(rs.getString(2));
		score.setTest_round(rs.getInt(3));
		score.setTest_date(rs.getString(4));
		return score;
	}
}
