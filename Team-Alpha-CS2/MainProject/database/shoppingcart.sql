/*
SQLyog v4.06 RC1
Host - 5.5.37 : Database - shoppingcart
*********************************************************************
Server version : 5.5.37
*/


create database if not exists `shoppingcart`;

USE `shoppingcart`;

/*Table structure for table `product` */

drop table if exists `product`;

CREATE TABLE `product` (
  `p_id` int(11) NOT NULL DEFAULT '0',
  `p_name` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `image_name` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert into `product` values (100,'google nexus',30000,'mobile','nexus image'),(101,'sony xperia',10000,'mobile','xperia image'),(102,'samsung s6',40000,'mobile','s6 image'),(103,'sony bravia',90000,'tv','bravia image'),(104,'lg L91',12000,'microwave oven','lg_owen pic');

/*Table structure for table `roles` */

drop table if exists `roles`;

CREATE TABLE `roles` (
  `r_id` int(11) NOT NULL,
  `r_name` varchar(30) NOT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `roles` */

insert into `roles` values (0,'user'),(1,'admin'),(2,'super_admin');

/*Table structure for table `user` */

drop table if exists `user`;

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_lname` varchar(30) DEFAULT NULL,
  `user_fname` varchar(30) DEFAULT NULL,
  `email_id` varchar(80) NOT NULL,
  `passwrd` varchar(12) NOT NULL,
  `address_line1` varchar(200) DEFAULT NULL,
  `address_line2` varchar(200) DEFAULT NULL,
  `phone_number` bigint(20) DEFAULT NULL,
  `r_id` int(11) NOT NULL,
  `gender` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `email_id` (`email_id`),
  KEY `r_id` (`r_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`r_id`) REFERENCES `roles` (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert into `user` values (1,'gaurav','sirisha','sirisha@emc.com','root','jp nagar','bangalore',1234567890,1,'male'),(2,'User','Test','test','root','1234','address',1234567890,0,'female'),(3,'kamath','shravya','shravya@emc.com','root','banashankari','bangalore',1213434367,0,'male'),(4,'ms','santhosh','santhosh@emc.com','root','paris','bangalore',1234567890,0,'female'),(5,'maharana','rubin','rubin@emc.com','root','murugeshpalya','bangalore',1235467890,2,'male'),(6,'b','jagdeesh','jagdeesh@emc.com','root','jalahalli','bangalore',9845120898,1,'male');
