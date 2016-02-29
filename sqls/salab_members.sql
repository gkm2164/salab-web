START TRANSACTION;
BEGIN;
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (0, 'Sungwon Kang', 'prof', null, '1997-01-01', 0, null, '강성원');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (1, 'Jungho Kim', 'phd', null, '2011-02-01', 0, null, '김정호');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (2, 'Hwi Ahn', 'phd', null, '2012-03-01', 0, null, '안휘');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (3, 'Jongsun Ahn', 'phd', null, '2012-10-31', 0, null, '안종선');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (4, 'Taehyun Park', 'phd', null, '2012-09-03', 0, null, '박태현');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (5, 'Pilsu Jung', 'phd', null, '2014-03-03', 0, null, '정필수');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (6, 'Younghun Han', 'phd', null, '2014-09-01', 0, null, '한영훈');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (7, 'Gyeongmin Go', 'phd', 'http://imarch.pe.kr', '2015-08-31', 0, null, '고경민');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (8, 'Jaejun Lee', 'ms', null, '2014-09-01', 0, null, '이재준');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (9, 'Taehyun Kim', 'ms', null, '2015-03-02', 0, null, '김태현');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (10, 'Haeun Baek', 'ms', null, '2011-03-01', 1, '2013-02-28', '백하은');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (11, 'Jungmin Kim', 'ms', null, '2011-03-02', 1, '2013-02-28', '김정민');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (12, 'Jihyun Lee', 'external', null, '2009-02-01', 1, null, '이지현');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (13, 'Inhey Kang', 'external', null, '2016-02-26', 1, null, '강인혜');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (14, 'Jin-Young Choi', 'external', null, '2016-02-26', 1, null, '최진영');
INSERT INTO Members (ID, Name, Degree, Link, EnterDate, Graduated, GraduatedDate, KoreanName) VALUES (15, 'Insup Lee', 'external', null, '2016-02-26', 1, null, '이인섭');
COMMIT;