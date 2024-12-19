package kr.co.dong.member;

import java.util.ArrayList;
import java.util.List;

public class StudentExpel {

	List<Student> expelStudents;

	public StudentExpel() {
		expelStudents = new ArrayList<Student>();
	}

	public void addExpelStudents(Student student) {
		expelStudents.add(new Student(student.getName(), student.getAge(), student.getStudentNum(), student.getMajor()));
		System.out.println(student.getName() + "님의 학생정보가 제거되었습니다");
	}
	
	public void arrayStudentExpel() {
		if(!expelStudents.isEmpty()) {
			for(int i=0; i<expelStudents.size(); i++) {
				System.out.println("이름 : " + expelStudents.get(i).getName());
				System.out.println("나이 : " + expelStudents.get(i).getAge());
				System.out.println("학번 : " + expelStudents.get(i).getStudentNum());
				System.out.println("전공 : " + expelStudents.get(i).getMajor());
				System.out.println("-----");
			}
		} else {
			System.out.println("(삭제된 데이터가 없습니다.)");
		}
	}
}
