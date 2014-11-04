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
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `name` varchar(100) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES ('AAFES-Saturday-Sale',1),('AAFES',2),('AC-Moore',3),('Academy-Sports',4),('Ace-Hardware',5),('Aeropostale',6),('Amazon',7),('Annas-Linens',8),('Ashley-Furniture',9),('BJs-Wholesale',10),('Bass-Pro-Shops',11),('Bealls-Texas',12),('Bealls',13),('Bed-Bath-and-Beyond',14),('Belk',15),('Best-Buy',16),('Big-5-Sporting-Goods',17),('Big-Lots-Thanksgiving',18),('Big-Lots',19),('Bonton',20),('Build-a-Bear',21),('CVS',22),('Cabelas',23),('Campmor',24),('Christmas-Tree-Shops',25),('Costco',26),('Craft-Warehouse',27),('Dell-Home',28),('Dicks-Sporting-Goods',29),('Dollar-General',30),('Dunhams-Sports',31),('Express',32),('Farm-and-Fleet',33),('Five-Below',34),('FredMeyer',35),('Freds',36),('Frys-Electronics',37),('GameStop',38),('Gander-Mountain',39),('Gordmans',40),('HEB-plus',41),('Half-Price-Books',42),('Harbor-Freight',43),('Hastings',44),('Havertys',45),('Home-Depot',46),('JCPenney',47),('Joann-Fabrics',48),('Just-Cabinets',49),('Kmart-Thanksgiving',50),('Kmart',51),('Kohls',52),('La-Z-Boy',53),('Lands-End',54),('Lord-and-Taylor',55),('Lowes',56),('Macys-Thanksgiving',57),('Macys',58),('Meijer-Thanksgiving',59),('Meijer',60),('Menards',61),('Michaels',62),('Microsoft-Store',63),('Mills-Fleet-Farm',64),('Modells',65),('Navy-Exchange',66),('NewEgg',67),('Northern-Tool',68),('Office-Depot',69),('Office-Max',70),('Old-Navy',71),('Olympia-Sports',72),('Origins',73),('Overstock',74),('PepBoys',75),('Pet-Smart',76),('Petco',77),('RadioShack',78),('Rakuten',79),('Rite-Aid',80),('Sams-Club',81),('Sears-Hometown',82),('Sears-Outlet',83),('Sears',84),('Shoe-Carnival',85),('Shopko',86),('Sierra-Trading-Post',87),('Sports-Authority',88),('Sportsmans-Warehouse',89),('Sprint',90),('Stage',91),('Staples',92),('Stein-Mart',93),('TMobile',94),('Tanger-Outlets',95),('Target',96),('Things-Remembered',97),('Tiger-Direct',98),('Tillys',99),('Tommy-Hilfiger',100),('Toys-R-Us',101),('Tractor-Supply',102),('True-Value',103),('ULTA',104),('Vera-Bradley',105),('Verizon',106),('Walgreens',107),('Walmart',108),('bath-and-body-works',109),('eBay',110),('hhgregg',111),('nyandcompany',112);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
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
