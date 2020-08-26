drop table studata;
drop sequence stuData_seq;
create sequence stuData_seq start with 1;
create table stuData(
   hakbun number(4) primary key,
   name varchar2(15) not null,
   id varchar2(12) not null unique,
   pw varchar2(8) not null,
   phoneNumber varchar2(11),
   lev number(2) default 1 not null,
   classCode number(2),
   gradeJava number(3),
   gradeWeb number(3),
   gradeFrame number(3),
   rate number(4,1),
   tcode varchar2(2) default 'x'
);
insert into stuData (hakbun, name, id, pw, phoneNumber, lev, classCode, gradeJava, gradeWeb, gradeFrame, rate) values (9999,'행정팀1','adminH1','qwer','01011112222',1,11,90,80,70,100);
insert into stuData (hakbun, name, id, pw, phoneNumber, lev, classCode, gradeJava, gradeWeb, gradeFrame, rate) values (9998,'행정팀2','adminH2','qwer','01011112222',1,11,90,80,70,100);
insert into stuData (hakbun, name, id, pw, phoneNumber, lev, classCode, gradeJava, gradeWeb, gradeFrame, rate) values (9997,'행정팀3','adminH3','qwer','01011112222',1,11,90,80,70,100);
insert into stuData (hakbun, name, id, pw, phoneNumber, lev, classCode, gradeJava, gradeWeb, gradeFrame, rate) values (9996,'취업팀1','adminC1','qwer','01011112222',1,11,90,80,70,100);
insert into stuData (hakbun, name, id, pw, phoneNumber, lev, classCode, gradeJava, gradeWeb, gradeFrame, rate) values (9995,'영업팀1','adminY1','qwer','01011112222',1,11,90,80,70,100);
insert into stuData (hakbun, name, id, pw, phoneNumber, lev, classCode, gradeJava, gradeWeb, gradeFrame, rate) values (9994,'영업팀2','adminY2','qwer','01011112222',1,11,90,80,70,100);
insert into stuData (hakbun, name, id, pw, phoneNumber, lev, classCode, gradeJava, gradeWeb, gradeFrame, rate,tcode) values (9993,'설민석','adminT1','qwer','01011112222',1,11,90,80,70,100,'t1');
insert into stuData (hakbun, name, id, pw, phoneNumber, lev, classCode, gradeJava, gradeWeb, gradeFrame, rate,tcode) values (9992,'정승제','adminT2','qwer','01011112222',1,11,90,80,70,100,'t2');
insert into stuData (hakbun, name, id, pw, phoneNumber, lev, classCode, gradeJava, gradeWeb, gradeFrame, rate,tcode) values (9991,'황현필','adminT3','qwer','01011112222',1,11,90,80,70,100,'t3');
commit