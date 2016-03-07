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
  CONSTRAINT `FK_Publications_ID` FOREIGN KEY (`PublicationID`) REFERENCES `Publications` (`ID`),
  CONSTRAINT `UQ_RMP_PublicationID_MemberID` UNIQUE (PublicationID, MemberID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


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

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-06 19:39:09
