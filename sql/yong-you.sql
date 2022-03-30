/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : yong-you

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2022-03-30 20:44:49
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
INSERT INTO `admin` VALUES ('1007', 'yyy', 'abcdefg', '0', '普通管理员', null);
INSERT INTO `admin` VALUES ('1008', 'syc', '000000', '0', '普通管理员', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', 'xian', '界面不清', null, '2022-03-08 15:27:58');
INSERT INTO `feedback` VALUES ('2', '游客', '容易出bug', null, '2022-03-08 15:28:17');
INSERT INTO `feedback` VALUES ('7', '游客', '界面不美观', 'http://localhost:9090/file/47960641468b431fa4c36ad8ce93699e.png', '2022-03-29 18:51:03');
INSERT INTO `feedback` VALUES ('9', '啊啊啊', '大概十点半', '', '2022-03-29 19:24:21');
INSERT INTO `feedback` VALUES ('10', 'Ursula', '啊啊啊', 'http://localhost:9090/file/59c58635b0174fcd87ebf89f8441ff40.png', '2022-03-30 13:53:41');
INSERT INTO `feedback` VALUES ('12', 'Ursula', '数据不显示', 'http://localhost:9090/file/9b8b46e0af4740b486bb3e58b9ade404.png', '2022-03-30 14:00:09');

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
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('23', '庆安会馆.jpeg', 'jpeg', '182124', 'http://localhost:9090/file/12517f86ea7944c9a100be461005580a.jpeg', '6c06054f669eb94b1938682d7ac51c78', '0', '1');
INSERT INTO `file` VALUES ('24', '河姆渡遗址.jpg', 'jpg', '145267', 'http://localhost:9090/file/db69269ad08f4fc0b26e085bff528b7c.jpg', 'bab8109135879033a91cadc13a5ea0b7', '0', '1');
INSERT INTO `file` VALUES ('25', '东钱湖.jpeg', 'jpeg', '113398', 'http://localhost:9090/file/7e801a0bee9548829393f39c63e9dcb9.jpeg', '7cec6b8f03d0fb45995e361d62f09f86', '0', '1');
INSERT INTO `file` VALUES ('26', '老外滩.jpeg', 'jpeg', '121362', 'http://localhost:9090/file/26a74bdf687f4e9ca678f4a3326a771d.jpeg', 'cd771d33cfcd52b35e32d9ba24d50a04', '0', '1');
INSERT INTO `file` VALUES ('27', '浙东小九寨.jpeg', 'jpeg', '260809', 'http://localhost:9090/file/6ef19dab8c2240c182ef81902203fda6.jpeg', 'e1185158d69f47dc00e79cfede3e7a3f', '0', '1');
INSERT INTO `file` VALUES ('28', '宁波植物园.jpeg', 'jpeg', '214317', 'http://localhost:9090/file/2e8a8fffcaca419fb791a4b9ec708fa2.jpeg', 'f253e525670f71c9fae7002b986db649', '0', '1');
INSERT INTO `file` VALUES ('29', '浙东四明山.jpeg', 'jpeg', '85821', 'http://localhost:9090/file/d0cd10e86f884dbb9abaa98e67a974e6.jpeg', 'bea201038b85438dbb40fed581cd9cee', '0', '1');
INSERT INTO `file` VALUES ('30', '宁波海洋世界.jpeg', 'jpeg', '90958', 'http://localhost:9090/file/159fb2d9d44842e3b781953acddfc3be.jpeg', '39f95943c3e0e46f7586dadef590dd07', '0', '1');
INSERT INTO `file` VALUES ('31', '天一阁.jpeg', 'jpeg', '118550', 'http://localhost:9090/file/65692664f5f94f2fbe65d7c1f075ce7a.jpeg', 'f3b62c47057ab04ef1fe250e711b4800', '0', '1');
INSERT INTO `file` VALUES ('32', '雅戈尔动物园.jpeg', 'jpeg', '160586', 'http://localhost:9090/file/83dae2dadf254df89fd883b8bfc29e48.jpeg', '4f2e6b5e746ea76295ce12ab77bbca40', '0', '1');
INSERT INTO `file` VALUES ('33', '1.png', 'png', '5941', 'http://localhost:9090/file/47960641468b431fa4c36ad8ce93699e.png', 'ff3560eca4e66189dfb9e20db70c5184', '0', '1');
INSERT INTO `file` VALUES ('55', 'nFyIXmNInn7Ve84d0e641c221a9047898a724cb96008.png', 'png', '95006', 'http://localhost:9090/file/59c58635b0174fcd87ebf89f8441ff40.png', 'e84d0e641c221a9047898a724cb96008', '0', '1');
INSERT INTO `file` VALUES ('56', 'LPkvXucEDtSt6f4983592b3f48b5084584bb734ce233.png', 'png', '7193', 'http://localhost:9090/file/9b8b46e0af4740b486bb3e58b9ade404.png', '6f4983592b3f48b5084584bb734ce233', '0', '1');
INSERT INTO `file` VALUES ('57', '0k9UFKkYsiKA6f4983592b3f48b5084584bb734ce233.png', 'png', '7193', 'http://localhost:9090/file/9b8b46e0af4740b486bb3e58b9ade404.png', '6f4983592b3f48b5084584bb734ce233', '0', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=1212 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of scenic
-- ----------------------------
INSERT INTO `scenic` VALUES ('1201', 'http://localhost:9090/file/83dae2dadf254df89fd883b8bfc29e48.jpeg', '雅戈尔动物园', '宁波野生动物园坐落在东钱湖度假区内，里面有丰富的动物和有趣的游乐项目、表演活动，适合带小朋友来科普观光、认知动物。\r\n\r\n动物园有南、北两个大门，南门离主要观赏区较远，进来是风铃广场和鸽子园。', '宁波市鄞州区东钱湖旅游度假区高钱村（近鄞县大道）)', '5月1日-10月31日 08:30-16:30(最晚入园15:30)；11月1日-次年4月30日 09:00-16:30(最晚入园15:30)', '4', '自然游', '4.6', '120', '0574-88378378');
INSERT INTO `scenic` VALUES ('1202', 'http://localhost:9090/file/65692664f5f94f2fbe65d7c1f075ce7a.jpeg', '天一阁博物馆', '现存最早的私家藏书楼，感受古老文化氛围', '宁波市海曙区天一街10号', '9:00-16:30 周一闭关，法定节假日除外', '3', '文化游', '3', null, '15844255536');
INSERT INTO `scenic` VALUES ('1204', 'http://localhost:9090/file/159fb2d9d44842e3b781953acddfc3be.jpeg', '宁波海洋世界', '宁波市一家展示海洋生物,宣传海洋知识的专业海洋馆', '宁波市鄞州区桑田路936号', '8:15-22:00 全天开放', '3', '文化游', '5', '200', '');
INSERT INTO `scenic` VALUES ('1205', 'http://localhost:9090/file/d0cd10e86f884dbb9abaa98e67a974e6.jpeg', '浙东四明山抗日根据地', '全国百个红色旅游经典景区之一', '宁波市余姚梁弄镇', '全天开放', '2', '红色游', '4', null, '');
INSERT INTO `scenic` VALUES ('1206', 'http://localhost:9090/file/2e8a8fffcaca419fb791a4b9ec708fa2.jpeg', '宁波植物园', '园内保留一段老铁路路基，和一台东方红火车头。在老铁路路基上铺了一小段游玩用的小小铁轨，坐小火车来回10元钱。目前只有1号门和3号门，还是3号门进出方便。', '宁波市镇海区北环东路1188号', '全年 08:00-17:00(停止售票16:30,最晚入园16:30)；3月18日-4月10日 08:00-20:30(停止售票20:00,最晚入园20:00)', '4', '自然游', '4.6', '18', null);
INSERT INTO `scenic` VALUES ('1207', 'http://localhost:9090/file/6ef19dab8c2240c182ef81902203fda6.jpeg', '浙东小九寨', '浙东小九寨景区地处四明山北麓，位于宁波市余姚大隐镇芝林村，由宁波华东城集团投资开发。因其境内山峦连绵，山岙弯弯，竹丰林茂，溪流纵横，幽谷、溪流、竹林景色诱人，故有“浙东小九寨”之美称。', '\r\n宁波市余姚市大隐镇芝林村', '全年 08:00-16:30(最晚入园16:00)', '4', '自然游', '4.4', '45', '\r\n0574-62912555');
INSERT INTO `scenic` VALUES ('1208', 'http://localhost:9090/file/26a74bdf687f4e9ca678f4a3326a771d.jpeg', '宁波老外滩', '欧式哥特老建筑的酒吧一条街', '宁波市江北区江夏街与甬江大桥交汇口', '全天', '3', '文化游', '4.5', null, '0574-87027104');
INSERT INTO `scenic` VALUES ('1209', 'http://localhost:9090/file/7e801a0bee9548829393f39c63e9dcb9.jpeg', '东钱湖国家旅游度假区', '浙江最大的淡水湖，由谷子湖、梅湖和外湖组成，相当于杭州西湖的四倍', '宁波市鄞州区安石路777号', '全天 (1月1日-12月31日 周一-周日)', '4', '自然游', '4', null, '400-826-8000;0574-83015959;');
INSERT INTO `scenic` VALUES ('1210', 'http://localhost:9090/file/db69269ad08f4fc0b26e085bff528b7c.jpg', '河姆渡遗址', '中国晚期新石器时代遗址，1973年开始发掘，是中国已发现的最早的新石器时期文化遗址之一。', '宁波市余姚市河姆渡镇浪墅桥村', '不对外开放(河姆渡遗址博物馆/田螺山遗址现场馆闭馆(除法定节假日))', '3', '文化游', '5', null, '0574-62963731');
INSERT INTO `scenic` VALUES ('1211', 'http://localhost:9090/file/12517f86ea7944c9a100be461005580a.jpeg', '庆安会馆', '天后宫，既是祭祀天后妈祖的殿堂，又是行业聚会的场所', '宁波市江东区江东北路156号（近木行路）', '8:30-16:30 (1月1日-12月31日 周一-周日)', '3', '文化游', '4.5', '10', '0574-87700187');

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
  `open_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(20) NOT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `avatar_url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `token` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'oN1im4mG52hLplZFqlrQZuBiA7Vs', 'Ursula', '13566562287', '424533406@qq.com', '2022-03-30 20:43:47', 'https://thirdwx.qlogo.cn/mmopen/vi_32/skbupBhJ87qbyOw42bDXkIpM9MzGfVbfRdIryHrGpmSr7I9PPqIwr234Hy3m4cCFXMNKBCds45orK5AiaQDdGkQ/132', null);
