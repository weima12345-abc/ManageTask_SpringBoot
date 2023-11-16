/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : gl

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 22/06/2023 14:20:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `menuid` int(0) NULL DEFAULT NULL,
  `parentid` int(0) NULL DEFAULT NULL,
  `menuName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 1, -1, '教师首页', '/index');
INSERT INTO `menu` VALUES (2, 2, 1, '学生作业提交列表', '/showUserListPage');
INSERT INTO `menu` VALUES (3, 3, 1, '布置作业', 'man_registerPage');
INSERT INTO `menu` VALUES (4, 4, 1, '修改老师密码', 'changePage');
INSERT INTO `menu` VALUES (5, 5, -1, '学生首页', '/index');
INSERT INTO `menu` VALUES (6, 6, 5, '学生作业提交', 'man_registerPage');
INSERT INTO `menu` VALUES (7, 7, 5, '修改学生密码', 'changePage');
INSERT INTO `menu` VALUES (8, 8, -1, '管理员首页', '/index');
INSERT INTO `menu` VALUES (9, 9, 8, '修改管理员密码', 'changePage');
INSERT INTO `menu` VALUES (10, 10, 8, '管理员查看日志', '/showUserListPage');
INSERT INTO `menu` VALUES (11, 11, 5, '学生作业提交列表', '/showUserListPage');
INSERT INTO `menu` VALUES (12, 12, 1, '老师修改作业信息', '/changeTaskPage');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleID` int(0) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`roleID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (0, 'Student');
INSERT INTO `role` VALUES (1, 'Teacher');
INSERT INTO `role` VALUES (2, 'Admin');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `r_m_id` int(0) NOT NULL AUTO_INCREMENT,
  `menuid` int(0) NULL DEFAULT NULL,
  `roleID` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`r_m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1, 1);
INSERT INTO `role_menu` VALUES (2, 2, 1);
INSERT INTO `role_menu` VALUES (3, 3, 1);
INSERT INTO `role_menu` VALUES (4, 4, 1);
INSERT INTO `role_menu` VALUES (5, 5, 0);
INSERT INTO `role_menu` VALUES (6, 6, 0);
INSERT INTO `role_menu` VALUES (7, 7, 0);
INSERT INTO `role_menu` VALUES (8, 8, 2);
INSERT INTO `role_menu` VALUES (9, 9, 2);
INSERT INTO `role_menu` VALUES (10, 10, 2);
INSERT INTO `role_menu` VALUES (11, 11, 0);

-- ----------------------------
-- Table structure for sys
-- ----------------------------
DROP TABLE IF EXISTS `sys`;
CREATE TABLE `sys`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `operate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `waste_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `operate_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 230 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys
-- ----------------------------

-- ----------------------------
-- Table structure for tea_already_biao
-- ----------------------------
DROP TABLE IF EXISTS `tea_already_biao`;
CREATE TABLE `tea_already_biao`  (
  `biao_id` int(0) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stu_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`biao_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tea_already_biao
-- ----------------------------
INSERT INTO `tea_already_biao` VALUES (38, '53', '1', '学生1', '2023-06-21 01:11:21');
INSERT INTO `tea_already_biao` VALUES (39, '54', 't提交', '学生1', '2023-06-21 15:26:44');

-- ----------------------------
-- Table structure for teacher_task
-- ----------------------------
DROP TABLE IF EXISTS `teacher_task`;
CREATE TABLE `teacher_task`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `builder` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `already` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_task
-- ----------------------------
INSERT INTO `teacher_task` VALUES (51, '123', '2023-06-21 00:32:10', '2023-06-22 00:00:00', '老师2', 0);
INSERT INTO `teacher_task` VALUES (54, '微服务', '2023-06-21 15:25:54', '2023-06-23 00:00:00', '老师1', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `roleID` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '老师1', 'c81e728d9d4c2f636f067f89cc14862c', '2875478810@qq.com', 1);
INSERT INTO `user` VALUES (2, '学生1', 'c81e728d9d4c2f636f067f89cc14862c', '18174001013@139.com', 0);
INSERT INTO `user` VALUES (3, '管理员1', 'c4ca4238a0b923820dcc509a6f75849b', '18174001014@139.com', 2);
INSERT INTO `user` VALUES (4, '老师2', 'c81e728d9d4c2f636f067f89cc14862c', '2875478812@qq.com', 1);
INSERT INTO `user` VALUES (5, '学生2', 'c81e728d9d4c2f636f067f89cc14862c', '2875478813@qq.com', 0);
INSERT INTO `user` VALUES (6, '学生3', 'c4ca4238a0b923820dcc509a6f75849b', '18174001013@139.com', 0);
INSERT INTO `user` VALUES (7, '老师3', 'c4ca4238a0b923820dcc509a6f75849b', '18174001016@139.com', 1);
INSERT INTO `user` VALUES (8, '管理员2', 'c4ca4238a0b923820dcc509a6f75849b', '18174001016@139.com', 2);
INSERT INTO `user` VALUES (9, '管理员3', 'c4ca4238a0b923820dcc509a6f75849b', '2052119931@qq.com', 3);

SET FOREIGN_KEY_CHECKS = 1;
