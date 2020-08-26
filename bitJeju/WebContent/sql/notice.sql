DROP TABLE notice;
DROP sequence notice_seq;
CREATE sequence notice_seq start with 1;
CREATE TABLE notice(
    noticeNum     NUMBER(5)         NOT NULL, 
    title         VARCHAR2(60)      NOT NULL, 
    writer        VARCHAR2(12)      default '비트캠프', 
    writedDate    DATE              DEFAULT SYSDATE, 
    cnt           NUMBER(4)         DEFAULT 1, 
    contents      VARCHAR2(3000)
);
insert into notice (noticeNum,title,writedDate,cnt,contents) values (notice_seq.nextval,'첫 공지', TO_DATE('2020-08-01', 'RRRR-MM-DD'), 500, '안녕하세요. 첫 공지사항입니다');
select * from notice;
commit

--update notice set cnt=cnt+1 where noticeNum=1;
--select * from notice where noticeNum = 1;
--select * from notice where noticeNum = 1;