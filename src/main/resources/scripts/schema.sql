-------------------
-- DELETE DATABASE
-------------------
DROP TABLE PLAYER_CONDITION IF EXISTS
DROP TABLE ABILITY_LEVEL IF EXISTS
DROP TABLE POSITION_RATING IF EXISTS
DROP TABLE PLAYER_PATCH IF EXISTS
DROP TABLE FIELDPOSITION IF EXISTS
DROP TABLE PLAYER IF EXISTS
DROP TABLE PATCH IF EXISTS 


DROP SEQUENCE PATCH_SEQUENCE IF EXISTS
DROP SEQUENCE PLAYER_SEQUENCE IF EXISTS
DROP SEQUENCE CONDITION_SEQUENCE IF EXISTS

-------------------
-- CREATE DATABASE
-------------------

CREATE SEQUENCE PATCH_SEQUENCE START WITH 1 INCREMENT BY 1
CREATE SEQUENCE PLAYER_SEQUENCE START WITH 1 INCREMENT BY 1
CREATE SEQUENCE CONDITION_SEQUENCE START WITH 1 INCREMENT BY 1

--PATCH table
CREATE TABLE PATCH(
	id INTEGER GENERATED BY DEFAULT AS SEQUENCE PATCH_SEQUENCE PRIMARY KEY,
	pesYear INTEGER NOT NULL,
	datapack INTEGER NOT NULL,
	version INTEGER NOT NULL,
	subversion INTEGER NOT NULL
)
-- PLAYER Table
CREATE TABLE PLAYER(
	id INTEGER GENERATED BY DEFAULT AS SEQUENCE PLAYER_SEQUENCE PRIMARY KEY,
	
	pesDbId INTEGER,
	name varchar(50),
	nationality varchar(50)
)
-- POSITION Table
CREATE TABLE FIELDPOSITION(
	id INTEGER PRIMARY KEY,
		
	code Character(3) NOT NULL,
	description VARCHAR(20)
	)	
	
--Condition TABLE
CREATE TABLE PLAYER_CONDITION(
	id INTEGER GENERATED BY DEFAULT AS SEQUENCE CONDITION_SEQUENCE PRIMARY KEY,
		
	playerId INTEGER NOT NULL,	
	condition Character(1) NOT NULL,	
	startDate DATE NOT NULL,	
	FOREIGN KEY (playerId) REFERENCES PLAYER(id)	
)

-- Player in Patch Basic Attributes Table
CREATE TABLE PLAYER_PATCH(
	patchId INTEGER NOT NULL,
	playerId INTEGER NOT NULL,
	
	squatNumber INTEGER,
	team varchar(50),
	league varchar(50),
	region varchar(50),
	height INTEGER,
	weight INTEGER,
	age INTEGER,
	foot varchar(20),
	condition Character(1),
	position varchar(3),
	rating INTEGER,
	FOREIGN KEY (patchId) REFERENCES PATCH(id),
	FOREIGN KEY(playerId) REFERENCES PLAYER(id),
	PRIMARY KEY(patchId,playerId)
);

--Position Table
CREATE TABLE POSITION_RATING(
	patchId INTEGER NOT NULL,
	playerId INTEGER NOT NULL,
	positionId INTEGER NOT NULL,
	
	rating INTEGER,
	FOREIGN KEY (patchId,playerId) REFERENCES PLAYER_PATCH(patchId,playerId),
	FOREIGN KEY (positionId) REFERENCES FIELDPOSITION(id),
	PRIMARY KEY(patchId,playerId,positionId)
)

--Attribute Table
CREATE TABLE ABILITY_LEVEL(
	patchId INTEGER NOT NULL,
	playerId INTEGER NOT NULL,
	level INTEGER NOT NULL,
	
	attackingProwness INTEGER,
	ballControl INTEGER,
	dribbling INTEGER,
	lowPass INTEGER,
	loftedPass INTEGER,
	finishing INTEGER,
	placeKLicking INTEGER,
	swerve INTEGER,
	header INTEGER,
	defensiveProwness INTEGER,
	ballWinning INTEGER,
	kickingPower INTEGER,
	speed INTEGER,
	explosivePower INTEGER,
	unwaveringBalance INTEGER,
	physicalContact INTEGER,
	jump INTEGER,
	goalkeeping INTEGER,
	gkcatch INTEGER,
	clearing INTEGER,
	reflexes INTEGER,
	coverage INTEGER,
	stamina INTEGER,
	weakFootUsage INTEGER,
	weakFootAccuracy INTEGER,
	form INTEGER,
	injuryResistance INTEGER,
	rating INTEGER,
	FOREIGN KEY (patchId,playerId) REFERENCES PLAYER_PATCH(patchId,playerId),
	PRIMARY KEY(patchId,playerId,level)
)
