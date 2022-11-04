/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.16 : Database - loo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE IF NOT EXISTS`loo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `loo`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `userId` bigint(18) NOT NULL,
  `username` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `phone` bigint(11) NOT NULL,
  `email` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Table structure for table `nodeInfo` */

DROP TABLE IF EXISTS `node_info`;

CREATE TABLE `node_info` (
   `id` bigint(100) NOT NULL AUTO_INCREMENT,
   `name` varchar(256) NOT NULL,
   `tcp_only` tinyint(1) NOT NULL,
   `reconnect` tinyint(1) NOT NULL,
   `username` varchar(256) NOT NULL,
   `password` varchar(256) NOT NULL,
   `host` varchar(256) NOT NULL,
   `port` bigint(64) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
