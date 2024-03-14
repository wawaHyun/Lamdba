--soccer-test.sql

create TABLE stadium(
    stadium_id VARCHAR(10),
    stadium_name VARCHAR(40),
    hometeam_id VARCHAR(10),
    seat_count INT,
    address VARCHAR(60),
    ddd VARCHAR(10),
    tel VARCHAR(10),
    CONSTRAINT stadium_pk PRIMARY KEY (stadium_id)
)DEFAULT CHARSET=utf8;

select * from stadium;

create TABLE team(
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

select * from team;



create TABLE SCHEDULE(
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
select * from SCHEDULE;




create TABLE player(
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

select * from player;

insert into STADIUM values  ('D03','전주월드컵경기장','K05',28000,'전북 전주시 덕진구 반월동  763-1','063','273-1763');
insert into TEAM values  ('K05','전북','현대모터스','CHUNBUK  HYUNDAI MOTORS  FC','1995','D03','560','190',
'전북 전주시 덕진구 반월동 763-1  전주월드컵경기장  내','063','273-1763','273-1762','http://www.hyundai-motorsfc.com','');
insert into SCHEDULE values  ('C02','20120501','Y','K06','K10','2','0');
insert into player values  ('2009175','우르모브','K06','','','2009','DF','4','유고','30-AUG-1987','1','180','70');
commit;


--1- 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
select * from team order by team_name;

--2- 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오
select distinct POSITION from player;

--3- 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
select distinct IFNULL(nullif(POSITION,''),'newone') from player;

--4- 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
select * from player where team_id = 'K02' and POSITION = 'GK';

--004-1 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. (ID 모를 경우)
select * from player where POSITION = 'GK'
and team_id = (select team_id from team where region_name='수원');

--5- 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
select * from player where player_name like '고%' and team_id = 'K02' and height >170;

--005-1 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. (ID를 모를 경우)
select * from player
where player_name like '고%'
and team_id = (select team_id from team t where t.region_name='수원')
and height >170;

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
        -- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.

select * from player
where POSITION ='MF' and (height > 170 and height <180 )
and (team_id =(select team_id
                from team t
                where t.team_name = '삼성블루윙즈')
                       or team_id =(select team_id
                                    from team t
                                    where t.team_name = '드래곤즈'));



-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
select * from player
where POSITION ='GK' and team_id = (
							select team_id
							from team t
							where t.region_name='수원');

-- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오-- 키와 몸무게가 없으면 "0" 으로 표시하시오
-- 키와 몸무게는 내림차순으로 정렬하시오
select player_name,IFNULL(nullif(height,''),0) as height,
IFNULL(nullif(weight,''),0) as weight from player
where team_id=(select team_id
					from team t
					where t.region_name='서울')
order by height, weight;

-- 문제 9-- 서울팀 선수들 이름과 포지션과-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오
-- 단, 키와 몸무게가 없으면 "0" 표시하시오-- BMI는 "NONE" 으로 표시하시오(as bmi)
-- 최종 결과는 이름내림차순으로 정렬하시오
select player_name,
POSITION,
concat(IFNULL(nullif(height,''),0),'cm') as height,
concat(IFNULL(nullif(weight,''),0),'kg') as weight,
IFNULL(((weight/(height*2))*100),'NONE') as BMI
from player
where team_id = (select team_id
                from team t
                where t.region_name='서울')
order by player_name desc;


select player_name,
POSITION,
if (height='', 0, concat(height,'cm')),
if (weight='', 0, concat(weight,'cm')),
IFNULL(((weight/(height*height))*10000),'NONE') as BMI
from player
where team_id = (select team_id
                from team t
                where t.region_name='서울')
order by player_name desc;

--full scan
--4개의 테이블을 모두 조인하시오.
select count(*) as count
from stadium s
	join team t on s.stadium_id = t.stadium_id
	join player p on t.team_id = p.team_id
	join SCHEDULE sc on s.stadium_id = sc.stadium_id;

---- 문제 10
---- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
---- 선수를 출력하시오
---- 단 , 팀명, 선수명 오름차순 정렬하시오.
SELECT *
FROM player
WHERE POSITION = "GK" AND (team_id ="K02" OR team_id ="K10")
ORDER BY team_id= (SELECT team_id FROM team t WHERE t.team_name),
			player_name;

SELECT *
FROM team t
	JOIN player p ON t.team_id = p.team_id
WHERE POSITION = "GK" AND (region_name ="수원" OR region_name ="대전")
ORDER BY region_name;

-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장
SELECT CONCAT_WS(" ",region_name,team_name) AS"팀 명",
		stadium_name  AS "홈구장"
FROM stadium s
	JOIN team t ON s.stadium_id = t.stadium_id;

-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
SELECT *
FROM team t
	JOIN player p ON t.team_id = p.team_id
WHERE height >= 180 AND height < 183
    AND ((region_name ="수원") OR (region_name ="대전"))
ORDER BY height,region_name,player_name;

-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순
SELECT team_name, player_name
FROM team t
	JOIN player p using (team_id)
WHERE p.position = ''
ORDER BY 1, 2;

--스칼라와 조인  사용
 -- 문제 14
-- 홈 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 홈 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.
SELECT t.team_name HOME_TEAM,
		s.stadium_name,
		(SELECT t.team_name
		FROM team t
		WHERE sc.awayteam_id = t.team_id) AWAY_TEAM
FROM stadium s JOIN schedule sc using (stadium_id)
						JOIN team t using (stadium_id)
WHERE sc.sche_date = '20120317' ;

-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
SELECT p.player_name,
		p.position,
		CONCAT(" ",t.region_name,t.team_name) AS "team_name",
		stadium_name,
		sche_date
FROM stadium s JOIN team t ON s.stadium_id = t.stadium_id
					JOIN player p using (team_id)
					JOIN schedule sc using (stadium_id)
WHERE region_name = "포항" and p.position = "GK" AND sc.sche_date = "20120317";

-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
SELECT s.stadium_name,
		 sc.sche_date,
		(SELECT t.team_name FROM team t WHERE sc.awayteam_id = t.team_id) awayteam_name,
		(SELECT t.team_name from team t where sc.hometeam_id = t.team_id) hometeam_name
FROM stadium s JOIN team t using (stadium_id)
					JOIN schedule sc using (stadium_id)
WHERE sc.home_score - sc.away_score >= 3;

-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록 = inner join은 null값이 있는 건 가져오지 못함!
--                                = 그래서 left join이 필요한 것.
-- 카운트 값(결과값)은 19
-- 경기장 이름, 홈팀
-- 힌트 : LEFT JOIN 사용해야함
SELECT s.stadium_name, t.team_name
FROM stadium s LEFT JOIN team t USING(stadium_id);
--scalar 쓴 이쪽이 더 좋은 코드.
SELECT s.stadium_name,
		(SELECT t.team_name FROM team t
		WHERE t.stadium_id = s.stadium_id) team_name
FROM stadium s;

-- 문제 18 플레이어 테이블에서 최상단 5개 로우를 출력
-- 페이지네이션!
SELECT player_name FROM player
order by 1 LIMIT 0,5;

-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.
SELECT t.team_id, t.team_name,
		round(AVG(height),2) avg_hei
FROM team t JOIN player p USING (team_id)
WHERE if(p.height = '',0,p.height)
GROUP BY t.team_id
having AVG(p.height) < (SELECT AVG(height)
								FROM team JOIN player USING(team_id)
								WHERE region_name='인천') ;

-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
SELECT (SELECT team_name FROM team t WHERE p.team_id = t.team_id) AS team_name,
		player_name,
		back_no
 from player p
 WHERE POSITION ="MF" ;

-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키 값이 없으면 제외
SELECT (select team_name FROM team t WHERE p.team_id=t.team_id) '소속팀명',
			player_name '선수명',
			back_no '백넘버'
FROM player p
ORDER BY height DESC LIMIT 5;

-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)
SELECT p.*
FROM player p
JOIN(SELECT p2.team_id, ROUND(AVG(p2.height),2)
		FROM player p2
		WHERE p.height != ''
		GROUP BY p2.team_id) AVG USING (team_id)
WHERE p.height != '' AND p.height < AVG;

-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회
SELECT stadium_name,
		sche_date
FROM stadium s LEFT JOIN schedule sc USING(stadium_id)
WHERE sche_date like '201205%';