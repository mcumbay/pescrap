----------------------------------------------------------------------------------
-- INITIAL DATA
----------------------------------------------------------------------------------
-- PATCHS
INSERT INTO PATCH (PESYEAR, DATAPACK, VERSION, SUBVERSION) VALUES(2020, 8, 1, 8);
-- POSITIONS
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(0, 'GK ', 'Goalkeeper');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(1, 'CB ', 'Centre Back');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(2, 'LB ', 'Left Back');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(3, 'RB ', 'Right Back');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(4, 'DMF', 'Defensive Midfielder');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(5, 'CMF', 'Centre Midfielder');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(6, 'LMF', 'Left Midfielder');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(7, 'RMF', 'Right Midfielder');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(8, 'AMF', 'Attacking Midfielder');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(9, 'LWF', 'Left Wing Forward');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(10, 'RWF', 'Right Wing Forward');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(11, 'SS ', 'Second Striker');
INSERT INTO FIELDPOSITION(ID, CODE, DESCRIPTION) VALUES(12, 'CF ', 'Centre Forward');
-- PLAYING STYLES
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(1, 'Goal Poacher', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(2, 'Dummy Runner', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(3, 'Fox in the Box', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(4, 'Prolific Winger', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(5, 'Classic No. 10', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(6, 'Hole Player', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(7, 'Box-to-Box', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(8, 'Anchor Man', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(9, 'The Destroyer', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(10, 'Extra Frontman', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(11, 'Offensive Full-back', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(12, 'Defensive Full-back', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(13, 'Target Man', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(14, 'Creative Playmaker', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(15, 'Build Up', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(16, 'Offensive Goalkeeper', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(17, 'Defensive Goalkeeper', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(18, 'Roaming Flank', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(19, 'Cross Specialist', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(20, 'Orchestrator', '');
INSERT INTO PLAYING_STYLE(ID, NAME, DESCRIPTION) VALUES(21, 'Full-back Finisher', '');
-- SKILLS
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(0, 'Scissors Feint', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(1, 'Double Touch', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(2, 'Flip Flap', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(3, 'Marseille Turn', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(4, 'Sombrero', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(5, 'Cross Over Turn', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(6, 'Cut Behind & Turn', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(7, 'Scotch Move', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(8, 'Step On Skill control', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(9, 'Heading', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(10, 'Long Range Drive', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(11, 'Chip shot control', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(12, 'Knuckle Shot', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(13, 'Dipping Shot', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(14, 'Rising Shots', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(15, 'Acrobatic Finishing', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(16, 'Heel Trick', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(17, 'First-time Shot', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(18, 'One-touch Pass', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(19, 'Weighted Pass', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(20, 'Pinpoint Crossing', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(21, 'Outside Curler', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(22, 'Rabona', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(23, 'No Look Pass', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(24, 'Low Lofted Pass', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(25, 'GK Low Punt', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(26, 'GK High Punt', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(27, 'Long Throw', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(28, 'GK Long Throw', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(29, 'Penalty Specialist', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(30, 'GK Penalty Saver', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(31, 'Malicia', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(32, 'Man Marking', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(33, 'Track Back', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(34, 'Interception', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(35, 'Acrobatic Clear', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(36, 'Captaincy', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(37, 'Super-sub', '');
INSERT INTO SKILL(ID, NAME, DESCRIPTION) VALUES(38, 'Fighting Spirit', '');

