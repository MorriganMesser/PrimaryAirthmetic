/*
Navicat MySQL Data Transfer

Source Server         : 115.29.34.101_3306
Source Server Version : 50716
Source Host           : 115.29.34.101:3306
Source Database       : arithmetic

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-10-13 22:35:33
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
  `grademodel` varchar(255) DEFAULT NULL,
  `gradedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `gradetime` varchar(255) DEFAULT NULL,
  `gradeexps` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gradeid`),
  KEY `gradestuid` (`gradestuid`),
  CONSTRAINT `t_grade_ibfk_1` FOREIGN KEY (`gradestuid`) REFERENCES `t_student` (`stuid`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------
INSERT INTO `t_grade` VALUES ('1', 'aaa', 'a', '100', '1', null, null, null, null);
INSERT INTO `t_grade` VALUES ('2', 'bbb', 'b', '59', '1', null, null, null, null);
INSERT INTO `t_grade` VALUES ('3', 'ccc', 'a', '87', '2', null, null, null, null);
INSERT INTO `t_grade` VALUES ('4', '考试', '考试等级', '8', '3', null, null, null, null);

-- ----------------------------
-- Table structure for `t_parent`
-- ----------------------------
DROP TABLE IF EXISTS `t_parent`;
CREATE TABLE `t_parent` (
  `parentid` int(11) NOT NULL AUTO_INCREMENT,
  `parentname` varchar(11) NOT NULL,
  `parentnick` varchar(11) DEFAULT NULL,
  `parentemail` varchar(23) NOT NULL,
  `parentpwd` varchar(11) NOT NULL,
  `parentage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`parentid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_parent
-- ----------------------------
INSERT INTO `t_parent` VALUES ('1', 'tianhongce', 'tian', '1196585084@qq.com', '333333', null);
INSERT INTO `t_parent` VALUES ('2', 'qqq', 'qqq', 'qqq', 'qqq', null);
INSERT INTO `t_parent` VALUES ('3', 'tttttt', 'tttt', 'ttt', 'ttttt', null);

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stuid` int(11) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(11) NOT NULL,
  `stunick` varchar(11) DEFAULT NULL,
  `stuemail` varchar(23) NOT NULL,
  `stupwd` varchar(11) NOT NULL,
  `stuparentid` int(11) DEFAULT NULL,
  `stuteacherid` int(11) DEFAULT NULL,
  `stuyear` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stuid`),
  KEY `stuparentid` (`stuparentid`),
  KEY `stuteacherid` (`stuteacherid`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`stuparentid`) REFERENCES `t_parent` (`parentid`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `t_student_ibfk_2` FOREIGN KEY (`stuteacherid`) REFERENCES `t_teacher` (`teacherid`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', 'qq', 'qqq', 'fasdf', 'qq', null, null, null);
INSERT INTO `t_student` VALUES ('2', 'tianhongce', 'tian', 'asdf', '111111', null, null, null);
INSERT INTO `t_student` VALUES ('3', 'qqq', 'qqq', 'qqq', 'qqq', null, null, null);
INSERT INTO `t_student` VALUES ('4', 'yyy', 'yyy', 'yyy', 'yyy', null, null, null);
INSERT INTO `t_student` VALUES ('5', 'tianhongce2', 'tian', '1196585084@qq.com2', '2222222', null, null, null);
INSERT INTO `t_student` VALUES ('6', 'kkkk', 'kkkk', 'kkkk', 'kkkk', null, null, null);
INSERT INTO `t_student` VALUES ('7', 'q', 'q', '', '', null, null, null);
INSERT INTO `t_student` VALUES ('8', 'q', 'q', 'q', '', null, null, null);
INSERT INTO `t_student` VALUES ('9', 'asdf', 'tian', '1196585084@qq.com', '111111', null, null, null);
INSERT INTO `t_student` VALUES ('10', 'asdf', 'tian', '375064070@qq.com', '111111', null, null, null);
INSERT INTO `t_student` VALUES ('11', 'tianhongce', 'yyy', '111@qq.com', '111111', null, null, null);
INSERT INTO `t_student` VALUES ('12', 'nohow', 'nohow', 'nohow@q.com', 'nohoow', null, null, null);

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `teacherid` int(11) NOT NULL AUTO_INCREMENT,
  `teachername` varchar(11) NOT NULL,
  `teachernick` varchar(11) DEFAULT NULL,
  `teacheremail` varchar(23) NOT NULL,
  `teacherpwd` varchar(11) NOT NULL,
  `teacherage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacherid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', 'tianhongce', 'tian', '111@qq.com', '222222', null);
INSERT INTO `t_teacher` VALUES ('2', 'qqq', 'qqq', 'qqq', 'qqq', null);
INSERT INTO `t_teacher` VALUES ('3', 'yyy', 'yyy', 'yyy', 'yyy', null);

-- ----------------------------
-- Table structure for `t_test`
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
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

-- ----------------------------
-- Records of t_test
-- ----------------------------
