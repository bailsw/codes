/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2019-05-07 15:39:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_genre` tinyint(1) DEFAULT NULL,
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_typeid` int(11) DEFAULT NULL,
  `book_name` varchar(20) DEFAULT NULL,
  `book_price` int(11) DEFAULT NULL,
  `book_pic` varchar(300) DEFAULT NULL,
  `book_info` varchar(300) DEFAULT NULL,
  `book_ISBN` varchar(50) DEFAULT NULL,
  `book_author` varchar(20) DEFAULT NULL,
  `book_publishingHouse` varchar(50) DEFAULT NULL,
  `book_browsedTime` int(11) DEFAULT NULL,
  `book_stock` int(11) DEFAULT NULL,
  `book_soldcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '4', '1', '漫威之父1', '11231', '52ad722f-d4af-46b1-96a7-2705fc5938b3538.jpg', '1111', 'aaaa', 'abc', 'abc', '0', '123', '0');

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `booktype_id` int(11) NOT NULL AUTO_INCREMENT,
  `booktype_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`booktype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('21', '123');
INSERT INTO `booktype` VALUES ('22', 'Second');
INSERT INTO `booktype` VALUES ('23', 'Third');

-- ----------------------------
-- Table structure for buyer
-- ----------------------------
DROP TABLE IF EXISTS `buyer`;
CREATE TABLE `buyer` (
  `buyer_id` int(8) NOT NULL AUTO_INCREMENT,
  `buyer_username` varchar(16) DEFAULT NULL,
  `buyer_password` varchar(50) DEFAULT NULL,
  `buyer_salt` char(8) DEFAULT NULL,
  `buyer_phone` char(11) DEFAULT NULL,
  `buyer_email` varchar(40) DEFAULT NULL,
  `buyer_lastLoginTime` datetime DEFAULT NULL,
  `buyer_registerTime` datetime DEFAULT NULL,
  `buyer_passwordQuestion` varchar(20) DEFAULT NULL,
  `buyer_passwordAnswer` varchar(20) DEFAULT NULL,
  `buyer_type` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`buyer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buyer
-- ----------------------------
INSERT INTO `buyer` VALUES ('1', 'abc', '900150983cd24fb0d6963f7d28e17f72', null, '18666666666', 'qweqe@qq.com', null, null, null, null, '0');
INSERT INTO `buyer` VALUES ('3', 'tom123', 'a8f5f167f44f4964e6c998dee827110c', null, '17822222222', '123@qq.com', null, '2019-04-27 15:37:00', '就读的小学叫什么？', '123', '1');
INSERT INTO `buyer` VALUES ('4', 'asdasd', 'a8f5f167f44f4964e6c998dee827110c', null, '17806255159', '979541197@qq.com', null, '2019-05-05 13:08:40', '就读的小学叫什么？', 'asd', '1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_userid` int(11) DEFAULT NULL,
  `order_item` varchar(300) DEFAULT NULL,
  `order_price` int(11) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `order_createdate` datetime DEFAULT NULL,
  `order_confirmdate` datetime DEFAULT NULL,
  `order_remark` varchar(100) DEFAULT NULL,
  `order_address` varchar(50) DEFAULT NULL,
  `order_item_amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '123', '123', '123', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('2', '234', '234', '234', null, null, null, null, null, null);
