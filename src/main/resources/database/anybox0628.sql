-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: anybox
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(225) NOT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (1,'salad','this is salad'),(3,'juice','this is juice');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL DEFAULT '',
  `last_name` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (1,'kk','aa','jsdj'),(5,'test2','k','test2@google.com'),(6,'test3',NULL,'test3@google.com');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Inventory`
--

DROP TABLE IF EXISTS `Inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `machine_id` int(11) NOT NULL,
  `tray_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `preorder_capacity` int(11) NOT NULL COMMENT 'the number of product that are preordered',
  `free_capacity` int(11) NOT NULL COMMENT 'the number of product that can be sold on site',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Inventory`
--

LOCK TABLES `Inventory` WRITE;
/*!40000 ALTER TABLE `Inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `Inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Machine`
--

DROP TABLE IF EXISTS `Machine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Machine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Machine`
--

LOCK TABLES `Machine` WRITE;
/*!40000 ALTER TABLE `Machine` DISABLE KEYS */;
INSERT INTO `Machine` VALUES (1,'machine1','1776');
/*!40000 ALTER TABLE `Machine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Order_detail`
--

DROP TABLE IF EXISTS `Order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `machine_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_number` int(11) NOT NULL,
  `pickup_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order_detail`
--

LOCK TABLES `Order_detail` WRITE;
/*!40000 ALTER TABLE `Order_detail` DISABLE KEYS */;
INSERT INTO `Order_detail` VALUES (1,3,1,1,5,'2015-05-30 00:00:00'),(2,4,1,1,5,'2015-05-30 00:00:00'),(3,5,1,1,5,'2015-05-30 00:00:00'),(4,21,1,2,5,'2015-05-30 00:00:00'),(5,25,1,1,2,'2015-06-14 00:00:00'),(6,26,1,1,2,'2015-06-14 00:00:00'),(7,27,1,1,4,'2015-06-14 00:00:00'),(8,31,1,1,1,'2015-06-30 00:00:00'),(9,31,1,1,3,'2015-07-01 00:00:00'),(10,32,1,1,2,'2015-06-30 00:00:00'),(11,32,1,1,3,'2015-07-01 00:00:00'),(12,33,1,1,2,'2015-06-29 00:00:00'),(13,33,1,1,2,'2015-07-02 00:00:00'),(14,35,1,1,2,'2015-06-29 00:00:00'),(15,35,1,3,2,'2015-06-29 00:00:00'),(16,36,1,1,3,'2015-06-29 00:00:00');
/*!40000 ALTER TABLE `Order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Policy`
--

DROP TABLE IF EXISTS `Policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `scope` int(11) NOT NULL COMMENT '1: global; 2: order; 3: user',
  `type` int(11) NOT NULL COMMENT '1: minus immediately; 2: percentage off',
  `description` varchar(225) NOT NULL COMMENT 'html format',
  `discount` double NOT NULL COMMENT 'if type == 1, amount means minus such number of money.\nif type == 2, amount means {amount}% off',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Policy`
--

LOCK TABLES `Policy` WRITE;
/*!40000 ALTER TABLE `Policy` DISABLE KEYS */;
INSERT INTO `Policy` VALUES (1,3,2,'this is the first policy for user',0.8),(2,1,2,'this is the first policy for global',0.9);
/*!40000 ALTER TABLE `Policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Preorder_record`
--

DROP TABLE IF EXISTS `Preorder_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Preorder_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `machine_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `preorder_capacity` int(11) NOT NULL DEFAULT '0' COMMENT 'the number of product that are preordered',
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Preorder_record`
--

LOCK TABLES `Preorder_record` WRITE;
/*!40000 ALTER TABLE `Preorder_record` DISABLE KEYS */;
INSERT INTO `Preorder_record` VALUES (2,'2015-05-30 00:00:00',1,1,15,19),(3,'2015-05-30 00:00:00',1,2,5,18),(4,'2015-05-30 00:00:00',1,3,0,25),(7,'2015-06-14 00:00:00',1,1,0,19),(8,'2015-06-14 00:00:00',1,2,0,18),(9,'2015-06-14 00:00:00',1,3,0,25),(10,'2015-06-15 00:00:00',1,1,0,19),(11,'2015-06-15 00:00:00',1,2,0,18),(12,'2015-06-15 00:00:00',1,3,0,25),(13,'2015-06-29 00:00:00',1,1,0,19),(14,'2015-06-29 00:00:00',1,2,0,18),(15,'2015-06-29 00:00:00',1,3,0,25),(16,'2015-06-30 00:00:00',1,1,0,19),(17,'2015-06-30 00:00:00',1,2,0,18),(18,'2015-06-30 00:00:00',1,3,0,25),(19,'2015-07-01 00:00:00',1,1,0,19),(20,'2015-07-01 00:00:00',1,2,0,18),(21,'2015-07-01 00:00:00',1,3,0,25),(22,'2015-07-02 00:00:00',1,1,0,19),(23,'2015-07-02 00:00:00',1,2,0,18),(24,'2015-07-02 00:00:00',1,3,0,25),(25,'2015-07-03 00:00:00',1,1,0,19),(26,'2015-07-03 00:00:00',1,2,0,18),(27,'2015-07-03 00:00:00',1,3,0,25),(28,'2015-07-07 00:00:00',1,1,0,19),(29,'2015-07-07 00:00:00',1,2,0,18),(30,'2015-07-07 00:00:00',1,3,0,25),(31,'2015-07-09 00:00:00',1,1,0,19),(32,'2015-07-09 00:00:00',1,2,0,18),(33,'2015-07-09 00:00:00',1,3,0,25),(34,'2015-07-08 00:00:00',1,1,0,19),(35,'2015-07-08 00:00:00',1,2,0,18),(36,'2015-07-08 00:00:00',1,3,0,25);
/*!40000 ALTER TABLE `Preorder_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(225) NOT NULL COMMENT 'html format',
  `category_id` varchar(45) NOT NULL,
  `original_price` double NOT NULL,
  `img1` varchar(225) DEFAULT NULL COMMENT 'img url 1:1',
  `img2` varchar(225) DEFAULT NULL COMMENT 'img url, 3:4',
  `img3` varchar(225) DEFAULT NULL COMMENT 'img url, 4:3',
  `img4` varchar(225) DEFAULT NULL COMMENT 'img url, 16:9',
  `img5` varchar(225) DEFAULT NULL COMMENT 'img url, 1 X 1',
  `policy_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (1,'salad1','this is a salad','1',10.5,'https://www.dropbox.com/s/q625ek4wsj5ydpa/1_1-1_Item.jpg?dl=0','https://www.dropbox.com/s/mio5ofdmo1szzb4/3_4_landing.jpg?dl=0','https://www.dropbox.com/s/tnwzyyh9b6i5tx9/4_3_home.jpg?dl=0','https://www.dropbox.com/s/nyug2acw3gs99o2/16_9_order.jpg?dl=0','https://www.dropbox.com/s/kipqhq4nj801h4a/1_1-3_Item.jpg?dl=0','2'),(2,'juice','this is a juice, 222222','2',5,NULL,NULL,NULL,NULL,NULL,'2'),(3,'salad3','this is a salad, 333333','1',11.5,NULL,NULL,NULL,NULL,NULL,'2'),(4,'juice2','this is a juice, 222222','2',5,NULL,NULL,NULL,NULL,NULL,'2');
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tray`
--

DROP TABLE IF EXISTS `Tray`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tray` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `machine_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `position` varchar(45) NOT NULL COMMENT 'indicate the position of the tray in the machine',
  `name` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tray`
--

LOCK TABLES `Tray` WRITE;
/*!40000 ALTER TABLE `Tray` DISABLE KEYS */;
INSERT INTO `Tray` VALUES (1,1,1,'1,2','tray1','this is a tray',10),(2,1,1,'1,1','tray2','this is another tray',9),(3,1,2,'2,1','tray3','another another tray',10),(4,1,2,'2,2','tray4','tray.....',8),(5,1,3,'3,1','tray5','ssss',25);
/*!40000 ALTER TABLE `Tray` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_order`
--

DROP TABLE IF EXISTS `User_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `freelunch_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_order`
--

LOCK TABLES `User_order` WRITE;
/*!40000 ALTER TABLE `User_order` DISABLE KEYS */;
INSERT INTO `User_order` VALUES (1,1,'2015-05-29 17:23:38','failed',NULL,'0'),(3,1,'2015-05-29 18:00:51','unpaid',NULL,'0'),(4,1,'2015-05-29 18:02:10','unpaid',NULL,'0'),(5,1,'2015-05-29 18:02:34','unpaid',NULL,'0'),(21,1,'2015-05-30 15:33:07','unpaid',NULL,'0'),(25,10,'2015-06-14 15:00:29','unpaid',0,'0'),(26,10,'2015-06-14 15:01:06','unpaid',0,'0'),(27,10,'2015-06-14 15:02:12','unpaid',42,'0'),(31,16,'2015-06-27 19:44:14','unpaid',42,'0'),(32,16,'2015-06-27 19:44:38','unpaid',52.5,'0'),(33,16,'2015-06-27 19:46:26','unpaid',42,'0'),(35,16,'2015-06-27 22:39:49','unpaid',39.6,'0'),(36,16,'2015-06-27 23:58:16','unpaid',28.35,'0');
/*!40000 ALTER TABLE `User_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_card`
--

DROP TABLE IF EXISTS `event_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(225) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL COMMENT 'pic url, \ntop, 4:3;\nbottom, 1;1',
  `category` varchar(45) NOT NULL DEFAULT 'top' COMMENT 'top, bottom',
  `type` varchar(45) NOT NULL DEFAULT 'product' COMMENT 'product, promotion',
  `valid` int(11) DEFAULT '1' COMMENT '1 means valid, 0 means not valid',
  `dest_id` int(11) DEFAULT NULL COMMENT 'if type is product, dest_id is product_id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_card`
--

LOCK TABLES `event_card` WRITE;
/*!40000 ALTER TABLE `event_card` DISABLE KEYS */;
INSERT INTO `event_card` VALUES (1,'salad1','new product promotion','/resources/pics/4_3_home.jpg','top','product',1,1),(2,'salad2','new product 2','/resources/pics/1_1-3_Item.jpg','bottom','product',1,1),(3,'salad3','new product promotion','/resources/pics/4_3_home.jpg','top','product',1,1),(4,'juice4','new product promotion','/resources/pics/1_1-3_Item.jpg','bottom','product',1,1);
/*!40000 ALTER TABLE `event_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free_lunch`
--

DROP TABLE IF EXISTS `free_lunch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `free_lunch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `money` double NOT NULL,
  `expire` datetime NOT NULL,
  `detail` varchar(225) NOT NULL COMMENT 'invite by xxx or invite xxx',
  `status` int(11) DEFAULT NULL COMMENT '0 : new, can be used; 1 : used',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free_lunch`
--

LOCK TABLES `free_lunch` WRITE;
/*!40000 ALTER TABLE `free_lunch` DISABLE KEYS */;
INSERT INTO `free_lunch` VALUES (1,'19',10,'2015-07-27 23:30:41','Invited by Jie Zhou',0),(2,'16',10,'2015-07-27 23:33:59','Invited by bbb bbbb',0);
/*!40000 ALTER TABLE `free_lunch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `promo_code` varchar(45) DEFAULT NULL,
  `invited_by` varchar(45) DEFAULT NULL COMMENT 'the id of the user who invite this user',
  `policy_id` varchar(45) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_code` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `update_referer` int(11) DEFAULT NULL COMMENT '0 : not updated; \n1: has updated;',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (16,'a','2023414130','a',NULL,'CPjgJ',NULL,'2015-06-27 19:24:27','R7zlx','Jie','Zhou',0),(17,'Rug','Drfvg','tggh',NULL,NULL,NULL,'2015-06-27 21:22:03','oTCQM','Furf','Fggg',0),(18,'Tfgggh','Hfh','gfg',NULL,NULL,NULL,'2015-06-27 22:34:26','7CNqN','Ygg','Ygg',0),(19,'b','bbbbb','b',NULL,'R7zlx',NULL,'2015-06-27 23:16:36','CPjgJ','bbb','bbbb',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-28 22:04:15
