DROP TABLE IF EXISTS RMemberInterests;
DROP TABLE IF EXISTS RMemberPublications;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS Interests;
DROP TABLE IF EXISTS Publications;
DROP TABLE IF EXISTS Members;

CREATE TABLE Members(
  ID INTEGER NOT NULL PRIMARY KEY,
  Name VARCHAR(255) NOT NULL,
  KoreanName VARCHAR(255) NOT NULL,
  Degree VARCHAR(255) NOT NULL,
  Link VARCHAR(255),
  EnterDate DATE NOT NULL,
  Graduated BOOLEAN DEFAULT FALSE,
  GraduatedDate DATE DEFAULT NULL

) Engine = InnoDB;

CREATE TABLE Publications(
  ID INTEGER NOT NULL PRIMARY KEY,
  PublicationType VARCHAR(255) NOT NULL,
  Title VARCHAR(255) NOT NULL,
  MetaData VARCHAR(255) NOT NULL,
  Date DATE NOT NULL
) Engine = InnoDB;

CREATE TABLE Interests(
  ID INTEGER NOT NULL PRIMARY KEY,
  FieldName VARCHAR(255) NOT NULL,
  FieldDesc TEXT
) Engine = InnoDB;

CREATE TABLE Courses(
  ID INTEGER NOT NULL PRIMARY KEY,
  CourseID VARCHAR(255) NOT NULL,
  Title VARCHAR(255) NOT NULL,
  Description TEXT NOT NULL
) Engine = InnoDB;

CREATE TABLE RMemberPublications(
  ID INTEGER NOT NULL PRIMARY KEY,
  PublicationID INTEGER NOT NULL,
  MemberID INTEGER NOT NULL,
  AuthorOrder INTEGER NOT NULL
) Engine = InnoDB;

CREATE TABLE RMemberInterests(
  ID INTEGER NOT NULL PRIMARY KEY,
  InterestID INTEGER NOT NULL,
  MemberID INTEGER NOT NULL
) Engine = InnoDB;

CREATE TABLE SurrogateKeys(
  TableName VARCHAR(255) NOT NULL PRIMARY KEY,
  KeyValue BIGINT NOT NULL
) Engine = InnoDB;

ALTER TABLE RMemberPublications
  ADD CONSTRAINT FK_Publications_ID FOREIGN KEY (PublicationID) REFERENCES Publications(ID),
  ADD CONSTRAINT FK_Members_ID FOREIGN KEY (MemberID) REFERENCES Members(ID);

ALTER TABLE RMemberInterests
  ADD CONSTRAINT FK_Interests_ID FOREIGN KEY (InterestID) REFERENCES Interests(ID),
  ADD CONSTRAINT FK_Interests_Members_ID FOREIGN KEY (MemberID) REFERENCES Members(ID);

/* Feb. 2016 Data */
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (0, 'Sungwon Kang', '강성원', 'prof', null, '1997-01-01', 0, null);
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (1, 'Jungho Kim', '김정호', 'phd', null, '2011-02-01', 0, null);
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (2, 'Hwi Ahn', '안휘', 'phd', null, '2012-03-01', 0, null);
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (3, 'Taehyun Park', '박태현', 'phd', null, '2012-09-03', 0, null);
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (4, 'Jongsun Ahn', '안종선', 'phd', '', '2012-10-31', 0, null);
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (5, 'Pilsu Jung', '정필수', 'phd', null, '2014-03-03', 0, null);
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (6, 'Younghun Han', '한영훈', 'phd', null, '2014-09-01', 0, null);
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (7, 'Gyeongmin Go', '고경민', 'phd', 'http://imarch.pe.kr', '2015-08-31', 0, null);
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (8, 'Jaejun Lee', '이재준', 'ms', null, '2014-09-01', 0, null);
INSERT INTO salab.members (ID, KoreanName, Name, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES (9, 'Taehyun Kim', '김태현', 'ms', null, '2015-03-02', 0, null);

INSERT INTO SurrogateKeys (TableName, KeyValue) VALUES ("Members", 10);


