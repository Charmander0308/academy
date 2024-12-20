package kr.co.dong.member;

import java.util.Scanner;

public class MemberIO {
	
	Scanner scan = new Scanner(System.in);
	MemberControl mc = new MemberControl();
	
	void init_a() {
		
	}
	
	String menuView() {
		System.out.println("1. 계정 추가, 2. 계정 수정, 3. 계정 삭제, 4. 계정 조회, 기타. 종료");
		System.out.print("> ");
		
		return scan.nextLine();
	}
	
	void memberPlay(String sel) {
		
		switch(sel) {
		case "1" : 
			mc.addMember();
			break;
		case "2" :
			mc.editView();
			break;
		case "3" :
			mc.deleteMember();
			break;
		case "4" :
			mc.searchMember();
			break;
		default :
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
	}
}
