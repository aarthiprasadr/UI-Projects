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
-- Table structure for table `category_subcategory`
--

DROP TABLE IF EXISTS `category_subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_subcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) NOT NULL,
  `sub_category` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_subcategory`
--

LOCK TABLES `category_subcategory` WRITE;
/*!40000 ALTER TABLE `category_subcategory` DISABLE KEYS */;
INSERT INTO `category_subcategory` VALUES (1,'Accessories',''),(2,'Apparel','Accessories'),(3,'Apparel','Babies'),(4,'Apparel','Jewelry'),(5,'Apparel','Kids\''),(6,'Apparel','Men\'s'),(7,'Apparel','Shoes'),(8,'Apparel','Watches'),(9,'Apparel','Women\'s'),(10,'Appliances','Dish Washers'),(11,'Appliances','Dryers'),(12,'Appliances','Freezers'),(13,'Appliances','Refrigerators'),(14,'Appliances','Stoves and Ranges'),(15,'Appliances','Washing Machines'),(16,'Arts & Crafts',''),(17,'Automobile',''),(18,'Baby',''),(19,'Bathroom',''),(20,'Bedroom',''),(21,'Books',''),(22,'Cables',''),(23,'Camcorders',''),(24,'Cameras','Accessories'),(25,'Cameras','Camcorders'),(26,'Cameras','Digital Cameras'),(27,'Cameras','DSLR'),(28,'Cellphones','Accessories'),(29,'Cellphones','Android'),(30,'Cellphones','Apple'),(31,'Cellphones','Windows Mobile'),(32,'Computer Accessories','Digital Media'),(33,'Computer Accessories','Keyboards'),(34,'Computer Accessories','Monitors'),(35,'Computer Accessories','Mouse'),(36,'Computer Accessories','Networking'),(37,'Computer Accessories','Other'),(38,'Computer Accessories','Printers'),(39,'Computer Accessories','Scanners'),(40,'Computer Accessories','Software'),(41,'Computer Accessories','Speakers'),(42,'Computer Accessories','Webcams'),(43,'Computer Components',''),(44,'Computer Components','Cases'),(45,'Computer Components','Graphic Cards'),(46,'Computer Components','Hard Drives'),(47,'Computer Components','Memory'),(48,'Computer Components','Power Supplies'),(49,'Computers','Laptops'),(50,'Desktops',''),(51,'Dish Washers',''),(52,'Dryers',''),(53,'DVD',''),(54,'Electronics','Accessories'),(55,'Electronics','Cables'),(56,'Electronics','Digital Picture Frame'),(57,'Electronics','E-Readers'),(58,'Electronics','GPS'),(59,'Electronics','Headphones'),(60,'Electronics','MP3 Players'),(61,'Electronics','Portable Media Player'),(62,'Electronics','Portable Speakers'),(63,'Electronics','Tablets'),(64,'Food',''),(65,'GPS',''),(66,'Headphones',''),(67,'Holiday Items',''),(68,'Home Items','Bathroom'),(69,'Home Items','Bedroom'),(70,'Home Items','Kitchen'),(71,'Home Theater','Blu-ray Players'),(72,'Home Theater','Cables'),(73,'Home Theater','DVD Players'),(74,'Home Theater','Home Theater Systems'),(75,'Home Theater','Network Media Players'),(76,'Home Theater','Projectors'),(77,'Home Theater','Receivers'),(78,'Home Theater','Speakers'),(79,'Home Theater','TV Stands'),(80,'Kids\'s',''),(81,'Kitchen',''),(82,'Men\'s',''),(83,'Misc',''),(84,'Movies & TV','Blu-ray'),(85,'Movies & TV','DVD'),(86,'Movies & TV','Other'),(87,'Music','CD'),(88,'Music','MP3 Download'),(89,'Musical Instruments',''),(90,'Office','Pens'),(91,'Office','Shredders'),(92,'Office','Stationary'),(93,'Outdoor',''),(94,'Patio & Garden',''),(95,'Personal Care',''),(96,'Pet',''),(97,'Portable Speakers',''),(98,'Promotional Items',''),(99,'Refrigerators',''),(100,'Shoes',''),(101,'Sporting Goods','Outdoor'),(102,'Stoves and Ranges',''),(103,'Tablets',''),(104,'Televisions','Accessories'),(105,'Televisions','LCD'),(106,'Televisions','LED'),(107,'Televisions','Plasma'),(108,'Tools',''),(109,'Toys',''),(110,'Travel',''),(111,'UNKNOWN',''),(112,'Video Games','Accessories'),(113,'Video Games','Nintendo 2DS'),(114,'Video Games','Nintendo 3DS'),(115,'Video Games','Nintendo DS'),(116,'Video Games','Other'),(117,'Video Games','PC'),(118,'Video Games','Playstation 3'),(119,'Video Games','PlayStation 4'),(120,'Video Games','Playstation Vita'),(121,'Video Games','Wii'),(122,'Video Games','Wii U'),(123,'Video Games','Xbox 360'),(124,'Video Games','Xbox One'),(125,'Washing Machines',''),(126,'Women\'s',''),(127,'Others',NULL);
/*!40000 ALTER TABLE `category_subcategory` ENABLE KEYS */;
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
