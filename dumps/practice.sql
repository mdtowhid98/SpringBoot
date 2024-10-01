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
INSERT INTO `categories` VALUES (1,'Omeprazole'),(2,'Flucloxacillin Sodium'),(3,'Montelukast Sodium'),(4,'Esomeprazole'),(5,'Aceclofenac'),(6,'Aminophylline'),(7,'Vitamin B1, B6 & B12');
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'2025-05-01','2024-10-01','Xeldrin 20 mg','Xeldrin_20_mg_f365c426-5964-4a6b-9aed-bc7e98d67ad1',0,100,60,1,1,1),(3,'2025-07-01','2024-10-01','Fluclox 500 mg','Fluclox_500_mg_876895f5-5fb3-4a2a-af1e-49d2a8d7260f',0,100,140,1,2,1),(4,'2025-06-01','2024-10-01','Monas Tablet','Monas_Tablet_3deaa3c0-61ad-45f3-9446-76806924830f',0,100,17,1,3,2),(5,'2025-05-01','2024-10-01','Maxima Capsule (Enteric Coated)','Maxima_Capsule__Enteric_Coated__9fef825f-dde5-4e9c-ad4e-ec9ed646c8af',0,100,6,1,4,2),(6,'2025-05-01','2024-10-01','Acelock Tablet','Acelock_Tablet_f6f76179-c0ee-404d-b762-ea15811e5054',0,100,3,1,5,3),(7,'2025-05-01','2024-10-01','Aminophylline Tablet 100 mg','Aminophylline_Tablet_100_mg_301ee7a2-115b-49bc-954a-1a7f98328af3',0,500,1,1,6,3),(8,'2025-08-01','2024-10-01','Seclo Capsule (Enteric Coated) 20 mg','Seclo_Capsule__Enteric_Coated__20_mg_daf4a9e1-23ed-475f-875d-77b82a951a9f',0,100,6,1,1,4),(9,'2025-03-01','2024-10-01','Neuro-B Tablet 100 mg','Neuro-B_Tablet_100_mg_9cbbe302-b4f2-475b-b0aa-0ec7081e3ead',0,100,10,1,7,4),(10,'2025-05-01','2024-10-01','Xeldrin Capsule (Enteric Coated) 20 mg','Xeldrin_Capsule__Enteric_Coated__20_mg_5c22e1ae-0724-420b-89fb-24cba8e7e05d',0,100,60,2,1,1),(11,'2025-05-01','2024-10-01','Fluclox Capsule 500 mg','Fluclox_Capsule_500_mg_49804ae0-6e37-45eb-93f1-a79e9cabc075',0,100,14,2,2,1),(12,'2025-05-01','2024-10-01','Monas Tablet  10 mg','Monas_Tablet__10_mg_c7c42441-3fe0-489e-ad1a-e6f54ced7bc8',0,100,17,2,3,2),(13,'2025-05-01','2024-10-01','Maxima Capsule (Enteric Coated) 20 mg','Maxima_Capsule__Enteric_Coated__20_mg_9a8aea40-47de-4bd1-9852-e59cd10227fc',0,100,7,2,4,2),(14,'2025-04-01','2024-10-01',' Acelock Tablet 100 mg','_Acelock_Tablet_100_mg_550ac79a-bf52-4895-ba67-66547e505e5f',0,100,3,2,5,3),(15,'2025-08-01','2024-10-01','Aminophylline Tablet 100 mg','Aminophylline_Tablet_100_mg_c208c5e1-d728-454d-978c-d040327a8703',0,1,1,2,6,3),(16,'2025-09-01','2024-10-02','Seclo Capsule (Enteric Coated) 20 mg','Seclo_Capsule__Enteric_Coated__20_mg_ecfb5913-9d4c-483d-b81d-0e7f819b36aa',0,100,6,2,1,4),(17,'2025-07-01','2024-10-01','Neuro-B Tablet 100 mg','Neuro-B_Tablet_100_mg_c7a173c7-daa5-4099-84aa-1dd739873269',0,100,10,2,7,4),(18,'2025-06-01','2024-10-01','Seclo Capsule (Enteric Coated) 20 mg','Seclo_Capsule__Enteric_Coated__20_mg_1668b35e-87fa-4694-b350-7496d8235ff8',0,100,6,3,1,4),(19,'2025-04-01','2024-10-01','Neuro-B Tablet 100 mg','Neuro-B_Tablet_100_mg_504f22ba-c9ff-45ca-a743-4717c985c484',0,100,10,3,7,4),(20,'2025-05-01','2024-10-01','Acelock Tablet','Acelock_Tablet_ab0414fa-36d6-4623-ae19-0a59c3289480',0,100,3,3,5,3),(21,'2025-07-01','2024-10-01','Aminophylline Tablet 100 mg','Aminophylline_Tablet_100_mg_6d541367-374a-4024-9dd4-615b68e81266',0,100,1,3,6,3),(22,'2025-04-01','2024-10-01','Xeldrin Capsule (Enteric Coated) 20 mg','Xeldrin_Capsule__Enteric_Coated__20_mg_d7712ab2-7f7e-4b42-adbe-3ab73de1b13e',0,100,6,3,1,1),(23,'2025-06-01','2024-10-01','Fluclox Capsule 500 mg','Fluclox_Capsule_500_mg_e3295e0e-399f-4321-9754-2c913a158c88',0,100,14,3,2,1),(24,'2025-05-01','2024-10-01','Monas Tablet  10 mg','Monas_Tablet__10_mg_d6537153-57f3-4471-a902-5fac3024d019',0,100,17,3,3,2),(25,'2025-06-01','2024-10-01','Maxima Capsule (Enteric Coated) 20 mg','Maxima_Capsule__Enteric_Coated__20_mg_7ea54377-4f57-449a-a04d-e270c1000949',0,100,6,3,4,2);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_details`
--

LOCK TABLES `sales_details` WRITE;
/*!40000 ALTER TABLE `sales_details` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Dhaka',15419659,'aci@gmail.com','ACI Limited'),(2,'Dhaka',41526,'acme@gmail.com','ACME Laboratories Ltd.'),(3,'Dhaka',546262652,'bristol@gmail.com','Bristol Pharmaceuticals Ltd.'),(4,'Dhaka',49596525,'square@gmail.com','Square Pharmaceuticals PLC');
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NDQzNzA1LCJleHAiOjE3Mjc1MzAxMDV9.nLOq6BhecJ4tgMsDIU__g2A0xorI_uQEalMWj4jjvbvyW968S0nHA4SvsbOM818U',1),(2,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NDQzODMxLCJleHAiOjE3Mjc1MzAyMzF9.9hHkPncxHN0-qLwrwTms7TTl-5ww9zbdQHJMifnvdtnmaMqBt9afGwCPNqF_oOns',1),(3,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NDU0NzU1LCJleHAiOjE3Mjc1NDExNTV9._uzS6UUZ6Wm5zx_rFObIcmm7gCG8TKIu-1mGmBEBjArr_-iemWgF3wtaN0dw452L',1),(4,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NDYwMzk3LCJleHAiOjE3Mjc1NDY3OTd9.LnndnQwS_KgOO2sHcWPDCs0IxvFpbwQmvBytSPSxzXgRVzGj7Tyn_AdEwhM6rAw-',1),(5,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NDk1OTQ1LCJleHAiOjE3Mjc1ODIzNDV9.W_0SO9x0839JFAjLb6CxbwPbEEe-brq0o-EpwPuaKoCrT1o4VEh4_z-YCV5o_k2Y',1),(6,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTQxODQzLCJleHAiOjE3Mjc2MjgyNDN9.zyLEgzBDDQHMtGkOjzEBaYuSt1VXMrjoK7mPStuX3oBa5DOzXbXJ2UpCmUjtQHSX',1),(7,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTQxOTczLCJleHAiOjE3Mjc2MjgzNzN9.2TojMrqtVZLQUG_Xiz4kocnn_0A96CFeyIiaauL8UE5KIbJ9Xl6SIt42rrY1_0oF',1),(8,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTQ0NjE1LCJleHAiOjE3Mjc2MzEwMTV9.3E6soaxhKLWXz631uBHLVj_na83mzOKojQZmIc9uns0xK7iKsOtod80bayf7Pv2U',1),(9,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTQ5MzAyLCJleHAiOjE3Mjc2MzU3MDJ9.-z0Oevnvw_raxJoTUCs6IC9ccj3xHWvmLAKv2BMkzQmHDra2zd26HoktMrYUG1l-',1),(10,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTgxOTg0LCJleHAiOjE3Mjc2NjgzODR9.S-OyxNQzy0tYrCcliBrWc0Adr8dtQIsTl0Uva8fWu_OgGgTZBncVjXeWo9Lpbxf2',1),(11,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTgyNTAxLCJleHAiOjE3Mjc2Njg5MDF9.pCn7mPB0GVGS_-BW8PdoL-hmjjmZ-unrrcrL8IFT3z-h3oe9Q2ZStLX9zswORUEI',1),(12,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTgyODc2LCJleHAiOjE3Mjc2NjkyNzZ9.YsBSFOD12vFeeAbSstTO3hcDojPUL0P3aFkehBEcv0GJXx3P3ShrxsgQuFkoAD1b',1),(13,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTg0ODM5LCJleHAiOjE3Mjc2NzEyMzl9.WvGa507wc7KTndsgAKtD6VHMNwTRpZ0d3JgL91WYYl7F4oOoFnbJOUOW46THl8LM',1),(14,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTg1MTQ0LCJleHAiOjE3Mjc2NzE1NDR9.t1bwyZhk37ELtZqkfAIHp0ct6UsCuw63MKitExHf1EhBo4jaNZOZH0S7XW8czdqG',1),(15,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NTg4NjkyLCJleHAiOjE3Mjc2NzUwOTJ9.t6v3ktkgFdD_z-rF9vzCd34dp27H3uM0CjbdhZwAMqIF1JRB3wcWl4TxIVUdrD2v',1),(16,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjI2MDEyLCJleHAiOjE3Mjc3MTI0MTJ9.Xc8skHCGCLyU5NiLvC5vXZQ-NnyMd8kPi5Sa0HuL0iVg7vDiXZrJjvPTR6hOpoCo',1),(17,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjI4MzU2LCJleHAiOjE3Mjc3MTQ3NTZ9.ArIhlIzIRfQ2jgpZNKcvaDtN0yzH9eh8Hk7O_9_iAN6BXOgNXaQiiq77_hxk3peH',1),(18,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjMyNDMzLCJleHAiOjE3Mjc3MTg4MzN9.26HuRQUXKR61uk1RrXowoy2Lac-C2gFVfbXqabj8TtsGdMHUxWLGnTV6hmWblNAT',1),(19,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjMzMTc1LCJleHAiOjE3Mjc3MTk1NzV9.yNuYoD3ZAHBrnW_lxTTczbC27-Dj6GJutJkluEJQa7ZvIvIfJvptSqdwR8yQGd8q',1),(20,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjMzNjAyLCJleHAiOjE3Mjc3MjAwMDJ9.CCtqzb9eaPfq20GVQE9n2T7-pjnsuChNKOjcjD-codjfl_Jct4nkbRDwYMhHztKO',1),(21,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjM1MzE4LCJleHAiOjE3Mjc3MjE3MTh9.zXE-GPK0n8saChmDGS_PqwyuJcH3OqFr68GpOGUjHfxTq1_7XYr3tTj-Tq5ld8PF',1),(22,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjM3NTgwLCJleHAiOjE3Mjc3MjM5ODB9.iyPeHG5PnZEQrDmTStyPKOlKczeFapH0BiDKq6Hdw9XzwiwOOS89U_L_BYIdh604',1),(23,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjY3NjgwLCJleHAiOjE3Mjc3NTQwODB9.BmEITWK6gAam9WUTcZu7UwyCzIzVVLIjydq2Te3srR4oS7RxrNJQSwek64KvBhXE',1),(24,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjcxODU4LCJleHAiOjE3Mjc3NTgyNTh9.wPJ7rC1Xf-hfh9opes4i7_1AhEu-Vds_aVweNo3Ysisze_9LcOiZgT3INCKufjil',1),(25,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjcyNjI3LCJleHAiOjE3Mjc3NTkwMjd9.5l8DCDErNRWMJPXPVv2rR3D9EfbmoOp_R7Yv_5DOm26oMD4qxM-AJ7WGou62WDPz',1),(26,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NjczMzAzLCJleHAiOjE3Mjc3NTk3MDN9.A6aauw3wxM7gLcXNsg2LXg71FLYCik3OUsBrXBqKQ8N_KsSzk0zjnjqruIWgGObb',1),(27,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3Njc1MTk4LCJleHAiOjE3Mjc3NjE1OTh9.nJswGf6KocDCm_bKydyJPd56a2926qhpv50T9j3dsEoS8HeCDd-tBbDyV72JF153',1),(28,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NzA3NjM1LCJleHAiOjE3Mjc3OTQwMzV9.iMXaeMf-euF7nxEkE56mRA2U5q2alFEjqWoRdSeRR4z0tnNZ4ZaXtwhG1PlT9E9k',1),(29,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NzE1NDQ3LCJleHAiOjE3Mjc4MDE4NDd9.C7RlXox2jm8S3AcSFj72DgY-KQLrUAZaWCwtg7l2Tvvmi5cxsDywVhCcO3wHX0ES',1),(30,_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtZHRvd2hpZHVsYTQ2MEBnbWFpbC5jb20iLCJyb2xlIjoiVVNFUiIsImlhdCI6MTcyNzcxNjc4MCwiZXhwIjoxNzI3ODAzMTgwfQ.nOU-QftEYIzhKLQfOVsKfDRTcKko8yrEA5-DQ-3qLS2y_dAskvyHf1jgjsIx5paH',2),(31,_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NzE2ODEwLCJleHAiOjE3Mjc4MDMyMTB9.EA7Akf4Wz5GtZGMCAjeL6Nn9VxcaVUvTBh-A-YzsHX8RTxgHW-paIpv1x17WxIF0',1),(32,_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbGFtbWR0b3doaWR1bDlAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzI3NzIwMTUyLCJleHAiOjE3Mjc4MDY1NTJ9.DhSVm0Lgw1vNDjnqslxiJ2rAEE09hmTnumOJ62U96PHvUOEiHMGnTld28OcjsDih',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,_binary '','Naogaon','49654',NULL,'alammdtowhidul9@gmail.com',NULL,NULL,'Towhid','$2a$10$oruqxdUz819698Qg5g0aJu64K8Mp0J2oZIZwJNfRfE.phMD19Gcbe','ADMIN'),(2,_binary '\0','Naogaon','017675150545','2024-09-03','mdtowhidula460@gmail.com','male','gseg','Md Towhid','$2a$10$lENs4SaJrTusfy1PTTxkDO7.rgFHI92iFP9tiscXNTigsyPhcrGHG','USER');
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

-- Dump completed on 2024-10-01  1:21:16
