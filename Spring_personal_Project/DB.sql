SELECT * FROM ALL_TABLES;

DROP TABLE MEMBER;
DROP TABLE POST_FOR_CAFE;
DROP TABLE COMM_FOR_CAFE;

-- MEMBER TABLE
CREATE TABLE MEMBER(
	MID VARCHAR(100) PRIMARY KEY,
	MPW VARCHAR(50) NOT NULL,
	NICKNAME VARCHAR(100) NOT NULL,
	PHONE VARCHAR(50) NOT NULL,
	BIRTH VARCHAR(50) NOT NULL,
	ADDRESS VARCHAR(200) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL,
	ROLE VARCHAR(50) DEFAULT 'USER',
	ACCESSTOKEN VARCHAR(100) DEFAULT 'withpp',
	PROFILEIMAGE VARCHAR(200) DEFAULT 'images/thumnail.png',
	MDATE DATE DEFAULT SYSDATE
);
-- 멤버리스트 불러오기
SELECT * FROM MEMBER ORDER BY MDATE DESC;
-- 회원 정보 불러오기 
SELECT * FROM MEMBER WHERE MID='cohaouo' AND MPW='11';
-- 회원가입
INSERT INTO MEMBER (MID,MPW,NICKNAME,PHONE,BIRTH,ADDRESS,EMAIL) VALUES ('cohaouo','11','코코아','010-3228-6063','1994-03-14','경기도','cohaouo@naver.com');
INSERT INTO MEMBER (MID,MPW,NICKNAME,PHONE,BIRTH,ADDRESS,EMAIL,ROLE) VALUES ('withpp_helper','1004','윗피','010-1004-1004','1994-03-14','withpp','withpp_Admin@withpp.com','ADMIN');
-- 회원정보변경
UPDATE MEMBER SET MPW='12',NICKNAME='COCO',PHONE='010-1234-1234',ADDRESS='서울시',EMAIL='cocoouo@naver.com' WHERE MID='cohaouo';
-- 회원탈퇴
DELETE FROM MEMBER WHERE MID='cohaouo' AND MPW='12';

SELECT * FROM MEMBER WHERE MID=? AND MPW=?
-- 반려견 동반 카페 게시글 TABLE
CREATE TABLE POST_FOR_CAFE(
	PNUM INT PRIMARY KEY,
	MID VARCHAR(100) NOT NULL,
	NICKNAME VARCHAR(100) NOT NULL,
	TITLE VARCHAR(300) NOT NULL,
	THUMNAIL VARCHAR(300) DEFAULT 'images/thumnail.png',
	CONTENT VARCHAR(1500) DEFAULT '내용 미입력',
	LOCADDRESS VARCHAR(200) DEFAULT '주소 미입력',
	LOCCALL VARCHAR(200) DEFAULT '연락처 미입력',
	LOCATION VARCHAR(100) DEFAULT '지역미입력',
	CNT INT DEFAULT 0 NOT NULL,
	HEART VARCHAR(50) DEFAULT 'N' NOT NULL,
	WDATE DATE DEFAULT SYSDATE NOT NULL
	--CONSTRAINT PFCAFE FOREIGN KEY (MID) REFERENCES MEMBER(MID) -- 현 테이블의MID는 MEMBER테이블의MID를 참조 
);
-- 모든 게시글 불러오기 
SELECT * FROM POST_FOR_CAFE ORDER BY PNUM DESC;
-- 게시글 불러오기 
SELECT * FROM POST_FOR_CAFE WHERE PNUM=1 ORDER BY PNUM DESC;
-- 검색 게시글 불러오기 
SELECT * FROM POST_FOR_CAFE WHERE TITLE LIKE '%3%' ORDER BY PNUM DESC; -- TITLE 검색
SELECT * FROM POST_FOR_CAFE WHERE LOCATION LIKE '%경기%' ORDER BY PNUM DESC; -- LOCATION 검색
SELECT * FROM POST_FOR_CAFE WHERE NICKNAME LIKE '%코%' ORDER BY PNUM DESC; -- 작성자 검색 
-- 내가 쓴 게시글 불러오기 
SELECT * FROM POST_FOR_CAFE WHERE MID='cohaouo'ORDER BY PNUM DESC;
-- 게시글 작성
INSERT INTO POST_FOR_CAFE (PNUM,MID,NICKNAME,TITLE,THUMNAIL,CONTENT,LOCADDRESS,LOCCALL,
LOCATION) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM POST_FOR_CAFE),'cohaouo','코코아',
'TEST_01','images/sorry.png','TEST_01','경기도 00시 00로 00','031-123-1234','경기도');
INSERT INTO POST_FOR_CAFE (PNUM,MID,NICKNAME,TITLE,THUMNAIL,CONTENT,LOCADDRESS,LOCCALL,
LOCATION) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM POST_FOR_CAFE),'cohaouo','코코아',
'TEST_02','images/sorry.png','TEST_02','경기도 00시 00로 00','031-123-1234','경기도');
INSERT INTO POST_FOR_CAFE (PNUM,MID,NICKNAME,TITLE,THUMNAIL,CONTENT,LOCADDRESS,LOCCALL,
LOCATION) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM POST_FOR_CAFE),'cohaouo','코코아',
'TEST_03','images/sorry.png','TEST_03','경기도 00시 00로 00','031-123-1234','경기도');
INSERT INTO POST_FOR_CAFE (PNUM,MID,NICKNAME,TITLE,THUMNAIL,CONTENT,LOCADDRESS,LOCCALL,
LOCATION) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM POST_FOR_CAFE),'withpp_helper','윗피',
'TEST_04','images/sorry.png','TEST_04','경기도 00시 00로 00','031-123-1234','경기도');
-- 게시글 수정
UPDATE POST_FOR_CAFE SET NICKNAME='코코아',TITLE='UPDATE_TEST_01',THUMNAIL='/images/thumnail.png',
CONTENT='UPDATE_TEST_01',LOCADDRESS='서울시 00역 00출구',LOCCALL='02-020-0202',LOCATION='서울시'
WHERE PNUM=1;
-- HEART UPDATE
UPDATE POST_FOR_CAFE SET HEART='Y' WHERE PNUM=1;
-- 조회수 증가
UPDATE POST_FOR_CAFE SET CNT=CNT+1 WHERE PNUM=1;
-- 게시글 삭제
DELETE FROM POST_FOR_CAFE WHERE PNUM=4;

