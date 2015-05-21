-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.21 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных queueshop
DROP DATABASE IF EXISTS `queueshop`;
CREATE DATABASE IF NOT EXISTS `queueshop` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `queueshop`;


-- Дамп структуры для таблица queueshop.purchaser
DROP TABLE IF EXISTS `purchaser`;
CREATE TABLE IF NOT EXISTS `purchaser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typePurchaser` int(11) NOT NULL,
  `cashBox` int(11) NOT NULL,
  `quantityGoods` int(11) NOT NULL DEFAULT '0',
  `waitCashbox` int(11) NOT NULL DEFAULT '0',
  `step1` int(11) NOT NULL DEFAULT '0',
  `step2` int(11) NOT NULL DEFAULT '0',
  `step3` int(11) NOT NULL DEFAULT '0',
  `step4` int(11) NOT NULL DEFAULT '0',
  `step5` int(11) NOT NULL DEFAULT '0',
  `step6` int(11) NOT NULL DEFAULT '0',
  `step7` int(11) NOT NULL DEFAULT '0',
  `step8` int(11) NOT NULL DEFAULT '0',
  `step9` int(11) NOT NULL DEFAULT '0',
  `step10` int(11) NOT NULL DEFAULT '0',
  `step11` int(11) NOT NULL DEFAULT '0',
  `step12` int(11) NOT NULL DEFAULT '0',
  `step13` int(11) NOT NULL DEFAULT '0',
  `step14` int(11) NOT NULL DEFAULT '0',
  `step15` int(11) NOT NULL DEFAULT '0',
  `step16` int(11) NOT NULL DEFAULT '0',
  `step17` int(11) NOT NULL DEFAULT '0',
  `step18` int(11) NOT NULL DEFAULT '0',
  `step19` int(11) NOT NULL DEFAULT '0',
  `step20` int(11) NOT NULL DEFAULT '0',
  `step21` int(11) NOT NULL DEFAULT '0',
  `step22` int(11) NOT NULL DEFAULT '0',
  `step23` int(11) NOT NULL DEFAULT '0',
  `step24` int(11) NOT NULL DEFAULT '0',
  `step25` int(11) NOT NULL DEFAULT '0',
  `step26` int(11) NOT NULL DEFAULT '0',
  `step27` int(11) NOT NULL DEFAULT '0',
  `step28` int(11) NOT NULL DEFAULT '0',
  `step29` int(11) NOT NULL DEFAULT '0',
  `step30` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=848 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы queueshop.purchaser: ~20 rows (приблизительно)
DELETE FROM `purchaser`;
/*!40000 ALTER TABLE `purchaser` DISABLE KEYS */;
INSERT INTO `purchaser` (`id`, `typePurchaser`, `cashBox`, `quantityGoods`, `waitCashbox`, `step1`, `step2`, `step3`, `step4`, `step5`, `step6`, `step7`, `step8`, `step9`, `step10`, `step11`, `step12`, `step13`, `step14`, `step15`, `step16`, `step17`, `step18`, `step19`, `step20`, `step21`, `step22`, `step23`, `step24`, `step25`, `step26`, `step27`, `step28`, `step29`, `step30`) VALUES
	(818, 2, 2, 12, 0, 1001, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(819, 1, 1, 18, 0, 0, 1001, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(820, 2, 1, 4, 0, 0, 0, 1002, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(821, 1, 3, 19, 0, 0, 0, 0, 1001, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(822, 1, 2, 5, 0, 0, 0, 0, 0, 1001, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(823, 1, 4, 2, 0, 0, 0, 0, 0, 0, 1001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(824, 0, 2, 20, 0, 0, 0, 0, 0, 0, 0, 1001, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(825, 0, 4, 14, 0, 0, 0, 0, 0, 0, 0, 0, 1001, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(826, 0, 1, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(827, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(828, 0, 3, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1001, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(829, 1, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(830, 1, 4, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1001, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(831, 2, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1003, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0),
	(832, 2, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1004, 3, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 0),
	(833, 1, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1001, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(834, 1, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1001, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(835, 2, 3, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
	(836, 0, 2, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0),
	(837, 0, 4, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1001, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0),
	(838, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 2, 1, 0, 0, 0, 0, 0, 0, 0),
	(839, 2, 4, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 2, 1, 1, 1, 0, 0, 0, 0),
	(840, 0, 3, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 1, 1, 1, 1, 0, 0, 0),
	(841, 1, 2, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 1, 1, 1, 0, 0, 0),
	(842, 1, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 2, 2, 2, 2, 1),
	(843, 2, 4, 18, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 1, 1, 1, 1),
	(844, 0, 2, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 1, 1, 1),
	(845, 0, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1001, 1, 0),
	(846, 0, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002, 1),
	(847, 0, 2, 8, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1002);
/*!40000 ALTER TABLE `purchaser` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
