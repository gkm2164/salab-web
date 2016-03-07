-- MySQL dump 10.13  Distrib 5.7.10, for osx10.11 (x86_64)
--
-- Host: localhost    Database: SALab
-- ------------------------------------------------------
-- Server version	5.7.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CourseCodes`
--

DROP TABLE IF EXISTS `CourseCodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CourseCodes` (
  `ID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `Code` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CourseCodes_CourseID` (`CourseID`),
  CONSTRAINT `FK_CourseCodes_CourseID` FOREIGN KEY (`CourseID`) REFERENCES `Courses` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CourseCodes`
--

LOCK TABLES `CourseCodes` WRITE;
/*!40000 ALTER TABLE `CourseCodes` DISABLE KEYS */;
INSERT INTO `CourseCodes` VALUES (0,0,'CS552'),(1,0,'SEP531');
/*!40000 ALTER TABLE `CourseCodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Courses`
--

DROP TABLE IF EXISTS `Courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Courses` (
  `ID` int(11) NOT NULL,
  `CourseType` varchar(50) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Description` text NOT NULL,
  `Link` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Courses`
--

LOCK TABLES `Courses` WRITE;
/*!40000 ALTER TABLE `Courses` DISABLE KEYS */;
INSERT INTO `Courses` VALUES (0,'GRADUATE','Models of Software Systems','Computer Scientists have long investigated the problem of how to automate software development from its specification to its program. So far the efforts were not fully successful but much of the results can be fruitfully applied to development of small programs and critical small portions of large programs. In this course, we learn how to formally write requirements, how to formally model specifications and how to rigorously verify that the models have the required properties.', 'http://klms.kaist.ac.kr');
/*!40000 ALTER TABLE `Courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Interests`
--

DROP TABLE IF EXISTS `Interests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Interests` (
  `ID` int(11) NOT NULL,
  `FieldName` varchar(255) NOT NULL,
  `FieldDesc` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Interests`
--

LOCK TABLES `Interests` WRITE;
/*!40000 ALTER TABLE `Interests` DISABLE KEYS */;
INSERT INTO `Interests` VALUES (0,'Software Engineering',NULL),(1,'Software Architecture',NULL),(2,'Software Product Lines',NULL),(3,'Software Testing',NULL),(4,'Model-Driven Development',NULL),(5,'Formal Methods',NULL),(6,'Service-Oriented Architecture',NULL),(7,'Measuring Quality based on Software Architecture',NULL),(8,'Evaluation of Software Architecture Software System',NULL),(9,'Construction of Software Architecture',NULL);
/*!40000 ALTER TABLE `Interests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Members`
--

DROP TABLE IF EXISTS `Members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Members` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `KoreanName` varchar(255) NOT NULL,
  `Degree` varchar(255) NOT NULL,
  `Link` varchar(255) DEFAULT NULL,
  `EnterDate` date NOT NULL,
  `Graduated` tinyint(1) DEFAULT '0',
  `GraduatedYear` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Members`
--

LOCK TABLES `Members` WRITE;
/*!40000 ALTER TABLE `Members` DISABLE KEYS */;
INSERT INTO `Members` VALUES (0,'Sungwon Kang','강성원','prof',NULL,'1997-01-01',0,NULL),(1,'Jungho Kim','김정호','phd',NULL,'2011-02-01',0,NULL),(2,'Hwi Ahn','안휘','phd',NULL,'2012-03-01',0,NULL),(3,'Jongsun Ahn','안종선','phd',NULL,'2012-10-31',0,NULL),(4,'Taehyun Park','박태현','phd',NULL,'2012-09-03',0,NULL),(5,'Pilsu Jung','정필수','phd',NULL,'2014-03-03',0,NULL),(6,'Younghun Han','한영훈','phd',NULL,'2014-09-01',0,NULL),(7,'Gyeongmin Go','고경민','phd','http://imarch.pe.kr','2015-08-31',0,NULL),(8,'Jaejun Lee','이재준','ms',NULL,'2014-09-01',0,NULL),(9,'Taehyun Kim','김태현','ms',NULL,'2015-03-02',0,NULL),(10,'Haeun Baek','백하은','ms',NULL,'2011-03-01',1,2013),(11,'Jungmin Kim','김정민','ms',NULL,'2011-03-02',1,2013),(12,'Jihyun Lee','이지현','external',NULL,'2009-02-01',1,NULL),(13,'Jinhyun Kim','김진현','external',NULL,'2016-02-26',1,NULL),(14,'Inhey Kang','강인혜','external',NULL,'2016-02-26',1,NULL),(15,'Jin-Young Choi','최진영','external',NULL,'2016-02-26',1,NULL),(16,'Insup Lee','이인섭','external',NULL,'2016-02-26',1,NULL),(17,'Seokhwan Eom','엄석환','ms',NULL,'2010-01-01',1,2012),(18,'Jinkyu Kim','김진규','phd',NULL,'2012-02-15',1,2012),(19,'Seonah Lee','이선아','dr',NULL,'2010-08-01',1,2016),(25,'Hamad Alsawalqah','하마드','phd','','2008-01-01',1,2014),(26,'Sangyup Han','한상엽','external','','2016-03-04',0,NULL),(27,'Ben Lee','벤리','external','','2016-03-04',0,NULL),(1000,'Heuijin Lee','이희진','ms','','2012-09-01',1,2014),(1050,'Changsub Keum','금창섭','phd','','2008-01-01',1,2014),(1100,'Danhyung Lee','이단형','external','','2016-03-04',0,NULL),(1150,'Myungchul Kim','김명철','external','','2016-12-31',0,NULL),(1200,'Sunghun Kim','김성훈','external','','2016-03-04',0,NULL),(1201,'Matt Staats','','external','','2016-03-04',0,NULL);
/*!40000 ALTER TABLE `Members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Publications`
--

DROP TABLE IF EXISTS `Publications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Publications` (
  `ID` int(11) NOT NULL,
  `PublicationType` varchar(255) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `MetaData` text NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Publications`
--

LOCK TABLES `Publications` WRITE;
/*!40000 ALTER TABLE `Publications` DISABLE KEYS */;
INSERT INTO `Publications` VALUES (0,'INTERNATIONAL_CONFERENCE','A Software Binding Application Tool based on the Orthogonal Variability Description Language for Software Product Line Development','The 16th ACIS International Conference on Software Engineering, Artificial Intelligence, Networking and Parallel/Distributed Computing (SNPD 2015), Takamatsu, Japan, June 1-3, 2015. (Regular Paper)','2015-06-01'),(1,'DOMESTIC_CONFERENCE','사례연구: 기능확장성을 위한 소프트웨어 아키텍처 재설계','2009 한국 소프트웨어공학 학술대회 (KCSE2009), 2009년 2월 9일 ~ 11일','2009-02-09'),(2,'INTERNATIONAL_CONFERENCE','Systematic Software Product Line Test Case Derivation for Test Data Reuse','The 7th IEEE International Workshop on Software Test Automation (STA 2015), Taichung, Taiwan, July 2015. (Regular Paper)','2015-07-01'),(3,'SCI_JOURNAL','Formal Synthesis of Application and Platform Behavior of Embedded Software Systems','Journal of Software and Systems Modeling, Vol.14, Issue 2, pp. 839-859, May 2015','2015-05-01'),(4,'DOMESTIC_JOURNAL','소프트웨어 제품 라인의 요구사항과 아키텍처 간 추적성 모델링','한국정보처리학회 논문지 - 소프트웨어 및 데이터 공학 - 제4권 제11호, pp. 487-498, 2015년 11월.','2015-11-01'),(5,'SCI_JOURNAL','The Impact of View Histories on Edit Recommendations','IEEE Transactions on Software Engineering, Vol. 41, Issue 3, pp. 314-330, March 2015.','2015-03-01'),(9,'SCI_JOURNAL','Fast Directional Handoff and Lightweight Retransmission Protocol for Enhancing Multimedia Quality in Indoor WLANs','Computer Networks, Volume: 79, Issue: 3, pp. 133~147, March 2015.','2015-03-01'),(10,'DOMESTIC_CONFERENCE','소프트웨어 아키텍처를 통한 시스템 기능확장성 측정에 관한 연구','한국IT서비스학회 추계학술대회, 2007.11.21.','2007-11-21'),(11,'DOMESTIC_CONFERENCE','FSP Model을 이용한 C&C View 아키텍처의 검증','한국IT서비스학회 추계학술대회, 2006.11.15.','2006-11-15'),(251,'INTERNATIONAL_JOURNAL','vPMM: A Value Based Process Maturity Model','Studies in Computational Intelligence, Vol 208/2009, R. Lee, G. Hu, H. Miao (Eds.), pp. 193-202, Springer-Verlag Berlin Heidelberg 2009. (Presented at the 8th IEEE Int\'l Conf. on Computer and Information Science (ICIS 2009), Shanghai, China, June 1-3, 2009. [Selected as 26 outstanding papers out of 585 submitted and 205 published in the conference proceedings.]','2009-06-01'),(300,'INTERNATIONAL_CONFERENCE','An Efficient Application-Device Matching Method for the Mobile Software Ecosystem','The 21st Asia-Pacific Software Engineering Conference, Jeju, Korea, December 1-4, 2014. (Acceptance Rate: 29.6%)','2014-12-01'),(350,'SCI_JOURNAL','A Technique for Measuring Business Process based on Business Values','IEICE Transactions on Information and Software Systems. Vol.E98-D,No.4, pp. 911-921, April 2015.','2015-04-01'),(400,'SCI_JOURNAL','Clustering Navigation Sequences to Create Contexts for Guiding Code Navigation','Journal of Systems and Software (2013), Vol. 86, 2154- 2165, August 2013.','2013-08-01');
/*!40000 ALTER TABLE `Publications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RMemberInterests`
--

DROP TABLE IF EXISTS `RMemberInterests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RMemberInterests` (
  `ID` int(11) NOT NULL,
  `InterestID` int(11) NOT NULL,
  `MemberID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Interests_ID` (`InterestID`),
  KEY `FK_Interests_Members_ID` (`MemberID`),
  CONSTRAINT `FK_Interests_ID` FOREIGN KEY (`InterestID`) REFERENCES `Interests` (`ID`),
  CONSTRAINT `FK_Interests_Members_ID` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RMemberInterests`
--

LOCK TABLES `RMemberInterests` WRITE;
/*!40000 ALTER TABLE `RMemberInterests` DISABLE KEYS */;
INSERT INTO `RMemberInterests` VALUES (0,0,0),(1,7,1),(2,8,1),(3,9,1);
/*!40000 ALTER TABLE `RMemberInterests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RMemberPublications`
--

DROP TABLE IF EXISTS `RMemberPublications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RMemberPublications` (
  `ID` int(11) NOT NULL,
  `PublicationID` int(11) NOT NULL,
  `MemberID` int(11) NOT NULL,
  `AuthorOrder` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Publications_ID` (`PublicationID`),
  KEY `FK_Members_ID` (`MemberID`),
  KEY `IDX_RMP_AuthorOrder` (`AuthorOrder`),
  CONSTRAINT `FK_Members_ID` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`),
  CONSTRAINT `FK_Publications_ID` FOREIGN KEY (`PublicationID`) REFERENCES `Publications` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RMemberPublications`
--

LOCK TABLES `RMemberPublications` WRITE;
/*!40000 ALTER TABLE `RMemberPublications` DISABLE KEYS */;
INSERT INTO `RMemberPublications` VALUES (0,0,7,1),(1,0,0,2),(2,0,3,3),(3,1,1,1),(4,1,0,2),(5,2,0,1),(6,2,10,2),(7,2,11,3),(8,2,12,4),(9,3,13,1),(10,3,14,2),(11,3,15,3),(12,3,16,4),(13,3,0,5),(14,4,17,1),(15,4,0,2),(16,4,18,3),(17,4,19,4),(18,251,12,1),(19,251,0,3),(20,251,1100,2),(21,300,1000,1),(22,300,0,2),(23,300,1150,3),(24,350,12,1),(25,350,0,2),(26,400,19,1),(27,400,0,2),(28,5,19,1),(29,5,0,2),(30,5,1200,3),(31,5,1201,4),(32,9,26,1),(33,9,1150,2),(34,9,27,3),(35,9,0,4),(36,10,1,1),(37,10,0,2),(38,11,1,1),(39,11,0,2);
/*!40000 ALTER TABLE `RMemberPublications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ResourceGroups`
--

DROP TABLE IF EXISTS `ResourceGroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ResourceGroups` (
  `ID` int(11) NOT NULL,
  `GroupName` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ResourceGroups`
--

LOCK TABLES `ResourceGroups` WRITE;
/*!40000 ALTER TABLE `ResourceGroups` DISABLE KEYS */;
INSERT INTO `ResourceGroups` VALUES (0,'KAIST Links'),(1,'Software Architecture Resources'),(2,'Related Conferences');
/*!40000 ALTER TABLE `ResourceGroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Resources`
--

DROP TABLE IF EXISTS `Resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Resources` (
  `ID` int(11) NOT NULL,
  `ResourceGroupID` int(11) NOT NULL,
  `ResourceType` varchar(255) NOT NULL,
  `Title` text NOT NULL,
  `Contents` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Resources_ResourceGroupID` (`ResourceGroupID`),
  CONSTRAINT `FK_Resources_ResourceGroupID` FOREIGN KEY (`ResourceGroupID`) REFERENCES `ResourceGroups` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resources`
--

LOCK TABLES `Resources` WRITE;
/*!40000 ALTER TABLE `Resources` DISABLE KEYS */;
INSERT INTO `Resources` VALUES (0,0,'LINK','KAIST','http://www.kaist.ac.kr');
/*!40000 ALTER TABLE `Resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SurrogateKeys`
--

DROP TABLE IF EXISTS `SurrogateKeys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SurrogateKeys` (
  `TableName` varchar(255) NOT NULL,
  `KeyValue` bigint(20) NOT NULL,
  PRIMARY KEY (`TableName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SurrogateKeys`
--

LOCK TABLES `SurrogateKeys` WRITE;
/*!40000 ALTER TABLE `SurrogateKeys` DISABLE KEYS */;
INSERT INTO `SurrogateKeys` VALUES ('Interests',2),('Members',28),('Publications',12),('RMemberInterests',2),('RMemberPublications',40);
/*!40000 ALTER TABLE `SurrogateKeys` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-06 19:39:09