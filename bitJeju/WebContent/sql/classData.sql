drop table classData;
drop sequence classData_seq;

create sequence classData_seq start with 1;
create table classData(
   classCode number(2) primary key,
   className varchar2(100) not null,
   teacher varchar2(15) not null,
   tcode varchar2(2),
   max number(3) default 30,
   startDay date not null,
   endDay date not null,
   totalDay number(3),
   filePath varchar2(100)
);
insert into classData (classCode,className,teacher,tcode,startDay,endDay,totalDay,filePath) values (classData_seq.nextval, 'NCS기반의 웹 개발자 양성 과정','설민석','t1',TO_DATE('2020-08-01', 'RRRR-MM-DD'),TO_DATE('2020-10-31', 'RRRR-MM-DD'),90,'img/sub5.jpg');
insert into classData (classCode,className,teacher,tcode,startDay,endDay,totalDay,filePath) values (classData_seq.nextval, 'Java기반의 웹 개발자 양성 과정','정승제','t2',TO_DATE('2020-08-01', 'RRRR-MM-DD'),TO_DATE('2020-10-31', 'RRRR-MM-DD'),90,'img/sub6.png');
insert into classData (classCode,className,teacher,tcode,startDay,endDay,totalDay,filePath) values (classData_seq.nextval, '인공지능 개발자 양성 과정','황현필','t3',TO_DATE('2020-08-01', 'RRRR-MM-DD'),TO_DATE('2020-10-31', 'RRRR-MM-DD'),90,'img/sub4.jpg');
commit