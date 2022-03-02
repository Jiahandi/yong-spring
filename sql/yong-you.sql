/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : yong-you

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2022-03-02 17:03:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adid` int NOT NULL AUTO_INCREMENT,
  `adpassword` varchar(20) NOT NULL,
  `type` int DEFAULT NULL,
  `type_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`adid`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1001', '123456', '0', '普通管理员');
INSERT INTO `admin` VALUES ('1002', '000000', '0', '超级管理员');
INSERT INTO `admin` VALUES ('1007', '123', '0', '普通管理员');

-- ----------------------------
-- Table structure for `scenic`
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic` (
  `scenicId` int NOT NULL,
  `scePicture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sceName` varchar(30) NOT NULL,
  `sceIntro` varchar(200) DEFAULT NULL,
  `sceAddress` varchar(200) DEFAULT NULL,
  `sceOpentime` varchar(200) DEFAULT NULL,
  `sceThemeId` int NOT NULL,
  `sceThemeName` varchar(10) NOT NULL,
  `sceScore` double DEFAULT NULL,
  `scePrice` double DEFAULT NULL,
  `sceTel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`scenicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of scenic
-- ----------------------------
INSERT INTO `scenic` VALUES ('1201', '', '雅戈尔动物园', '中国水域面积最大的野生动物园', '宁波市鄞州区鄞县大道(东钱湖旅游度假区)', '9:00-16:30 周一闭关，法定节假日除外', '4', '自然游', '4.7', '122', '15844255536');
INSERT INTO `scenic` VALUES ('1202', '', '天一阁博物馆', '园林中的藏书楼', '浙江省宁波市海曙区天一街10号', '9:00-16:30 周一闭关，法定节假日除外', '3', '文化游', '3', null, '15844255536');
INSERT INTO `scenic` VALUES ('1203', null, '月湖', '宁波人的后花园', '宁波市海曙区县学街183号-2', '9:00-16:30 周一闭关，法定节假日除外', '4', '自然游', '2', null, '12566356636');

-- ----------------------------
-- Table structure for `strategy`
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `strategyId` int NOT NULL,
  `strauser` varchar(30) NOT NULL,
  `straTitle` varchar(30) NOT NULL,
  `straScenic` varchar(30) NOT NULL,
  `straThemeId` int NOT NULL,
  `straThemeName` varchar(10) NOT NULL,
  `straContent` varchar(500) NOT NULL,
  `straTime` datetime DEFAULT NULL,
  `straLove` int DEFAULT NULL,
  `straCollect` int DEFAULT NULL,
  PRIMARY KEY (`strategyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of strategy
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `avatar_url` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '1234567', '13566562287', '45222351312@qq.com', '2022-03-02 14:22:38', null);
INSERT INTO `user` VALUES ('3', '333333', '3333', '33333', '333333', '2022-03-02 14:22:29', null);
INSERT INTO `user` VALUES ('4', '444444', '4444444444', '44444444', '4444444', '2022-03-02 14:27:52', null);
INSERT INTO `user` VALUES ('5', '猪八戒', '52136452', '125996355411', '12633520210', '2022-03-02 16:24:06', null);
