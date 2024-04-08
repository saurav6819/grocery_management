-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: 127.0.0.1    Database: grocery_db
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `grocery_item`
--

DROP TABLE IF EXISTS `grocery_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grocery_item` (
  `grocery_item_id` bigint NOT NULL AUTO_INCREMENT,
  `grocery_item_name` varchar(255) DEFAULT NULL,
  `grocery_item_price` double DEFAULT NULL,
  `grocery_item_type` enum('VEGETABLES','FRUITS','MEAT','RICE_CEREAL','SPICES','HEALTH_CARE','PERSONAL_CARE','HOUSEHOLD') DEFAULT NULL,
  `grocery_total_stock` bigint NOT NULL,
  PRIMARY KEY (`grocery_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grocery_item`
--

LOCK TABLES `grocery_item` WRITE;
/*!40000 ALTER TABLE `grocery_item` DISABLE KEYS */;
INSERT INTO `grocery_item` VALUES (1,' Onion',25,'VEGETABLES',8),(2,' Potato',20,'VEGETABLES',20),(3,' Cabbage',42,'VEGETABLES',-15),(4,' Grapes',85,'FRUITS',15),(5,' Apple',110,'FRUITS',1),(6,' Chicken',200,'MEAT',25),(7,' Bombil Fish',270,'MEAT',10),(8,' Rice',35,'RICE_CEREAL',10),(9,' Flour',32,'RICE_CEREAL',50),(10,' Maida',20,'RICE_CEREAL',50),(11,' Dhaniya',64,'SPICES',14),(12,' Haldi',52,'SPICES',27),(13,' Red Chilli Powder',48,'SPICES',26),(14,' Stayfree Pads',40,'HEALTH_CARE',20),(15,' Cotton',20,'HEALTH_CARE',15),(16,' Soap',10,'PERSONAL_CARE',4),(17,' Shampoo',70,'PERSONAL_CARE',42),(18,' Harpic',160,'HOUSEHOLD',44),(19,' Scoth Brite Broom',160,'HOUSEHOLD',35);
/*!40000 ALTER TABLE `grocery_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_grocery_item`
--

DROP TABLE IF EXISTS `ordered_grocery_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordered_grocery_item` (
  `ordered_grocery_item_id` bigint NOT NULL AUTO_INCREMENT,
  `grocery_item_name` varchar(255) DEFAULT NULL,
  `grocery_item_price` double DEFAULT NULL,
  `total_quantity` bigint NOT NULL,
  `user_order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ordered_grocery_item_id`),
  KEY `FK6e2woj44510laui5occcbykce` (`user_order_id`),
  CONSTRAINT `FK6e2woj44510laui5occcbykce` FOREIGN KEY (`user_order_id`) REFERENCES `user_orders` (`user_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_grocery_item`
--

LOCK TABLES `ordered_grocery_item` WRITE;
/*!40000 ALTER TABLE `ordered_grocery_item` DISABLE KEYS */;
INSERT INTO `ordered_grocery_item` VALUES (1,' Onion',25,10,1),(2,' Cabbage',42,5,1),(3,' Rice',35,10,1),(4,' Apple',110,2,1);
/*!40000 ALTER TABLE `ordered_grocery_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'rohit.kumar@gmail.com','Rohit Kumar','rohit'),(2,'saurav.suman@gmail.com','Saurav Suman','saurav');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_orders`
--

DROP TABLE IF EXISTS `user_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_orders` (
  `user_order_id` bigint NOT NULL AUTO_INCREMENT,
  `ordered_date` datetime(6) DEFAULT NULL,
  `total_order_value` double DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`user_order_id`),
  KEY `FKkuspr37yv513ga1okogyxrb7m` (`user_id`),
  CONSTRAINT `FKkuspr37yv513ga1okogyxrb7m` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_orders`
--

LOCK TABLES `user_orders` WRITE;
/*!40000 ALTER TABLE `user_orders` DISABLE KEYS */;
INSERT INTO `user_orders` VALUES (1,'2024-04-06 22:50:46.985000',1030,1);
/*!40000 ALTER TABLE `user_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_user_id` bigint NOT NULL,
  `roles` enum('ADMIN','USER') DEFAULT NULL,
  KEY `FKkv46dn3qakjvsk7ra33nd5sns` (`user_user_id`),
  CONSTRAINT `FKkv46dn3qakjvsk7ra33nd5sns` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'USER'),(2,'USER'),(2,'ADMIN');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-07  2:14:45
