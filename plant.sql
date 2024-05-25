-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: localhost    Database: plant
-- ------------------------------------------------------
-- Server version	8.0.35-0ubuntu0.23.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `customer_customer_id` int NOT NULL,
  `address_id` int DEFAULT NULL,
  `address_type` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `colony` varchar(255) DEFAULT NULL,
  `house_no` varchar(255) DEFAULT NULL,
  `pin_code` int DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  KEY `FKs7adsy5nt5r7eb5m5mjfjphjo` (`customer_customer_id`),
  CONSTRAINT `FKs7adsy5nt5r7eb5m5mjfjphjo` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,2,'work','haridwar','jwalapur','b573',123,'uttarakhand'),(1,1,'home','Haridwar','jurs','a 301',123,'uttarakhand');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'A123!','srishti@gmail.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_item_id` int NOT NULL,
  `cart_total` double DEFAULT NULL,
  `customer_customer_id` int DEFAULT NULL,
  PRIMARY KEY (`cart_item_id`),
  KEY `FK9pmybgo923694wis4o9rntuqo` (`customer_customer_id`),
  CONSTRAINT `FK9pmybgo923694wis4o9rntuqo` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_planters`
--

DROP TABLE IF EXISTS `cart_planters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_planters` (
  `cart_cart_item_id` int NOT NULL,
  `planters_planter_id` int NOT NULL,
  UNIQUE KEY `UK_jwrhco1mx78x00eps5lwq18oe` (`planters_planter_id`),
  KEY `FKl3bfx0u6is9exgjavnw17ufj6` (`cart_cart_item_id`),
  CONSTRAINT `FKl3bfx0u6is9exgjavnw17ufj6` FOREIGN KEY (`cart_cart_item_id`) REFERENCES `cart` (`cart_item_id`),
  CONSTRAINT `FKxel5p48rtjgf4655ypimm27g` FOREIGN KEY (`planters_planter_id`) REFERENCES `planter` (`planter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_planters`
--

LOCK TABLES `cart_planters` WRITE;
/*!40000 ALTER TABLE `cart_planters` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_planters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_seq`
--

DROP TABLE IF EXISTS `cart_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_seq`
--

