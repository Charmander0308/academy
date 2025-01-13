package kr.co.dong.good2;

public class GoodsBean {
	private int gid;
	private String gname;
	private String gcontent;
	private int gcnt;
	private String getc;
	
	public GoodsBean() {
		super();
	}

	
	
	public GoodsBean(String gname, String gcontent, int gcnt, String getc) {
		super();
		this.gname = gname;
		this.gcontent = gcontent;
		this.gcnt = gcnt;
		this.getc = getc;
	}



	public GoodsBean(int gid, String gname, String gcontent, int gcnt, String getc) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gcontent = gcontent;
		this.gcnt = gcnt;
		this.getc = getc;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGcontent() {
		return gcontent;
	}

	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}

	public int getGcnt() {
		return gcnt;
	}

	public void setGcnt(int gcnt) {
		this.gcnt = gcnt;
	}

	public String getGetc() {
		return getc;
	}

	public void setGetc(String getc) {
		this.getc = getc;
	}

	@Override
	public String toString() {
		return "GoodsBean [상품번호 : " + gid + ", 상품명 : " + gname + ", 상품설명 : " + gcontent + ", 상품수량 : " + gcnt + ", 기타정보 : "
				+ getc + "]";
	}
	
	

}
