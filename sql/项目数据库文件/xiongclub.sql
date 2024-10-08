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

 Date: 18/08/2024 16:08:29
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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES (1, '新增题目', 1, 1, '1adiwd/awdw', 1, 1, 'httt://1.png', 'subject:add', NULL, NULL, NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES (1, '管理员', 'admin_user', NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_role` VALUES (2, '普通用户', 'normal_user', NULL, NULL, NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_role_permission
-- ----------------------------
INSERT INTO `auth_role_permission` VALUES (1, 2, 1, NULL, NULL, NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES (1, '家雄', '海绵宝宝', '12312312@qq.com', '12321312', '06cb2346090c9a60fe3edb6841a9cf77', 1, 'https://avatars.githubusercontent.com/u/61930795?v=4', 0, '个人介绍', '留存json', NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_user` VALUES (2, '派大星', '派大星', '12312312@qq.com', '12321312', '06cb2346090c9a60fe3edb6841a9cf77', 1, 'https://avatars.githubusercontent.com/u/61930795?v=4', 0, '个人介绍', '留存json', NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_user` VALUES (3, '章鱼哥', '章鱼哥', '12312312@qq.com', '12321312', '06cb2346090c9a60fe3edb6841a9cf77', 1, 'https://avatars.githubusercontent.com/u/61930795?v=4', 0, '个人介绍', '留存json', NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_user` VALUES (4, 'oh_tG6SENPKGoINk9-qDRtW9YbRM', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_user` VALUES (5, 'oh_tG6cjQH3sZXq6EmQ7u9hgE7dc', '丁家雄', NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_user` VALUES (8, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '丁家雄', 'xiong@qq.com', '18708360500', '19991012', 1, 'http://116.196.77.213:9000/user/icon/mytouxiang.jpg', 0, '风轻轻拂过半山', '留存json', NULL, NULL, NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
INSERT INTO `auth_user_role` VALUES (1, 2, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_user_role` VALUES (2, 3, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_user_role` VALUES (3, 4, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_user_role` VALUES (4, 5, 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `auth_user_role` VALUES (7, 8, 2, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for practice_detail
-- ----------------------------
DROP TABLE IF EXISTS `practice_detail`;
CREATE TABLE `practice_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `practice_id` bigint(20) NULL DEFAULT NULL COMMENT '练题id',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '题目id',
  `subject_type` int(11) NULL DEFAULT NULL COMMENT '题目类型',
  `answer_status` int(11) NULL DEFAULT NULL COMMENT '回答状态',
  `answer_content` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '回答内容',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '练习详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of practice_detail
-- ----------------------------
INSERT INTO `practice_detail` VALUES (1, 3, 20, 1, 0, '', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:24:57', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (2, 3, 21, 2, 0, '', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:24:57', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (3, 3, 22, 3, 0, '', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:24:57', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (4, 4, 20, 1, 1, '3', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:38:14', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (5, 4, 21, 2, 1, '1,2,4', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:39:09', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (6, 4, 22, 3, 0, '', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:39:11', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (7, 5, 20, 1, 1, '3', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:45:54', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (8, 5, 21, 2, 1, '1,2,4', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:47:14', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (9, 5, 22, 3, 0, '', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:47:18', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (10, 6, 20, 1, 1, '3', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:55:17', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (11, 6, 21, 2, 1, '1,2,4', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:57:36', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (12, 6, 22, 3, 0, '', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 22:02:24', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (13, 7, 20, 1, 1, '3', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 22:42:01', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (14, 7, 21, 2, 1, '1,2,4', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 22:42:04', NULL, NULL, 0);
INSERT INTO `practice_detail` VALUES (15, 7, 22, 3, 0, '', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 22:42:49', NULL, NULL, 0);

-- ----------------------------
-- Table structure for practice_info
-- ----------------------------
DROP TABLE IF EXISTS `practice_info`;
CREATE TABLE `practice_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `set_id` bigint(20) NULL DEFAULT NULL COMMENT '套题id',
  `complete_status` int(11) NULL DEFAULT NULL COMMENT '是否完成 1完成 0未完成',
  `time_use` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用时',
  `submit_time` datetime NULL DEFAULT NULL COMMENT '交卷时间',
  `correct_rate` decimal(10, 2) NULL DEFAULT NULL COMMENT '正确率',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '练习表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of practice_info
-- ----------------------------
INSERT INTO `practice_info` VALUES (1, 1, 0, '00:00:00', '2024-08-17 20:00:50', 0.00, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 20:00:50', NULL, NULL, 0);
INSERT INTO `practice_info` VALUES (2, 3, 0, '00:00:00', '2024-08-17 20:52:10', 0.00, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 20:52:10', NULL, NULL, 0);
INSERT INTO `practice_info` VALUES (3, 4, 1, '00:01:18', '2024-08-17 21:24:55', 0.00, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:23:38', NULL, NULL, 0);
INSERT INTO `practice_info` VALUES (4, 5, 1, '00:01:53', '2024-08-17 21:39:10', 66.67, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:37:17', NULL, NULL, 0);
INSERT INTO `practice_info` VALUES (5, 6, 1, '00:01:45', '2024-08-17 21:47:17', 66.67, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:45:32', NULL, NULL, 0);
INSERT INTO `practice_info` VALUES (6, 7, 1, '00:05:31', '2024-08-17 21:58:41', 66.67, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:53:11', NULL, NULL, 0);
INSERT INTO `practice_info` VALUES (7, 8, 1, '00:00:59', '2024-08-17 22:42:48', 66.67, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 22:41:50', NULL, NULL, 0);
INSERT INTO `practice_info` VALUES (8, 9, 0, '00:00:00', '2024-08-18 09:31:42', 0.00, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 09:31:42', NULL, NULL, 1);

-- ----------------------------
-- Table structure for practice_set
-- ----------------------------
DROP TABLE IF EXISTS `practice_set`;
CREATE TABLE `practice_set`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `set_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '套题名称',
  `set_type` int(11) NULL DEFAULT NULL COMMENT '套题类型 1实时生成 2预设套题',
  `set_heat` int(11) NULL DEFAULT NULL COMMENT '热度',
  `set_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '套题描述',
  `primary_category_id` bigint(20) NULL DEFAULT NULL COMMENT '大类id',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '套题信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of practice_set
-- ----------------------------
INSERT INTO `practice_set` VALUES (1, '缓存、数据库等专项练习', 2, 200, '高质量套卷，只有三道题', 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 19:32:08', NULL, NULL, 0);
INSERT INTO `practice_set` VALUES (2, '缓存、数据库等专项练习', 1, NULL, NULL, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 19:36:26', NULL, NULL, 0);
INSERT INTO `practice_set` VALUES (3, '缓存、数据库等专项练习', 1, NULL, NULL, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 20:52:08', NULL, NULL, 0);
INSERT INTO `practice_set` VALUES (4, '缓存、数据库等专项练习', 1, NULL, NULL, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:23:37', NULL, NULL, 0);
INSERT INTO `practice_set` VALUES (5, '缓存、数据库等专项练习', 1, NULL, NULL, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:37:16', NULL, NULL, 0);
INSERT INTO `practice_set` VALUES (6, '缓存、数据库等专项练习', 1, NULL, NULL, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:45:31', NULL, NULL, 0);
INSERT INTO `practice_set` VALUES (7, '缓存、数据库等专项练习', 1, NULL, NULL, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:53:10', NULL, NULL, 0);
INSERT INTO `practice_set` VALUES (8, '缓存、数据库等专项练习', 1, NULL, NULL, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 22:41:48', NULL, NULL, 0);
INSERT INTO `practice_set` VALUES (9, '缓存、数据库等专项练习', 1, NULL, NULL, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 09:31:41', NULL, NULL, 0);

-- ----------------------------
-- Table structure for practice_set_detail
-- ----------------------------
DROP TABLE IF EXISTS `practice_set_detail`;
CREATE TABLE `practice_set_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `set_id` bigint(20) NOT NULL COMMENT '套题id',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '题目id',
  `subject_type` int(11) NULL DEFAULT NULL COMMENT '题目类型',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '套题内容表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of practice_set_detail
-- ----------------------------
INSERT INTO `practice_set_detail` VALUES (1, 1, 20, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 19:32:08', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (2, 1, 21, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 19:32:08', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (3, 1, 22, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 19:32:08', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (4, 2, 20, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 19:36:26', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (5, 2, 21, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 19:36:26', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (6, 2, 22, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 19:36:26', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (7, 3, 20, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 20:52:09', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (8, 3, 21, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 20:52:09', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (9, 3, 22, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 20:52:09', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (10, 4, 20, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:23:37', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (11, 4, 21, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:23:37', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (12, 4, 22, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:23:37', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (13, 5, 20, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:37:16', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (14, 5, 21, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:37:16', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (15, 5, 22, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:37:17', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (16, 6, 20, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:45:31', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (17, 6, 21, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:45:31', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (18, 6, 22, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:45:32', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (19, 7, 20, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:53:10', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (20, 7, 21, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:53:10', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (21, 7, 22, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 21:53:10', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (22, 8, 20, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 22:41:49', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (23, 8, 21, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 22:41:49', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (24, 8, 22, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 22:41:49', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (25, 9, 20, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 09:31:41', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (26, 9, 21, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 09:31:41', NULL, NULL, 0);
INSERT INTO `practice_set_detail` VALUES (27, 9, 22, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 09:31:41', NULL, NULL, 0);

-- ----------------------------
-- Table structure for sensitive_words
-- ----------------------------
DROP TABLE IF EXISTS `sensitive_words`;
CREATE TABLE `sensitive_words`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `words` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `type` int(11) NULL DEFAULT 0 COMMENT '1=黑名单 2=白名单',
  `is_deleted` int(11) NULL DEFAULT NULL COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '敏感词表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sensitive_words
-- ----------------------------

-- ----------------------------
-- Table structure for share_circle
-- ----------------------------
DROP TABLE IF EXISTS `share_circle`;
CREATE TABLE `share_circle`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '圈子ID',
  `parent_id` bigint(20) NOT NULL COMMENT '父级ID,-1为大类',
  `circle_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '圈子名称',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '圈子图片',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '圈子信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of share_circle
-- ----------------------------
INSERT INTO `share_circle` VALUES (1, -1, '推荐圈子', 'http://1123.img', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 14:19:22', NULL, NULL, 0);
INSERT INTO `share_circle` VALUES (2, 1, 'Java圈子', 'https://img0.baidu.com/it/u=3569431596,3072439958&fm=253&fmt=auto&app=138&f=JPEG?w=893&h=500', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 14:21:18', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 14:47:35', 0);
INSERT INTO `share_circle` VALUES (3, 1, '前端圈子【更新版】', 'https://img0.baidu.com/it/u=3813516895,2440098047&fm=253&fmt=auto&app=120&f=JPEG?w=683&h=384', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 14:25:27', NULL, '2024-08-18 14:43:34', 0);
INSERT INTO `share_circle` VALUES (4, 1, '运维圈子【更新版】', 'https://img2.baidu.com/it/u=383026482,2806158636&fm=253&fmt=auto&app=138&f=PNG?w=350&h=245', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 14:36:48', NULL, '2024-08-18 14:44:54', 0);
INSERT INTO `share_circle` VALUES (5, 1, '准备删除的圈子', 'http://1123.img', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 14:48:33', NULL, NULL, 1);

-- ----------------------------
-- Table structure for share_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `share_comment_reply`;
CREATE TABLE `share_comment_reply`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `moment_id` int(11) NOT NULL COMMENT '原始动态ID',
  `reply_type` int(11) NOT NULL COMMENT '回复类型 1评论 2回复',
  `to_id` bigint(20) NULL DEFAULT NULL COMMENT '评论目标id',
  `to_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论人',
  `to_user_author` int(11) NULL DEFAULT NULL COMMENT '评论人是否作者 1=是 0=否',
  `reply_id` bigint(20) NULL DEFAULT NULL COMMENT '回复目标id',
  `reply_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复人',
  `replay_author` int(11) NULL DEFAULT NULL COMMENT '回复人是否作者 1=是 0=否',
  `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `pic_urls` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片内容',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  `parent_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_moment_id`(`moment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论及回复信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of share_comment_reply
-- ----------------------------
INSERT INTO `share_comment_reply` VALUES (1, 1, 1, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', 1, NULL, NULL, NULL, '希望大家天天开心', NULL, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 15:57:34', NULL, NULL, 0, -1);
INSERT INTO `share_comment_reply` VALUES (2, 1, 2, NULL, NULL, NULL, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', 1, '再下一层', NULL, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 15:58:52', NULL, NULL, 0, 1);

-- ----------------------------
-- Table structure for share_message
-- ----------------------------
DROP TABLE IF EXISTS `share_message`;
CREATE TABLE `share_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `from_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '来自人',
  `to_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '送达人',
  `content` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `is_read` int(11) NULL DEFAULT 0 COMMENT '是否被阅读 1是 2否',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_to_id`(`to_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of share_message
-- ----------------------------

-- ----------------------------
-- Table structure for share_moment
-- ----------------------------
DROP TABLE IF EXISTS `share_moment`;
CREATE TABLE `share_moment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '动态ID',
  `circle_id` bigint(20) NOT NULL COMMENT '圈子ID',
  `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '动态内容',
  `pic_urls` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '动态图片内容',
  `reply_count` int(11) NOT NULL DEFAULT 0 COMMENT '回复数',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_circle_id`(`circle_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '动态信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of share_moment
-- ----------------------------
INSERT INTO `share_moment` VALUES (1, 2, '这是我的第一条熊圈，大家好！', NULL, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-18 15:21:46', NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '简答题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_brief
-- ----------------------------
INSERT INTO `subject_brief` VALUES (1, 1, '<p><br></p><ol><li>String（字符串）</li><li>List（列表）</li><li>Hash（字典）</li><li>Set（集合）</li><li>Sorted Set（有序集合）</li></ol><p><br></p><p><strong>String</strong></p><p><br></p><p>String是简单的 key-value 键值对，value 不仅可以是 String，也可以是数字。String在redis内部存储默认就是一个字符串，被redisObject所引用，当遇到incr,decr等操作时会转成数值型进行计算，此时redisObject的encoding字段为int。</p><p><br></p><p><strong>List</strong></p><p><br></p><p>Redis列表是简单的字符串列表，可以类比到C++中的std::list，简单的说就是一个链表或者说是一个队列。可以从头部或尾部向Redis列表添加元素。列表的最大长度为2^32 - 1，也即每个列表支持超过40亿个元素。</p><p><br></p><p>Redis list的实现为一个双向链表，即可以支持反向查找和遍历，更方便操作，不过带来了部分额外的内存开销，Redis内部的很多实现，包括发送缓冲队列等也都是用的这个数据结构。</p><p><br></p><p><strong>Hash</strong></p><p><br></p><p>Redis Hash对应Value内部实际就是一个HashMap，实际这里会有2种不同实现，这个Hash的成员比较少时Redis为了节省内存会采用类似一维数组的方式来紧凑存储，而不会采用真正的HashMap结构，对应的value redisObject的encoding为zipmap,当成员数量增大时会自动转成真正的HashMap。</p><p><br></p><p><strong>Set</strong></p><p><br></p><p>set 的内部实现是一个 value永远为null的HashMap，实际就是通过计算hash的方式来快速排重的，这也是set能提供判断一个成员是否在集合内的原因。</p><p><br></p><p><strong>Sorted Set</strong></p><p><br></p><p>Redis有序集合类似Redis集合，不同的是增加了一个功能，即集合是有序的。一个有序集合的每个成员带有分数，用于进行排序。</p><p><br></p><p>Redis有序集合添加、删除和测试的时间复杂度均为O(1)(固定时间，无论里面包含的元素集合的数量)。列表的最大长度为2^32- 1元素(4294967295，超过40亿每个元素的集合)。</p><p><br></p><p>Redis sorted set的内部使用HashMap和跳跃表(SkipList)来保证数据的存储和有序，HashMap里放的是成员到score的映射，而跳跃表里存放的是所有的成员，排序依据是HashMap里存的score,使用跳跃表的结构可以获得比较高的查找效率，并且在实现上比较简单。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (2, 2, '<p><br></p><p>bitmap：bitmap是一种位数据类型，常常用于统计，大家比较知名的就是布隆过滤器。也可以统计一些大数据量的东西，比如每天有多少优惠券被使用。</p><p><br></p><p>hyperloglog：用于基数统计，基数是数据集去重后元素个数，运用了LogLog的算法。{1,3,5,7,5,7,8} &nbsp; 基数集:{1,3,5,7,8} &nbsp;基数:5</p><p><br></p><p>geo：应用于地理位置计算，主要是经纬度的计算，常见的就是附近的人，可以以当前人的坐标获取周围附近的成员，可以计算经纬度，计算地理位置</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (3, 3, '<p><br></p><p>(1) 速度快，因为数据存在内存中，类似于HashMap，HashMap的优势就是查找和操作的时间复杂度都是O(1)</p><p><br></p><p>(2) 支持丰富数据类型，支持string，list，set，Zset，hash等</p><p><br></p><p>(3) 支持事务，操作都是原子性，所谓的原子性就是对数据的更改要么全部执行，要么全部不执行</p><p><br></p><p>(4) 丰富的特性：可用于缓存，消息，按key设置过期时间，过期后将会自动删除</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (4, 4, '<p><br></p><p>(1) Memcached所有的值均是简单的字符串，redis作为其替代者，支持更为丰富的数据类型</p><p><br></p><p>(2) Redis的速度比Memcached快很多</p><p><br></p><p>(3) Redis可以持久化其数据</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (5, 5, '<p><br></p><p>Redis采用的是单线程模型，因为Redis是一个基于内存的数据库，将所有的数据放入内存，所以使用单线程的操作效率是最高的，多线程会上下文切换消耗大量时间，对于内存系统来说，单线程才能产生更高的效率。但是单线程不意味着整个Redis就一个线程，Redis其他模块还有各自的线程。</p><p><br></p><p>Redis使用I/O threads 指的是网络I/O处理方面使用了多线程，如网络数据的读写和协议解析等，这是因为读写网络的read/write在Redis执行期间占用了大部分CPU时间，如果把这部分模块使用多线程方式实现会对性能带来极大地提升。但是Redis执行命令的核心模块还是单线程的。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (6, 6, '<p><br></p><p>1、更新数据库，同时更新缓存，适合并发场景不高的场景</p><p><br></p><p>2、先删除缓存，再更新数据，再删除缓存</p><p><br></p><p>3、通过消息来更新缓存。</p><p><br></p><p>4、通过canal等消息同步的方式。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (7, 7, '<p><br></p><p>noeviction: 当内存不足以容纳新写入数据时，新写入操作会报错。</p><p><br></p><p>allkeys-lru：当内存不足以容纳新写入数据时，在键空间中，移除最近最少使用的 key。</p><p><br></p><p>allkeys-random：当内存不足以容纳新写入数据时，在键空间中，随机移除某个 key，这个一般没人用吧，为啥要随机，肯定是把最近最少使用的 key 给干掉啊。</p><p><br></p><p>volatile-lru：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，移除最近最少使用的 key。</p><p><br></p><p>volatile-random：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，随机移除某个 key。</p><p><br></p><p>volatile-ttl：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，有更早过期时间的 key 优先移除。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (8, 8, '<p><br></p><p>缓存穿透是指缓存和数据库中都没有的数据，而用户不断发起请求，如发起为id为“-1”的数据或id为特别大不存在的数据。这时的用户很可能是攻击者，攻击会导致数据库压力过大。</p><p><br></p><p>解决方案</p><p><br></p><p>接口层增加校验，如用户鉴权校验，id做基础校验，id&lt;=0的直接拦截；<br>从缓存取不到的数据，在数据库中也没有取到，这时也可以将key-value对写为key-null，缓存有效时间可以设置短点，如30秒（设置太长会导致正常情况也没法使用）。这样可以防止攻击用户反复用同一个id暴力攻击，也可以使用会话重放，防止不断的攻击。</p><p><br></p><h3></h3>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (9, 9, '<p><br></p><p>缓存击穿是指缓存中没有但数据库中有的数据（一般是缓存时间到期），这时由于并发用户特别多，同时读缓存没读到数据，又同时去数据库去取数据，引起数据库压力瞬间增大，造成过大压力</p><p><br></p><p>解决方案：</p><p><br></p><p>设置热点数据永远不过期。<br>加互斥锁</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (10, 10, '<p><br></p><p>缓存雪崩是指缓存中数据大批量到过期时间，而查询数据量巨大，引起数据库压力过大甚至down机。和缓存击穿不同的是，缓存击穿指并发查同一条数据，缓存雪崩是不同数据都过期了，很多数据都查不到从而查数据库。</p><p><br></p><p>解决方案</p><p><br></p><p>缓存数据的过期时间设置随机，防止同一时间大量数据过期现象发生。<br>如果缓存数据库是分布式部署，将热点数据均匀分布在不同的缓存数据库中。也可以是二级缓存，本地和redis共同使用。<br>设置热点数据永远不过期。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (11, 11, '<p>setex：<br>setex key seconds value：将key值设置为value，并将设置key的生存周期<br>1，属于原子操作，作用和set key value、expire key seconds作用一致。<br>2，如果key值存在，使用setex将覆盖原有值<br>setnx:<br>setnx key value:只有当key不存在的情况下，将key设置为value；若key存在，不做任何操作，结果成功返回1，失败返回0</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (12, 12, 'Redis是个缓存', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (13, 13, 'MySQL是个数据库', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (14, 14, 'MyISAM，InnoDB等', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:07:44', NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (15, 15, 'MySQL的覆盖索引(Covering Index)是指二级索引中包含了查询所需的所有字段，从而使查询可以仅通过访问二级索引而不需要访问实际的表数据（主键索引)。', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:18:30', NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (16, 16, 'MVCC(Multi--Version Concurrency Control)多版本并发控制。', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:24:00', NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (17, 17, '表示显示宽度', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:38:06', NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (18, 18, '读写操作会冲突', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 10:43:51', NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (19, 19, '主要是通过：锁、Redo Log、Undo Log、MVCC。', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 10:48:20', NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_category
-- ----------------------------
INSERT INTO `subject_category` VALUES (1, '后端', 1, 'https://image/category.icon', 0, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:09', NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (2, '缓存', 2, 'https://image/category.icon', 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:09', NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (3, '数据库', 2, 'https://image/category.icon', 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:09', NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (4, '前端', 1, 'https://image/category.icon', 0, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:09', NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_info
-- ----------------------------
INSERT INTO `subject_info` VALUES (1, 'Redis支持哪几种数据类型？', 1, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (2, 'Redis的高级数据类型有什么？', 2, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (3, 'Redis的优点有什么？', 1, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (4, 'Redis相比Memcached有哪些优势？', 1, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (5, 'Redis是单进程单线程的？', 1, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (6, '数据库和缓存的数据一致性如何保障，有哪些方案？', 2, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (7, 'redis过期策略都有哪些？', 1, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (8, '什么是缓存穿透？', 1, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (9, '什么是缓存击穿', 1, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (10, '什么是缓存雪崩', 1, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (11, 'redis的setnx和setex区别', 1, NULL, 4, 1, '解析什么', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (12, 'Redis是个什么东西？', 1, NULL, 4, 2, '题目解析2', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:07:44', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (13, 'MySQL是个什么东西？', 1, NULL, 4, 2, '题目解析2', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:07:44', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (14, 'MySQL有哪些存储引擎？', 1, NULL, 4, 2, '题目解析', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:07:44', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (15, 'MySQL的覆盖索引是什么', 1, NULL, 4, 2, '题目解析', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:18:30', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (16, 'MySQL的MVCC是什么', 1, NULL, 4, 2, '题目解析', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:24:00', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (17, 'MySQL的int(11)的11是什么?', 1, NULL, 4, 2, '题目解析', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:38:06', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (18, '如果MySQL中没有MVCC,会有什么影响？', 1, NULL, 4, 2, '题目解析', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 10:43:51', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (19, 'MySQL是如何实现事务的？', 1, NULL, 4, 2, '题目解析', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 10:48:20', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (20, 'Redis有几种基础数据类型', 1, NULL, 1, 1, 'Redis有5种类型，其中有string、hash、set、zset等等', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 17:55:52', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (21, 'Redis的数据类型有以下哪几种', 1, NULL, 2, 1, '简单题', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 18:00:02', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (22, 'MySQL是关系型数据库吗', 1, NULL, 3, 1, '简单题', 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 18:02:08', NULL, NULL, 0);

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
INSERT INTO `subject_judge` VALUES (1, 22, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 18:02:08', NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_label
-- ----------------------------
INSERT INTO `subject_label` VALUES (1, 'Redis', 1, 2, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:27', NULL, NULL, 0);
INSERT INTO `subject_label` VALUES (2, '数据一致性', 1, 2, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:27', NULL, NULL, 0);
INSERT INTO `subject_label` VALUES (3, 'MySQL', 1, 3, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:27', NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_liked
-- ----------------------------
DROP TABLE IF EXISTS `subject_liked`;
CREATE TABLE `subject_liked`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '题目id',
  `like_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '点赞人id',
  `status` int(11) NULL DEFAULT NULL COMMENT '点赞状态 1点赞 0不点赞',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniq_like`(`subject_id`, `like_user_id`) USING BTREE COMMENT '点赞唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '题目点赞表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_liked
-- ----------------------------
INSERT INTO `subject_liked` VALUES (1, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_liked` VALUES (2, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', 1, NULL, NULL, NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目分类关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_mapping
-- ----------------------------
INSERT INTO `subject_mapping` VALUES (1, 1, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (2, 2, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (3, 3, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (4, 4, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (5, 5, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (6, 6, 2, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (7, 6, 3, 2, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (8, 7, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (9, 8, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (10, 9, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (11, 10, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (12, 11, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (13, 12, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (14, 13, 3, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (15, 14, 3, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:24:00', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (16, 15, 3, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:24:00', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (17, 16, 3, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:24:00', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (18, 17, 3, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-16 22:38:07', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (19, 18, 3, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 10:43:51', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (20, 19, 3, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 10:48:20', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (21, 20, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 17:55:53', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (22, 21, 2, 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 18:00:03', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (24, 22, 3, 3, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 18:02:08', NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '多选题信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_multiple
-- ----------------------------
INSERT INTO `subject_multiple` VALUES (1, 21, 1, '<p>string</p>', 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 18:00:02', NULL, NULL, 0);
INSERT INTO `subject_multiple` VALUES (2, 21, 2, '<p>set</p>', 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 18:00:02', NULL, NULL, 0);
INSERT INTO `subject_multiple` VALUES (3, 21, 3, '<p>int</p>', 0, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 18:00:02', NULL, NULL, 0);
INSERT INTO `subject_multiple` VALUES (4, 21, 4, '<p>zset</p>', 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 18:00:02', NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '单选题信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_radio
-- ----------------------------
INSERT INTO `subject_radio` VALUES (1, 20, 1, '<p>3</p>', 0, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 17:55:53', NULL, NULL, 0);
INSERT INTO `subject_radio` VALUES (2, 20, 2, '<p>4</p>', 0, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 17:55:53', NULL, NULL, 0);
INSERT INTO `subject_radio` VALUES (3, 20, 3, '<p>5</p>', 1, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 17:55:53', NULL, NULL, 0);
INSERT INTO `subject_radio` VALUES (4, 20, 4, '<p>6</p>', 0, 'oGbwpwBMJ_qpWWxDvsl2ZL_7o_L4', '2024-08-17 17:55:53', NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
