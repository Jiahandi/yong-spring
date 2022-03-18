/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : yong-you

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2022-03-18 10:35:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adid` int NOT NULL AUTO_INCREMENT,
  `adname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adpassword` varchar(20) NOT NULL,
  `type` int DEFAULT NULL,
  `type_name` varchar(10) DEFAULT NULL,
  `token` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`adid`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1001', 'xian', '123456', '0', '普通管理员', null);
INSERT INTO `admin` VALUES ('1007', 'yyy', '123', '0', '普通管理员', null);
INSERT INTO `admin` VALUES ('1008', 'qqqqq', '000000', '0', '普通管理员', null);

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `fb_id` int NOT NULL AUTO_INCREMENT,
  `fb_user` varchar(20) NOT NULL,
  `fb_content` varchar(500) NOT NULL,
  `fb_image` varchar(200) DEFAULT NULL,
  `fb_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`fb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', 'xian', '界面不清', null, '2022-03-08 15:27:58');
INSERT INTO `feedback` VALUES ('2', '游客', '容易出bug', null, '2022-03-08 15:28:17');
INSERT INTO `feedback` VALUES ('3', '游客', '界面不美观', null, '2022-03-08 16:37:52');
INSERT INTO `feedback` VALUES ('4', 'xian', '225566', '', '2022-03-09 15:37:41');
INSERT INTO `feedback` VALUES ('5', 'xian', '8555555555', '', '2022-03-09 15:37:54');

-- ----------------------------
-- Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `size` bigint NOT NULL,
  `url` varchar(255) NOT NULL,
  `md5` varchar(255) NOT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `is_enable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('5', 'syq.jpg', 'jpg', '211327', 'http://localhost:9090/file/7079f97535e54731b085d3e83979d89e.jpg', 'e8a4c65d4973f17c486eacc4ffe634d8', '0', '1');
INSERT INTO `file` VALUES ('8', '111.jpg', 'jpg', '211327', 'http://localhost:9090/file/7079f97535e54731b085d3e83979d89e.jpg', 'e8a4c65d4973f17c486eacc4ffe634d8', '0', '1');

-- ----------------------------
-- Table structure for `forum`
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `forum_id` int NOT NULL AUTO_INCREMENT,
  `forum_name` varchar(20) NOT NULL,
  `forum_title` varchar(20) NOT NULL,
  `forum_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `forum_categoryid` int NOT NULL,
  `forum_categoryname` varchar(20) NOT NULL,
  `forum_content` varchar(500) NOT NULL,
  `forum_pageview` int NOT NULL,
  PRIMARY KEY (`forum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES ('1', 'xian', 'bbbbbbb', '2022-03-09 14:05:26', '1', '问题求助', '啊啊啊啊啊啊', '0');
INSERT INTO `forum` VALUES ('2', '游客', 'bb', '2022-03-08 15:27:20', '2', '意见建议', '柔柔弱弱柔柔弱弱柔柔弱弱柔柔弱弱热热热', '0');
INSERT INTO `forum` VALUES ('3', 'xxx', 'ccccccc', '2022-03-08 16:29:50', '1', '问题求助', 'ooooooo', '0');
INSERT INTO `forum` VALUES ('4', 'aaaaaaaa', 'fffffffffff', '2022-03-09 15:22:15', '3', '线路讨论', 'sfhdth', '0');

-- ----------------------------
-- Table structure for `scenic`
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic` (
  `scenic_id` int NOT NULL AUTO_INCREMENT,
  `sce_picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sce_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sce_intro` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sce_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sce_opentime` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sce_themeid` int NOT NULL,
  `sce_themename` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sce_score` double DEFAULT NULL,
  `sce_price` double DEFAULT NULL,
  `sce_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`scenic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1206 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of scenic
-- ----------------------------
INSERT INTO `scenic` VALUES ('1201', '', '雅戈尔动物园', '中国水域面积最大的野生动物园', '宁波市鄞州区鄞县大道(东钱湖旅游度假区)', '9:00-16:30 周一闭关，法定节假日除外', '4', '自然游', '4.7', '122', '15844255536');
INSERT INTO `scenic` VALUES ('1202', '', '天一阁博物馆', '园林中的藏书楼', '浙江省宁波市海曙区天一街10号', '9:00-16:30 周一闭关，法定节假日除外', '3', '文化游', '3', null, '15844255536');
INSERT INTO `scenic` VALUES ('1204', '', '宁波海洋世界', '宁波市一家展示海洋生物,宣传海洋知识的专业海洋馆', '浙江省宁波市鄞州区桑田路936号', '8:15-22:00 全天开放', '3', '文化游', '5', '200', '');
INSERT INTO `scenic` VALUES ('1205', '', '浙东四明山抗日根据地', '全国百个红色旅游经典景区之一', '宁波市余姚梁弄镇', '', '2', '红色游', '4', null, '');

-- ----------------------------
-- Table structure for `strategy`
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `strategy_id` int NOT NULL AUTO_INCREMENT,
  `stra_user` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stra_title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stra_scenic` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `stra_themeid` int NOT NULL,
  `stra_themename` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stra_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stra_time` date DEFAULT NULL,
  `stra_love` int NOT NULL DEFAULT '0',
  `stra_collect` int NOT NULL DEFAULT '0',
  `stra_pageview` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`strategy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20220004 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of strategy
-- ----------------------------
INSERT INTO `strategy` VALUES ('20220000', '游客', '雪窦山一日游', '雪窦山', '4', '自然游', '哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈啊哈哈哈哈', '2022-01-04', '400', '212', '0');
INSERT INTO `strategy` VALUES ('20220002', 'xian', '海洋世界', '宁波海洋世界', '3', '文化游', '嗯嗯嗯很好玩的', '2022-11-20', '0', '0', '0');
INSERT INTO `strategy` VALUES ('20220003', 'xian', '东钱湖独行记', '宁波东钱湖', '4', '自然游', '2013年的7月，一个炎炎夏日的周末，在 宁波 当单身狗的日子百无聊赖。自己给自己找乐子吧，就到 宁波 的后花园，东钱湖风景区逛一逛，看看这如诗如画的景色。行程没啥好说的，一开始先是坐公交车到了 马山 湿地公园，在公园逛了一会儿，又坐车到了东钱湖镇上吃了晚餐，看地图说是附近有个小景点叫白石仙枰的小山，算是饭后消食吧，又到山上逛了一圈。', '2022-03-15', '0', '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xxxxxx', '1234567', '13566562287', '45222351312@qq.com', '2022-03-04 15:18:22', 'https://pic2.zhimg.com/v2-6eec875c277de6f7f0b1e402a11397b1_r');
INSERT INTO `user` VALUES ('3', '333333', '3333', '33333', '333333', '2022-03-04 15:18:54', 'https://pic4.zhimg.com/v2-9ddea817568d692ed605a6425471a813_r.jpg');
INSERT INTO `user` VALUES ('4', '444444', '4444444444', '44444444', '4444444', '2022-03-04 15:19:40', 'https://pic2.zhimg.com/80/v2-9807ee8a75a5fc9eba1491e5b010d659_720w.jpg');
INSERT INTO `user` VALUES ('5', '猪八戒', '52136452', '125996355411', '12633520210', '2022-03-04 15:19:39', 'https://pic3.zhimg.com/80/v2-48f08fa1787895e22f9a635282f6d11c_720w.jpg?source=1940ef5c');
INSERT INTO `user` VALUES ('6', 'bbbbb', '000000', '12699633545', null, '2022-03-16 19:51:22', null);