-- 반려견 동반 카페 댓글 TABLE
CREATE TABLE COMM_FOR_CAFE(
	CNUM INT PRIMARY KEY,
	PNUM INT NOT NULL,
	MID VARCHAR(100) NOT NULL,
	NICKNAME VARCHAR(100) NOT NULL,
	PROFILEIMAGE VARCHAR(200) DEFAULT 'images/thumnail.png',
	COMM VARCHAR(1000) NOT NULL,
	LIKECNT INT DEFAULT 0,
	CDATE DATE DEFAULT SYSDATE NOT NULL,
	CONSTRAINT CFCAFE FOREIGN KEY (PNUM) REFERENCES POST_FOR_CAFE (PNUM) ON DELETE CASCADE
);

-- 확인용
SELECT * FROM COMM_FOR_CAFE ORDER BY CNUM DESC;

-- 모든 댓글 불러오기 
SELECT * FROM COMM_FOR_CAFE WHERE PNUM=1 ORDER BY CNUM DESC;

-- 댓글 작성
INSERT INTO COMM_FOR_CAFE (CNUM,PNUM,MID,NICKNAME,PROFILEIMAGE,COMM) VALUES 
((SELECT NVL(MAX(CNUM),0)+1 FROM COMM_FOR_CAFE),1,'cohaouo','코코아','images/thumnail.png','COMMENT_TEST_01');

-- 댓글 좋아요 증가 
UPDATE COMM_FOR_CAFE SET LIKECNT=LIKECNT+1 WHERE CNUM=1;

-- 게시글 삭제
DELETE FROM COMM_FOR_CAFE WHERE CNUM>=7 and CNUM<=9;

SELECT * FROM (SELECT ROWNUM AS RNUM, A.PNUM,A.MID,A.NICKNAME,A.TITLE,A.THUMNAIL,A.CONTENT,A.LOC_ADDRESS,A.LOC_CALL,A.LOCATION,A.CNT,A.HEART,A.WDATE FROM (SELECT * FROM POST_FOR_CAFE ORDER BY PNUM DESC) A) WHERE RNUM BETWEEN 1 AND 10;

