package model;

import java.util.List;

import dto.RgsVO;

public class RgsService {
	
	RgsDAO dao = new RgsDAO();
	
	public int insertRgs(String testId, String userId) {
		return dao.insertRgs(testId, userId);
	}
	
	public List<RgsVO> selectRgsList(String userId) {
		return dao.selectRgsList(userId);
	}
	
	public int deleteRgs(int rgsNo) {
		return dao.deleteRgs(rgsNo);
	}

}
