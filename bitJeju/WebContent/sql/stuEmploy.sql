DROP TABLE stuEmploy;
DROP sequence stuEmploy_seq;
CREATE sequence stuEmploy_seq start with 1;
CREATE TABLE stuEmploy(
    stuEmployNum     NUMBER(5)         NOT NULL, 
    title         VARCHAR2(60)      NOT NULL, 
    writer        VARCHAR2(12)      default '비트캠프', 
    writedDate    DATE              NOT NULL, 
    contents      VARCHAR2(3000)
);
insert into stuEmploy (stuEmployNum,title,writedDate,cnt,contents) values (stuEmploy_seq.nextval,'김기철(자바5기) 초귤 소프트 입사!!', TO_DATE('2020-08-01', 'RRRR-MM-DD'), 555, '제주 첫 졸업생 김기철씨 감귤 소프트에 입사했어요!');
select * from stuEmploy;
commit