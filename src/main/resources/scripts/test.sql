SELECT * FROM ABILITY_LEVEL
SELECT * FROM POSITION_RATING
SELECT * FROM PLAYER_DETAIL
SELECT * FROM SCOUT
SELECT * FROM NATIONALITY
SELECT * FROM REGION
SELECT * FROM LEAGUE
SELECT * FROM TEAM
SELECT * FROM PLAYING_STYLE
SELECT * FROM FIELDPOSITION
SELECT * FROM PLAYER 
SELECT * FROM PATCH 
SELECT * FROM SKILL


--BUG WHERE TEAMID WAS NOT SAVED
DELETE FROM ABILITY_LEVEL 
WHERE playerid IN (SELECT PLAYERID FROM PUBLIC.PLAYER_DETAIL  WHERE TEAMID  IS NULL)
DELETE FROM PLAYER_DETAIL WHERE teamid IS NULL

-- To Disconnect DB
shutdown SQL 