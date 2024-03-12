package model;

import dto.CstVO;

public class CstService {
	
	CstDAO dao = new CstDAO();
	
	public CstVO selectById(String cst_id, String cst_pw) {
		return dao.selectById(cst_id,cst_pw);
	}
	
	public int insertCst(CstVO cst) {
		return dao.insertCst(cst);
	}
	
	public CstVO selectCst(String cst_id) {
		return dao.selectCst(cst_id);
	}
	
	public int selectCheckCst(String cst_id) {
		return dao.selectCheckCst(cst_id);
	}
	
	public int updateCst(String cst_id, String cst_pw) {
		return dao.updateCst(cst_id,cst_pw);
	}
	
	public int deleteCst(String cst_id) {
		return dao.deleteCst(cst_id);
	}
	
}
