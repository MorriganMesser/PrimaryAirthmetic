/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : primary_arith

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2016-09-22 00:28:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userid` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `usernick` varchar(25) NOT NULL,
  `userpwd` varchar(25) NOT NULL,
  `useremail` varchar(25) DEFAULT NULL,
  `userphone` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'qqqq', 'qqqq', 'qqqq', null, null);
