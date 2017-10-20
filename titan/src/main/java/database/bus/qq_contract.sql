/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50718
Source Host           : 47.94.158.38:3306
Source Database       : lukebang

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-10-20 11:51:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qq_contract
-- ----------------------------
DROP TABLE IF EXISTS `qq_contract`;
CREATE TABLE `qq_contract` (
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `nick_name` varchar(100) DEFAULT NULL,
  `qq_number` varchar(100) DEFAULT NULL,
  `home_phone` varchar(100) DEFAULT NULL,
  `work_phone` varchar(100) DEFAULT NULL,
  `other_phone` varchar(100) DEFAULT NULL,
  `home_mobile` varchar(100) DEFAULT NULL,
  `work_mobile` varchar(100) DEFAULT NULL,
  `other_mobile` varchar(100) DEFAULT NULL,
  `home_fax` varchar(100) DEFAULT NULL,
  `work_fax` varchar(100) DEFAULT NULL,
  `depart` varchar(100) DEFAULT NULL,
  `home_address` varchar(100) DEFAULT NULL,
  `work_address` varchar(100) DEFAULT NULL,
  `other_address` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `personal_email` varchar(50) DEFAULT NULL,
  `home_email` varchar(50) DEFAULT NULL,
  `work_email` varchar(50) DEFAULT NULL,
  `personal_url` varchar(255) DEFAULT NULL,
  `home_url` varchar(255) DEFAULT NULL,
  `work_url` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `duty` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qq_contract
-- ----------------------------
