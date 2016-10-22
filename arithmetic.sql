-- MySQL dump 10.13  Distrib 5.7.15, for Win64 (x86_64)
--
-- Host: 115.29.34.101    Database: arithmetic
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `t_grade`
--

DROP TABLE IF EXISTS `t_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_grade` (
  `gradeid` int(11) NOT NULL,
  `gradename` varchar(255) DEFAULT NULL,
  `graderank` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `gradestuid` int(11) DEFAULT NULL,
  `grademodel` varchar(255) DEFAULT NULL,
  `gradedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `gradetime` varchar(255) DEFAULT NULL,
  `gradeexps` varchar(255) DEFAULT NULL,
  `graderightnum` int(11) DEFAULT NULL,
  `gradeerrornum` int(11) DEFAULT NULL,
  `graderate` varchar(255) DEFAULT NULL,
  `gradenums` int(11) DEFAULT NULL,
  PRIMARY KEY (`gradeid`),
  KEY `gradestuid` (`gradestuid`),
  CONSTRAINT `t_grade_ibfk_1` FOREIGN KEY (`gradestuid`) REFERENCES `t_student` (`stuid`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_parent`
--

DROP TABLE IF EXISTS `t_parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_parent` (
  `parentid` int(11) NOT NULL AUTO_INCREMENT,
  `parentname` varchar(255) NOT NULL,
  `parentnick` varchar(255) DEFAULT NULL,
  `parentemail` varchar(255) NOT NULL,
  `parentpwd` varchar(255) NOT NULL,
  `parentage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`parentid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_student`
--

DROP TABLE IF EXISTS `t_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_student` (
  `stuid` int(11) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(222) NOT NULL,
  `stunick` varchar(222) DEFAULT NULL,
  `stuemail` varchar(232) NOT NULL,
  `stupwd` varchar(222) NOT NULL,
  `stuparentid` int(11) DEFAULT NULL,
  `stuteacherid` int(11) DEFAULT NULL,
  `stuyear` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stuid`),
  KEY `stuparentid` (`stuparentid`),
  KEY `stuteacherid` (`stuteacherid`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`stuparentid`) REFERENCES `t_parent` (`parentid`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `t_student_ibfk_2` FOREIGN KEY (`stuteacherid`) REFERENCES `t_teacher` (`teacherid`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_teacher`
--

DROP TABLE IF EXISTS `t_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_teacher` (
  `teacherid` int(11) NOT NULL AUTO_INCREMENT,
  `teachername` varchar(255) NOT NULL,
  `teachernick` varchar(255) DEFAULT NULL,
  `teacheremail` varchar(255) NOT NULL,
  `teacherpwd` varchar(255) NOT NULL,
  `teacherage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacherid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_test`
--

DROP TABLE IF EXISTS `t_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_test` (
  `testid` int(11) NOT NULL,
  `testname` varchar(255) DEFAULT NULL,
  `testrank` varchar(255) DEFAULT NULL,
  `testgrade` varchar(255) DEFAULT NULL,
  `testdate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `teststuid` int(11) DEFAULT NULL,
  `testexps` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`testid`),
  KEY `teststuid` (`teststuid`),
  CONSTRAINT `t_test_ibfk_1` FOREIGN KEY (`teststuid`) REFERENCES `t_student` (`stuid`) ON DELETE SET NULL
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

-- Dump completed on 2016-10-23  0:49:53
