--PES table

DROP TABLE IF EXISTS Pes
CREATE TABLE Pes(
pesId INTEGER NOT NULL,
pesYear INTEGER NOT NULL,
version INTEGER NOT NULL,
subversion INTEGER NOT NULL,
created TIMESTAMP,
modified TIMESTAMP,
lastUser VARCHAR(20),
PRIMARY KEY (pesId)
)


-- Player Table
drop table if exists Player
CREATE TABLE Player(
pesId INTEGER NOT NULL,
playerId INTEGER NOT NULL,
name varchar(50),
squatNumber INTEGER,
team varchar(50),
league varchar(50),
nationality varchar(50),
region varchar(50),
height INTEGER,
weight INTEGER,
age INTEGER,
foot varchar(20),
condition Character(1),
position varchar(3),
FOREIGN KEY (pesId) REFERENCES Pes(pesId),
PRIMARY KEY(pesId,playerId)
);


--Attribute Table
DROP TABLE IF EXISTS ATTRIBUTE
CREATE TABLE Attribute(
pesId INTEGER NOT NULL,
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
FOREIGN KEY (pesId,playerId) REFERENCES Player(pesId,playerId),
PRIMARY KEY(pesId,playerId,level)
)

--Position Table
DROP TABLE IF EXISTS Position
CREATE TABLE Position(
	pesId INTEGER NOT NULL,
	playerId INTEGER NOT NULL,
	position VARCHAR(3) NOT NULL,
	rating INTEGER,
	FOREIGN KEY (pesId,playerId) REFERENCES Player(pesId,playerId),
	PRIMARY KEY(pesId,playerId,position)
)


--Condition TABLE
DROP TABLE IF EXISTS CONDITION
CREATE TABLE Condition(
	pesId INTEGER NOT NULL,
	playerId INTEGER NOT NULL,
	startDate DATE NOT NULL,
	condition Character(1),
	FOREIGN KEY (pesId,playerId) REFERENCES Player(pesId,playerId),
	PRIMARY KEY(pesId,playerId,condition)
)