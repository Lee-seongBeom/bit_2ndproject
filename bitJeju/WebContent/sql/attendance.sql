drop table attendance;
create table attendance(
	classCode number(2),
	className varchar2(100),
	hakbun number(4),
	name varchar2(15),
	nalja date,
	stuCheck varchar2(9) default '-'
);
commit