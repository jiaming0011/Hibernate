/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : auctiondb

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-08-30 19:29:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auction`
-- ----------------------------
DROP TABLE IF EXISTS `auction`;
CREATE TABLE `auction` (
  `auctionId` int(11) NOT NULL AUTO_INCREMENT,
  `auctionName` varchar(50) NOT NULL,
  `auctionStartPrice` decimal(9,2) NOT NULL,
  `auctionUpset` decimal(9,2) NOT NULL,
  `auctionStartTime` datetime NOT NULL,
  `auctionEndTime` datetime NOT NULL,
  `auctionPic` varchar(50) NOT NULL,
  `auctionPicType` varchar(20) NOT NULL,
  `auctionDesc` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`auctionId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auction
-- ----------------------------
INSERT INTO `auction` VALUES ('1', '华为智能手表', '1.00', '2188.00', '2017-07-01 14:36:03', '2017-07-22 18:36:32', '/neusoft/img/huawei.jpg', 'jpg', '华为 HUAWEI WATCH动感系列智能手表（黑色不锈钢三珠表带）手表蓝牙通话，银黑两色任选');
INSERT INTO `auction` VALUES ('2', 'iphone6s plus', '10.00', '6088.00', '2017-07-03 14:41:01', '2017-07-17 14:41:09', '/neusoft/img/iphone6s.jpg', 'jpg', 'Apple iPhone6s plus 16G 移动联通电信4G手机，四色任选');
INSERT INTO `auction` VALUES ('3', '跑步机', '100.00', '3299.00', '2017-07-17 14:44:11', '2017-07-29 14:44:16', '/neusoft/img/paobuji.jpg', 'jpg', '舒华家用静音跑步机BC-1002多功能');
INSERT INTO `auction` VALUES ('4', '背包', '1.00', '290.00', '2017-07-05 14:46:25', '2017-08-07 14:46:29', '/neusoft/img/beibao.jpg', 'jpg', '瑞士军刀威戈Wenger14寸双肩包电脑包背包SAB87610109037黑色');
INSERT INTO `auction` VALUES ('5', '豆浆机', '2.00', '323.00', '2017-07-10 14:49:02', '2017-08-16 14:49:06', '/neusoft/img/doujiangji.jpg', 'jpg', '九阳（joyoung）豆浆机DJ12B-A11');
INSERT INTO `auction` VALUES ('6', '剃须刀', '50.00', '247.00', '2017-07-03 14:51:07', '2017-07-21 14:51:11', '/neusoft/img/tixudao.jpg', 'jpg', '飞利浦（Philips）RQ310 锐锋系列电动剃须刀');
INSERT INTO `auction` VALUES ('7', 'iphone7', '200.00', '6388.00', '2017-07-12 14:55:02', '2017-08-23 14:55:10', '/neusoft/img/iphone7.jpg', 'jpg', '苹果（Apple）iphone7移动联通电信4G手机玫瑰金 128G 标配');
INSERT INTO `auction` VALUES ('8', '民国 竹节铜烟枪', '2000.00', '10000.00', '2017-07-18 15:01:21', '2017-07-22 15:01:39', '/neusoft/img/yanqiang.jpg', 'jpg', '长度：36.5厘米，重量约270g。年代：民国。详情请咨询');
INSERT INTO `auction` VALUES ('9', '清 铜金金刚杵', '3000.00', '20000.00', '2017-07-05 15:05:24', '2017-07-28 15:05:27', '/neusoft/img/jinggangchu.jpg', 'jpg', '长度：11.5厘米，有小焊伤，发货看货请提前预约');
INSERT INTO `auction` VALUES ('10', '刘文西 沙漠之舟', '25000.00', '100000.00', '2017-07-04 15:07:26', '2017-09-19 15:07:30', '/neusoft/img/shamo.jpg', 'jpg', '长度为34.5厘米，宽度为46厘米，画心有黄斑，缺损');
INSERT INTO `auction` VALUES ('11', '马晋 书画扇面', '4800.00', '15000.00', '2017-07-03 15:10:02', '2017-07-29 15:10:07', '/neusoft/img/shanmian.jpg', 'jpg', '此拍品约为0.83平尺，画心有修补，裂');
INSERT INTO `auction` VALUES ('12', '手串', '4900.00', '10000.00', '2017-07-10 15:13:27', '2017-07-29 15:13:30', '/neusoft/img/shouchuan.jpg', 'jpg', '现代 1.6cm柬埔寨沉香手串14粒 15g');
INSERT INTO `auction` VALUES ('13', '相机', '148.00', '3999.00', '2017-07-03 15:15:51', '2017-08-22 15:15:55', '/neusoft/img/xiangji.jpg', 'jpg', '佳能（Canon）EOS 700D 单反套机（EF-S 18-55mm f/3.5-5.6 IS STM 镜头）');

