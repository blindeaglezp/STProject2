/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : manage_system

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2015-12-02 09:43:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `city_id` int(50) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(255) NOT NULL,
  PRIMARY KEY (`city_id`,`city_name`),
  KEY `city_name` (`city_name`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('67', '临汾市');
INSERT INTO `city` VALUES ('68', '吕梁市');
INSERT INTO `city` VALUES ('64', '大同市');
INSERT INTO `city` VALUES ('62', '太原市');
INSERT INTO `city` VALUES ('70', '忻州市');
INSERT INTO `city` VALUES ('66', '晋中市');
INSERT INTO `city` VALUES ('65', '晋城市');
INSERT INTO `city` VALUES ('69', '朔州市');
INSERT INTO `city` VALUES ('72', '运城市');
INSERT INTO `city` VALUES ('63', '长治市');
INSERT INTO `city` VALUES ('71', '阳泉市');

-- ----------------------------
-- Table structure for city_project
-- ----------------------------
DROP TABLE IF EXISTS `city_project`;
CREATE TABLE `city_project` (
  `city_rfc_cpfk` varchar(255) NOT NULL,
  `county_name_cpfk` varchar(255) NOT NULL,
  `subject_name_cpfk` varchar(255) NOT NULL,
  `project_name` varchar(255) NOT NULL,
  `total_budget` int(50) DEFAULT NULL,
  `county_local_rfc_cpfk` varchar(255) DEFAULT NULL,
  `county_budget` int(50) DEFAULT NULL,
  `county_cost` int(50) DEFAULT NULL,
  `county_percent` int(50) DEFAULT NULL,
  `town_rfc_cpfk` varchar(255) DEFAULT NULL,
  `town_budget` int(50) DEFAULT NULL,
  `town_cost` int(50) DEFAULT NULL,
  `town_percent` int(50) DEFAULT NULL,
  KEY `county_local_rfc_cpfk` (`county_local_rfc_cpfk`),
  KEY `town_rfc_cpfk` (`town_rfc_cpfk`),
  KEY `city_rfc_cpfk` (`city_rfc_cpfk`),
  KEY `subject_name_cpfk` (`subject_name_cpfk`),
  KEY `county_name_cpfk` (`county_name_cpfk`),
  CONSTRAINT `city_project_ibfk_1` FOREIGN KEY (`city_rfc_cpfk`) REFERENCES `city_rfc` (`city_rfc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `city_project_ibfk_2` FOREIGN KEY (`county_local_rfc_cpfk`) REFERENCES `county_rfc` (`county_rfc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `city_project_ibfk_3` FOREIGN KEY (`county_name_cpfk`) REFERENCES `county` (`county_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `city_project_ibfk_4` FOREIGN KEY (`subject_name_cpfk`) REFERENCES `subject` (`sbj_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `city_project_ibfk_5` FOREIGN KEY (`town_rfc_cpfk`) REFERENCES `town_rfc` (`town_rfc`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city_project
-- ----------------------------
INSERT INTO `city_project` VALUES ('1099', '太谷县', '农业经济', '花卉培养', null, null, '100000', '80000', '80', null, null, null, null);
INSERT INTO `city_project` VALUES ('1099', '太谷县', '农业经济', '农林经济', '0', null, '30000', '20000', '0', null, '0', '0', '0');
INSERT INTO `city_project` VALUES ('1099', '太谷县', '农业经济', '花卉种植', '0', null, '50000', '25000', '0', null, '0', '0', '0');
INSERT INTO `city_project` VALUES ('1099', '太谷县', '农业经济', '1234', '0', null, '50000', '30000', '60', null, '0', '0', '0');
INSERT INTO `city_project` VALUES ('1099', '太谷县', '农业经济', '5678', '0', null, '100000', '40000', '40', null, '0', '0', '0');

-- ----------------------------
-- Table structure for city_rfc
-- ----------------------------
DROP TABLE IF EXISTS `city_rfc`;
CREATE TABLE `city_rfc` (
  `city_fk_rfc` int(50) NOT NULL,
  `city_rfc` char(255) NOT NULL,
  `sbj_id_pfk` char(30) NOT NULL,
  `sbj_name_pfk` char(255) NOT NULL,
  `county_name` char(255) NOT NULL,
  KEY `city_fk_rfc` (`city_fk_rfc`),
  KEY `sbj_id_pfk` (`sbj_id_pfk`),
  KEY `sbj_name_pfk` (`sbj_name_pfk`),
  KEY `city_rfc` (`city_rfc`),
  CONSTRAINT `city_rfc_ibfk_1` FOREIGN KEY (`city_fk_rfc`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `city_rfc_ibfk_2` FOREIGN KEY (`sbj_id_pfk`) REFERENCES `subject` (`sbj_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `city_rfc_ibfk_3` FOREIGN KEY (`sbj_name_pfk`) REFERENCES `subject` (`sbj_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of city_rfc
-- ----------------------------
INSERT INTO `city_rfc` VALUES ('67', '1099', '1222343', '农业经济', '侯马市');
INSERT INTO `city_rfc` VALUES ('66', '1099', '1222343', '农业经济', '太谷县');
INSERT INTO `city_rfc` VALUES ('66', '1099', '1222343', '农业经济', '太谷县');
INSERT INTO `city_rfc` VALUES ('66', '1099', '1222343', '农业经济', '太谷县');

-- ----------------------------
-- Table structure for city_rfc_subject
-- ----------------------------
DROP TABLE IF EXISTS `city_rfc_subject`;
CREATE TABLE `city_rfc_subject` (
  `city_rfc` varchar(255) DEFAULT NULL,
  `subject_id` char(50) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city_rfc_subject
-- ----------------------------

-- ----------------------------
-- Table structure for county
-- ----------------------------
DROP TABLE IF EXISTS `county`;
CREATE TABLE `county` (
  `city_fk` int(50) NOT NULL,
  `county_id` int(50) NOT NULL AUTO_INCREMENT,
  `county_name` char(255) NOT NULL,
  PRIMARY KEY (`county_id`),
  KEY `city_fk` (`city_fk`),
  KEY `county_name` (`county_name`),
  CONSTRAINT `county_ibfk_1` FOREIGN KEY (`city_fk`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of county
-- ----------------------------
INSERT INTO `county` VALUES ('71', '1', '平定县');
INSERT INTO `county` VALUES ('71', '2', '盂县');
INSERT INTO `county` VALUES ('66', '3', '太谷县');
INSERT INTO `county` VALUES ('67', '4', '侯马市');
INSERT INTO `county` VALUES ('66', '5', '123');

-- ----------------------------
-- Table structure for county_rfc
-- ----------------------------
DROP TABLE IF EXISTS `county_rfc`;
CREATE TABLE `county_rfc` (
  `county_fk_rfc` int(50) NOT NULL,
  `county_rfc` char(255) NOT NULL,
  `sbj_id_countyfk` char(30) NOT NULL,
  `sbj_name_countyfk` char(255) NOT NULL,
  `town_name` char(255) NOT NULL,
  KEY `county_fk_rfc` (`county_fk_rfc`),
  KEY `sbj_id_countyfk` (`sbj_id_countyfk`),
  KEY `sbj_name_countyfk` (`sbj_name_countyfk`),
  KEY `county_rfc` (`county_rfc`),
  CONSTRAINT `county_rfc_ibfk_1` FOREIGN KEY (`county_fk_rfc`) REFERENCES `county` (`county_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `county_rfc_ibfk_2` FOREIGN KEY (`sbj_id_countyfk`) REFERENCES `subject` (`sbj_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `county_rfc_ibfk_3` FOREIGN KEY (`sbj_name_countyfk`) REFERENCES `subject` (`sbj_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of county_rfc
-- ----------------------------
INSERT INTO `county_rfc` VALUES ('4', '1455', '1222343', '农业经济', '侯城乡');

-- ----------------------------
-- Table structure for county_rfc_subject
-- ----------------------------
DROP TABLE IF EXISTS `county_rfc_subject`;
CREATE TABLE `county_rfc_subject` (
  `county_rfc` varchar(255) DEFAULT NULL,
  `subject_id` char(50) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of county_rfc_subject
-- ----------------------------

-- ----------------------------
-- Table structure for province_project
-- ----------------------------
DROP TABLE IF EXISTS `province_project`;
CREATE TABLE `province_project` (
  `province_rfc_ppfk` varchar(255) NOT NULL,
  `city_name_ppfk` varchar(255) NOT NULL,
  `subject_ppfk` varchar(255) NOT NULL,
  `project_name` varchar(255) NOT NULL,
  `total_budget` int(50) DEFAULT NULL,
  `centre_budget` int(50) DEFAULT NULL,
  `province_budget` int(50) DEFAULT NULL,
  `city_local_rfc_ppfk` varchar(255) DEFAULT NULL,
  `city_local_budget` int(50) DEFAULT NULL,
  `city_local_cost` int(50) DEFAULT NULL,
  `city_local_percent` int(50) DEFAULT NULL,
  `county_rfc_ppfk` varchar(255) DEFAULT NULL,
  `county_budget` int(50) DEFAULT NULL,
  `county_cost` int(50) DEFAULT NULL,
  `county_percent` int(50) DEFAULT NULL,
  KEY `city_local_rfc_ppfk` (`city_local_rfc_ppfk`),
  KEY `county_rfc_ppfk` (`county_rfc_ppfk`),
  KEY `province_rfc_ppfk` (`province_rfc_ppfk`),
  KEY `subject_ppfk` (`subject_ppfk`),
  KEY `city_name_ppfk` (`city_name_ppfk`),
  CONSTRAINT `province_project_ibfk_1` FOREIGN KEY (`city_local_rfc_ppfk`) REFERENCES `city_rfc` (`city_rfc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `province_project_ibfk_2` FOREIGN KEY (`city_name_ppfk`) REFERENCES `city` (`city_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `province_project_ibfk_3` FOREIGN KEY (`county_rfc_ppfk`) REFERENCES `county_rfc` (`county_rfc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `province_project_ibfk_4` FOREIGN KEY (`province_rfc_ppfk`) REFERENCES `province_rfc` (`province_rfc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `province_project_ibfk_5` FOREIGN KEY (`subject_ppfk`) REFERENCES `subject` (`sbj_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province_project
-- ----------------------------
INSERT INTO `province_project` VALUES ('1134', '临汾市', '农业经济', 'zppp', '100000', '50000', '50000', '1099', '30000', '20000', '66', '1455', '70000', '30000', '42');

-- ----------------------------
-- Table structure for province_rfc
-- ----------------------------
DROP TABLE IF EXISTS `province_rfc`;
CREATE TABLE `province_rfc` (
  `province_rfc` char(255) NOT NULL,
  `sbj_id_cityfk` char(30) NOT NULL,
  `sbj_name_cityfk` char(255) NOT NULL,
  `city_name` char(255) NOT NULL,
  KEY `sbj_id_cityfk` (`sbj_id_cityfk`),
  KEY `sbj_name_cityfk` (`sbj_name_cityfk`),
  KEY `province_rfc` (`province_rfc`),
  CONSTRAINT `province_rfc_ibfk_1` FOREIGN KEY (`sbj_id_cityfk`) REFERENCES `subject` (`sbj_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `province_rfc_ibfk_2` FOREIGN KEY (`sbj_name_cityfk`) REFERENCES `subject` (`sbj_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province_rfc
-- ----------------------------
INSERT INTO `province_rfc` VALUES ('1134', '1222343', '农业经济', '3432');

-- ----------------------------
-- Table structure for province_rfc_subject
-- ----------------------------
DROP TABLE IF EXISTS `province_rfc_subject`;
CREATE TABLE `province_rfc_subject` (
  `province_rfc` varchar(255) DEFAULT NULL,
  `subject_id` char(50) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province_rfc_subject
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `sbj_class` char(10) NOT NULL,
  `sbj_regulation` char(10) NOT NULL,
  `sbj_item` char(10) NOT NULL,
  `sbj_id` char(30) NOT NULL,
  `sbj_name` varchar(255) NOT NULL,
  PRIMARY KEY (`sbj_name`,`sbj_id`),
  KEY `sbj_id` (`sbj_id`),
  KEY `sbj_name` (`sbj_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('111', '23', '34', '1112334', 'oinj');
INSERT INTO `subject` VALUES ('111', '23', '34', '1112334', 'rts');
INSERT INTO `subject` VALUES ('111', '23', '35', '1112335', 'rts2');
INSERT INTO `subject` VALUES ('122', '23', '43', '1222343', '农业经济');
INSERT INTO `subject` VALUES ('1234', '41', '22', '12344122', '农林经济');
INSERT INTO `subject` VALUES ('111', '22', '33', '1112233', '软件工程');

-- ----------------------------
-- Table structure for town
-- ----------------------------
DROP TABLE IF EXISTS `town`;
CREATE TABLE `town` (
  `county_fk` int(50) NOT NULL,
  `town_id` int(50) NOT NULL AUTO_INCREMENT,
  `town_name` char(255) NOT NULL,
  PRIMARY KEY (`town_id`),
  KEY `county_fk` (`county_fk`),
  CONSTRAINT `town_ibfk_1` FOREIGN KEY (`county_fk`) REFERENCES `county` (`county_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of town
-- ----------------------------
INSERT INTO `town` VALUES ('1', '1', '冠山镇');
INSERT INTO `town` VALUES ('1', '2', '娘子关镇');
INSERT INTO `town` VALUES ('3', '5', '侯城乡');

-- ----------------------------
-- Table structure for town_rfc
-- ----------------------------
DROP TABLE IF EXISTS `town_rfc`;
CREATE TABLE `town_rfc` (
  `town_fk_rfc` int(50) NOT NULL,
  `town_rfc` char(255) NOT NULL,
  `sbj_id_tfk` char(30) NOT NULL,
  `sbj_name_tfk` char(255) NOT NULL,
  KEY `town_fk_rfc` (`town_fk_rfc`),
  KEY `sbj_id_tfk` (`sbj_id_tfk`),
  KEY `sbj_name_tfk` (`sbj_name_tfk`),
  KEY `town_rfc` (`town_rfc`),
  CONSTRAINT `town_rfc_ibfk_1` FOREIGN KEY (`sbj_id_tfk`) REFERENCES `subject` (`sbj_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `town_rfc_ibfk_2` FOREIGN KEY (`sbj_name_tfk`) REFERENCES `subject` (`sbj_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `town_rfc_ibfk_3` FOREIGN KEY (`town_fk_rfc`) REFERENCES `town` (`town_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of town_rfc
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_city_name` varchar(255) NOT NULL,
  `user_county_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_level` varchar(255) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('阳泉市', null, '12345', '12345', '市级');
INSERT INTO `user` VALUES ('晋中市', '123', '23', '123', '县级');
INSERT INTO `user` VALUES ('', null, 'admin', 'admin', '省级');
INSERT INTO `user` VALUES ('晋中市', '太谷县', 'asdas', '3422', '县级');
INSERT INTO `user` VALUES ('晋中市', '太谷县', 'asdsa', 'f2323', '县级');
INSERT INTO `user` VALUES ('吕梁市', null, 'asdsasadasd', 'sawerwe', '市级');
INSERT INTO `user` VALUES ('临汾市', null, 'city4', 'city4', '市级');
INSERT INTO `user` VALUES ('晋中市', '太谷县', 'county2', 'county2', '县级');
INSERT INTO `user` VALUES ('吕梁市', null, 'sa213', '0000', '市级');
INSERT INTO `user` VALUES ('太原市', null, 'sadsa', '13213', '市级');
INSERT INTO `user` VALUES ('太原市', null, 'sdassada', 'rwerewr', '市级');
INSERT INTO `user` VALUES ('太原市', null, 'taiyuan1', 'taiyuan', '市级');
INSERT INTO `user` VALUES ('太原市', null, 'taiyuan2', 'taiyuan', '市级');
INSERT INTO `user` VALUES ('太原市', null, 'taiyuan3', 'taiyuan', '市级');
INSERT INTO `user` VALUES ('晋中市', null, 'user8', '123456', '市级');
