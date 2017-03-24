/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : test_spring_boot

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-03-24 18:57:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for examples
-- ----------------------------
DROP TABLE IF EXISTS `examples`;
CREATE TABLE `examples` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examples
-- ----------------------------
INSERT INTO `examples` VALUES ('11', 'string');
INSERT INTO `examples` VALUES ('111', 'example');

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务分组',
  `job_status` char(1) NOT NULL COMMENT '0：无效，1：有效',
  `cron_expression` varchar(32) NOT NULL COMMENT 'cron表达式',
  `bean_class` varchar(64) NOT NULL COMMENT '任务执行时调用哪个类的方法 包名+类名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'test', '测试', '1', '0 * * * * ?', 'com.springboot.demo.job.ExamplesJob', '2017-03-23 17:56:54', '2017-03-23 17:56:54', 'test');