-- ----------------------------
-- Table structure for `auctionrecord`
-- ----------------------------
DROP TABLE IF EXISTS `auctionrecord`;
CREATE TABLE `auctionrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `auctionId` int(11) NOT NULL,
  `auctionTime` datetime NOT NULL,
  `auctionPrice` decimal(9,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rec_REF_user` (`userId`),
  KEY `FK_rec_REF_AUC` (`auctionId`),
  CONSTRAINT `FK_rec_REF_AUC` FOREIGN KEY (`auctionId`) REFERENCES `auction` (`auctionId`),
  CONSTRAINT `FK_rec_REF_user` FOREIGN KEY (`userId`) REFERENCES `auctionuser` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auctionrecord
-- ----------------------------
INSERT INTO `auctionrecord` VALUES ('11', '2', '8', '2017-07-19 15:48:48', '3000.00');
INSERT INTO `auctionrecord` VALUES ('12', '2', '7', '2017-07-19 15:49:06', '300.00');
INSERT INTO `auctionrecord` VALUES ('13', '4', '8', '2017-07-19 15:50:45', '3100.00');
INSERT INTO `auctionrecord` VALUES ('14', '7', '8', '2017-07-20 11:00:54', '3200.00');

-- ----------------------------
-- Table structure for `auctionuser`
-- ----------------------------
DROP TABLE IF EXISTS `auctionuser`;
CREATE TABLE `auctionuser` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `userPassword` varchar(20) NOT NULL,
  `userCardNo` varchar(20) DEFAULT NULL,
  `userTel` varchar(20) DEFAULT NULL,
  `userAddress` varchar(200) DEFAULT NULL,
  `userPostNumber` varchar(6) DEFAULT NULL,
  `userIsadmin` int(11) DEFAULT '0',
  `userQuestion` varchar(100) DEFAULT NULL,
  `userAnswer` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auctionuser
-- ----------------------------
INSERT INTO `auctionuser` VALUES ('1', 'admin', '123456', '123456', '123456', '中国首都', '无', '1', '无', '无');
INSERT INTO `auctionuser` VALUES ('2', 'Mike', '123456', '123456', '123456', '广东广州', '无', '0', '无', '无');
INSERT INTO `auctionuser` VALUES ('3', 'Tom', '123456', '123456', '123456', '广东深圳', '无', '0', '无', '无');
INSERT INTO `auctionuser` VALUES ('4', 'lucy', '123456', '123456', '123456', '广东汕头', '无', '0', '无', '无');
INSERT INTO `auctionuser` VALUES ('5', 'abcabc', '123456', '123456', '123456', '广东汕头', '无', '0', '无', '无');
INSERT INTO `auctionuser` VALUES ('6', 'abcabcs', '123452', '12312', '213123123', '广东', '510000', '0', '', '');
INSERT INTO `auctionuser` VALUES ('7', 'abcabcd', '123456', '123456', '123456', '广东广州', '510000', '0', '', '');
