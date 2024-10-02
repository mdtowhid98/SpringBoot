-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: practice
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `branches`
--

DROP TABLE IF EXISTS `branches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branches` (
  `id` int NOT NULL AUTO_INCREMENT,
  `branch_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branches`
--

LOCK TABLES `branches` WRITE;
/*!40000 ALTER TABLE `branches` DISABLE KEYS */;
INSERT INTO `branches` VALUES (1,'Dhanmondi','Dhaka'),(2,'Banani','Dhaka'),(3,'Gulshan','Dhaka');
/*!40000 ALTER TABLE `branches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Omeprazole'),(2,'Flucloxacillin Sodium'),(3,'Montelukast Sodium'),(4,'Esomeprazole'),(7,'Vitamin B1, B6 & B12');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `cell` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `expiry_date` date DEFAULT NULL,
  `manufacture_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `quantity` int NOT NULL,
  `stock` int NOT NULL,
  `unitprice` int NOT NULL,
  `branch_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7yh1cmuib7hnrbu4ntka4v7ro` (`branch_id`),
  KEY `FKowomku74u72o6h8q0khj7id8q` (`category_id`),
  KEY `FKhiwr0cl8fpxh1xm9y17wo5up0` (`supplier_id`),
  CONSTRAINT `FK7yh1cmuib7hnrbu4ntka4v7ro` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`id`),
  CONSTRAINT `FKhiwr0cl8fpxh1xm9y17wo5up0` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`),
  CONSTRAINT `FKowomku74u72o6h8q0khj7id8q` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'2025-05-01','2024-10-01','Xeldrin Capsule (Enteric Coated) 20 mg','Xeldrin_Capsule__Enteric_Coated__20_mg_33f36b4f-8679-445c-8904-a6c27213fcaf',0,100,6,1,1,1),(2,'2025-05-01','2024-10-01','Fluclox Capsule 500 mg','Fluclox_Capsule_500_mg_38b36b96-f3b4-462f-920a-c80cbe1191bb',0,100,14,1,2,1),(3,'2025-07-01','2024-10-01','Monas Tablet  10 mg','Monas_Tablet__10_mg_5378854b-f55d-4644-88cc-e00f2eedf793',0,100,17,1,3,3),(4,'2025-02-01','2024-10-01','Maxima Capsule (Enteric Coated) 20 mg','Maxima_Capsule__Enteric_Coated__20_mg_37be43d2-b988-4832-bb3f-7544e5fba321',0,97,7,1,4,3),(5,'2025-04-01','2024-10-01','Seclo Capsule (Enteric Coated) 20 mg','Seclo_Capsule__Enteric_Coated__20_mg_2042b72e-2b24-4515-95ee-27d14e82be78',0,100,60,1,1,2),(6,'2025-04-01','2024-10-01',' Neuro-B Tablet 100 mg','_Neuro-B_Tablet_100_mg_12ec201d-7dc0-49f1-a00a-ab3dbcb28617',0,99,10,1,7,2),(7,'2025-03-01','2024-10-01','Xeldrin Capsule (Enteric Coated) 20 mg','Xeldrin_Capsule__Enteric_Coated__20_mg_c21fbdbf-363c-4a18-8577-36b18d3182a4',0,100,6,2,1,1),(8,'2025-05-01','2024-10-01','Fluclox Capsule 500 mg','Fluclox_Capsule_500_mg_f795f8c0-2bdd-465a-ac1a-6d041f27a255',0,97,14,2,2,1),(9,'2025-03-01','2024-10-01','Monas Tablet 10 mg','Monas_Tablet_10_mg_24b2686b-0416-411f-86bc-18c55bce6bed',0,100,10,2,3,3),(10,'2025-05-01','2024-10-01','Maxima Capsule (Enteric Coated) 20 mg','Maxima_Capsule__Enteric_Coated__20_mg_6234e528-497b-4619-8e8d-6da44773a471',0,100,7,2,4,3),(11,'2025-05-01','2024-10-01','Seclo Capsule (Enteric Coated) 20 mg','Seclo_Capsule__Enteric_Coated__20_mg_f54bf0fe-3506-4963-bb0e-0bfb952567ba',0,100,60,2,1,2),(12,'2025-05-01','2024-10-01','Neuro-B Tablet 100 mg','Neuro-B_Tablet_100_mg_dd825526-68bc-4bfa-8c5d-3fe87abb984b',0,98,10,2,7,2),(13,'2025-04-01','2024-10-01','Xeldrin Capsule (Enteric Coated) 20 mg','Xeldrin_Capsule__Enteric_Coated__20_mg_faff7747-76e3-46b8-b1af-a0f91e7b283b',0,97,6,3,1,1),(14,'2025-05-01','2024-10-01','Fluclox Capsule 500 mg','Fluclox_Capsule_500_mg_89e1e271-d5ca-404a-8dc4-3ad7f42027d1',0,98,14,3,2,1),(15,'2025-06-01','2024-10-01','Monas Tablet 10 mg','Monas_Tablet_10_mg_9cc176bb-dbd7-4a6b-8f08-e21f8293d07a',0,100,10,3,3,3),(16,'2025-06-01','2024-10-01','Maxima Capsule (Enteric Coated) 20 mg','Maxima_Capsule__Enteric_Coated__20_mg_6bb8da48-81b9-4042-9988-55e1617b3b01',0,100,7,3,4,3),(17,'2025-05-01','2024-10-01','Seclo Capsule (Enteric Coated) 20 mg','Seclo_Capsule__Enteric_Coated__20_mg_2ec847bb-d7f8-46fb-8d0c-3ccfd39441a9',0,100,60,3,1,2),(18,'2025-05-01','2024-10-01','Neuro-B Tablet 100 mg','Neuro-B_Tablet_100_mg_56c4bd51-d299-48ec-ad6b-2ac0dd1212b8',0,100,10,3,7,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customername` varchar(255) DEFAULT NULL,
  `discount` float NOT NULL,
  `quantity` int NOT NULL,
  `salesdate` date DEFAULT NULL,
  `totalprice` int NOT NULL,
  `sales_details_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb6pnjoyoc51ead5sdtsixkuht` (`sales_details_id`),
  CONSTRAINT `FKb6pnjoyoc51ead5sdtsixkuht` FOREIGN KEY (`sales_details_id`) REFERENCES `sales_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,'Kutub',0,0,'2024-10-02',31,NULL),(2,'Towhid',0,0,'2024-10-02',46,NULL),(3,'Shabab',0,0,'2024-10-02',62,NULL);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_details`
--

DROP TABLE IF EXISTS `sales_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `discount` float NOT NULL,
  `quantity` int NOT NULL,
  `total_price` float NOT NULL,
  `unit_price` float NOT NULL,
  `product_id` int NOT NULL,
  `sales_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfro6i33ctcc7us92q7j85j41m` (`product_id`),
  KEY `FK9k57fsnt2gom2tvbrft8p9q0x` (`sales_id`),
  CONSTRAINT `FK9k57fsnt2gom2tvbrft8p9q0x` FOREIGN KEY (`sales_id`) REFERENCES `sales` (`id`),
  CONSTRAINT `FKfro6i33ctcc7us92q7j85j41m` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_details`
--

LOCK TABLES `sales_details` WRITE;
/*!40000 ALTER TABLE `sales_details` DISABLE KEYS */;
INSERT INTO `sales_details` VALUES (1,0,3,21,7,4,1),(2,0,1,10,10,6,1),(3,0,2,28,14,14,2),(4,0,3,18,6,13,2),(5,0,3,42,14,8,3),(6,0,2,20,10,12,3);
/*!40000 ALTER TABLE `sales_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_product`
--

DROP TABLE IF EXISTS `sales_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_product` (
  `sales_id` int NOT NULL,
  `product_id` int NOT NULL,
  KEY `FK7dl4fmr89kvli7uaj1u19306i` (`product_id`),
  KEY `FK18ebowds3h9totm6kall9ovbh` (`sales_id`),
  CONSTRAINT `FK18ebowds3h9totm6kall9ovbh` FOREIGN KEY (`sales_id`) REFERENCES `sales` (`id`),
  CONSTRAINT `FK7dl4fmr89kvli7uaj1u19306i` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_product`
--

LOCK TABLES `sales_product` WRITE;
/*!40000 ALTER TABLE `sales_product` DISABLE KEYS */;
INSERT INTO `sales_product` VALUES (1,4),(1,6),(2,14),(2,13),(3,8),(3,12);
/*!40000 ALTER TABLE `sales_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `cell` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Dhaka',14541965,'aci@gmail.com','ACI Limited'),(2,'Dhaka',569654,'square@gmail.com','Square Pharmaceuticals PLC'),(3,'Dhaka',5145646,'acme@gmail.com','ACME Laboratories Ltd.');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_logged_out` bit(1) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj8rfw4x0wjjyibfqq566j4qng` (`user_id`),
  CONSTRAINT `FKj8rfw4x0wjjyibfqq566j4qng` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NzgyMDUxLCJleHAiOjE3Mjc4Njg0NTF9.HI03jHoBF8_q4E0cNEBtZNKfBOp2qCGrFKRdPLIM8-Hs5nzsz3CDcMl4s38qiOGR',1),(2,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NzgyMDk2LCJleHAiOjE3Mjc4Njg0OTZ9.kuXxSLpEiXAnl4WPNPklYalHxcFHRYcnzmNl8hHCOsR1oprllnYcaD8HOqfp9U_F',1),(3,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NzgyMjczLCJleHAiOjE3Mjc4Njg2NzN9.7QK2mrAYDoIaVcfY-VR1RPPJ1f5c01YunaPwKuaf2ndPj0HfRP9msrxFqueCw52P',1),(4,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtZHRvd2hpZHVsYTQ2MEBnbWFpbC5jb20iLCJyb2xlIjoiVVNFUiIsImlhdCI6MTcyNzc4MzA0NiwiZXhwIjoxNzI3ODY5NDQ2fQ.rVT3r6_ajJAyOJzBYM2YtqiGCwoX991KHgfSq9zmLi047unpjZmgJXApTgyjkr-C',2),(5,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtZHRvd2hpZHVsYTQ2MEBnbWFpbC5jb20iLCJyb2xlIjoiVVNFUiIsImlhdCI6MTcyNzc4MzA4OSwiZXhwIjoxNzI3ODY5NDg5fQ.0xx2UuNwlYi20y33CP9hD8gcRy6hUAYQsiAixP1PCuT7NVS2SglkxlUnRssV005p',2),(6,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJjdnZ2YmpqNzU1QGdtYWlsLmNvbSIsInJvbGUiOiJQSEFSTUFDSVNUIiwiaWF0IjoxNzI3NzgzNDU5LCJleHAiOjE3Mjc4Njk4NTl9.13DGkjn6Q1TOrl-TSLjSzK7jRlwpBZ09CjMvrAZ1xH2iDj9ME6UAHyA2-P6Nfm7e',4),(7,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJjdnZ2YmpqNzU1QGdtYWlsLmNvbSIsInJvbGUiOiJQSEFSTUFDSVNUIiwiaWF0IjoxNzI3Nzg0OTE3LCJleHAiOjE3Mjc4NzEzMTd9.tBaoYSXY64S8dfTugMv3ZBxWAEpMg_MnEQ-2ZFzLbo4HCRtyfHe9zaxxY3UeLM4N',4),(8,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3Nzg1MzM4LCJleHAiOjE3Mjc4NzE3Mzh9.s8sux5Oc8BYPqJPmmA17mHJzwRonkCac0nG_DghnjiF1vjMyUHr4KUklJD7Q4uvJ',1),(9,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtZHRvd2hpZHVsYTQ2MEBnbWFpbC5jb20iLCJyb2xlIjoiVVNFUiIsImlhdCI6MTcyNzc4NTQ0OCwiZXhwIjoxNzI3ODcxODQ4fQ.DvVRKvnRRoyxkojYVEJzKO-PFN8WR9_OVHILrQaqvZWCnkSd-Z1Rc722OEHhAXI3',2),(10,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3Nzg1NTg1LCJleHAiOjE3Mjc4NzE5ODV9.of0RIPRyJ4T9Tin37MgRqTcDj-PHJrAjRQeRM1aYAoBq9kulWCdRSvFQrU_8UV21',1),(11,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3Nzg1ODQ3LCJleHAiOjE3Mjc4NzIyNDd9.mLfPR0Se_9LDGAPsggzT-iFrsubQoK2L7MTU0wdM1TLNFFIT0GMBk9EBBk4wKLfI',1),(12,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3Nzg1OTAwLCJleHAiOjE3Mjc4NzIzMDB9.9GxICs22N-QRtUqdpClvlQBr1DF7FVo-Qy9iVDVHyKnl6L_8oc_5h1h0EOb_waUc',1),(13,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3Nzg2MTQ5LCJleHAiOjE3Mjc4NzI1NDl9.vY7SfVR0XdxT9k3bf-thbMoB5iMF6jGSQSpx307OQkv29qov9X5XcA-MY-ZzhVFf',1),(14,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtZHRvd2hpZHVsYTQ2MEBnbWFpbC5jb20iLCJyb2xlIjoiVVNFUiIsImlhdCI6MTcyNzc4NjE3OCwiZXhwIjoxNzI3ODcyNTc4fQ.jAy00AH6N4DrMvVJy3tjDUUcTeEMcx5DkydQeF_vwU6RwI_m8FfQYTYafAJ6mUXK',2),(15,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJjdnZ2YmpqNzU1QGdtYWlsLmNvbSIsInJvbGUiOiJQSEFSTUFDSVNUIiwiaWF0IjoxNzI3Nzg2MjI1LCJleHAiOjE3Mjc4NzI2MjV9.qXkkFKuPWLQmy23RW9huvlcau_uVt9qw_u3Bn8qabhcWCvyTuNPJY717wciNkVCt',4),(16,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3ODQ2MjMzLCJleHAiOjE3Mjc5MzI2MzN9.IL4PqqEgrV0byRsTXYigRwC3-AAj0zx40rqo2kapLEB64kGX7UrCHVqTDikzXKH7',1),(17,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtZHRvd2hpZHVsYTQ2MEBnbWFpbC5jb20iLCJyb2xlIjoiVVNFUiIsImlhdCI6MTcyNzg0NjQxNiwiZXhwIjoxNzI3OTMyODE2fQ.Xr2RDUK-OE8HNzQVmWzyBrbNlwWy4Cf67aObBIvdkWTGP0aRT_I2jhTXsNsPkdVz',2),(18,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJjdnZ2YmpqNzU1QGdtYWlsLmNvbSIsInJvbGUiOiJQSEFSTUFDSVNUIiwiaWF0IjoxNzI3ODQ2NDMxLCJleHAiOjE3Mjc5MzI4MzF9.EHjnl73Z8UDwGL1NTqsEMJ2JSNdeZyymTmI-kp45Tgr04TRaYcf5ysCX8LA-o3oM',4),(19,_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3ODQ2NDYwLCJleHAiOjE3Mjc5MzI4NjB9.96SP7xEHbmrPgAyUafnG_0_A8ZqFg5Y2FZ2sT_PWbvi_jpJpEY9iFbuHySOGCNMR',1),(20,_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtZHRvd2hpZHVsYTQ2MEBnbWFpbC5jb20iLCJyb2xlIjoiVVNFUiIsImlhdCI6MTcyNzg0OTUxNiwiZXhwIjoxNzI3OTM1OTE2fQ.ZCUSDwDCVzdzER3zqsNxOW94ZPkr7BgO8RnMrr401lsIJmCyHuC8Km5bKxNpNmPr',2),(21,_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJjdnZ2YmpqNzU1QGdtYWlsLmNvbSIsInJvbGUiOiJQSEFSTUFDSVNUIiwiaWF0IjoxNzI3ODQ5NTc2LCJleHAiOjE3Mjc5MzU5NzZ9.4YYYJ2BVS_MFoFAxHu8WrN-08o5TQOZVaMEQs8MDXIyv_9pGWKaPGUPs3GM5b6l-',4);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `cell` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','PHARMACIST','USER') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK3wfgv34acy32imea493ekogs5` (`cell`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,_binary '',NULL,'45541652',NULL,'alammdtowhidul9@gmail.com',NULL,NULL,'Towhid','$2a$10$7bH2rrcnALN4WcRPY7Q5Ae.LQvzcEKMCvECV0BUY7IyaQHhiyYiry','ADMIN'),(2,_binary '','Naogaon','017675150543','2024-10-01','mdtowhidula460@gmail.com','male','gyesr','Md Towhidul Alam','$2a$10$qP0vrVbVNIpwnduI6nDUT.JIOTJSkJjlAaicdjiOyarVgGQII5R0.','USER'),(4,_binary '',NULL,'455416521556',NULL,'cvvvbjj755@gmail.com',NULL,NULL,'Towhid','$2a$10$2hgVLDQ5bNvgK.kMv1hWo.JfSfnaVxRvrupuzFSZjrx7DkIYScUKW','PHARMACIST');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02 12:25:05
