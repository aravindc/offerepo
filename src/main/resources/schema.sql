CREATE DATABASE IF NOT EXISTS `offermgmt`;
USE `offermgmt`;

DROP TABLE IF EXISTS `offer_product`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `offer`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `isactive` boolean DEFAULT true,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`userid`,`roleid`),
  KEY `fk_user_role_roleid_idx` (`roleid`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `offer` (
  `offerid` int(11) NOT NULL AUTO_INCREMENT,
  `offername` varchar(255) DEFAULT NULL,
  `offerdescription` varchar(255) DEFAULT NULL,
  `offercode` varchar(30) DEFAULT NULL,
  `offerstartdate` datetime DEFAULT NULL,
  `offerenddate` datetime DEFAULT NULL,
  PRIMARY KEY (`offerid`),
  UNIQUE KEY(`offercode`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `productid` int(11) NOT NULL AUTO_INCREMENT,
  `productname` varchar(255) DEFAULT NULL,
  `productcode` varchar(30) DEFAULT NULL,
  `skuno` int(11) DEFAULT NULL,
  `classid` varchar(30) DEFAULT NULL,
  `classvalue` varchar(150) DEFAULT NULL,
  `categoryid` varchar(30) DEFAULT NULL,
  `categoryvalue` varchar(150) DEFAULT NULL,
  `supercatid` varchar(30) DEFAULT NULL,
  `supercatvalue` varchar(150) DEFAULT NULL,
  `groupid` varchar(30) DEFAULT NULL,
  `groupvalue` varchar(150) DEFAULT NULL,
  `departmentid` varchar(30) DEFAULT NULL,
  `departmentvalue` varchar(150) DEFAULT NULL,
  `brandid` varchar(30) DEFAULT NULL,
  `brandvalue` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `offer_product` (
  `offerid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  PRIMARY KEY (`offerid`,`productid`)
--  ,
--  KEY `fk_offer_product_productid_idx` (`productid`),
--  CONSTRAINT `fk_offer_product_productid` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`) ON DELETE CASCADE ON UPDATE CASCADE,
--  CONSTRAINT `fk_offer_product_offerid` FOREIGN KEY (`offerid`) REFERENCES `offer` (`offerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;