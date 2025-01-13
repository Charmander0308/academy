package kr.co.dong.good2;

import java.util.List;

public class GoodsServiceImp implements GoodsService{
	GoodsDAOImp gsdao = new GoodsDAOImp();

	@Override
	public List<GoodsBean> listAll() {
		gsdao.prnState();
		return gsdao.listAll();
	}

	@Override
	public int insert(GoodsBean g) {
		gsdao.prnState();
		return gsdao.insert(g);
	}

	@Override
	public GoodsBean selectOne(int gid) {
		gsdao.prnState();
		return gsdao.selectOne(gid);
	}

	@Override
	public int update(GoodsBean g) {
		gsdao.prnState();
		return gsdao.update(g);
	}

	@Override
	public int delete(int gid) {
		gsdao.prnState();
		return gsdao.delete(gid);
	}

	@Override
	public void prnState() {
	}


}
