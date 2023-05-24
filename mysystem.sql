/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : mysystem

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 09/05/2023 19:38:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `ctype` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `cstatus` int NULL DEFAULT 1,
  `cold` int NULL DEFAULT 100,
  `cmoney` int NOT NULL,
  `cdescription` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (1, '玛莎拉蒂', 0, 100, 1000, '无');
INSERT INTO `car` VALUES (25, '奔驰', 0, 100, 1000, '无');
INSERT INTO `car` VALUES (26, '哈罗单车', 0, 100, 1, '无');
INSERT INTO `car` VALUES (27, '小黄车', 0, 100, 2, '无');
INSERT INTO `car` VALUES (28, '奔驰2', 1, 100, 1000, '无');
INSERT INTO `car` VALUES (29, '奔驰3', 1, 100, 1000, '无');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `username` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `cid` int NOT NULL,
  `ctype` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `hour` int NULL DEFAULT 1,
  `orderstatus` int NULL DEFAULT 1,
  `renttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `returntime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (32, '1', '李', 1, '玛莎拉蒂', 1, 0, '2023-04-21 16:36:56', '2023-04-21 16:37:12');
INSERT INTO `orders` VALUES (33, '1', '李', 1, '玛莎拉蒂', 1, 0, '2023-04-21 16:41:02', '2023-04-21 16:41:09');
INSERT INTO `orders` VALUES (34, '1', '李', 1, '玛莎拉蒂', 1, 0, '2023-05-03 19:59:53', '2023-05-03 19:59:55');
INSERT INTO `orders` VALUES (35, '1', '李', 1, '玛莎拉蒂', 1, 0, '2023-05-04 08:14:59', '2023-05-04 08:15:07');
INSERT INTO `orders` VALUES (36, '1', '李', 1, '玛莎拉蒂', 1, 0, '2023-05-04 08:25:45', '2023-05-04 08:30:11');
INSERT INTO `orders` VALUES (37, '1', '李', 25, '奔驰', 1, 1, '2023-05-04 08:30:05', NULL);
INSERT INTO `orders` VALUES (38, '1', '李', 1, '玛莎拉蒂', 1, 0, '2023-05-04 08:36:17', '2023-05-04 08:36:23');
INSERT INTO `orders` VALUES (39, '1', '李', 1, '玛莎拉蒂', 1, 1, '2023-05-04 09:11:10', NULL);
INSERT INTO `orders` VALUES (40, '2', '王', 26, '哈罗单车', 1, 0, '2023-05-04 09:19:56', '2023-05-04 09:20:06');
INSERT INTO `orders` VALUES (41, '2', '王', 27, '小黄车', 1, 0, '2023-05-04 09:19:56', '2023-05-04 09:20:07');
INSERT INTO `orders` VALUES (42, '2', '王', 28, '奔驰2', 1, 0, '2023-05-04 09:19:56', '2023-05-04 09:20:08');
INSERT INTO `orders` VALUES (43, '2', '王', 29, '奔驰3', 1, 0, '2023-05-04 09:19:56', '2023-05-09 09:50:50');
INSERT INTO `orders` VALUES (44, '2', '王', 26, '哈罗单车', 1, 1, '2023-05-09 09:46:44', NULL);
INSERT INTO `orders` VALUES (45, '2', '王', 27, '小黄车', 1, 1, '2023-05-09 09:49:18', NULL);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userid` int NOT NULL AUTO_INCREMENT,
  `userno` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `username` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `userpwd` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `userage` int NULL DEFAULT NULL,
  `userphone` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `userisvalid` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT 'Y',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '12', '李', '1', 18, '123', 'N');
INSERT INTO `users` VALUES (2, 'root', '王', 'root', 18, '123', 'Y');
INSERT INTO `users` VALUES (35, '123', '赵', '1', 18, '123', 'N');
INSERT INTO `users` VALUES (36, 'boss', '钱', 'boss', 25, '123', 'Y');

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `workno` int NOT NULL AUTO_INCREMENT,
  `workname` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `worksalar` int NOT NULL,
  `workage` int NULL DEFAULT NULL,
  `worktype` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `workblankid` int NULL DEFAULT NULL,
  `workisvalid` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT 'Y',
  PRIMARY KEY (`workno`) USING BTREE,
  UNIQUE INDEX `workblankid`(`workblankid` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES (1, '李四', 6000, 19, '维修人员', 1234, 'Y');
INSERT INTO `worker` VALUES (2, '王二', 2000, 20, '保安', 1235, 'Y');
INSERT INTO `worker` VALUES (3, '赵六', 10000, 30, '经历', 1237, 'Y');
INSERT INTO `worker` VALUES (34, '麻子', 8000, 19, '高级技师', 1238, 'Y');

-- ----------------------------
-- Triggers structure for table orders
-- ----------------------------
DROP TRIGGER IF EXISTS `trg_orders_update_returntime`;
delimiter ;;
CREATE TRIGGER `trg_orders_update_returntime` BEFORE UPDATE ON `orders` FOR EACH ROW BEGIN
    SET NEW.returntime = NOW();
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
