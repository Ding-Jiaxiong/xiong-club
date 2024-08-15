/*
 Navicat Premium Data Transfer

 Source Server         : 面试熊Club MySQL
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : 116.196.77.213:3306
 Source Schema         : xiongclub

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 14/08/2024 22:30:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父id',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '权限类型 0菜单 1操作',
  `menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单路由',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '状态 0启用 1禁用',
  `show` tinyint(2) NULL DEFAULT NULL COMMENT '展示状态 0展示 1隐藏',
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `permission_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限唯一标识',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色唯一标识',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_role
-- ----------------------------

-- ----------------------------
-- Table structure for auth_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_permission`;
CREATE TABLE `auth_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) NULL DEFAULT NULL COMMENT '权限id',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称/账号',
  `nick_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` tinyint(2) NULL DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '状态 0启用 1禁用',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  `ext_json` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '特殊字段',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_user
-- ----------------------------

-- ----------------------------
-- Table structure for auth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for subject_brief
-- ----------------------------
DROP TABLE IF EXISTS `subject_brief`;
CREATE TABLE `subject_brief`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` int(20) NULL DEFAULT NULL COMMENT '题目id',
  `subject_answer` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '题目答案',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '简答题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_brief
-- ----------------------------
INSERT INTO `subject_brief` VALUES (1, 12, '题目答案', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (2, 13, '题目答案2', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_category
-- ----------------------------
DROP TABLE IF EXISTS `subject_category`;
CREATE TABLE `subject_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `category_type` tinyint(2) NULL DEFAULT NULL COMMENT '分类类型',
  `image_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标连接',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级id',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除 0: 未删除 1: 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_category
-- ----------------------------
INSERT INTO `subject_category` VALUES (1, '后端', 1, 'http://image/123', 0, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (2, '前端', 1, 'http://image/123', 0, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (3, '测试', 1, 'http://image/123', 0, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (4, '框架', 2, 'http://image/123', 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (5, '并发', 2, 'http://image/123', 1, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_info
-- ----------------------------
DROP TABLE IF EXISTS `subject_info`;
CREATE TABLE `subject_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目名称',
  `subject_difficult` tinyint(4) NULL DEFAULT NULL COMMENT '题目难度',
  `settle_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出题人名',
  `subject_type` tinyint(4) NULL DEFAULT NULL COMMENT '题目类型 1单选 2多选 3判断 4简答',
  `subject_score` tinyint(4) NULL DEFAULT NULL COMMENT '题目分数',
  `subject_parse` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目解析',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_info
-- ----------------------------
INSERT INTO `subject_info` VALUES (1, 'SpringBoot自动装配原理是什么？', 1, NULL, 1, 2, '题目解析', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (2, 'SpringBoot自动装配原理是什么？【多选题版例子】', 1, NULL, 2, 10, '题目解析', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (3, 'SpringBoot自动装配原理是什么？【判断题版】', 1, NULL, 3, 8, '题目解析', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (12, 'SpringBoot自动装配原理是什么？【简答题版】', 1, NULL, 4, 6, '题目解析', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (13, '多线程实现方式有哪几种？2', 1, NULL, 4, 2, '题目解析2', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_judge
-- ----------------------------
DROP TABLE IF EXISTS `subject_judge`;
CREATE TABLE `subject_judge`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '题目id',
  `is_correct` tinyint(2) NULL DEFAULT NULL COMMENT '是否正确',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '判断题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_judge
-- ----------------------------
INSERT INTO `subject_judge` VALUES (1, 3, 1, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_label
-- ----------------------------
DROP TABLE IF EXISTS `subject_label`;
CREATE TABLE `subject_label`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `label_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签分类',
  `sort_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `category_id` bigint(20) NULL DEFAULT NULL,
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_label
-- ----------------------------
INSERT INTO `subject_label` VALUES (1, 'Spirng', 10, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_label` VALUES (2, 'SpringMVC', 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_label` VALUES (3, 'SpringBoot', 2, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_label` VALUES (4, 'MySQL', 1, 1, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_mapping
-- ----------------------------
DROP TABLE IF EXISTS `subject_mapping`;
CREATE TABLE `subject_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '题目id',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '分类id',
  `label_id` bigint(20) NULL DEFAULT NULL COMMENT '标签id',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目分类关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_mapping
-- ----------------------------
INSERT INTO `subject_mapping` VALUES (3, 1, 4, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (4, 1, 4, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (5, 1, 5, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (6, 1, 5, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (7, 2, 4, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (8, 2, 4, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (9, 2, 5, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (10, 2, 5, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (11, 3, 4, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (12, 3, 4, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (13, 3, 5, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (14, 3, 5, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (43, 12, 4, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (44, 12, 4, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (45, 12, 5, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (46, 12, 5, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (47, 13, 5, 11, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_multiple
-- ----------------------------
DROP TABLE IF EXISTS `subject_multiple`;
CREATE TABLE `subject_multiple`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '题目id',
  `option_type` bigint(4) NULL DEFAULT NULL COMMENT '选项类型',
  `option_content` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项内容',
  `is_correct` tinyint(2) NULL DEFAULT NULL COMMENT '是否正确',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '多选题信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_multiple
-- ----------------------------
INSERT INTO `subject_multiple` VALUES (1, 2, 1, '自动的', 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_multiple` VALUES (2, 2, 2, '其实是用配置文件', 1, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_radio
-- ----------------------------
DROP TABLE IF EXISTS `subject_radio`;
CREATE TABLE `subject_radio`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '题目id',
  `option_type` tinyint(4) NULL DEFAULT NULL COMMENT 'a,b,c,d',
  `option_content` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项内容',
  `is_correct` tinyint(2) NULL DEFAULT NULL COMMENT '是否正确',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '单选题信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_radio
-- ----------------------------
INSERT INTO `subject_radio` VALUES (1, 1, 1, '自动的', 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_radio` VALUES (2, 1, 2, '其实是用配置文件', 0, NULL, NULL, NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
