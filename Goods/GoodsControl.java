package kr.co.dong.good2;

import java.util.List;

public class GoodsControl {
	GoodsServiceImp gservice = new GoodsServiceImp();
	GoodsMsg gmsg = new GoodsMsg();
	
	public void listAll() {
		List<GoodsBean> list = gservice.listAll();
		
		if(list.isEmpty()) {
			System.out.println("조회 정보가 없습니다.");
		} else {
			gmsg.goodsViewAll(list);
		}
	}
	
	public void insert(GoodsBean g) {
		int r = gservice.insert(g);
		
		if(r>0) {
			System.out.println("상품 정보 추가 완료");
		} else {
			gmsg.goodErrorMsg("insert");
		}
	}
	
	public void update(GoodsBean gnext, int gid) {
		GoodsBean gp = gservice.selectOne(gid);
		
		if(gp == null) {
			gmsg.goodErrorMsg("selectOne");
			return;
		}
		gmsg.goodsView(gp);
	}
	
	public void selectOne(int gid) {
		GoodsBean g = gservice.selectOne(gid);
		
		if(g == null) {
			gmsg.goodErrorMsg("selectOne");
		} else {
			gmsg.goodsView(g);
		}
	}
	
	public void delete(int gid) {
		int r = gservice.delete(gid);
		
		if(r>0) {
			System.out.println("상품 삭제 완료");
		} else {
			gmsg.goodErrorMsg("delete");
		}
	}
}
