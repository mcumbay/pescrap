drop table if exists Players
-- Player Table
CREATE TABLE Players(
id INTEGER NOT NULL,
position varchar(2),
name varchar(50),
team varchar(50),
nationality varchar(50),
height INTEGER,
weight INTEGER,
age INTEGER,
speed INTEGER,
form INTEGER,
condition Character(1),
rating INTEGER,
PRIMARY KEY(id)
);