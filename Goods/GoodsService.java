package kr.co.dong.good2;

import java.util.List;

public interface GoodsService {
	public List<GoodsBean> listAll();
	public int insert(GoodsBean g);
	public GoodsBean selectOne(int gid);
	public int update(GoodsBean g);
	public int delete(int gid);
	public void prnState();

}
