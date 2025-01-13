package kr.co.dong.good2;

import java.util.Scanner;

public class GoodsMenu {
	Scanner scan = new Scanner(System.in);
	GoodsControl gc = new GoodsControl();
	
	public void displayMenu() {
		while(true) {
			int n = menuView();
			
			switch(n) {
			case 1 :
				gc.insert(add());
				break;
			case 2:
				gc.update(add(), GoodsId());
				break;
			case 3:
				gc.listAll();
				break;
			case 4:
				gc.selectOne(GoodsId());
				break;
			case 5:
				gc.delete(GoodsId());
				break;
			case 999:
				System.out.println("프로그램을 종료합니다.");
			default:
				System.out.println("번호를 다시 입력해주세요");
			}
		}
	}

	private int GoodsId() {
		System.out.print("상품 번호 입력 : ");
		return Integer.parseInt(scan.nextLine());
	}

	private GoodsBean add() {
		GoodsBean g = null;
		System.out.println("==== 상품 추가 / 수정 ====");
		System.out.print("상품명 : ");
		String name = scan.nextLine();
		System.out.print("상세 설명 : ");
		String gcontent = scan.nextLine();
		System.out.print("수량 : ");
		int gcnt = Integer.parseInt(scan.nextLine());
		System.out.println("부가 설명 : ");
		String getc = scan.nextLine();
		
		g = new GoodsBean(name, gcontent, gcnt, getc);
		return g;
	}

	private int menuView() {
		System.out.println(" ==== 상품 메뉴 ====");
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 정보 수정");
		System.out.println("3. 상품 전체 목록 조회");
		System.out.println("4. 상품 아이디로 조회");
		System.out.println("5. 상품 삭제");
		System.out.println("999. 끝내기");
		System.out.println("==================");
		System.out.print("번호 입력 : ");
		return Integer.parseInt(scan.nextLine());
	}
}
