/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : yong-you

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2022-03-04 16:38:24
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
  `sceOpenTime` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
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
  `strategyId` int NOT NULL AUTO_INCREMENT,
  `straUser` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `straTitle` varchar(30) NOT NULL,
  `straScenic` varchar(30) NOT NULL,
  `straThemeId` int NOT NULL,
  `straThemeName` varchar(10) NOT NULL,
  `straContent` varchar(500) NOT NULL,
  `straTime` datetime DEFAULT NULL,
  `straLove` int DEFAULT NULL,
  `straCollect` int DEFAULT NULL,
  PRIMARY KEY (`strategyId`)
) ENGINE=InnoDB AUTO_INCREMENT=20220002 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of strategy
-- ----------------------------
INSERT INTO `strategy` VALUES ('20220000', '游客', '雪窦山一日游', '雪窦山', '4', '自然游', '哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈啊哈哈哈哈', '2022-01-04 00:00:00', '400', '212');
INSERT INTO `strategy` VALUES ('20220001', 'wwwwwww', '动物园哈哈哈哈', '雅戈尔动物园', '4', '自然游', '推荐推荐', '2021-11-18 00:00:00', '555', '333');

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
  `avatar_url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '1234567', '13566562287', '45222351312@qq.com', '2022-03-04 15:18:22', 'https://pic2.zhimg.com/v2-6eec875c277de6f7f0b1e402a11397b1_r');
INSERT INTO `user` VALUES ('3', '333333', '3333', '33333', '333333', '2022-03-04 15:18:54', 'https://pic4.zhimg.com/v2-9ddea817568d692ed605a6425471a813_r.jpg');
INSERT INTO `user` VALUES ('4', '444444', '4444444444', '44444444', '4444444', '2022-03-04 15:19:40', 'https://pic2.zhimg.com/80/v2-9807ee8a75a5fc9eba1491e5b010d659_720w.jpg');
INSERT INTO `user` VALUES ('5', '猪八戒', '52136452', '125996355411', '12633520210', '2022-03-04 15:19:39', 'https://pic3.zhimg.com/80/v2-48f08fa1787895e22f9a635282f6d11c_720w.jpg?source=1940ef5c');
