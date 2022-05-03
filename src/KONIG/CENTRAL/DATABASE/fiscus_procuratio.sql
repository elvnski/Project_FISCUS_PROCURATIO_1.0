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
  `invoice_amount` decimal(13,2) NOT NULL,
  `discount` decimal(13,2) NOT NULL DEFAULT '0.00',
  `due_date` date NOT NULL,
  `payment` decimal(13,2) NOT NULL DEFAULT '0.00',
  `balance_due` decimal(13,2) NOT NULL,
  `debit` decimal(13,2) NOT NULL DEFAULT '0.00',
  `credit` decimal(13,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`AP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2000006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts_payable`
--

LOCK TABLES `accounts_payable` WRITE;
/*!40000 ALTER TABLE `accounts_payable` DISABLE KEYS */;
INSERT INTO `accounts_payable` VALUES ('2022-05-02','20:41',2000000,'KNYZ-JHW732HFW-2022','Kanyambez Engineering Ltd','PLumbing inspection and upgrade',150000.00,10000.00,'2022-05-31',0.00,150000.00,0.00,150000.00),('2022-05-02','20:57',2000001,'MSPC-OUWEF0884HW','Michael Scott Paper Company','10 boxes of copier paper',30000.00,0.00,'2022-05-31',0.00,30000.00,0.00,30000.00),('2022-05-03','10:39',2000002,'KNYZ-JHW732HFW-2022','Kanyambez Engineering Ltd','PLumbing inspection and upgrade',150000.00,10000.00,'2022-05-31',20000.00,130000.00,20000.00,0.00),('2022-05-03','10:41',2000003,'KNYZ-JHW732HFW-2022','Kanyambez Engineering Ltd','PLumbing inspection and upgrade',150000.00,10000.00,'2022-05-31',20000.00,110000.00,20000.00,0.00),('2022-05-03','12:23',2000004,'KNYZ-JHW732HFW-2022','Kanyambez Engineering Ltd','PLumbing inspection and upgrade',150000.00,10000.00,'2022-05-31',20000.00,90000.00,20000.00,0.00),('2022-05-03','12:28',2000005,'KNYZ-JHW732HFW-2022','Kanyambez Engineering Ltd','PLumbing inspection and upgrade',150000.00,10000.00,'2022-05-31',20000.00,70000.00,20000.00,0.00);
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
  `time` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'EMP',
  `AR_ID` int NOT NULL AUTO_INCREMENT,
  `invoice_no` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'EMP',
  `customer_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'EMP',
  `description` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'EMP',
  `invoice_amount` decimal(13,2) NOT NULL DEFAULT '0.00',
  `discount` decimal(13,2) NOT NULL DEFAULT '0.00',
  `due_date` date DEFAULT NULL,
  `payment` decimal(13,2) NOT NULL DEFAULT '0.00',
  `balance_due` decimal(13,2) NOT NULL DEFAULT '0.00',
  `debit` decimal(13,2) NOT NULL DEFAULT '0.00',
  `credit` decimal(13,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`AR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts_receivable`
--

LOCK TABLES `accounts_receivable` WRITE;
/*!40000 ALTER TABLE `accounts_receivable` DISABLE KEYS */;
INSERT INTO `accounts_receivable` VALUES ('2022-05-03','15:52',1000000,'CMYK-OIJWE8325H5BYS87','Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',100000.00,3000.00,'2022-05-31',0.00,100000.00,100000.00,0.00),('2022-05-03','15:53',1000001,'CMYK-OIJWE8325H5BYS87','Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',100000.00,3000.00,'2022-05-31',10000.00,90000.00,0.00,10000.00),('2022-05-03','15:59',1000002,'CMYK-OIJWE8325H5BYS87','Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',100000.00,3000.00,'2022-05-31',10000.00,80000.00,0.00,10000.00),('2022-05-03','16:01',1000003,'CMYK-OIJWE8325H5BYS87','Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',100000.00,3000.00,'2022-05-31',10000.00,70000.00,0.00,10000.00),('2022-05-03','16:03',1000004,'CMYK-OIJWE8325H5BYS87','Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',100000.00,3000.00,'2022-05-31',10000.00,60000.00,0.00,10000.00);
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
  `payment_date` date NOT NULL,
  `beginning_balance` decimal(13,2) NOT NULL,
  `scheduled_payment` decimal(13,2) NOT NULL,
  `extra_payment` decimal(13,2) NOT NULL,
  `total_payment` decimal(13,2) NOT NULL,
  `principal` decimal(13,2) NOT NULL,
  `interest` decimal(13,2) NOT NULL,
  `ending_balance` decimal(13,2) NOT NULL,
  `cumulative_interest` decimal(13,2) NOT NULL,
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
  `date` date NOT NULL,
  `time` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cash_ID` int NOT NULL AUTO_INCREMENT,
  `source` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `debit` decimal(10,2) DEFAULT '0.00',
  `credit` decimal(10,2) DEFAULT '0.00',
  `balance` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`cash_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5000014 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash`
--

LOCK TABLES `cash` WRITE;
/*!40000 ALTER TABLE `cash` DISABLE KEYS */;
INSERT INTO `cash` VALUES ('2022-03-03','11:32',1,'ijij','gy',100.00,100.00,100.00),('2022-05-02','20:58',5000000,'Michael Scott Paper Company','10 boxes of copier paper',0.00,10000.00,-10000.00),('2022-05-03','10:39',5000001,'Kanyambez Engineering Ltd','PLumbing inspection and upgrade',0.00,20000.00,-20000.00),('2022-05-03','10:41',5000002,'Kanyambez Engineering Ltd','PLumbing inspection and upgrade',0.00,20000.00,-20000.00),('2022-05-03','11:30',5000003,'Owner Capital','Owners',10000000.00,0.00,10000000.00),('2022-05-03','12:23',5000007,'Kanyambez Engineering Ltd','PLumbing inspection and upgrade',0.00,20000.00,-20000.00),('2022-05-03','12:28',5000008,'Kanyambez Engineering Ltd','PLumbing inspection and upgrade',0.00,20000.00,-40000.00),('2022-05-03','15:53',5000009,'Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',10000.00,0.00,-30000.00),('2022-05-03','15:59',5000010,'Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',10000.00,0.00,-20000.00),('2022-05-03','16:01',5000011,'Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',10000.00,0.00,-10000.00),('2022-05-03','16:03',5000012,'Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',10000.00,0.00,0.00),('2022-05-03','18:02',5000013,'huhuh','huhuh',500.00,0.00,500.00);
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
  `CSHP_ID` int NOT NULL AUTO_INCREMENT,
  `invoice_no` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `supplier` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cash_paid` decimal(10,2) NOT NULL,
  `discount_received` decimal(10,2) NOT NULL,
  PRIMARY KEY (`CSHP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3000003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_payments`
--

LOCK TABLES `cash_payments` WRITE;
/*!40000 ALTER TABLE `cash_payments` DISABLE KEYS */;
INSERT INTO `cash_payments` VALUES ('2022-05-03','10:41',3000000,'KNYZ-JHW732HFW-2022','Kanyambez Engineering Ltd','PLumbing inspection and upgrade',20000.00,0.00),('2022-05-03','12:23',3000001,'KNYZ-JHW732HFW-2022','Kanyambez Engineering Ltd','PLumbing inspection and upgrade',20000.00,0.00),('2022-05-03','12:28',3000002,'KNYZ-JHW732HFW-2022','Kanyambez Engineering Ltd','PLumbing inspection and upgrade',20000.00,0.00);
/*!40000 ALTER TABLE `cash_payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash_receipts`
--

DROP TABLE IF EXISTS `cash_receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cash_receipts` (
  `date` date NOT NULL,
  `time` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CR_ID` int NOT NULL AUTO_INCREMENT,
  `rec_or_inv_ID` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `client` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cash_received` decimal(10,2) NOT NULL,
  `discount_given` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`CR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_receipts`
--

LOCK TABLES `cash_receipts` WRITE;
/*!40000 ALTER TABLE `cash_receipts` DISABLE KEYS */;
INSERT INTO `cash_receipts` VALUES ('2022-05-03','16:03',4000000,'CMYK-OIJWE8325H5BYS87','Dunder Mifflin Paper Co','Information Systems Security Check and Upgrade',10000.00,0.00);
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
  `client_details` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `debit` decimal(10,2) NOT NULL DEFAULT '0.00',
  `credit` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`GL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_ledger`
--

LOCK TABLES `general_ledger` WRITE;
/*!40000 ALTER TABLE `general_ledger` DISABLE KEYS */;
INSERT INTO `general_ledger` VALUES (1,'2022-05-01','Liability','Accounts Payable','Rewauwo IT Services -- CAT 6 cables 600m',0.00,10000.00),(2,'2022-05-03','Asset','Cash','Kanyambez Engineering Ltd -- PLumbing inspection and upgrade',0.00,20000.00),(3,'2022-05-03','Asset','Cash','Kanyambez Engineering Ltd -- PLumbing inspection and upgrade',0.00,20000.00),(4,'2022-05-03','Asset','Cash','Owner Capital -- Owners',10000000.00,0.00),(5,'2022-05-03','Asset','Cash','ljiojoij -- jijij',10.00,0.00),(6,'2022-05-03','Asset','Cash','iikijaijdoijdw -- okckockeoec',452.00,0.00),(7,'2022-05-03','Asset','Cash','kjwfwijwidjwijd -- dwowkdowowdk',855.00,0.00),(8,'2022-05-03','Asset','Cash','Kanyambez Engineering Ltd -- PLumbing inspection and upgrade',0.00,20000.00),(9,'2022-05-03','Asset','Cash','Kanyambez Engineering Ltd -- PLumbing inspection and upgrade',0.00,20000.00),(10,'2022-05-03','Asset','Accounts Receivable','Dunder Mifflin Paper Co -- Information Systems Security Check and Upgrade',100000.00,0.00),(11,'2022-05-03','Asset','Accounts Receivable','Dunder Mifflin Paper Co -- Information Systems Security Check and Upgrade',100000.00,0.00),(12,'2022-05-03','Asset','Cash','Dunder Mifflin Paper Co -- Information Systems Security Check and Upgrade',10000.00,0.00),(13,'2022-05-03','Asset','Cash','Dunder Mifflin Paper Co -- Information Systems Security Check and Upgrade',10000.00,0.00),(14,'2022-05-03','Asset','Cash','Dunder Mifflin Paper Co -- Information Systems Security Check and Upgrade',10000.00,0.00),(15,'2022-05-03','Asset','Cash','Dunder Mifflin Paper Co -- Information Systems Security Check and Upgrade',10000.00,0.00),(16,'2022-05-03','Asset','Cash','huhuh -- huhuh',500.00,0.00);
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
  `date` date NOT NULL,
  `time` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL,
  `item_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `catalogue_ID` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `reorder_level` decimal(10,2) NOT NULL,
  `selling_price` decimal(10,2) NOT NULL,
  `current_quantity` decimal(10,2) NOT NULL,
  `stocking_price` decimal(10,2) NOT NULL,
  `stock_value` decimal(10,2) NOT NULL,
  `discount_limit` decimal(10,2) NOT NULL,
  PRIMARY KEY (`INY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=600001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (600000,'2022-05-03','16:06','jiojio','iiojioig',50.00,1500.00,80.00,1000.00,80000.00,300.00);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loans_directory`
--

DROP TABLE IF EXISTS `loans_directory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loans_directory` (
  `loan_NO` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `provider` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `loan_amount` decimal(13,2) NOT NULL,
  `annual_rate` decimal(13,2) NOT NULL,
  `loan_period` decimal(13,2) NOT NULL,
  `number_of_payments` decimal(13,2) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `scheduled_payment` decimal(13,2) NOT NULL,
  `total_early_payments` decimal(13,2) NOT NULL,
  `total_interest` decimal(13,2) NOT NULL,
  PRIMARY KEY (`loan_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans_directory`
--

LOCK TABLES `loans_directory` WRITE;
/*!40000 ALTER TABLE `loans_directory` DISABLE KEYS */;
INSERT INTO `loans_directory` VALUES ('KDFW-742THKSV98UWT4G','KanxDyns Finance','Purchase of new office block',15000000.00,8.00,60.00,43.00,'2022-05-26','2025-11-26',314272.61,4200000.00,2290495.98);
/*!40000 ALTER TABLE `loans_directory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owners_equity`
--

DROP TABLE IF EXISTS `owners_equity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owners_equity` (
  `date` date NOT NULL,
  `time` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `OE_ID` int NOT NULL AUTO_INCREMENT,
  `owner_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `account_action` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `notes` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`OE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owners_equity`
--

LOCK TABLES `owners_equity` WRITE;
/*!40000 ALTER TABLE `owners_equity` DISABLE KEYS */;
INSERT INTO `owners_equity` VALUES ('2022-05-03','16:06',7000000,'HAJHD','Investment','efmiln dznadvajavdn',500.00);
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

-- Dump completed on 2022-05-03 18:05:58
