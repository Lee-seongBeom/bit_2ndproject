DROP TABLE StuEmploy;
DROP sequence StuEmploy_seq;
CREATE sequence StuEmploy_seq start with 1;
CREATE TABLE StuEmploy(
    StuEmployNum     NUMBER(5)         NOT NULL, 
    title         VARCHAR2(60)      NOT NULL, 
    writer        VARCHAR2(12)      default '비트캠프', 
    writedDate    DATE              NOT NULL, 
    cnt           NUMBER(4)         DEFAULT 1, 
    contents      VARCHAR2(3000)
);
insert into StuEmploy (StuEmployNum,title,writedDate,cnt,contents) values (StuEmploy_seq.nextval,'김기철(자바5기) 초귤 소프트 입사!!', TO_DATE('2020-08-01', 'RRRR-MM-DD'), 555, '제주 첫 졸업생 김기철씨 감귤 소프트에 입사했어요!');
insert into StuEmploy (StuEmployNum,title,writedDate,cnt,contents) values (StuEmploy_seq.nextval,'김기철(자바4기) 중귤 소프트 입사!!', TO_DATE('2020-08-01', 'RRRR-MM-DD'), 555, '제주 첫 졸업생 김기철씨 감귤 소프트에 입사했어요!');
insert into StuEmploy (StuEmployNum,title,writedDate,cnt,contents) values (StuEmploy_seq.nextval,'김기철(자바3기) 고귤 소프트 입사!!', TO_DATE('2020-08-01', 'RRRR-MM-DD'), 555, '제주 첫 졸업생 김기철씨 감귤 소프트에 입사했어요!');
insert into StuEmploy (StuEmployNum,title,writedDate,cnt,contents) values (StuEmploy_seq.nextval,'김기철(자바2기) 대귤 소프트 입사!!', TO_DATE('2020-08-01', 'RRRR-MM-DD'), 555, '제주 첫 졸업생 김기철씨 감귤 소프트에 입사했어요!');
insert into StuEmploy (StuEmployNum,title,writedDate,cnt,contents) values (StuEmploy_seq.nextval,'김기철(자바1기) 감귤 소프트 입사!!', TO_DATE('2020-08-01', 'RRRR-MM-DD'), 555, '제주 첫 졸업생 김기철씨 감귤 소프트에 입사했어요!');
select * from StuEmploy;
commit