LOCK TABLES `cart_seq` WRITE;
/*!40000 ALTER TABLE `cart_seq` DISABLE KEYS */;
INSERT INTO `cart_seq` VALUES (1);
/*!40000 ALTER TABLE `cart_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `current_admin_session`
--

DROP TABLE IF EXISTS `current_admin_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `current_admin_session` (
  `user_id` int NOT NULL,
  `local_date_time` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_admin_session`
--

LOCK TABLES `current_admin_session` WRITE;
/*!40000 ALTER TABLE `current_admin_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `current_admin_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `current_user_session`
--

DROP TABLE IF EXISTS `current_user_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `current_user_session` (
  `user_id` int NOT NULL,
  `local_date_time` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_user_session`
--

LOCK TABLES `current_user_session` WRITE;
/*!40000 ALTER TABLE `current_user_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `current_user_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `is_active` int DEFAULT NULL,
  `mobile_no` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'SRISHTI','sri@example.com',1,'9999999999','Abcd1234','srishti');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `booking_order_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `order_date` date DEFAULT NULL,
  `quantity` int NOT NULL,
  `total_cost` double NOT NULL,
  `transaction_mode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`booking_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_planters`
--

DROP TABLE IF EXISTS `orders_planters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_planters` (
  `orders_booking_order_id` int NOT NULL,
  `planters_planter_id` int NOT NULL,
  UNIQUE KEY `UK_c7o1rupv0srgh06d7gjbb9jk6` (`planters_planter_id`),
  KEY `FK709xnmj9elrjc8t7tuitv7wdt` (`orders_booking_order_id`),
  CONSTRAINT `FK709xnmj9elrjc8t7tuitv7wdt` FOREIGN KEY (`orders_booking_order_id`) REFERENCES `orders` (`booking_order_id`),
  CONSTRAINT `FKdn0gt49nner7dat8y47tf5sqc` FOREIGN KEY (`planters_planter_id`) REFERENCES `planter` (`planter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_planters`
--

LOCK TABLES `orders_planters` WRITE;
/*!40000 ALTER TABLE `orders_planters` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_planters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_seq`
--

DROP TABLE IF EXISTS `orders_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_seq`
--

LOCK TABLES `orders_seq` WRITE;
/*!40000 ALTER TABLE `orders_seq` DISABLE KEYS */;
INSERT INTO `orders_seq` VALUES (1);
/*!40000 ALTER TABLE `orders_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plant`
--

DROP TABLE IF EXISTS `plant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plant` (
  `plant_id` int NOT NULL AUTO_INCREMENT,
  `bloom_time` varchar(255) NOT NULL,
  `common_name` varchar(255) NOT NULL,
  `difficulty_level` varchar(255) DEFAULT NULL,
  `medicinal_or_culinary_use` varchar(255) DEFAULT NULL,
  `plant_cost` double NOT NULL,
  `plant_description` varchar(255) DEFAULT NULL,
  `plant_height` double NOT NULL,
  `plant_spread` double NOT NULL,
  `plants_stock` int NOT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  `type_of_plant` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`plant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant`
--

LOCK TABLES `plant` WRITE;
/*!40000 ALTER TABLE `plant` DISABLE KEYS */;
INSERT INTO `plant` VALUES (1,'morning','roses','medium','yes',200,'good plant',40,3,20,'35 degree','flowering');
/*!40000 ALTER TABLE `plant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planter`
--

DROP TABLE IF EXISTS `planter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planter` (
  `planter_id` int NOT NULL AUTO_INCREMENT,
  `drainage_holes` int NOT NULL,
  `planter_capacity` double NOT NULL,
  `planter_color` varchar(255) DEFAULT NULL,
  `planter_cost` int NOT NULL,
  `planter_height` double NOT NULL,
  `planter_shape` varchar(255) DEFAULT NULL,
  `planter_stock` int NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `plants_plant_id` int DEFAULT NULL,
  `seeds_seed_id` int DEFAULT NULL,
  PRIMARY KEY (`planter_id`),
  KEY `FKldw7s3wtaxdy43mv7mmhsmhq0` (`plants_plant_id`),
  KEY `FKbwpooqb6tye7l6rmxqpnjp4rb` (`seeds_seed_id`),
  CONSTRAINT `FKbwpooqb6tye7l6rmxqpnjp4rb` FOREIGN KEY (`seeds_seed_id`) REFERENCES `seed` (`seed_id`),
  CONSTRAINT `FKldw7s3wtaxdy43mv7mmhsmhq0` FOREIGN KEY (`plants_plant_id`) REFERENCES `plant` (`plant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planter`
--

LOCK TABLES `planter` WRITE;
/*!40000 ALTER TABLE `planter` DISABLE KEYS */;
INSERT INTO `planter` VALUES (1,6,6,'brown',200,3,'round',6,NULL,1,1),(2,6,10,'value_here',200,7,'value_here',300,NULL,NULL,NULL),(3,8,9,'briwn',200,8,'gol',200,NULL,NULL,NULL);
/*!40000 ALTER TABLE `planter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seed`
--

DROP TABLE IF EXISTS `seed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seed` (
  `seed_id` int NOT NULL AUTO_INCREMENT,
  `bloom_time` varchar(255) DEFAULT NULL,
  `common_name` varchar(255) NOT NULL,
  `difficulty_level` varchar(255) DEFAULT NULL,
  `seeds_cost` double NOT NULL,
  `seeds_description` varchar(255) NOT NULL,
  `seeds_per_packet` int NOT NULL,
  `seeds_stock` int NOT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  `type_of_seeds` varchar(255) DEFAULT NULL,
  `watering` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seed`
--

LOCK TABLES `seed` WRITE;
/*!40000 ALTER TABLE `seed` DISABLE KEYS */;
INSERT INTO `seed` VALUES (1,'morning','roses','medium',20,'seed are good',30,40,'35 degree','round','2 times');
/*!40000 ALTER TABLE `seed` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-25 11:09:28
