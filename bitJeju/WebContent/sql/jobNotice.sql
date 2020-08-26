DROP TABLE jobNotice;
DROP sequence jobNotice_seq;
CREATE sequence jobNotice_seq start with 1;
CREATE TABLE jobNotice(
    jobNoticeNum    NUMBER(5)	NOT NULL,
    writer	 	VARCHAR2(30)	default '비트캠프',
    title       VARCHAR2(120)	NOT NULL, 
    company     VARCHAR2(90)	NOT NULL, 
    endDay      DATE			NOT NULL,
    contents     VARCHAR2(3000)	NOT NULL
);
insert into jobNotice (jobNoticeNum,title,company,endDay, contents) values (jobNotice_seq.nextval, '한라 소프트웨어 구인공고', '한라 소프트웨어', TO_DATE('2020-08-02', 'RRRR-MM-DD'),'안녕하세요. 한라 소프트에서 자바 백엔드 개발자를 구합니다. 이메일 hanla@hansoft.com으로 이력서 보내주세요');
select * from jobNotice;
commit