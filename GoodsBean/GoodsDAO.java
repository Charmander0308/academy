/*
 * DAO(Data Access Object)
 * : 데이터베이스에 접근하는 클래스(인터페이스)
 * 
 * 1. 상품 전체 목록(조회)
 * 	  List<GoodsBean> listAll();
 * 2. 상품 추가
 * 	  void insert(GoodsBean g);
 * 3. 상품 선택 조회(기본키)
 * 	  GoodsBean selectOne(int gid);		// read(), view(), show() ...
 * 4. 상품 수정
 * 	  void update(GoodsBean g);		// goodsBean
 * 5. 상품 삭제
 * 	  void delete(int gid);
 */
package kr.co.dong.good;

import java.util.List;

public interface GoodsDAO {
//	public abstract : 생략가능
	public abstract List<GoodsBean> listAll();
	void insert(GoodsBean g);
	public GoodsBean selectOne(int gid);
	void update(GoodsBean g);
	void delete(int gid);

}
