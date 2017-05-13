DROP TABLE IF EXISTS `test_order`;
CREATE TABLE `test_order` (
  `ID` varchar(50) NOT NULL,
  `CREATE_DATE` varchar(50) default NULL,
  `CREATE_USER` varchar(50) default NULL,
  `ORDER_STATUS` int(50) default NULL,
  `SELL_GOODID` varchar(50) default NULL,
  `SELL_PRICE` int(50) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;