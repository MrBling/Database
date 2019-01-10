# Host: localhost  (Version 5.7.21)
# Date: 2019-01-10 20:21:16
# Generator: MySQL-Front 6.1  (Build 1.23)


#
# Structure for table "person"
#

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `pId` varchar(8) NOT NULL DEFAULT '',
  `pName` varchar(8) NOT NULL,
  `pSex` varchar(4) DEFAULT NULL,
  `pBirthday` varchar(20) DEFAULT NULL,
  `pDepartment` varchar(10) DEFAULT NULL,
  `pAuthority` varchar(8) DEFAULT NULL,
  `pPasswd` varchar(50) DEFAULT NULL,
  `pJob` varchar(8) DEFAULT NULL,
  `pEdulevel` varchar(8) DEFAULT NULL,
  `pSpcialty` varchar(8) DEFAULT NULL,
  `pAddress` varchar(8) DEFAULT NULL,
  `pTel` varchar(20) DEFAULT NULL,
  `pEmail` varchar(20) DEFAULT NULL,
  `pState` varchar(5) DEFAULT NULL,
  `pRemark` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Data for table "person"
#

INSERT INTO `person` VALUES ('1','程航宇','男','19980101','体育部','员工','3132333619fe','委员','大本','C语言','陕西','13975831171','351911372@qq.com','部长','无'),('2','赵帅斌','男','19980615','学习部','管理员','3132333619fe','部长','大本','学习','湖南','18507480874','738156044@qq.com','在职','帅气'),('3','赵帅斌','男','19980615','学习部','员工','3132333619fe','部长','大本','学习','无','无','无','无','无'),('4','刘宇轩','男','19980615','学习部','员工','3132333619fe','部长','大本','学习','无','无','无','无','无'),('5','赵帅斌','男','19980615','学习部','员工','3132333619fe','部长','大本','学习','无','无','无','无','无'),('6','刘邦','男','19980615','学习部','员工','3132333619fe','部长','大本','学习','无','无','无','无','无');

#
# Structure for table "personnel"
#

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel` (
  `Id` varchar(20) CHARACTER SET gbk NOT NULL DEFAULT '',
  `pId` varchar(25) CHARACTER SET gbk NOT NULL DEFAULT '',
  `pChange` varchar(25) CHARACTER SET gbk NOT NULL DEFAULT '',
  `pDescription` varchar(25) CHARACTER SET gbk NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "personnel"
#

INSERT INTO `personnel` VALUES ('201862202252','3','0','员工号:  3 ,加入公司'),('201862202253','4','0','员工号:  4 ,加入公司'),('201862204056','5','0','员工号:  5 ,加入公司'),('2018629103935','1','1','员工号:  1 ,由学习部调整至体育部');
