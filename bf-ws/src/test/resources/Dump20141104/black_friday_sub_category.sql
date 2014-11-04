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
-- Table structure for table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category`
--

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` VALUES (1,'Accessories'),(2,'Jewelry'),(3,'Kids\''),(4,'Men\'s'),(5,'Shoes'),(6,'Watches'),(7,'Women\'s'),(8,'Digital Cameras'),(9,'DSLR'),(10,'Android'),(12,'Digital Media'),(13,'Mouse'),(14,'Printers'),(15,'Laptops'),(16,'Cables'),(17,'Headphones'),(18,'Tablets'),(19,'Bedroom'),(20,'Kitchen'),(21,'Blu-ray Players'),(22,'Home Theatre Systems'),(23,'Network Media Players'),(24,'Speakers'),(25,'Blu-ray'),(26,'DVD'),(27,'LED'),(28,'Nintendo 3DS'),(29,'Other'),(30,'Playstation 3'),(31,'Playstation Vita'),(32,'Wii'),(33,'Wii U'),(34,'Xbox 360'),(35,'Babies'),(36,'Software'),(37,'Cases'),(38,'Hard Drives'),(39,'GPS'),(40,'Portable Speakers'),(41,'Bathroom'),(42,'DVD Players'),(43,'Outdoor'),(44,'PC'),(45,'MP3 Download'),(46,'Camcorders'),(47,'Monitors'),(48,'Shredders'),(49,'Nintendo DS'),(50,'Portable Media Player'),(51,'Dish Washers'),(52,'Dryers'),(53,'Refrigerators'),(54,'Stoves and Ranges'),(55,'Washing Machines'),(56,'Apple'),(57,'Keyboards'),(58,'Networking'),(59,'E-Readers'),(60,'MP3 Players'),(61,'Receivers'),(62,'PlayStation 4'),(63,'Xbox One'),(64,'CD'),(65,'Scanners'),(66,'Stationary'),(67,'Digital Picture Frame'),(68,'Memory'),(69,'Projectors'),(70,'TV Stands'),(71,'LCD'),(72,'Windows Mobile'),(73,'Nintendo 2DS'),(74,'Freezers'),(75,'Plasma'),(76,'Webcams'),(77,'Power Supplies'),(78,'Pens'),(79,'Graphic Cards');
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-04 14:12:25
