--soccer-test.sql

CREATE TABLE stadium(
    stadium_id VARCHAR(10),
    stadium_name VARCHAR(40),
    hometeam_id VARCHAR(10),
    seat_count INT,
    address VARCHAR(60),
    ddd VARCHAR(10),
    tel VARCHAR(10),
    CONSTRAINT stadium_pk PRIMARY KEY (stadium_id)
)DEFAULT CHARSET=utf8;

SELECT * FROM stadium;

CREATE TABLE team(
    team_id VARCHAR(10),
    region_name VARCHAR(10),
    team_name VARCHAR(40),
    e_team_name VARCHAR(50),
    orig_yyyy VARCHAR(10),
    stadium_id VARCHAR(10),
    zip_code1 VARCHAR(10),
    zip_code2 VARCHAR(10),
    address VARCHAR(80),
    ddd VARCHAR(10),
    tel VARCHAR(10),
    fax VARCHAR(10),
    homepage VARCHAR(50),
    OWNER VARCHAR(10),
    CONSTRAINT team_pk PRIMARY KEY (team_id),
    CONSTRAINT team_fk FOREIGN KEY (stadium_id) REFERENCES stadium(stadium_id)
)DEFAULT CHARSET=utf8;

SELECT * FROM team;



CREATE TABLE SCHEDULE(
    stadium_id VARCHAR(10),
    sche_date VARCHAR(10),
    gubun VARCHAR(10),
    hometeam_id VARCHAR(10),
    awayteam_id VARCHAR(10),
    home_score int,
    away_score INT,
    CONSTRAINT schedule_pk PRIMARY KEY (stadium_id,sche_date),
    CONSTRAINT schedule_fk FOREIGN KEY (stadium_id) REFERENCES stadium(stadium_id)
)DEFAULT CHARSET=utf8;
SELECT * FROM SCHEDULE;




CREATE TABLE player(
    player_id VARCHAR(10),
    player_name VARCHAR(20),
    team_id VARCHAR(10),
    e_player_name VARCHAR(40),
    nickname VARCHAR(30),
    join_yyyy VARCHAR(10),
    POSITION VARCHAR(10),
    back_no VARCHAR(10),
    nation VARCHAR(20),
    birth_date VARCHAR(20),
    solar VARCHAR(10),
    height VARCHAR(10),
    weight VARCHAR(10),
    CONSTRAINT player_pk PRIMARY KEY (player_id),
    CONSTRAINT player_fk FOREIGN KEY (team_id) REFERENCES team(team_id)
)DEFAULT CHARSET=utf8;

SELECT * FROM player;

INSERT INTO STADIUM VALUES  ('D03','전주월드컵경기장','K05',28000,'전북 전주시 덕진구 반월동  763-1','063','273-1763');
INSERT INTO TEAM VALUES  ('K05','전북','현대모터스','CHUNBUK  HYUNDAI MOTORS  FC','1995','D03','560','190',
'전북 전주시 덕진구 반월동 763-1  전주월드컵경기장  내','063','273-1763','273-1762','http://www.hyundai-motorsfc.com','');
INSERT INTO SCHEDULE VALUES  ('C02','20120501','Y','K06','K10','2','0');
INSERT INTO player VALUES  ('2009175','우르모브','K06','','','2009','DF','4','유고','30-AUG-1987','1','180','70');
COMMIT;


--1- 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
SELECT * FROM team ORDER BY team_name;

--2- 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오
SELECT DISTINCT POSITION FROM player;

--3- 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
SELECT DISTINCT IFNULL(NULLIF(POSITION,''),'newone') FROM player;

--4- 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
SELECT * FROM player WHERE team_id = 'K02' AND POSITION = 'GK';

--004-1 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. (ID 모를 경우)
SELECT * FROM player WHERE POSITION = 'GK'
AND team_id = (SELECT team_id FROM team WHERE region_name='수원');

--5- 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
SELECT * FROM player WHERE player_name LIKE '고%' and team_id = 'K02' AND height >170;

--005-1 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. (ID를 모를 경우)
SELECT * FROM player
WHERE player_name LIKE '고%'
AND team_id = (SELECT team_id FROM team t WHERE t.region_name='수원')
AND height >170;

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
        -- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.

SELECT * FROM player
WHERE POSITION ='MF' AND (height > 170 AND height <180 )
AND (team_id =(SELECT team_id FROM team t WHERE t.team_name = '삼성블루윙즈')OR team_id =(SELECT team_id FROM team t WHERE t.team_name = '드래곤즈'));



-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
SELECT * FROM player
WHERE POSITION ='GK' AND team_id = (
							SELECT team_id
							FROM team t
							WHERE t.region_name='수원');

-- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오-- 키와 몸무게가 없으면 "0" 으로 표시하시오
-- 키와 몸무게는 내림차순으로 정렬하시오
SELECT player_name,IFNULL(NULLIF(height,''),0) as height,
IFNULL(NULLIF(weight,''),0) as weight from player
WHERE team_id=(SELECT team_id
					FROM team t
					WHERE t.region_name='서울')
ORDER BY height, weight;

-- 문제 9-- 서울팀 선수들 이름과 포지션과-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오
-- 단, 키와 몸무게가 없으면 "0" 표시하시오-- BMI는 "NONE" 으로 표시하시오(as bmi)
-- 최종 결과는 이름내림차순으로 정렬하시오
SELECT player_name,
POSITION,
CONCAT(IFNULL(NULLIF(height,''),0),'cm') as height,
CONCAT(IFNULL(NULLIF(weight,''),0),'kg') as weight,
IFNULL(((weight/(height*2))*100),'NONE') AS BMI
from player
WHERE team_id = (SELECT team_id FROM team t WHERE t.region_name='서울')
ORDER BY player_name DESC;


SELECT player_name,
POSITION,
if (height='', 0, CONCAT(height,'cm')),
if (weight='', 0, CONCAT(weight,'cm')),
IFNULL(((weight/(height*height))*10000),'NONE') AS BMI
from player
WHERE team_id = (SELECT team_id FROM team t WHERE t.region_name='서울')
ORDER BY player_name DESC;