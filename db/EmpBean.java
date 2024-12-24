/*
 * Table: emp
Columns:
EMPNO int PK 
ENAME varchar(10) 
JOB varchar(9) 
MGR int 
HIREDATE datetime 
SAL double 
COMM double 
DEPTNO int

EmpBean (데이터베이스와 다를 수 있음 : 원하는걸 고를 수 있다)/ 
EmpEntity (데이터베이스와 똑같음) / 
EmpVO / 
EmpDTO (데이터 전달의 개념)

생성자, getter/setter / toString()
 */


package kr.co.dong.jdbc;

public class EmpBean {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hireDate;
	private double sal;
	private double comm;
	private int deptno;
	
	EmpBean() {}

	public EmpBean(int empno, String ename, String job, int mgr, String hireDate, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "EmpBean [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hireDate="
				+ hireDate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	
	
}