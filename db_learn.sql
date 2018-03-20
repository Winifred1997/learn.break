/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库（java）
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_learn

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-03-20 13:41:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article_content`
-- ----------------------------
DROP TABLE IF EXISTS `article_content`;
CREATE TABLE `article_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL COMMENT '作者accountId',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '文章内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `type` int(4) DEFAULT NULL COMMENT '文章类型，0：语文；1：数学；2：英语；3：物理；4：化学；5、生物；6、政治；7、地理。',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `title` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文章标题',
  `teacher_account_id` bigint(20) DEFAULT NULL COMMENT '作者accountId',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of article_content
-- ----------------------------
INSERT INTO `article_content` VALUES ('1', '1', '这是内容1一<br/>内容1二adsadasdsadsaddsad\\nscxvxzzvvxcvasd\\nsadsaa', '2018-03-15 18:35:21', '0', '2018-03-15 18:35:24', '这是标题1', '1');
INSERT INTO `article_content` VALUES ('2', '2', '这是内容2一<br/>内容2dsadsad二dsadsadsadvcxzvcvcxzvcvxvcx', '2018-03-15 18:36:00', '0', '2018-03-15 18:36:06', '这是标题2', '1');

-- ----------------------------
-- Table structure for `article_read_log`
-- ----------------------------
DROP TABLE IF EXISTS `article_read_log`;
CREATE TABLE `article_read_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL COMMENT '作者accountId',
  `article_id` bigint(20) DEFAULT NULL COMMENT '文章id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `teacher_account_id` bigint(20) DEFAULT NULL COMMENT '作者accountId',
  `title` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文章标题',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of article_read_log
-- ----------------------------
INSERT INTO `article_read_log` VALUES ('1', '6', '1', '2018-03-19 20:01:21', '1', '文章历史标题1');
INSERT INTO `article_read_log` VALUES ('2', '6', '2', '2018-03-19 20:06:41', '1', '文章历史标题2');

-- ----------------------------
-- Table structure for `integral`
-- ----------------------------
DROP TABLE IF EXISTS `integral`;
CREATE TABLE `integral` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL COMMENT '作者accountId',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `integral` bigint(20) DEFAULT NULL COMMENT '当前积分',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `now_integral` bigint(20) DEFAULT NULL COMMENT '当前积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of integral
-- ----------------------------
INSERT INTO `integral` VALUES ('51', '6', '2018-03-19 17:52:51', '10', '2018-03-20 11:17:03', '0');

-- ----------------------------
-- Table structure for `teacher_account`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_account`;
CREATE TABLE `teacher_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `password` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_name` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
  `nick_name` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of teacher_account
-- ----------------------------
INSERT INTO `teacher_account` VALUES ('1', '2018-03-12 09:32:41', 'admin', '2018-03-12 09:32:49', 'admin', '昵称');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar_url` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `city` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市',
  `country` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '国家',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `gender` int(1) DEFAULT NULL COMMENT '性别',
  `language` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '语言',
  `nick_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `province` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省份',
  `signature` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '唯一标识',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo4LkvZBW1xX5LDeHzjkIJJTibEzOkXFqG5rTGCIevrJmpw9ibdtddCViaJQibxpicVbJLfKSsBtT15J8w/0', '', 'China', '2018-03-17 17:32:51', '1', 'zh_CN', '高兴就好[[%F0%9F%8C%AA]]', '', 'ceea3d7863317179bc8b5fa2e4fe6a290388438a', '2018-03-17 17:46:09');
INSERT INTO `user_info` VALUES ('2', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo4LkvZBW1xX5LDeHzjkIJJTibEzOkXFqG5rTGCIevrJmpw9ibdtddCViaJQibxpicVbJLfKSsBtT15J8w/0', '', 'China', '2018-03-17 17:48:52', '1', 'zh_CN', '高兴就好[[%F0%9F%8C%AA]]', '', 'fd282e7de9f64a8d4f7fa87d4d89fe7b31ef62ba', '2018-03-17 17:52:29');
INSERT INTO `user_info` VALUES ('3', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo4LkvZBW1xX5LDeHzjkIJJTibEzOkXFqG5rTGCIevrJmpw9ibdtddCViaJQibxpicVbJLfKSsBtT15J8w/0', '', 'China', '2018-03-17 18:22:03', '1', 'zh_CN', '高兴就好[[%F0%9F%8C%AA]]', '', '46087682c90094296888e087d476fef404ba70d6', '2018-03-17 18:22:03');
INSERT INTO `user_info` VALUES ('4', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo4LkvZBW1xX5LDeHzjkIJJTibEzOkXFqG5rTGCIevrJmpw9ibdtddCViaJQibxpicVbJLfKSsBtT15J8w/0', '', 'China', '2018-03-17 18:22:46', '1', 'zh_CN', '高兴就好[[%F0%9F%8C%AA]]', '', '97230ce120d9d369c6b312457f47c4fb81c04b57', '2018-03-17 18:24:45');
INSERT INTO `user_info` VALUES ('5', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo4LkvZBW1xX5LDeHzjkIJJTibEzOkXFqG5rTGCIevrJmpw9ibdtddCViaJQibxpicVbJLfKSsBtT15J8w/0', '', 'China', '2018-03-19 09:16:40', '1', 'zh_CN', '高兴就好[[%F0%9F%8C%AA]]', '', 'd33788ab662f4a9e9b577a6533c14bba56fe0ca3', '2018-03-19 09:17:58');
INSERT INTO `user_info` VALUES ('6', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo4LkvZBW1xX5LDeHzjkIJJTibEzOkXFqG5rTGCIevrJmpw9ibdtddCViaJQibxpicVbJLfKSsBtT15J8w/0', '', 'China', '2018-03-19 09:19:45', '1', 'zh_CN', '高兴就好[[%F0%9F%8C%AA]]', '', '24b5d4bdf04dcfeae82726b52302b8d5b42a586a', '2018-03-20 11:16:18');
INSERT INTO `user_info` VALUES ('7', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo4LkvZBW1xX5LDeHzjkIJJTibEzOkXFqG5rTGCIevrJmpw9ibdtddCViaJQibxpicVbJLfKSsBtT15J8w/0', '', 'China', '2018-03-20 11:22:28', '1', 'zh_CN', '高兴就好[[%F0%9F%8C%AA]]', '', '98a7b656a22dabedee4d179451c0fb0b600bafaf', '2018-03-20 11:23:19');
INSERT INTO `user_info` VALUES ('8', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo4LkvZBW1xX5LDeHzjkIJJTibEzOkXFqG5rTGCIevrJmpw9ibdtddCViaJQibxpicVbJLfKSsBtT15J8w/0', '', 'China', '2018-03-20 11:50:03', '1', 'zh_CN', '高兴就好[[%F0%9F%8C%AA]]', '', 'cdfc6054eaf7380d9636b2053813183ebf0754ba', '2018-03-20 11:56:53');
INSERT INTO `user_info` VALUES ('9', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo4LkvZBW1xX5LDeHzjkIJJTibEzOkXFqG5rTGCIevrJmpw9ibdtddCViaJQibxpicVbJLfKSsBtT15J8w/0', '', 'China', '2018-03-20 13:07:37', '1', 'zh_CN', '高兴就好[[%F0%9F%8C%AA]]', '', 'ff8ce98307ad64a4c9dfea2c1de13d2ba07e9f98', '2018-03-20 13:07:52');
