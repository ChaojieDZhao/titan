/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
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
  `cuAdId` int(8) NOT NULL AUTO_INCREMENT COMMENT '顾客地址ID',
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `phone` varchar(12) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `province` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '省份(如:河南省)',
  `city` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '省市',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区域(如：金水区)',
  `areaCode` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '该区域code',
  `address` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `status` int(1) DEFAULT NULL COMMENT '是否是默认1默认0不是',
  `customerId` int(8) DEFAULT NULL COMMENT '顾客ID',
  `type` int(1) DEFAULT NULL COMMENT '0顾客地址  1商家地址',
  `cuAddressCodeStr` varchar(255) CHARACTER SET utf16 DEFAULT NULL COMMENT '地址拼接',
  `isDeleted` int(1) DEFAULT '0' COMMENT '顾客的地址是否删除0没有删除   1删除',
  PRIMARY KEY (`cuAdId`)
) ENGINE=InnoDB AUTO_INCREMENT=547 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
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
  `customerId` int(8) NOT NULL AUTO_INCREMENT COMMENT '顾客ID',
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `nickName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `referrer` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '推荐人手机号',
  `wallet` double(8,2) DEFAULT '0.00' COMMENT '钱包',
  `headImg` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '顾客头像',
  `dealerId` int(8) DEFAULT NULL COMMENT '经销商ID(判断是否是经销商子账号)',
  `isDisable` int(1) DEFAULT '0' COMMENT '是否停用1停用0未停用,2新注册没密码',
  `gender` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `join_date` datetime DEFAULT NULL COMMENT '注册时间',
  `boundBank` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '绑定银行卡名称',
  `bankNumber` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '绑定银行卡号',
  `bankName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '银行卡姓名',
  `weixin` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '绑定的微信账号',
  `zhifubao` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '绑定的支付宝账号',
  `rebate` double(4,2) DEFAULT '0.00' COMMENT '返点百分比',
  `xinName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '微信姓名',
  `baoName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '支付宝姓名',
  `region` varchar(10) COLLATE utf8_bin DEFAULT '无' COMMENT '地区',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
