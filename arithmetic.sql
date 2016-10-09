/*
Navicat MySQL Data Transfer

Source Server         : ti19.com_3306
Source Server Version : 50715
Source Host           : ti19.com:3306
Source Database       : arithmetic

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-10-03 16:07:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_grade`
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
  `gradeid` int(11) NOT NULL AUTO_INCREMENT,
  `gradename` varchar(255) DEFAULT NULL,
  `graderank` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `gradestuid` int(11) DEFAULT NULL,
  PRIMARY KEY (`gradeid`),
  KEY `gradestuid` (`gradestuid`),
  CONSTRAINT `t_grade_ibfk_1` FOREIGN KEY (`gradestuid`) REFERENCES `t_student` (`stuid`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------

-- ----------------------------
-- Table structure for `t_parent`
-- ----------------------------
DROP TABLE IF EXISTS `t_parent`;
CREATE TABLE `t_parent` (
  `parentid` int(11) NOT NULL AUTO_INCREMENT,
  `parentname` varchar(11) NOT NULL,
  `parentnick` varchar(11) NOT NULL,
  `parentemail` varchar(23) NOT NULL,
  `parentpwd` varchar(11) NOT NULL,
  PRIMARY KEY (`parentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_parent
-- ----------------------------

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stuid` int(11) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(11) NOT NULL,
  `stunick` varchar(11) NOT NULL,
  `stuemail` varchar(23) NOT NULL,
  `stupwd` varchar(11) NOT NULL,
  `stuparentid` int(11) DEFAULT NULL,
  `stuteacherid` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuid`),
  KEY `stuparentid` (`stuparentid`),
  KEY `stuteacherid` (`stuteacherid`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`stuparentid`) REFERENCES `t_parent` (`parentid`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `t_student_ibfk_2` FOREIGN KEY (`stuteacherid`) REFERENCES `t_teacher` (`teacherid`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `teacherid` int(11) NOT NULL AUTO_INCREMENT,
  `teachername` varchar(11) NOT NULL,
  `teachernick` varchar(11) NOT NULL,
  `teacheremail` varchar(23) NOT NULL,
  `teacherpwd` varchar(11) NOT NULL,
  PRIMARY KEY (`teacherid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
