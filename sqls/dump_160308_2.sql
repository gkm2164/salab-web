-- MySQL dump 10.13  Distrib 5.7.10, for Win64 (x86_64)
--
-- Host: localhost    Database: SALab
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `activities`
--

DROP TABLE IF EXISTS `activities`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activities` (
  `ID`       INT(11)      NOT NULL,
  `Title`    VARCHAR(255) NOT NULL,
  `Contents` TEXT         NOT NULL,
  `Date`     DATE         NOT NULL,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coursecodes`
--

DROP TABLE IF EXISTS `coursecodes`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursecodes` (
  `ID`       INT(11)     NOT NULL,
  `CourseID` INT(11)     NOT NULL,
  `Code`     VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CourseCodes_CourseID` (`CourseID`),
  CONSTRAINT `FK_CourseCodes_CourseID` FOREIGN KEY (`CourseID`) REFERENCES `courses` (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursecodes`
--

LOCK TABLES `coursecodes` WRITE;
/*!40000 ALTER TABLE `coursecodes` DISABLE KEYS */;
INSERT INTO `coursecodes` VALUES (0, 0, 'CS552'), (1, 0, 'SEP531');
/*!40000 ALTER TABLE `coursecodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `ID`          INT(11)      NOT NULL,
  `CourseType`  VARCHAR(50)  NOT NULL,
  `Title`       VARCHAR(255) NOT NULL,
  `Description` TEXT         NOT NULL,
  `Link`        TEXT         NOT NULL,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (0, 'GRADUATE', 'Models of Software Systems',
                              'Computer Scientists have long investigated the problem of how to automate software development from its specification to its program. So far the efforts were not fully successful but much of the results can be fruitfully applied to development of small programs and critical small portions of large programs. In this course, we learn how to formally write requirements, how to formally model specifications and how to rigorously verify that the models have the required properties.',
                              'http://klms.kaist.ac.kr');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interests`
--

DROP TABLE IF EXISTS `interests`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interests` (
  `ID`        INT(11)      NOT NULL,
  `FieldName` VARCHAR(255) NOT NULL,
  `FieldDesc` TEXT,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interests`
--

LOCK TABLES `interests` WRITE;
/*!40000 ALTER TABLE `interests` DISABLE KEYS */;
INSERT INTO `interests`
VALUES (0, 'Software Engineering', NULL), (1, 'Software Architecture', NULL), (2, 'Software Product Lines', NULL),
  (3, 'Software Testing', NULL), (4, 'Model-Driven Development', NULL), (5, 'Formal Methods', NULL),
  (6, 'Service-Oriented Architecture', NULL), (7, 'Measuring Quality based on Software Architecture', NULL),
  (8, 'Evaluation of Software Architecture Software System', NULL), (9, 'Construction of Software Architecture', NULL);
/*!40000 ALTER TABLE `interests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `ID`            INT(11)      NOT NULL,
  `Name`          VARCHAR(255) NOT NULL,
  `KoreanName`    VARCHAR(255) NOT NULL,
  `Degree`        VARCHAR(255) NOT NULL,
  `Link`          VARCHAR(255) DEFAULT NULL,
  `EnterDate`     DATE         NOT NULL,
  `Graduated`     TINYINT(1)   DEFAULT '0',
  `GraduatedYear` INT(11)      DEFAULT NULL,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (0, 'Sungwon Kang', '강성원', 'prof', NULL, '1997-01-01', 0, NULL),
  (1, 'Jungho Kim', '김정호', 'phd', NULL, '2011-02-01', 0, NULL),
  (2, 'Hwi Ahn', '안휘', 'phd', NULL, '2012-03-01', 0, NULL),
  (3, 'Jongsun Ahn', '안종선', 'phd', NULL, '2012-10-31', 0, NULL),
  (4, 'Taehyun Park', '박태현', 'phd', NULL, '2012-09-03', 0, NULL),
  (5, 'Pilsu Jung', '정필수', 'phd', NULL, '2014-03-03', 0, NULL),
  (6, 'Younghun Han', '한영훈', 'phd', NULL, '2014-09-01', 0, NULL),
  (7, 'Gyeongmin Go', '고경민', 'phd', 'http://imarch.pe.kr', '2015-08-31', 0, NULL),
  (8, 'Jaejun Lee', '이재준', 'ms', NULL, '2014-09-01', 0, NULL),
  (9, 'Taehyun Kim', '김태현', 'ms', NULL, '2015-03-02', 0, NULL),
  (10, 'Haeun Baek', '백하은', 'ms', NULL, '2011-03-01', 1, 2013),
  (11, 'Jungmin Kim', '김정민', 'ms', NULL, '2011-03-02', 1, 2013),
  (12, 'Jihyun Lee', '이지현', 'external', NULL, '2009-02-01', 1, NULL),
  (13, 'Jinhyun Kim', '김진현', 'external', NULL, '2016-02-26', 1, NULL),
  (14, 'Inhey Kang', '강인혜', 'external', NULL, '2016-02-26', 1, NULL),
  (15, 'Jin-Young Choi', '최진영', 'external', NULL, '2016-02-26', 1, NULL),
  (16, 'Insup Lee', '이인섭', 'external', NULL, '2016-02-26', 1, NULL),
  (17, 'Seokhwan Eom', '엄석환', 'ms', NULL, '2010-01-01', 1, 2012),
  (18, 'Jinkyu Kim', '김진규', 'phd', NULL, '2012-02-15', 1, 2012),
  (19, 'Seonah Lee', '이선아', 'dr', NULL, '2010-08-01', 1, 2016),
  (25, 'Hamad Alsawalqah', '하마드', 'phd', '', '2008-01-01', 1, 2014),
  (26, 'Sangyup Han', '한상엽', 'external', '', '2016-03-04', 0, NULL),
  (27, 'Ben Lee', '벤리', 'external', '', '2016-03-04', 0, NULL),
  (28, 'Hoseung Shin', '신호승', 'external', '', '2016-03-07', 0, NULL),
  (29, 'Heuijin Lee', '이희진', 'ms', '', '2012-09-01', 1, 2014),
  (30, 'Changsub Keum', '금창섭', 'phd', '', '2008-01-01', 1, 2014),
  (31, 'Danhyung Lee', '이단형', 'external', '', '2016-03-04', 0, NULL),
  (32, 'Myungchul Kim', '김명철', 'external', '', '2016-12-31', 0, NULL),
  (33, 'Sunghun Kim', '김성훈', 'external', '', '2016-03-04', 0, NULL),
  (34, 'Matt Staats', '', 'external', '', '2016-03-04', 0, NULL),
  (35, 'Kyungmin Go', '고경민', 'external', '', '2016-12-31', 0, NULL),
  (36, 'Jongmoon Baik', '백종문', 'external', '', '2016-12-31', 0, NULL);
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publications`
--

DROP TABLE IF EXISTS `publications`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publications` (
  `ID`              INT(11)      NOT NULL,
  `PublicationType` VARCHAR(255) NOT NULL,
  `Title`           VARCHAR(255) NOT NULL,
  `MetaData`        TEXT         NOT NULL,
  `Date`            DATE         NOT NULL,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publications`
--

LOCK TABLES `publications` WRITE;
/*!40000 ALTER TABLE `publications` DISABLE KEYS */;
INSERT INTO `publications` VALUES (0, 'INTERNATIONAL_CONFERENCE',
                                   'A Software Binding Application Tool based on the Orthogonal Variability Description Language for Software Product Line Development',
                                   'The 16th ACIS International Conference on Software Engineering, Artificial Intelligence, Networking and Parallel/Distributed Computing (SNPD 2015), Takamatsu, Japan, June 1-3, 2015. (Regular Paper)',
                                   '2015-06-01'),
  (1, 'DOMESTIC_CONFERENCE', '사례연구: 기능확장성을 위한 소프트웨어 아키텍처 재설계', '2009 한국 소프트웨어공학 학술대회 (KCSE2009), 2009년 2월 9일 ~ 11일', '2009-02-09'),
  (2, 'INTERNATIONAL_CONFERENCE', 'Systematic Software Product Line Test Case Derivation for Test Data Reuse', 'The 7th IEEE International Workshop on Software Test Automation (STA 2015), Taichung, Taiwan, July 2015. (Regular Paper)', '2015-07-01'),
  (3, 'SCI_JOURNAL', 'Formal Synthesis of Application and Platform Behavior of Embedded Software Systems', 'Journal of Software and Systems Modeling, Vol.14, Issue 2, pp. 839-859, May 2015', '2015-05-01'),
  (4, 'DOMESTIC_JOURNAL', '소프트웨어 제품 라인의 요구사항과 아키텍처 간 추적성 모델링', '한국정보처리학회 논문지 - 소프트웨어 및 데이터 공학 - 제4권 제11호, pp. 487-498, 2015년 11월.', '2015-11-01'),
  (5, 'SCI_JOURNAL', 'The Impact of View Histories on Edit Recommendations', 'IEEE Transactions on Software Engineering, Vol. 41, Issue 3, pp. 314-330, March 2015.', '2015-03-01'),
  (9, 'SCI_JOURNAL', 'Fast Directional Handoff and Lightweight Retransmission Protocol for Enhancing Multimedia Quality in Indoor WLANs', 'Computer Networks, Volume: 79, Issue: 3, pp. 133~147, March 2015.', '2015-03-01'),
  (10, 'DOMESTIC_CONFERENCE', '소프트웨어 아키텍처를 통한 시스템 기능확장성 측정에 관한 연구', '한국IT서비스학회 추계학술대회, 2007.11.21.', '2007-11-21'),
  (11, 'DOMESTIC_CONFERENCE', 'FSP Model을 이용한 C&C View 아키텍처의 검증', '한국IT서비스학회 추계학술대회, 2006.11.15.', '2006-11-15'),
  (12, 'INTERNATIONAL_CONFERENCE', 'A Case Study of Global Software Development with A-SQUARE Project', 'The 11th IEEE Int\'l Conf. on Computer and Information Science (ICIS 2012), Shanghai, China, May 30 - June 1, 2012.', '2012-05-30'),
  (13, 'DOMESTIC_JOURNAL', '확장형 실시간 데이터 파이프라인 시스템 아키텍처 설계', '한국정보과학회 논문지 제42권 제8호, pp. 1010-1021, 2015년 8월.', '2015-08-01'),
  (14, 'DOMESTIC_JOURNAL', '문제틀과 아키텍처 패턴의 매칭을 이용한 소프트웨어 아키텍처 설계방법', '한국정보과학회 논문지 제42권 제3호, pp. 341-360, 2015년 3월.',
   '2015-03-01'),
  (15, 'DOMESTIC_JOURNAL', '조합 시험 설계를 이용한 소프트웨어 제품라인 시험항목 생성 방법', '한국정보과학회논문지 제31권 제10호, pp. 86-93, 2014년 10월.',
   '2014-10-01'), (16, 'INTERNATIONAL_JOURNAL', 'vPMM: A Value Based Process Maturity Model',
                   'Studies in Computational Intelligence, Vol 208/2009, R. Lee, G. Hu, H. Miao (Eds.), pp. 193-202, Springer-Verlag Berlin Heidelberg 2009. (Presented at the 8th IEEE Int\'l Conf. on Computer and Information Science (ICIS 2009), Shanghai, China, June 1-3, 2009. [Selected as 26 outstanding papers out of 585 submitted and 205 published in the conference proceedings.]',
                   '2009-06-01'),
  (17, 'INTERNATIONAL_CONFERENCE', 'An Efficient Application-Device Matching Method for the Mobile Software Ecosystem',
   'The 21st Asia-Pacific Software Engineering Conference, Jeju, Korea, December 1-4, 2014. (Acceptance Rate: 29.6%)',
   '2014-12-01'), (18, 'SCI_JOURNAL', 'A Technique for Measuring Business Process based on Business Values',
                   'IEICE Transactions on Information and Software Systems. Vol.E98-D,No.4, pp. 911-921, April 2015.',
                   '2015-04-01'),
  (19, 'SCI_JOURNAL', 'Clustering Navigation Sequences to Create Contexts for Guiding Code Navigation',
   'Journal of Systems and Software (2013), Vol. 86, 2154- 2165, August 2013.', '2013-08-01'),
  (20, 'SCI_JOURNAL', 'A Method to Optimize the Scope of a Software Product Platform Based On End-User Features',
   'Journal of Systems and Software, Vol. 98, pp. 79–106, December 2014.', '2014-12-01'),
  (21, 'SCI_JOURNAL', 'Pairwise Testing for Systems with Data Derived from Real-valued Variable Inputs',
   'Software: Practice and Experience, DOI: 10.1002/spe.2295, Oct. 16, 2014.', '2014-10-16');
/*!40000 ALTER TABLE `publications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourcegroups`
--

DROP TABLE IF EXISTS `resourcegroups`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourcegroups` (
  `ID`        INT(11)      NOT NULL,
  `GroupName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourcegroups`
--

LOCK TABLES `resourcegroups` WRITE;
/*!40000 ALTER TABLE `resourcegroups` DISABLE KEYS */;
INSERT INTO `resourcegroups`
VALUES (0, 'KAIST Links'), (1, 'Software Architecture Resources'), (2, 'Related Conferences');
/*!40000 ALTER TABLE `resourcegroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resources` (
  `ID`              INT(11)      NOT NULL,
  `ResourceGroupID` INT(11)      NOT NULL,
  `ResourceType`    VARCHAR(255) NOT NULL,
  `Title`           TEXT         NOT NULL,
  `Contents`        TEXT         NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Resources_ResourceGroupID` (`ResourceGroupID`),
  CONSTRAINT `FK_Resources_ResourceGroupID` FOREIGN KEY (`ResourceGroupID`) REFERENCES `resourcegroups` (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` VALUES (0, 0, 'LINK', 'KAIST', 'http://www.kaist.ac.kr');
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rmemberinterests`
--

DROP TABLE IF EXISTS `rmemberinterests`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rmemberinterests` (
  `ID`         INT(11) NOT NULL,
  `InterestID` INT(11) NOT NULL,
  `MemberID`   INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Interests_ID` (`InterestID`),
  KEY `FK_Interests_Members_ID` (`MemberID`),
  CONSTRAINT `FK_Interests_ID` FOREIGN KEY (`InterestID`) REFERENCES `interests` (`ID`),
  CONSTRAINT `FK_Interests_Members_ID` FOREIGN KEY (`MemberID`) REFERENCES `members` (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rmemberinterests`
--

LOCK TABLES `rmemberinterests` WRITE;
/*!40000 ALTER TABLE `rmemberinterests` DISABLE KEYS */;
INSERT INTO `rmemberinterests` VALUES (0, 0, 0), (1, 7, 1), (2, 8, 1), (3, 9, 1);
/*!40000 ALTER TABLE `rmemberinterests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rmemberpublications`
--

DROP TABLE IF EXISTS `rmemberpublications`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rmemberpublications` (
  `ID`            INT(11) NOT NULL,
  `PublicationID` INT(11) NOT NULL,
  `MemberID`      INT(11) NOT NULL,
  `AuthorOrder`   INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UQ_RMP_PublicationID_MemberID` (`PublicationID`, `MemberID`),
  KEY `FK_Publications_ID` (`PublicationID`),
  KEY `FK_Members_ID` (`MemberID`),
  KEY `IDX_RMP_AuthorOrder` (`PublicationID`, `AuthorOrder`),
  CONSTRAINT `FK_Members_ID` FOREIGN KEY (`MemberID`) REFERENCES `members` (`ID`),
  CONSTRAINT `FK_Publications_ID` FOREIGN KEY (`PublicationID`) REFERENCES `publications` (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rmemberpublications`
--

LOCK TABLES `rmemberpublications` WRITE;
/*!40000 ALTER TABLE `rmemberpublications` DISABLE KEYS */;
INSERT INTO `rmemberpublications`
VALUES (0, 0, 7, 1), (1, 0, 0, 2), (2, 0, 3, 3), (3, 1, 1, 1), (4, 1, 0, 2), (5, 2, 0, 1), (6, 2, 10, 2), (7, 2, 11, 3),
  (8, 2, 12, 4), (9, 3, 13, 1), (10, 3, 14, 2), (11, 3, 15, 3), (12, 3, 16, 4), (13, 3, 0, 5), (14, 4, 17, 1),
  (15, 4, 0, 2), (16, 4, 18, 3), (17, 4, 19, 4), (18, 16, 12, 1), (19, 16, 0, 3), (20, 16, 31, 2), (21, 17, 29, 1),
  (22, 17, 0, 2), (23, 17, 32, 3), (24, 18, 12, 1), (25, 18, 0, 2), (26, 19, 19, 1), (27, 19, 0, 2), (28, 5, 19, 1),
  (29, 5, 0, 2), (30, 5, 33, 3), (31, 5, 34, 4), (32, 9, 26, 1), (33, 9, 32, 2), (34, 9, 27, 3), (35, 9, 0, 4),
  (36, 10, 1, 1), (37, 10, 0, 2), (38, 11, 1, 1), (39, 11, 0, 2), (40, 12, 4, 1), (41, 12, 0, 2), (42, 13, 28, 1),
  (43, 13, 0, 2), (44, 13, 12, 3), (45, 14, 11, 1), (46, 14, 0, 2), (47, 14, 12, 3), (48, 15, 10, 1), (49, 15, 0, 2),
  (50, 15, 12, 3), (51, 20, 25, 1), (52, 20, 0, 2), (53, 20, 12, 3), (54, 21, 35, 1), (55, 21, 0, 2), (56, 21, 32, 4),
  (57, 21, 36, 3);
/*!40000 ALTER TABLE `rmemberpublications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surrogatekeys`
--

DROP TABLE IF EXISTS `surrogatekeys`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `surrogatekeys` (
  `TableName` VARCHAR(255) NOT NULL,
  `KeyValue`  BIGINT(20)   NOT NULL,
  PRIMARY KEY (`TableName`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surrogatekeys`
--

LOCK TABLES `surrogatekeys` WRITE;
/*!40000 ALTER TABLE `surrogatekeys` DISABLE KEYS */;
INSERT INTO `surrogatekeys`
VALUES ('CourseCodes', 2), ('Courses', 1), ('Interests', 10), ('Members', 37), ('Publications', 22),
  ('ResourceGroups', 3), ('Resources', 1), ('RMemberInterests', 4), ('RMemberPublications', 58);
/*!40000 ALTER TABLE `surrogatekeys` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2016-03-08 16:50:38
