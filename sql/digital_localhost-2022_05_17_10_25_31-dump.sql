-- MySQL dump 10.13  Distrib 5.7.37, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: digital
-- ------------------------------------------------------
-- Server version	5.7.37-log

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
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `productid` int(10) DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  `borrowtime` varchar(20) DEFAULT NULL,
  `returntime` varchar(20) DEFAULT NULL,
  `adminid` int(10) DEFAULT NULL,
  `state` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
INSERT INTO `borrow` (`id`, `productid`, `userid`, `borrowtime`, `returntime`, `adminid`, `state`) VALUES (1,107,17,'2022-05-17','2022-06-16',NULL,0),(2,6,17,'2022-05-17','2022-06-16',NULL,0);
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `lessor` varchar(20) DEFAULT NULL,
  `manufacturer` varchar(20) DEFAULT NULL,
  `rentprice` int(10) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `productcaseid` int(10) DEFAULT NULL,
  `abled` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ieh6qsxp6q7oydadktc9oc8t2` (`productcaseid`),
  CONSTRAINT `FK_ieh6qsxp6q7oydadktc9oc8t2` FOREIGN KEY (`productcaseid`) REFERENCES `productcase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `name`, `lessor`, `manufacturer`, `rentprice`, `price`, `productcaseid`, `abled`) VALUES (1,'???????????????','????????????','?????????????????????',102,27.30,9,0),(2,'???????????????','????????????????????','?????????????????????',230,33.50,3,0),(3,'????????????','?????????','???????????????',150,17.30,1,1),(4,'????????????????????????','?????????','?????????????????????',220,59.00,3,1),(5,'?????????','????????????','??????????????????',300,27.30,4,1),(6,'?????????','???????????????????????','????????????????????????',225,22.80,1,1),(7,'???????????????','???????????????','?????????????????????',168,131.60,5,1),(8,'????????????????????????','??????','????????????????????????',330,27.50,6,1),(9,'?????????','??????','??????.??????.??????????????????',89,17.20,7,1),(10,'??????','??????','???????????????',100,100.00,6,1),(11,'?????????','?????????','???????????????',300,50.00,1,1),(12,'????????????','?????????','???????????????',300,50.00,2,1),(13,'?????????','?????????','???????????????',300,50.00,5,1),(14,'?????????','?????????','???????????????',300,60.00,3,1),(107,'apple watch','cloud lessor wuhan','apple',1000,200.00,1,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productadmin`
--

DROP TABLE IF EXISTS `productadmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productadmin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productadmin`
--

LOCK TABLES `productadmin` WRITE;
/*!40000 ALTER TABLE `productadmin` DISABLE KEYS */;
INSERT INTO `productadmin` (`id`, `username`, `password`) VALUES (1,'admin1','123123'),(2,'admin2','222222');
/*!40000 ALTER TABLE `productadmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcase`
--

DROP TABLE IF EXISTS `productcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productcase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcase`
--

LOCK TABLES `productcase` WRITE;
/*!40000 ALTER TABLE `productcase` DISABLE KEYS */;
INSERT INTO `productcase` (`id`, `name`) VALUES (1,'??????'),(2,'??????'),(3,'??????'),(4,'??????'),(5,'??????'),(6,'?????????'),(7,'??????'),(8,'??????'),(9,'?????????'),(10,'??????');
/*!40000 ALTER TABLE `productcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `returnproduct`
--

DROP TABLE IF EXISTS `returnproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `returnproduct` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `productid` int(10) DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  `returntime` varchar(20) DEFAULT NULL,
  `adminid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `returnproduct`
--

LOCK TABLES `returnproduct` WRITE;
/*!40000 ALTER TABLE `returnproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `returnproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `cardid` varchar(20) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `name`, `tel`, `cardid`, `gender`) VALUES (3,'lisi','123123','??????','131','001','???'),(4,'test001','000000','??????','987655123','002','???'),(17,'zs','1234',NULL,NULL,NULL,NULL);
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

-- Dump completed on 2022-05-17 10:25:31
