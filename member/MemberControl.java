/*
 * 수정, 삭제, 추가, 조회(전체조회, 선택조회)
 */

package kr.co.dong.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberControl {
	Scanner scan = new Scanner(System.in);
	List<Member> members = new ArrayList<>();
	MemberExpel memberExpel = new MemberExpel();

	void addMember() {
		System.out.print("[계정 추가] ID를 입력하세요 : ");
		String id = scan.nextLine();
		System.out.print("[계정 추가] Password를 입력하세요 : ");
		String password = scan.nextLine();
		System.out.print("[계정 추가] 이름을 입력하세요 : ");
		String name = scan.nextLine();
		System.out.print("[계정 추가] 닉네임을 입력하세요 : ");
		String nickname = scan.nextLine();

		Member member = new Member(id, password, name, nickname);
		members.add(member);
		System.out.println("완료되었습니다.");
	}

	void editView() {
		int index = -1;
		String name = "";

		while (true) {
			System.out.print("[계정 수정]이름을 입력하세요 : ");
			name = scan.nextLine();
			index = searchMemberIndex(name);
			if (index >= 0) {
				editMember(index);
				break;
			} else {
				System.out.println("회원정보가 없습니다. 다시 입력해주세요.");
			}
		}
	}

	void editMember(int index) {
		System.out.println("수정할 항목 선택 [1. ID][2. Password][3. 이름][4. 닉네임]");
		String sel = scan.nextLine();

		switch (sel) {
		case "1":
			System.out.print("새로운 ID 입력 : ");
			String id = scan.nextLine();
			members.get(index).setId(id);
			System.out.println("수정되었습니다.");
			break;
		case "2":
			System.out.print("새로운 Password 입력 : ");
			String pw = scan.nextLine();
			members.get(index).setId(pw);
			System.out.println("수정되었습니다.");
			break;
		case "3":
			System.out.print("새로운 이름 입력 : ");
			String name = scan.nextLine();
			members.get(index).setId(name);
			System.out.println("수정되었습니다.");
			break;
		case "4":
			System.out.print("새로운 닉네임 입력 : ");
			String nickname = scan.nextLine();
			members.get(index).setId(nickname);
			System.out.println("수정되었습니다.");
			break;
		}
	}

	void deleteMember() {
		System.out.print("[계정 삭제] 이름을 입력해주세요 : ");
		String name = scan.nextLine();
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {
				memberExpel.addMemberExpel(members.get(i));
				members.remove(i);
			}
		}
	}

	void searchMember() {
		boolean run = true;
		while (run) {

			System.out.println("1. 전체조회, 2. 선택조회, 3. 삭제내역조회, 기타. 메뉴");
			switch (scan.nextLine()) {
			case "1":
				searchMemberAll();
				break;
			case "2":
				searchMemberSelect();
				break;
			case "3":
				memberExpel.arrayMemberExpel();
			default:
				run = false;
				break;
			}
		}
	}

	void searchMemberAll() {
		if (members.size() > 0) {
			for (int i = 0; i < members.size(); i++) {
				System.out.println("ID : " + members.get(i).getId());
				System.out.println("Password : " + members.get(i).getPassword());
				System.out.println("이름 : " + members.get(i).getName());
				System.out.println("닉네임 : " + members.get(i).getNickname());
				System.out.println("------");
			}
		} else {
			System.out.println("(등록된 데이터가 없습니다.)");
		}
	}

	void searchMemberSelect() {
		if (members.size() > 0) {
			System.out.print("[계정 조회] 이름을 입력하세요 : ");
			int index = searchMemberIndex(scan.nextLine());
			if (index >= 0) {
				System.out.println("ID : " + members.get(index).getId());
				System.out.println("Password : " + members.get(index).getPassword());
				System.out.println("이름 : " + members.get(index).getName());
				System.out.println("닉네임 : " + members.get(index).getNickname());
			} else {
				System.out.println("조회되는 정보가 없습니다. 다시 입력해주세요.");
			}
		} else {
			System.out.println("(등록된 데이터가 없습니다.)");
		}
	}

	int searchMemberIndex(String name) {
		int index = -1;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}

}
