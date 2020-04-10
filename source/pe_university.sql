/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : xh_college

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 10/04/2020 17:53:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pe_university
-- ----------------------------
DROP TABLE IF EXISTS `pe_university`;
CREATE TABLE `pe_university` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `region_id` int(10) NOT NULL COMMENT '地区id',
  `name` varchar(100) NOT NULL COMMENT '院校名称',
  `code` varchar(10) NOT NULL COMMENT '院校编码',
  `badge` varchar(255) NOT NULL DEFAULT '' COMMENT '校徽',
  `subordinate` varchar(20) NOT NULL COMMENT '院校隶属',
  `pro_school_type` varchar(20) NOT NULL DEFAULT '' COMMENT '学校类型',
  `flag_211` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否为211 0否 1是',
  `flag_985` tinyint(2) NOT NULL COMMENT '是否为985 0否 1是',
  `is_graduate_school` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否为研究生院 0否1是',
  `is_self_scribing` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否为自划线',
  `is_doctoral_college` tinyint(2) NOT NULL COMMENT '是否为博士点',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `inx_region_id` (`region_id`) USING BTREE,
  KEY `inx_code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='院校表';

-- ----------------------------
-- Records of pe_university
-- ----------------------------
BEGIN;
INSERT INTO `pe_university` VALUES (1, 1, '北京大学', '10001', '', '教育部', '综合类', 1, 1, 1, 1, 1, 1, '2020-03-27 12:28:59', '2020-03-31 12:34:26');
INSERT INTO `pe_university` VALUES (2, 1, '中国人民大学', '10002', '', '教育部', '综合类', 1, 1, 1, 1, 1, 1, '2020-03-27 12:28:59', '2020-03-31 12:34:27');
INSERT INTO `pe_university` VALUES (3, 1, '清华大学', '10003', '', '教育部', '理工类', 1, 1, 1, 1, 1, 1, '2020-03-27 12:28:59', '2020-03-31 12:34:27');
INSERT INTO `pe_university` VALUES (4, 1, '北京交通大学', '10004', '', '教育部', '理工类', 1, 0, 1, 0, 1, 1, '2020-03-27 12:28:59', '2020-03-31 12:34:27');
INSERT INTO `pe_university` VALUES (5, 1, '北京工业大学', '10005', '', '北京市', '理工类', 1, 0, 0, 0, 1, 1, '2020-03-27 12:28:59', '2020-03-31 12:34:27');
INSERT INTO `pe_university` VALUES (6, 1, '北京航空航天大学', '10006', '', '工业与信息化部', '理工类', 1, 1, 1, 1, 1, 1, '2020-03-27 12:28:59', '2020-03-31 12:34:27');

COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
