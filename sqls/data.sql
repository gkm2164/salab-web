START TRANSACTION;
BEGIN;
INSERT INTO Members (ID, Name, KoreanName, Degree, Link, EnterDate, Graduated, GraduatedDate)
  VALUES
    (0, 'Sungwon Kang', '강성원', 'prof', null, '1997-01-01', 0, null),
    (1, 'Jungho Kim', '김정호', 'phd', null, '2011-02-01', 0, null),
    (2, 'Hwi Ahn', '안휘', 'phd', null, '2012-03-01', 0, null),
    (3, 'Jongsun Ahn', '안종선', 'phd', null, '2012-10-31', 0, null),
    (4, 'Taehyun Park', '박태현', 'phd', null, '2012-09-03', 0, null),
    (5, 'Pilsu Jung', '정필수', 'phd', null, '2014-03-03', 0, null),
    (6, 'Younghun Han', '한영훈', 'phd', null, '2014-09-01', 0, null),
    (7, 'Gyeongmin Go', '고경민', 'phd', 'http://imarch.pe.kr', '2015-08-31', 0, null),
    (8, 'Jaejun Lee', '이재준', 'ms', null, '2014-09-01', 0, null),
    (9, 'Taehyun Kim', '김태현', 'ms', null, '2015-03-02', 0, null),
    (10, 'Haeun Baek', '백하은', 'ms', null, '2011-03-01', 1, '2013-02-28'),
    (11, 'Jungmin Kim', '김정민', 'ms', null, '2011-03-02', 1, '2013-02-28'),
    (12, 'Jihyun Lee', '이지현', 'external', null, '2009-02-01', 1, null),
    (13, 'Jinhyun Kim', '김진현', 'external', null, '2016-02-26', 1, null),
    (14, 'Inhey Kang', '강인혜', 'external', null, '2016-02-26', 1, null),
    (15, 'Jin-Young Choi' , '최진영', 'external', null, '2016-02-26', 1, null),
    (16, 'Insup Lee', '이인섭','external', null, '2016-02-26', 1, null);

INSERT INTO Publications (ID, PublicationType, Title, MetaData, Date)
  VALUES
    (0, 'INTERNATIONAL_CONFERENCE', 'A Software Binding Application Tool based on the Orthogonal Variability Description Language for Software Product Line Development', 'The 16th ACIS International Conference on Software Engineering, Artificial Intelligence, Networking and Parallel/Distributed Computing (SNPD 2015), Takamatsu, Japan, June 1-3, 2015. (Regular Paper)', '2015-06-01'),
    (1, 'DOMESTIC_CONFERENCE', '사례연구: 기능확장성을 위한 소프트웨어 아키텍처 재설계', '2009 한국 소프트웨어공학 학술대회 (KCSE2009), 2009년 2월 9일 ~ 11일', '2009-02-09'),
    (2, 'INTERNATIONAL_CONFERENCE', 'Systematic Software Product Line Test Case Derivation for Test Data Reuse', 'The 7th IEEE International Workshop on Software Test Automation (STA 2015), Taichung, Taiwan, July 2015. (Regular Paper)', '2015-07-01'),
    (3, 'SCI_JOURNAL', 'Formal Synthesis of Application and Platform Behavior of Embedded Software Systems', 'Journal of Software and Systems Modeling, Vol.14, Issue 2, pp. 839-859, May 2015', '2015-05-01');

INSERT INTO Interests (ID, FieldName, FieldDesc)
  VALUES
    (0, 'Software Product Lines', null),
    (1, 'Software Engineering', null);

INSERT INTO RMemberPublications (ID, PublicationID, MemberID, AuthorOrder)
  VALUES
    (0, 0, 7, 1), (1, 0, 0, 2), (2, 0, 3, 3),
    (3, 1, 1, 1), (4, 1, 0, 2),
    (5, 2, 0, 1), (6, 2, 10, 2), (7, 2, 11, 3), (8, 2, 12, 4),
    (9, 3, 13, 1), (10, 3, 14, 2), (11, 3, 15, 3), (12, 3, 16, 4), (13, 3, 0, 5);

INSERT INTO SurrogateKeys (TableName, KeyValue)
  VALUES
    ('Members', 17),
    ('Publications', 4),
    ('Interests', 2),
    ('RMemberPublications', 14);

COMMIT;