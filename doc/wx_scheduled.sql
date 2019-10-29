/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : wx_scheduled

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 29/10/2019 16:49:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_scheduled_config
-- ----------------------------
DROP TABLE IF EXISTS `t_scheduled_config`;
CREATE TABLE `t_scheduled_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `class_reference` varchar(255) DEFAULT NULL COMMENT '类',
  `cron` varchar(100) DEFAULT NULL COMMENT '表达式',
  `class_param` varchar(100) DEFAULT NULL COMMENT '初始参数',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `state` tinyint(4) DEFAULT NULL COMMENT '启动停止标识',
  `sys_number` int(11) DEFAULT NULL COMMENT '系统标识',
  `flag1` varchar(255) DEFAULT NULL COMMENT '预留',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
