drop table stuAssignment;

create table stuAssignment(
	hakbun		number(4),
	name		varchar2(15),
	tcode		varchar2(2),
	classCode	number(2),
	className	varchar2(200),
	applyDate	Date default sysdate,
	temp		number(1) default 1
);
insert into stuAssignment values (1, '홍길동', 't1', 1, '자바클래스', TO_DATE(sysdate , 'RRRR-MM-DD'), 1);
commit