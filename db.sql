/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.5.54 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

/*Table structure for table `booktype` */

DROP TABLE IF EXISTS `booktype`;

CREATE TABLE `booktype` (
  `booktype_id` int(11) NOT NULL AUTO_INCREMENT,
  `booktype_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`booktype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `booktype` */

/*Table structure for table `buyer` */

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
  PRIMARY KEY (`buyer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `buyer` */

insert  into `buyer`(`buyer_id`,`buyer_username`,`buyer_password`,`buyer_salt`,`buyer_phone`,`buyer_email`,`buyer_lastLoginTime`,`buyer_registerTime`,`buyer_passwordQuestion`,`buyer_passwordAnswer`) values (1,'abc','900150983cd24fb0d6963f7d28e17f72',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `buyer_info` */

DROP TABLE IF EXISTS `buyer_info`;

CREATE TABLE `buyer_info` (
  `buyer_id` int(11) NOT NULL,
  `buyer_name` varchar(10) DEFAULT NULL,
  `buyer_address1` varchar(50) DEFAULT NULL,
  `buyer_address2` varchar(50) DEFAULT NULL,
  `buyer_address3` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`buyer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `buyer_info` */

/*Table structure for table `order` */

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
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`order_id`,`order_userid`,`order_item`,`order_price`,`order_status`,`order_createdate`,`order_confirmdate`,`order_remark`,`order_address`) values (1,123,'123',123,NULL,NULL,NULL,NULL,NULL),(2,234,'234',234,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
