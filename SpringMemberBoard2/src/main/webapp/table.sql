create table smember (
id varchar2(15),
password varchar2(10),
name varchar2(15),
age number,
gender varchar2(5),
email varchar2(30),
primary key(id)
);

create table smemberboard2(
num number, // 글번호
id varchar2(20), // 회원아이디
subject varchar2(50), // 제목
content varchar2(2000),
org_file varchar2(50), // 오리지널 파일 이름
up_file varchar2(50), // 실제 업로드 된 파일 이름
re_ref number, // 원글과 답글을 그룹으로 만들기 위한 컬럼 
re_lev number, // 들여쓰기를 하기 위해서 쓰는 컬럼
re_seq number, // 원글과 답글에 대한 순서를 유지하기 위해 사용하는 컬럼
readcount number, // 조회수
boarddate date, // 글쓴 날짜
primary key(num)
);