package model;

import java.util.List;

import dto.ScoreVO;

public class ScoreService {
	
	ScoreDAO dao = new ScoreDAO();
	
	public List<ScoreVO> selectScoreList(String userId) {
		return dao.selectScoreList(userId);
	}

}
