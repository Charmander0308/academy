package kr.co.dong.member;

import java.util.*;

public class MemberExpel {
	List<Member> memberExpel = new ArrayList();
	ArrayList<String> recordTime = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	Date now = new Date();
	String currentTime = now.toString();

	void addMemberExpel(Member member) {
		memberExpel.add(new Member(member.getId(), member.getPassword(), member.getName(), member.getNickname()));
		recordTime.add(currentTime);
		System.out.println(member.getName() + "님의 정보가 삭제되었습니다.");
	}

	void arrayMemberExpel() {
		if (memberExpel.size() > 0) {
			for (int i = 0; i < memberExpel.size(); i++) {
				System.out.println("ID : " + memberExpel.get(i).getId());
				System.out.println("Password : " + memberExpel.get(i).getPassword());
				System.out.println("이름 : " + memberExpel.get(i).getName());
				System.out.println("닉네임 : " + memberExpel.get(i).getNickname());
				System.out.println("(삭제된 날짜 : " + recordTime.get(i) + " )");
			}
		} else {
			System.out.println("(삭제된 데이터가 없습니다.)");
		}
	}
}
