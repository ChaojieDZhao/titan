/*
Navicat MySQL Data Transfer

Source Server         : ����mysql
Source Server Version : 50718
Source Host           : 47.94.158.38:3306
Source Database       : lukebang

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-25 08:44:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer_address
-- ----------------------------
DROP TABLE IF EXISTS `customer_address`;
CREATE TABLE `customer_address` (
  `cuAdId` int(8) NOT NULL AUTO_INCREMENT COMMENT '�˿͵�ַID',
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '����',
  `phone` varchar(12) COLLATE utf8_bin DEFAULT NULL COMMENT '�ֻ���',
  `province` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'ʡ��(��:����ʡ)',
  `city` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT 'ʡ��',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '����(�磺��ˮ��)',
  `areaCode` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '������code',
  `address` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '��ַ',
  `status` int(1) DEFAULT NULL COMMENT '�Ƿ���Ĭ��1Ĭ��0����',
  `customerId` int(8) DEFAULT NULL COMMENT '�˿�ID',
  `type` int(1) DEFAULT NULL COMMENT '0�˿͵�ַ  1�̼ҵ�ַ',
  `cuAddressCodeStr` varchar(255) CHARACTER SET utf16 DEFAULT NULL COMMENT '��ַƴ��',
  `isDeleted` int(1) DEFAULT '0' COMMENT '�˿͵ĵ�ַ�Ƿ�ɾ��0û��ɾ��   1ɾ��',
  PRIMARY KEY (`cuAdId`)
) ENGINE=InnoDB AUTO_INCREMENT=547 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


/*
Navicat MySQL Data Transfer

Source Server         : ����mysql
Source Server Version : 50718
Source Host           : 47.94.158.38:3306
Source Database       : lukebang

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-25 08:46:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` int(8) NOT NULL AUTO_INCREMENT COMMENT '�˿�ID',
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '�ֻ���',
  `nickName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '�ǳ�',
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '����',
  `referrer` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '�Ƽ����ֻ���',
  `wallet` double(8,2) DEFAULT '0.00' COMMENT 'Ǯ��',
  `headImg` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '�˿�ͷ��',
  `dealerId` int(8) DEFAULT NULL COMMENT '������ID(�ж��Ƿ��Ǿ��������˺�)',
  `isDisable` int(1) DEFAULT '0' COMMENT '�Ƿ�ͣ��1ͣ��0δͣ��,2��ע��û����',
  `gender` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '�Ա�',
  `join_date` datetime DEFAULT NULL COMMENT 'ע��ʱ��',
  `boundBank` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '�����п�����',
  `bankNumber` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '�����п���',
  `bankName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '���п�����',
  `weixin` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '�󶨵�΢���˺�',
  `zhifubao` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '�󶨵�֧�����˺�',
  `rebate` double(4,2) DEFAULT '0.00' COMMENT '����ٷֱ�',
  `xinName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '΢������',
  `baoName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '֧��������',
  `region` varchar(10) COLLATE utf8_bin DEFAULT '��' COMMENT '����',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
