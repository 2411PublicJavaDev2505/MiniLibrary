CREATE TABLE book
(
    Book_No    NUMBER Primary key,
    Book_Name    VARCHAR2(100) NOT NULL,
    Book_Writer    VARCHAR2(50) NOT NULL,
    Book_Price    NUMBER NOT NULL,
    publisher    VARCHAR2(30) NOT NULL,
    genre    VARCHAR2(30) NOT NULL
);
COMMENT ON COLUMN book.Book_No IS '책번호';
COMMENT ON COLUMN book.Book_Name IS '제목';
COMMENT ON COLUMN book.Book_Writer IS '글쓴이';
COMMENT ON COLUMN book.Book_Price IS '가격';
COMMENT ON COLUMN book.publisher IS '출판사';
COMMENT ON COLUMN book.genre IS '장르';
COMMENT ON TABLE book IS '책';


DROP TABLE customer;
CREATE TABLE customer
(
    user_No    NUMBER NOT NULL,
    User_Id    VARCHAR2(20) PRIMARY KEY,
    user_Name    VARCHAR2(20) NOT NULL,
    user_Age    NUMBER NOT NULL,
    Addr    VARCHAR2(100) NOT NULL,
    Gender    CHAR(1) CHECK(GENDER IN('M','F')),
    Enroll_Date    DATE DEFAULT SYSDATE
);

COMMENT ON COLUMN customer.user_No IS '고객번호';
COMMENT ON COLUMN customer.User_Id IS '고객아이디';
COMMENT ON COLUMN customer.user_Name IS '이름';
COMMENT ON COLUMN customer.user_Age IS '나이';
COMMENT ON COLUMN customer.Addr IS '주소';
COMMENT ON COLUMN customer.Gender IS '성별';
COMMENT ON COLUMN customer.Enroll_Date IS '가입일';
COMMENT ON TABLE customer IS '고객';

DROP TABLE library;
CREATE TABLE library
(
    Lease_No    NUMBER Primary key,
    Book_No    NUMBER NOT NULL,
    User_Id    VARCHAR2(20) NOT NULL,
    Lease_date    DATE DEFAULT SYSDATE,
    Return_date    DATE NOT NULL,
    FOREIGN KEY (Book_NO) REFERENCES book (Book_NO) ON DELETE CASCADE,
    FOREIGN KEY (User_Id) REFERENCES customer (User_Id) ON DELETE CASCADE
);
COMMENT ON COLUMN library.Lease_No IS '대여번호';
COMMENT ON COLUMN library.Book_No IS '책번호';
COMMENT ON COLUMN library.Lease_date IS '대여일';
COMMENT ON COLUMN library.Return_date IS '반납일';
COMMENT ON COLUMN library.User_Id IS '고객아이디';
COMMENT ON TABLE library IS '도서관';

CREATE SEQUENCE SEQ_BOOK_NO
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_USER_NO
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_LIBRARY_NO
NOCYCLE
NOCACHE;


INSERT INTO book VALUES (SEQ_BOOK_NO.NEXTVAL,'마이러브','이충호',4500,'서울문화사','코믹/순정');
INSERT INTO book VALUES (SEQ_BOOK_NO.NEXTVAL,'떳다 럭키맨','나베시마 오사무',4500,'코믹출판사','코믹');
INSERT INTO book VALUES (SEQ_BOOK_NO.NEXTVAL,'만만하게 보이지 않는 대화법','나이토 요시히토',12800,'홍익출판사','심리기술');
INSERT INTO book VALUES (SEQ_BOOK_NO.NEXTVAL,'열혈강호','전극진',4500,'대원씨아이','무협');
INSERT INTO book VALUES (SEQ_BOOK_NO.NEXTVAL,'고스트바둑왕','카미야 쥰',5000,'점프','드라마');

INSERT INTO customer VALUES (SEQ_USER_NO.NEXTVAL,'user11','홍길동',20,'서울특별시 관악구 관악로 145(봉천동) 123-33 1층','M','15/01/27');
INSERT INTO customer VALUES (SEQ_USER_NO.NEXTVAL,'khlove','김경호',30,'인천광역시 남동구 정각로 29(구월동) 23-4 205호','F','12/03/11');
INSERT INTO customer VALUES (SEQ_USER_NO.NEXTVAL,'hakgugu','김학구',40,'경기도 부천시 길주로 210(중동) 99-1 101호','M','16/03/24');
INSERT INTO customer VALUES (SEQ_USER_NO.NEXTVAL,'javakim','김자바',53,'서울특별시 종로구 청와대로 1 49-4 602호','F','17/02/25');
INSERT INTO customer VALUES (SEQ_USER_NO.NEXTVAL,'dbmaster','천디비',19,'서울시 마포구 성암로 267 52-33 4층','M','18/03/01');

INSERT INTO library VALUES(SEQ_LIBRARY_NO.NEXTVAL,2,'user11','18/04/01','18/04/03');
INSERT INTO library VALUES(SEQ_LIBRARY_NO.NEXTVAL,3,'khlove','18/04/02','18/04/04');
INSERT INTO library VALUES(SEQ_LIBRARY_NO.NEXTVAL,4,'javakim','18/04/05','18/04/07');
INSERT INTO library VALUES(SEQ_LIBRARY_NO.NEXTVAL,1,'dbmaster','18/04/07','18/04/09');
commit;


DESC book;
DESC customer;
DESC library;


SELECT * FROM book;
SELECT * FROM customer;
SELECT * FROM library;


SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_BOOK_NO
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_LIBRARY_NO
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_USER_NO
NOCYCLE
NOCACHE;

DROP SEQUENCE SEQ_USER_NO;
DROP SEQUENCE SEQ_LIBRARY_NO;
DROP SEQUENCE SEQ_BOOK_NO;

DROP TABLE LIBRARY;
DROP TABLE CUSTOMER;
DROP TABLE BOOK;

SELECT * FROM LIBRARY;
SELECT * FROM CUSTOMER;
SELECT * FROM BOOK;

SELECT L.LEASE_NO, L.BOOK_NO, L.USER_ID, L.LEASE_DATE, L.RETURN_DATE , B.BOOK_NAME, C.USER_NAME
FROM LIBRARY L
JOIN CUSTOMER C ON L.USER_ID = C.USER_ID
JOIN BOOK B ON L.BOOK_NO = B.BOOK_NO;

SELECT COUNT(*) FROM CUSTOMER;

SELECT COUNT(*) FROM CUSTOMER;




