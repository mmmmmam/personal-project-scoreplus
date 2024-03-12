package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.TestVO;
import util.DBUtil;

public class TestDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	//시험리스트 조회
	//select
	public List<TestVO> selectTestList() {
		List<TestVO> testlist = new ArrayList<>();
		String sql = "select test_id,test_round ,test_name,test_date,test_rgsstart,test_rgsend\r\n"
				+ ",case when TO_CHAR(SYSDATE, 'YYYYMMDD') < test_rgsend and TO_CHAR(SYSDATE, 'YYYYMMDD') > test_rgsstart then 'Y'\r\n"
				+ "else 'N'\r\n"
				+ "end as test_yn\r\n"
				+ "from testtypes order by test_round desc ";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				TestVO test = makeTest(rs);
				testlist.add(test);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return testlist;
	}
	
	private TestVO makeTest(ResultSet rs) throws SQLException {
		TestVO test = new TestVO();
		test.setTest_id(rs.getString(1));
		test.setTest_round(rs.getInt(2));
		test.setTest_name(rs.getString(3));
		test.setTest_date(rs.getString(4));
		test.setTest_rgsstart(rs.getString(5));
		test.setTest_rgsend(rs.getString(6));
		test.setTest_yn(rs.getString(7));
		return test;
	}

}
