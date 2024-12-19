package kr.co.dong.member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고 있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성

	// 초기값 : 파일 문서를 읽어들여서 students에 추가하기
	void init_a() {
		String fileName = "studentList.txt";

		FileReader reader = null;
		BufferedReader br = null;

		try {
			reader = new FileReader(fileName);
			br = new BufferedReader(reader);

			while (true) {
				String str = br.readLine();
				if (str == null)
					break;

				StringTokenizer tokenstr = new StringTokenizer(str, ",");
				
				if(tokenstr.hasMoreTokens()) {
					String name = tokenstr.nextToken();
					String age = tokenstr.nextToken();
					String studentNum = tokenstr.nextToken();
					String major = tokenstr.nextToken();
					
					Student student = new Student(name, age, studentNum, major);
					students.add(student);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("1. 추가, 2. 수정, 3. 삭제, 4. 보기, 기타. 종료");

		return scan.nextLine(); // 입력된 데이터를 리턴
	}

	void studentPlay(String sel) {
		// 화면 메뉴출력 1. 추가 , 2. 수정, 3. 삭제, 4. 보기, 기타. 종료
		switch (sel) {
		case "1": // 추가메소드()
			addStudent();
			break;
		case "2": // 수정메소드()
			updateView();
			break;
		case "3": // 삭제메소드()
			deleteStudent();
			break;
		case "4": // 보기메소드()
			studentView();
			break;
		default:
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
	}

	// 보기 메소드
	void studentView() {
		// 1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");

		boolean run = true;

		while (run) {
			System.out.println("1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
			String sel = scan.nextLine();

			switch (sel) {
			case "1":
				if (!students.isEmpty()) {
					arrayStudents();
				} else {
					noData();
				}
				break;
			case "2":
				if (!students.isEmpty()) {
					searchStudent();
				} else {
					noData();
				}
				break;
			case "3":
				studentExpel.arrayStudentExpel();
				break;
			default:
				run = false;
				break;
			}
		}
	}

	// 추가 메소드
	private void addStudent() {
		while (true) {

			// 정보를 입력받아 students 배열에 추가
			System.out.print("[학생정보 추가] 이름을 입력하세요 : ");
			String name = scan.nextLine();

			System.out.print("[학생정보 추가] 나이를 입력하세요 : ");
			String age = scan.nextLine();

			System.out.print("[학생정보 추가] 학번을 입력하세요 : ");
			String studentNum = scan.nextLine();

			System.out.print("[학생정보 추가] 전공을 입력하세요 : ");
			String major = scan.nextLine();

			Student student = new Student(name, age, studentNum, major);
			students.add(student);
			System.out.println("입력되었습니다.");
			
			FileWriter writer = null;
			String filename = "studentList.txt";
			
			try {
				writer = new FileWriter(filename, true);
					String newLine = System.lineSeparator();
					writer.write(name + "," + age + "," + studentNum + "," + major + newLine);
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		}
	}

	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[학생정보 수정] 학번을 입력하세요 : ");
			studentNum = scan.nextLine();
			index = searchStudents(studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				updateStudent(index); // 수정
				break;
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}

	// 검색 메소드(학번 기준)
	int searchStudents(String studentNum) {
		int index = -1;

		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentNum().equals(studentNum)) {
				index = i;
			}
		}
		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
	}

	// 검색 메소드2
	void searchStudent() {
		int index;
		String studentNum = "";

		System.out.print("학번을 입력하세요 : ");
		studentNum = scan.nextLine();
		index = searchStudents(studentNum);

		if (index >= 0) {
			System.out.println("이름 : " + students.get(index).getName());
			System.out.println("나이 : " + students.get(index).getAge());
			System.out.println("학번 : " + students.get(index).getStudentNum());
			System.out.println("전공 : " + students.get(index).getMajor());
		} else {
			System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요.");
		}
	}

	// 수정 메소드
	boolean updateStudent(int index) {
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공]

		System.out.println("수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공]");
		String sel = scan.nextLine();

		switch (sel) {
		case "1":
			System.out.print("새로운 이름 입력 : ");
			students.get(index).setName(scan.nextLine());
			break;
		case "2":
			System.out.print("새로운 나이 입력 : ");
			students.get(index).setAge(scan.nextLine());
			break;
		case "3":
			System.out.print("새로운 학번 입력 : ");
			students.get(index).setStudentNum(scan.nextLine());
			break;
		case "4":
			System.out.print("새로운 전공 입력 : ");
			students.get(index).setMajor(scan.nextLine());
			break;
		default:
			break;
		}
		return false;
	}

	// 삭제 메소드
	void deleteStudent() {
		while (true) {
			// [학생정보 삭제] 학번을 입력해주세요 :
			System.out.print("[학생정보 삭제] 학번을 입력해주세요 : ");
			String str = scan.nextLine();

			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getStudentNum().equals(str)) {
					studentExpel.addExpelStudents(students.get(i));
					students.remove(i);
				}
			}
			break;
		}
	}

	void arrayStudents() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println("이름 : " + students.get(i).getName());
			System.out.println("나이 : " + students.get(i).getAge());
			System.out.println("학번 : " + students.get(i).getStudentNum());
			System.out.println("전공 : " + students.get(i).getMajor());
			System.out.println("-----");
		}
	}

	void noData() {
		System.out.println("(데이터 없음)");
	}
}
