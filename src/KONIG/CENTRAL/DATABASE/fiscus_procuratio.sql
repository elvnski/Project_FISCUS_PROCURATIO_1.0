CREATE DATABASE  IF NOT EXISTS `fiscus_procuratio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fiscus_procuratio`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: fiscus_procuratio
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `accounts_payable`
--

DROP TABLE IF EXISTS `accounts_payable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts_payable` (
  `date` date NOT NULL,
  `time` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `AP_ID` int NOT NULL AUTO_INCREMENT,
  `invoice_no` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `supplier_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `invoice_amount` decimal(10,2) NOT NULL,
  `discount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `due_date` date NOT NULL,
  `balance_due` decimal(10,2) NOT NULL,
  `debit` decimal(10,2) NOT NULL DEFAULT '0.00',
  `credit` decimal(10,2) NOT NULL,
  PRIMARY KEY (`AP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts_payable`
--

LOCK TABLES `accounts_payable` WRITE;
/*!40000 ALTER TABLE `accounts_payable` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts_payable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounts_receivable`
--

DROP TABLE IF EXISTS `accounts_receivable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts_receivable` (
  `date` date NOT NULL,
  `time` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `AR_ID` int NOT NULL AUTO_INCREMENT,
  `invoice_no` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `customer_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `invoice_amount` decimal(10,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `payment` decimal(10,2) DEFAULT NULL,
  `balance_due` decimal(10,2) DEFAULT NULL,
  `debit` decimal(10,2) DEFAULT NULL,
  `credit` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`AR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts_receivable`
--

LOCK TABLES `accounts_receivable` WRITE;
/*!40000 ALTER TABLE `accounts_receivable` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts_receivable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amortization_schedule`
--

DROP TABLE IF EXISTS `amortization_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amortization_schedule` (
  `payment_no` int NOT NULL,
  `payment_date` date DEFAULT NULL,
  `beginning_balance` decimal(10,2) DEFAULT NULL,
  `scheduled_payment` decimal(10,2) DEFAULT NULL,
  `extra_payment` decimal(10,2) DEFAULT NULL,
  `total_payment` decimal(10,2) DEFAULT NULL,
  `principal` decimal(10,2) DEFAULT NULL,
  `interest` decimal(10,2) DEFAULT NULL,
  `ending_balance` decimal(10,2) DEFAULT NULL,
  `cumulative_interest` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`payment_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amortization_schedule`
--

LOCK TABLES `amortization_schedule` WRITE;
/*!40000 ALTER TABLE `amortization_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `amortization_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash`
--

DROP TABLE IF EXISTS `cash`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cash` (
  `date` date DEFAULT NULL,
  `time` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CSH_ID` int NOT NULL AUTO_INCREMENT,
  `source` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `details` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `debit` decimal(10,2) DEFAULT NULL,
  `credit` decimal(10,2) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`CSH_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash`
--

LOCK TABLES `cash` WRITE;
/*!40000 ALTER TABLE `cash` DISABLE KEYS */;
INSERT INTO `cash` VALUES ('2022-03-03','11:32',1,'ijij','gy',100.00,100.00,100.00);
/*!40000 ALTER TABLE `cash` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash_payments`
--

DROP TABLE IF EXISTS `cash_payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cash_payments` (
  `date` date NOT NULL,
  `time` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CSH_ID` int NOT NULL AUTO_INCREMENT,
  `invoice_no` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `supplier_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cash_paid` decimal(10,2) NOT NULL,
  `discount_received` decimal(10,2) NOT NULL,
  PRIMARY KEY (`CSH_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_payments`
--

LOCK TABLES `cash_payments` WRITE;
/*!40000 ALTER TABLE `cash_payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash_receipts`
--

DROP TABLE IF EXISTS `cash_receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cash_receipts` (
  `date` int NOT NULL,
  `time` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CR_ID` int NOT NULL AUTO_INCREMENT,
  `rec_or_inv_ID` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `client` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cash_received` decimal(10,2) NOT NULL,
  `dicount_given` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`CR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_receipts`
--

LOCK TABLES `cash_receipts` WRITE;
/*!40000 ALTER TABLE `cash_receipts` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_receipts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_ledger`
--

DROP TABLE IF EXISTS `general_ledger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `general_ledger` (
  `GL_ID` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `account_type` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `account_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `client_details` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `debit` decimal(10,2) NOT NULL DEFAULT '0.00',
  `credit` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`GL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_ledger`
--

LOCK TABLES `general_ledger` WRITE;
/*!40000 ALTER TABLE `general_ledger` DISABLE KEYS */;
INSERT INTO `general_ledger` VALUES (1,'2022-05-01','Liability','Accounts Payable','Rewauwo IT Services -- CAT 6 cables 600m',0.00,10000.00);
/*!40000 ALTER TABLE `general_ledger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `INY_ID` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `time` varchar(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `item_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `catalogue_ID` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reorder_level` decimal(10,2) DEFAULT NULL,
  `selling_price` decimal(10,2) DEFAULT NULL,
  `current_quantity` decimal(10,2) DEFAULT NULL,
  `stocking_price` decimal(10,2) DEFAULT NULL,
  `stock_value` decimal(10,2) DEFAULT NULL,
  `discount_limit` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`INY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=600000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owners_equity`
--

DROP TABLE IF EXISTS `owners_equity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owners_equity` (
  `date` date DEFAULT NULL,
  `time` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `OE_ID` int NOT NULL AUTO_INCREMENT,
  `owner_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_action` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `notes` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`OE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owners_equity`
--

LOCK TABLES `owners_equity` WRITE;
/*!40000 ALTER TABLE `owners_equity` DISABLE KEYS */;
/*!40000 ALTER TABLE `owners_equity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fiscus_procuratio'
--

--
-- Dumping routines for database 'fiscus_procuratio'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-02 19:37:38
