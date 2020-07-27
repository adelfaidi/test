-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: workflow
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.16.04.1

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
-- Table structure for table `workflow`
--

DROP TABLE IF EXISTS `workflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow`
--

LOCK TABLES `workflow` WRITE;
/*!40000 ALTER TABLE `workflow` DISABLE KEYS */;
INSERT INTO `workflow` VALUES (1,'the first workflow',_binary '','workflow1'),(2,'the second workflow',_binary '','workflow2'),(3,'the third workflow',_binary '','workflow3');
/*!40000 ALTER TABLE `workflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow_category`
--

DROP TABLE IF EXISTS `workflow_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` date NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `modified_at` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9028viu0g3ppcrgi1te23xafb` (`parent_category_id`),
  CONSTRAINT `FK9028viu0g3ppcrgi1te23xafb` FOREIGN KEY (`parent_category_id`) REFERENCES `workflow_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow_category`
--

LOCK TABLES `workflow_category` WRITE;
/*!40000 ALTER TABLE `workflow_category` DISABLE KEYS */;
INSERT INTO `workflow_category` VALUES (1,'2020-07-27','the first workflow category',_binary '','logo1','2020-07-27','worflowCategory1',2),(2,'2020-07-27','the second workflow category',_binary '','logo2','2020-07-27','workflowCategory2',1);
/*!40000 ALTER TABLE `workflow_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow_variantes`
--

DROP TABLE IF EXISTS `workflow_variantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow_variantes` (
  `workflow_id` bigint(20) NOT NULL,
  `variantes_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_swf94cg97m0knbbdiy94rvhwm` (`variantes_id`),
  KEY `FKghcl1ha893s1n0raq80ps84gi` (`workflow_id`),
  CONSTRAINT `FK47sq9jn8dw1ud33ledcwn4uxv` FOREIGN KEY (`variantes_id`) REFERENCES `workflow` (`id`),
  CONSTRAINT `FKghcl1ha893s1n0raq80ps84gi` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow_variantes`
--

LOCK TABLES `workflow_variantes` WRITE;
/*!40000 ALTER TABLE `workflow_variantes` DISABLE KEYS */;
INSERT INTO `workflow_variantes` VALUES (1,2),(1,3);
/*!40000 ALTER TABLE `workflow_variantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow_workflowcategory`
--

DROP TABLE IF EXISTS `workflow_workflowcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow_workflowcategory` (
  `workflow_id` bigint(20) NOT NULL,
  `workflowcategory_id` bigint(20) NOT NULL,
  PRIMARY KEY (`workflow_id`,`workflowcategory_id`),
  KEY `FKpg969i1hhhlm1bt42w034ua13` (`workflowcategory_id`),
  CONSTRAINT `FKfwwmyki28j2owf7dw24beq10x` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`),
  CONSTRAINT `FKpg969i1hhhlm1bt42w034ua13` FOREIGN KEY (`workflowcategory_id`) REFERENCES `workflow_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow_workflowcategory`
--

LOCK TABLES `workflow_workflowcategory` WRITE;
/*!40000 ALTER TABLE `workflow_workflowcategory` DISABLE KEYS */;
INSERT INTO `workflow_workflowcategory` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `workflow_workflowcategory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-27 15:32:37