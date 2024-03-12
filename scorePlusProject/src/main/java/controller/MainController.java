package controller;

import java.util.List;
import java.util.Scanner;

import dto.CstVO;
import dto.RgsVO;
import dto.ScoreVO;
import dto.TestVO;
import model.CstService;
import model.RgsService;
import model.ScoreService;
import model.TestService;
import view.MainView;

public class MainController {
	private static CstService cstService = new CstService();
	private static TestService testService = new TestService();
	private static RgsService RgsService = new RgsService();
	private static ScoreService ScoreService = new ScoreService();
	static Scanner sc = new Scanner(System.in);
	static boolean loginYn = false;
	static String userId = null;
	static int menuFlag = 1;
	
	public static void main(String[] args) {
		boolean isRun = true;
		int job1, job2, job3, selectTestNum;
		
		while(isRun) {
			
			if(loginYn) 
			{
				//메인화면 bb
				if(menuFlag == 2)
				{
					MainView.printMenu(menuFlag); 
					job2 = sc.nextInt();
					switch (job2) {
					//bb시험접수
					case 1:
						//접수가능한 회차 보여주기
						List<TestVO> testList = testService.selectTestList();
						MainView.printSelectTestList(testList);
						selectTestNum = sc.nextInt();
						if(selectTestNum == 999) { //이전으로
							break;
						}else {
							insertRgs(selectTestNum, testList, userId); //접수
							break;
						}
					//bb마이페이지
					case 2:
						menuFlag =3;
						break ;
					//bb로그아웃
					case 3:
						menuFlag =1;
						loginYn = false;
						break ;
					default:
						break;
					}
				}
				
				//마이페이지화면 cc
				else if(menuFlag == 3)
				{
					MainView.printMenu(menuFlag);
					job3 = sc.nextInt();
					switch (job3) {
					//cc접수내역
					case 1:
						selectRgsList(userId);
						sc.nextInt();
						menuFlag =3;
						break ;
					//cc성적조회
					case 2:
						selectScoreList(userId);
						sc.nextInt();
						menuFlag =3;
						break;
					//cc회원정보조회
					case 3:
						CstVO userInfo = cstService.selectCst(userId);
						MainView.printUserInfo(userInfo);
						sc.nextInt();
						menuFlag =3;
						break;	
					//cc비밀번호변경
					case 4:
						System.out.print("변경할 PW를 입력하세요>> ");
						int updatecnt = cstService.updateCst(userId,sc.next());
						MainView.print(updatecnt>0?"변경성공":"변경실패");
						break;
					//cc회원탈퇴
					case 5: 
						System.out.print("탈퇴할 ID를 입력하세요>> ");
						String cst_id = sc.next();
						int deletecnt = cstService.deleteCst(cst_id);
						if (deletecnt > 0) {
							loginYn = false;
							menuFlag =1;
							MainView.print("탈퇴성공");
						} else {
							MainView.print("탈퇴실패");
						}
						break;
					//cc이전으로
					case 6:
						menuFlag =2;
						break;
					default:
						break; 
					}
				}
			}
			
			//시작화면 aa
			else
			{
				MainView.printMenu(menuFlag);
				job1 = sc.nextInt();
				switch (job1) {
				//aa로그인
				case 1:
					login(); //로그인 메소드호출
					break;
				//aa회원가입
				case 2: 
					join(); //회원가입 메소드호출
					break ;
				//aa종료
				case 3:
					isRun=false; 
					break;
				default:
					break;
				}	
			}
		}
		sc.close();
		MainView.print("프로그램 종료");
	}

	//로그인
	private static void login() {
		System.out.print("ID를 입력하세요>> ");
		String cst_id = sc.next();
		System.out.print("PW를 입력하세요>> ");
		String cst_pw = sc.next();
		
		if(loginCheck(cst_id, cst_pw)){
			userId = cst_id;
			loginYn = true; 
			menuFlag = 2;
		}
		//로그인 실패시 회원가입 메소드호출
		else
		{
			MainView.print("입력하신 ID,PW의 회원정보를 찾을 수 없습니다.");
			MainView.print("회원가입 진행하시겠습니까? (Y/N)");
			System.out.print("진행여부 입력 >> ");
			String inputYN = sc.next();
			if(inputYN.equals("Y")) 
			{
				join();				
			}else {
				//MainView.printMenu(1);
			}
		}
	}
	 
	//로그인 정합성확인
	private static boolean loginCheck(String cst_id, String cst_pw) {		
		boolean loginChk = false;
		CstVO cst = cstService.selectById(cst_id, cst_pw);
		if(cst!=null) {
			MainView.print(cst.getCst_name()+"님 로그인 완료입니다");
			loginChk = true;
		}
		return loginChk;
	}
		
	//회원가입
	private static void join() {
		System.out.println();
		System.out.println("-JOIN PAGE-");			
		System.out.print("회원가입 ID를 입력하세요>> ");
		String cst_id = sc.next();
		System.out.print("회원가입 PW를 입력하세요>> ");
		String cst_pw = sc.next();
		System.out.print("회원가입 이름을 입력하세요>> ");
		String cst_name = sc.next();
		System.out.print("회원가입 생년월일을 입력하세요>> ");
		String cst_birth = sc.next();
		
		CstVO cst = new CstVO();
		cst.setCst_id(cst_id);
		cst.setCst_pw(cst_pw);
		cst.setCst_name(cst_name);
		cst.setCst_birth(cst_birth);
		
		int resultCnt = cstService.insertCst(cst);
		
		if(resultCnt > 0){
			System.out.println("회원가입 성공");
			
		}else {
			System.out.println("회원가입 실패");
		}
	}
	
	//시험접수
	public static void insertRgs(int selectTestNum, List<TestVO> testList, String userId) {
		String testId = null;
		for(int i = 0; i < testList.size();i++) { //접수시험 리스트 선택 ID가져오기
			if((selectTestNum-1) == i) {
				testId = testList.get(i).getTest_id();
			}
		}
		
		int resultCnt = RgsService.insertRgs(testId, userId);
		
		if(resultCnt > 0){
			MainView.print("시험접수 성공");
		}else {
			MainView.print("시험접수 실패");
		}
	}
	
	//접수내역
	public static void selectRgsList(String userId){
		List<RgsVO> rgsList =RgsService.selectRgsList(userId);
		MainView.printSelectRgsList(rgsList);
	}
	
	//성적조회
	public static void selectScoreList(String userId){
		List<ScoreVO> rgsList =ScoreService.selectScoreList(userId);
		MainView.printSelectScoreList(rgsList);
	}
	
}
