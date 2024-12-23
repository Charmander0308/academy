-- scott 데이터베이스를 사용
use scott;

show tables;

-- emp테이블을 전체 조회
select *
from emp;
-- emp테이블에서 사원번호, 사원명, 급여, 부서번호를 조회
select empno as 사원번호, ename as 사원명, sal, deptno
from scott.emp;

-- emp 테이블에서 사원명과 사원번호, 세금(급여의 5%)을 조회
select empno, ename, sal*0.05 as 세금
from emp;

-- 최고 급여는 얼마????
select max(sal) from emp;
-- 사원수는 몇 명???
select count(empno) from emp;
select count(job) from emp;
select count(comm) from emp;
select count(*) from emp;
-- 급여 합계, 평균급여, 최대급여, 최소급여, 개수 조회
select sum(sal),round(avg(sal),2),max(sal),min(sal),count(*)
from emp;
select sum(sal),avg(sal),max(sal),min(sal),count(*)
from emp;

-- 정렬 order by asc : 오름차순 (desc : 내림차순)
select * from emp
order by empno, ename, sal;

-- [where 조건절 구문]
-- 부서 코드가 10인 사원의 사원명, 사원번호, 직업을 조회
select empno, ename, job, deptno
from emp
where deptno = 10;

-- 월급여가 2500 이상인 사원명, 사원번호, 직업을 조회
select empno, ename, job, sal
from emp
where sal >= 2500;

-- 사원명이 'KING'인 사원의 사원명, 사원번호, 직업을 조회
select ename, empno, job
from emp
where ename = 'KING';

-- 월급여가 1200에서 3000사이의 사원의 사번, 이름, 급여를 조회
select empno, ename, sal
from emp
-- where sal >= 1200 AND sal <= 3000;
where sal between 1200 And 3000;  -- 위랑 같은거

commit; -- 자동반영이라 사용하지 않음(오라클은 사용해야 함)
-- rollback
-- ====> 트랜젝션 : 데이터가 커밋될때까지의 행위(실행)

-- 커미션이 300, 500, 1400인 사원의 사번, 이름, 커미션을 조회
select empno as 사원번호, ename as 사원명, comm as 커미션
from emp
-- where comm = 300 or comm = 500 or comm = 1400;
where comm In(300,500,1400);

-- 직업(job)이 MANAGER이고 부서번호가 30인 사원의 이름, 사번, 직업, 부서번호를 조회alter
select ename as 사원명, empno as 사원번호, job as 직업, deptno as 부서번호
from emp
where job = 'MANAGER' and deptno = 30;

-- 사원명이 'S'자로 시작하는 사원의 사원번호와 이름, 급여, 부서번호를 조회
select ename as 사원명, empno as 사원번호, sal as 급여, deptno as 부서번호
from emp
where ename like 'S%';

-- 사원명에 'S'자를 포함하는 사원의 사원번호와 이름, 급여, 부서번호를 조회
select ename as 사원명, empno as 사원번호, sal as 급여, deptno as 부서번호
from emp
where ename like '%S%';