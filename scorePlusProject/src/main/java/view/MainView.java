package view;

import java.util.List;

import dto.CstVO;
import dto.RgsVO;
import dto.ScoreVO;
import dto.TestVO;

public class MainView {
	
	public static void print(String message) {
		System.out.println("----------------");
		System.out.println(message);
		System.out.println("----------------");
	}
	
	/*
	 *  flag 
	 *  1: 시작화면
	 *  2: 로그인후 메인
	 *  3: 마이페이지
	 */
	public static void printMenu(int menuFlag) {

		if (menuFlag == 1)
		{
			System.out.println("## SCOREPLUS! ##");
			System.out.println("----------------");
			System.out.println("-START PAGE-");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 종료");
		}
		else if(menuFlag == 2)
		{
			System.out.println();
			System.out.println("-MAIN PAGE-");
			System.out.println("1. 시험접수");
			System.out.println("2. 마이페이지");
			System.out.println("3. 로그아웃");
		}
		else if(menuFlag == 3) 
		{
			System.out.println();
			System.out.println("-MY PAGE-");
			System.out.println("1. 접수내역");
			System.out.println("2. 성적조회");
			System.out.println("3. 회원정보조회");
			System.out.println("4. 비밀번호변경");
			System.out.println("5. 회원탈퇴");
			System.out.println("6. 이전으로");
		}
		System.out.println("----------------");
		System.out.print("선택입력 >> ");
	}
	
	//시험 리스트
	public static void printSelectTestList(List<TestVO> testList) {
		String acceptability = null;
		System.out.println();
		System.out.println("MAIN > TEST LIST");
		System.out.println("----------------");
		System.out.println("-TEST_LIST-");
		System.out.println("==================================================================================");
		for(int i = 0; i < testList.size(); i++) {			
			if(testList.get(i).getTest_yn().equals("N")) { 
				acceptability ="접수불가능";
			}else {
				acceptability ="접수가능";
			}
			System.out.println("["+(i+1)+"]_["+acceptability+"]"
					+ " 시험명: " + testList.get(i).getTest_name()
					+ " 시험회차: " + testList.get(i).getTest_round()
					+ " 응시일: " + testList.get(i).getTest_date()
					+ " 접수시작일:" + testList.get(i).getTest_rgsstart()
					+ " 접수마감일:" + testList.get(i).getTest_rgsend()
					);
		}
		System.out.println("==================================================================================");
		System.out.println("999. 이전으로");
		System.out.println("----------------");
		System.out.print("접수시험 번호를 입력 혹은 이전으로 이동을 원하시면(999)입력 >>");
	}

	//마이페이지> 접수리스트
	public static void printSelectRgsList(List<RgsVO> rsgList) {
		System.out.println();
		System.out.println("MAIN > MY PAGE > RGS LIST");
		System.out.println("----------------");
		System.out.println("-RGS_LIST-");
		System.out.println("==================================================================================");
		for(int i = 0; i < rsgList.size();i++) {
			System.out.println("["+(i+1)+"]_"					
					+ " 접수번호: " + rsgList.get(i).getRgs_no()
					+ " 시험명: " + rsgList.get(i).getTest_name()
					+ " 시험회차: " + rsgList.get(i).getTest_round()
					+ " 응시일: " + rsgList.get(i).getTest_date()
					);	
		}
		System.out.println("==================================================================================");
		System.out.println("1. 이전으로");
		System.out.println("----------------");
		System.out.print("선택입력 >> ");		
	}

	//마이페이지> 점수리스트
	public static void printSelectScoreList(List<ScoreVO> scoreList) {
		System.out.println();
		System.out.println("MAIN > MY PAGE > SCORE LIST");
		System.out.println("----------------");
		System.out.println("-SCORE_LIST-");
		System.out.println("==================================================================================");
		for(int i = 0; i < scoreList.size();i++) {
			System.out.println("["+(i+1)+"]_"					
					+ " 점수: " + scoreList.get(i).getScore()
					+ " 시험명: " + scoreList.get(i).getTest_name()
					+ " 시험회차: " + scoreList.get(i).getTest_round()
					+ " 응시일: " + scoreList.get(i).getTest_date()
					);	
		}
		System.out.println("==================================================================================");
		System.out.println("1. 이전으로");
		System.out.println("----------------");
		System.out.print("선택입력 >> ");
	}
	
	//마이페이지> 회원정보조회
	public static void printUserInfo(CstVO userInfo) {
		System.out.println();
		System.out.println("MAIN > MY PAGE > MY INFO");
		System.out.println("----------------");
		System.out.println("========================================================================");
		System.out.println("ID: " + userInfo.getCst_id());
		System.out.println("이름: " + userInfo.getCst_name());
		System.out.println("생년월일: " + userInfo.getCst_birth());
		System.out.println("가입일자: " + userInfo.getCst_rgsdate());
		System.out.println("========================================================================");
		System.out.println("1. 이전으로");
		System.out.println("----------------");
		System.out.print("선택입력 >> ");
	}
}
