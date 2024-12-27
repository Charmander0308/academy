package kr.co.dong.jdbc;

import java.util.Scanner;

public class IO {
	Scanner scan = new Scanner(System.in);
	EmpDAO dao = new EmpDAO();
	EmpBean eb = new EmpBean();

	void mainView() {
		dao.listAll();
		boolean run = false;

		while (!run) {

			System.out.println("1. 전체조회, 2. 선택조회, 3. 추가, 4. 수정, 5. 삭제");
			System.out.print("원하시는 기능을 선택하세요 > ");
			String sel = scan.nextLine();

			switch (sel) {
			case "1":
				listAllView();
				break;
			case "2":
				selectOneView();
				break;
			case "3":
				insertView();
				break;
			case "4":
				updateView();
				break;
			case "5":
				deleteView();
				break;

			default:
				return;
			}
		}
	}

	void listAllView() {
		for (int i = 0; i < dao.list.size(); i++) {
			System.out.println(dao.list.get(i));
		}
	}

	void selectOneView() {
		System.out.print("조회할 사번을 입력하세요 > ");
		int empno = Integer.parseInt(scan.nextLine());
		System.out.println(dao.selectOne(empno));
	}

	void insertView() {
		System.out.print("추가할 사번 입력 > ");
		int empno = Integer.parseInt(scan.nextLine());
		System.out.print("추가할 사원명 입력 > ");
		String ename = scan.nextLine();
		System.out.print("추가할 직군 입력 > ");
		String job = scan.nextLine();
		System.out.print("추가할 사수번호 입력 > ");
		int mgr = Integer.parseInt(scan.nextLine());
		System.out.print("추가할 입사일 입력(ex : 2000-01-01) > ");
		String hireDate = scan.nextLine();
		System.out.print("추가할 연봉 입력(단위: 0만 원) > ");
		int sal = Integer.parseInt(scan.nextLine());
		System.out.print("추가할 보너스 입력 > ");
		int comm = Integer.parseInt(scan.nextLine());
		System.out.print("추가할 부서번호 입력 > ");
		int deptno = Integer.parseInt(scan.nextLine());

		EmpBean eb = new EmpBean(empno, ename, job, mgr, hireDate, sal, comm, deptno);
		int result = dao.insert(eb);

		if (result == 1) {
			System.out.println("성공적으로 추가되었습니다.");
		} else if (result == 0) {
			System.out.println("추가 실패!!");
		}

	}

	void updateView() {
		System.out.println("1. 사원명, 2. 직군, 3. 사수번호, 4. 입사일, 5. 연봉, 6. 보너스, 7. 부서번호");
		System.out.print("수정할 항목을 선택해주세요 > ");
		String sel = scan.nextLine();
		System.out.print("수정할 사원번호 입력 > ");
		int empno = Integer.parseInt(scan.nextLine());

		eb = dao.selectOne(empno);

		switch (sel) {
		case "1":
			System.out.print("새로운 사원명 입력 > ");
			String ename = scan.nextLine();
			eb.setEname(ename);
			System.out.println("변경되었습니다.");
			break;
		case "2":
			System.out.print("새로운 직군 입력 > ");
			String job = scan.nextLine();
			eb.setJob(job);
			System.out.println("변경되었습니다.");
			break;
		case "3":
			System.out.print("새로운 사수번호 입력 > ");
			int mgr = Integer.parseInt(scan.nextLine());
			eb.setMgr(mgr);
			System.out.println("변경되었습니다.");
			break;
		case "4":
			System.out.print("새로운 고용일 입력 > ");
			String hireDate = scan.nextLine();
			eb.setHireDate(hireDate);
			System.out.println("변경되었습니다.");
			break;
		case "5":
			System.out.print("새로운 연봉 입력 > ");
			double sal = Double.parseDouble(scan.nextLine());
			eb.setSal(sal);
			System.out.println("변경되었습니다.");
			break;
		case "6":
			System.out.print("새로운 보너스 입력 > ");
			double comm = Double.parseDouble(scan.nextLine());
			eb.setComm(comm);
			System.out.println("변경되었습니다.");
			break;
		case "7":
			System.out.print("새로운 부서번호 입력 > ");
			int deptno = Integer.parseInt(scan.nextLine());
			eb.setDeptno(deptno);
			System.out.println("변경되었습니다.");
			break;

		default:
			return;
		}

		int result = dao.update(eb);

		if (result == 1) {
			System.out.println("성공적으로 변경되었습니다.");
		} else if (result == 0) {
			System.out.println("변경 실패!!");
		}
	}

	void deleteView() {
		System.out.print("삭제할 사번을 입력하세요 > ");
		int empno = Integer.parseInt(scan.nextLine());
		int result = dao.delete(empno);

		if (result == 0)
			System.out.println("삭제되었습니다.");
		else if (result == 1)
			System.out.println("삭제 실패!!");

	}
}
