package kr.co.dong.member;

public class MemberMain {

	public static void main(String[] args) {
		
		MemberIO mi = new MemberIO();
		String sel = "";
		
		while(!sel.equals("5")) {
			sel = mi.menuView();
			
			mi.memberPlay(sel);
		}
	}
}
