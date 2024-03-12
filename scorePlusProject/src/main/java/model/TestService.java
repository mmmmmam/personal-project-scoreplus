package model;

import java.util.List;

import dto.TestVO;

public class TestService {
	
	TestDAO dao = new TestDAO();
	
	public List<TestVO> selectTestList() {
		return dao.selectTestList();
	}

}
