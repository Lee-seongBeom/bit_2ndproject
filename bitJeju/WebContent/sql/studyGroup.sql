drop table studyGroup;

create table studyGroup(
	classCode number(2),
	className varchar2(100) not null,
	hakbun number(4) ,
	name varchar2(15) not null,
	gradeJava number(3),
	gradeWeb number(3),
	gradeFrame number(3),
	totalDay number(3),
	checkDay number(3),
	missDay number(3),
	tardy number(3),
	rate number(4,1),
	tcode varchar2(2)
);
select * from studyGroup;
insert into studyGroup values (1,'NCS기반의 웹 개발자 양성 과정',1,'user1',90,80,70,90,0,0,0,0,'t1');
insert into studyGroup values (2,'Java기반의 웹 개발자 양성 과정',2,'user2',90,80,70,90,0,0,0,0,'t2');
insert into studyGroup values (3,'인공지능 개발자 양성 과정',3,'user3',90,80,70,90,87,0,0,0,0,'t3');
insert into studyGroup values (1,'NCS기반의 웹 개발자 양성 과정',4,'user4',90,80,70,90,0,0,0,0,'t1');
insert into studyGroup values (3,'인공지능 개발자 양성 과정',5,'user5',90,80,70,90,85,0,0,0,0,'t3');
insert into studyGroup values (2,'Java기반의 웹 개발자 양성 과정',6,'user6',90,80,70,90,0,0,0,0,'t2');
insert into studyGroup values (1,'NCS기반의 웹 개발자 양성 과정',7,'user7',90,80,70,90,0,0,0,0,'t1');
insert into studyGroup values (3,'인공지능 개발자 양성 과정',8,'user8',90,80,70,90,0,0,0,0,'t3');
insert into studyGroup values (2,'Java기반의 웹 개발자 양성 과정',9,'user9',90,80,70,90,0,0,0,0,'t2');
insert into studyGroup values (1,'NCS기반의 웹 개발자 양성 과정',10,'user10',90,80,70,90,0,0,0,0,'t1');
commit

select * from studyGroup;