package kr.co.dong.good2;

import java.util.List;

public class GoodsMsg {
	public void goodErrorMsg(String msg) {
		switch(msg) {
		case "insert":
			System.out.println("상품정보 추가 실패");
			break;
		case "update":
			System.out.println("상품정보 수정 실패");
			break;
		case "selectOne":
			System.out.println("상품 정보가 없습니다.");
			break;
		case "delete":
			System.out.println("상품 정보 삭제 실패");
			break;
		default:
			System.out.println("오류를 찾을 수 없습니다.");
		}
	}
	
	public void goodsViewAll(List<GoodsBean> list) {
		System.out.println(">====== 상품 전체 목록 조회 =====");
		for(GoodsBean g : list) {
			System.out.println(g);
		}
	}
	
	public void goodsView(GoodsBean g) {
		System.out.println(">==== 상품 조회 =====");
		System.out.println(g);
	}
}
