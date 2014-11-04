CREATE DATABASE  IF NOT EXISTS `black_friday` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `black_friday`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: black_friday
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (26,'Accessories'),(1,'Apparel'),(18,'Appliances'),(25,'Arts & Crafts'),(19,'Automobile'),(20,'Baby'),(27,'Bedroom'),(28,'Books'),(47,'Cables'),(29,'Camcorders'),(2,'Cameras'),(3,'Cellphones'),(4,'Computer Accessories'),(21,'Computer Components'),(5,'Computers'),(22,'Desktops'),(48,'Dish Washers'),(49,'Dryers'),(30,'DVD'),(6,'Electronics'),(7,'Food'),(31,'GPS'),(32,'Headphones'),(8,'Holiday Items'),(9,'Home Items'),(10,'Home Theatre'),(33,'Kid\'s'),(34,'Kitchen'),(35,'Men\'s'),(36,'Misc'),(11,'Movies & TV'),(44,'Music'),(45,'Musical Instruments'),(46,'Office'),(54,'Others'),(37,'Outdoor'),(38,'Patio & Garden'),(12,'Personal Care'),(23,'Pet'),(39,'Portable Speakers'),(13,'Promotional Items'),(50,'Refrigerators'),(40,'Shoes'),(24,'Sporting Goods'),(51,'Stoves and Ranges'),(41,'Tablets'),(14,'Televisions'),(15,'Tools'),(16,'Toys'),(42,'Travel'),(53,'UNKNOWN'),(17,'Video Games'),(52,'Washing Machines'),(43,'Women\'s');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-04 14:12:24
