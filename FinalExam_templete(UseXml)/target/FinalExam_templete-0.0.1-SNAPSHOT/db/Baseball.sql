drop table TEAM_TB;
drop table PLAYER_TB;

-- team table create
CREATE TABLE TEAM_TB (
  ID int AUTO_INCREMENT, 
  NAME VARCHAR(50) character set utf8, 
  REGION VARCHAR(50) character set utf8, 
  MANAGER VARCHAR(50) character set utf8, 
  STADIUM VARCHAR(50) character set utf8, 
  LOGO VARCHAR(200), 
  PRIMARY KEY (ID)
);

-- player table create
CREATE TABLE PLAYER_TB (
  ID int AUTO_INCREMENT, 
  TEAMID int, 
  NAME VARCHAR(50) character set utf8, 
  BACKNUMBER int, 
  POSITION VARCHAR(50) character set utf8, 
  HITTING CHAR(1), 
  THROW CHAR(1), 
  PRIMARY KEY (ID) 
);

-- team data insert
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('기아타이거즈', '광주', '김기태', 'KIA챔피언스필드', 'kia.png');
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('넥센히어로즈', '서울', '염경엽', '목동종합운동장 야구장', 'nexen.png');
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('두산베어스', '서울', '김태형', '잠실종합운동장 야구장', 'doosan.png');
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('롯데자이언츠', '부산', '이종운', '부산사직구장', 'lotte.png');
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('삼성라이온즈', '대구', '류중일', '대구시민운동장 야구장', 'samsung.png');
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('SK와이번스', '인천', '김용희', '인천SK행복드림구장', 'sk.png');
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('NC다이노스', '창원', '김경문', '마산종합운동장 야구장', 'nc.png');
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('LG트윈스', '서울', '양상문', '잠실종합운동장 야구장', 'lg.png');
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('KT위즈', '수원', '조범현', '수원KT위즈파크', 'kt.png');
INSERT INTO team_tb (name, region, manager, stadium, logo) VALUES ('한화이글스', '대전', '김성근', '한화생명이글스파크 한밭야구장', 'hanwha.png');

-- player tata insert
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES   (10, '강경학', 14, '내야수', 'L', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(10, '권용관', 13, '내야수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(10, '권혁', 47, '투수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(10, '김경언', 51, '외야수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(10, '김기현', 49, '투수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(6, '고효준', 15, '투수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(6, '김광현', 29, '투수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(6, '김민식', 24, '포수', 'R', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(6, '나주환', 3, '내야수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(6, '김강민', 0, '외야수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(1, '최희섭', 23, '내야수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(1, '임준섭', 11, '투수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(1, '이홍구', 34, '포수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(1, '윤석민', 20, '투수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(1, '나지완', 29, '외야수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(2, '손승락', 1, '투수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(2, '박동원', 27, '포수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(2, '박병호', 52, '내야수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(2, '김하성', 7, '내야수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(2, '이택근', 29, '외야수', 'R', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(3, '유희관', 29, '투수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(3, '장원준', 28, '투수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(3, '김현수', 50, '외야수', 'L', 'R');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(3, '정수빈', 31, '외야수', 'L', 'L');
INSERT INTO player_tb (teamId, name, backNumber, position, hitting, throw) VALUES	(3, '양의지', 25, '포수', 'R', 'R');
