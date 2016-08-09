CREATE DATABASE  IF NOT EXISTS `trainee_feedback`;
USE `trainee_feedback`;


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_account` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(10) NOT NULL,
  `last_name` varchar(10) NOT NULL,
  PRIMARY KEY (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `user` WRITE;

INSERT INTO `user` VALUES ('aaa','aaa@aaa.com','aaa','aaa'),('kien8995','trandongkien.sine@gmail.com','kien','tran'),('trankien','trandongkien.sine@gmail.com','kien','tran');

UNLOCK TABLES;

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `feedback_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `feedback_rate` varchar(255) DEFAULT NULL,
  `feedback_type` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `user_account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`feedback_id`),
  FOREIGN KEY (`user_account`) REFERENCES `user` (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `feedback` WRITE;

INSERT INTO `feedback` VALUES (1,'Neutral','The course objectives were met','note','kien8995'),(2,'Neutral','The course objectives were met','note','kien8995'),(3,'Agree','The organization of the course (facility) was good','','kien8995'),(4,'Neutral','The course objectives were met','note','kien8995'),(5,'Agree','The organization of the course (facility) was good','','kien8995'),(6,'Neutral','The training materials were good','','kien8995'),(7,'Neutral','The course objectives were met','','aaa'),(8,'Neutral','The course objectives were met','','aaa'),(9,'Agree','The level of the course is appropriate','','aaa'),(10,'Neutral','Subject coverage is good with respect to courseware','','aaa'),(11,'Neutral','Subject coverage is good with respect to courseware','','aaa'),(12,'Strongly agree','Your questions/doubts were answered satisfactorily and teacher support is good','','aaa'),(13,'Strongly disagree','The level of the course is appropriate','','aaa'),(14,'Neutral','Subject coverage is good with respect to courseware','','aaa'),(15,'Neutral','The quality of trainer instruction and communication was good','','aaa'),(16,'Strongly agree','Your questions/doubts were answered satisfactorily and teacher support is good','','kien8995'),(17,'Strongly agree','Your questions/doubts were answered satisfactorily and teacher support is good','noteeeeeeeeee','kien8995'),(18,'Neutral','Your questions/doubts were answered satisfactorily and teacher support is good','','aaa'),(19,'Strongly agree','This course will be useful for my work','Strongly agreeeeeeee','trankien');

UNLOCK TABLES;




