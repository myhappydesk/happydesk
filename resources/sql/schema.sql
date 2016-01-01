# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.25)
# Database: happydesk
# Generation Time: 2015-12-13 07:12:01 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table agent
# ------------------------------------------------------------

DROP TABLE IF EXISTS `agent`;

CREATE TABLE `agent` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  `master_user_type` int(11) DEFAULT NULL,
  `profile_pic` varchar(256) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table company
# ------------------------------------------------------------

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `logo` varchar(256) DEFAULT NULL,
  `website_url` varchar(256) DEFAULT NULL,
  `company_address` varchar(256) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `facebook_realtime_enable` tinyint(11) DEFAULT NULL,
  `sub_domain_name` varchar(50) DEFAULT NULL,
  `twitter_feed_enable` tinyint(4) DEFAULT NULL,
  `email_parser_enable` tinyint(4) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table company_email_parser
# ------------------------------------------------------------

DROP TABLE IF EXISTS `company_email_parser`;

CREATE TABLE `company_email_parser` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` int(11) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table company_email_respond
# ------------------------------------------------------------

DROP TABLE IF EXISTS `company_email_response`;

CREATE TABLE `company_email_response` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` int(11) DEFAULT NULL,
  `respond_email` varchar(50) DEFAULT NULL,
  `default` tinyint(1) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table company_social_handler
# ------------------------------------------------------------

DROP TABLE IF EXISTS `company_social_handler`;

CREATE TABLE `company_social_handler` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` int(11) DEFAULT NULL,
  `company_token` varchar(500) DEFAULT NULL,
  `token_secret_key` varchar(500) DEFAULT NULL,
  `social_media_id` varchar(500) DEFAULT NULL,
  `source_type_id` int(11) DEFAULT NULL,
  `screen_name` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table complainer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `complainer`;

CREATE TABLE `complainer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `source_type_id` int(11) DEFAULT NULL,
  `external_user_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `profile_url` varchar(256) DEFAULT NULL,
  `profile_image_url` varchar(256) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  `impact_score` int(11) DEFAULT NULL,
  `screen_name` varchar(50) DEFAULT NULL,
  `friends_count` int(11) DEFAULT NULL,
  `followers_count` int(11) DEFAULT NULL,
  `status_count` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table conversation
# ------------------------------------------------------------

DROP TABLE IF EXISTS `conversation`;

CREATE TABLE `conversation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `source_type_id` int(11) DEFAULT NULL,
  `resource_id` varchar(50) DEFAULT NULL,
  `resource_text` varchar(500) DEFAULT NULL,
  `resource_type` int(11) DEFAULT NULL,
  `resource_url` varchar(256) DEFAULT NULL,
  `resource_publish_date` timestamp NULL DEFAULT NULL,
  `resource_parent_id` varchar(50) DEFAULT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `sentiment` varchar(10) DEFAULT NULL,
  `top_parent_id` varchar(50) DEFAULT NULL,
  `corrected_sentiment` varchar(10) DEFAULT NULL,
  `sentiment_corrected_at` timestamp NULL DEFAULT NULL,
  `external_user_id` varchar(50) DEFAULT NULL,
  `resource_group_id` int(11) DEFAULT NULL,
  `favourite_by_brand` tinyint(4) DEFAULT NULL,
  `handle_id` varchar(50) DEFAULT NULL,
  `attachment_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table conversation_attachment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `conversation_attachment`;

CREATE TABLE `conversation_attachment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `conversation_id` int(11) DEFAULT NULL,
  `attachment_type` varchar(50) DEFAULT NULL,
  `attachment_url` varchar(256) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` int(11) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table master_priority
# ------------------------------------------------------------

DROP TABLE IF EXISTS `master_priority`;

CREATE TABLE `master_priority` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `master_priority` WRITE;
/*!40000 ALTER TABLE `master_priority` DISABLE KEYS */;

INSERT INTO `master_priority` (`id`, `name`, `created_at`, `created_by`, `updated_at`, `updated_by`)
VALUES
	(1,'low','2015-12-02 12:44:08','SYSTEM','2015-12-02 12:44:08','SYSTEM'),
	(2,'high','2015-12-02 12:44:15','SYSTEM','2015-12-02 12:44:15','SYSTEM'),
	(3,'very high','2015-12-02 12:44:21','SYSTEM','2015-12-02 12:44:21','SYSTEM');

/*!40000 ALTER TABLE `master_priority` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table master_source_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `master_source_type`;

CREATE TABLE `master_source_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `source_name` varchar(50) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table master_state_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `master_state_type`;

CREATE TABLE `master_state_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `master_state_type` WRITE;
/*!40000 ALTER TABLE `master_state_type` DISABLE KEYS */;

INSERT INTO `master_state_type` (`id`, `name`, `created_at`, `created_by`, `updated_at`, `updated_by`)
VALUES
	(1,'open','2015-12-02 12:34:29','SYSTEM','2015-12-02 12:34:29','SYSTEM'),
	(2,'pending','2015-12-02 12:34:41','SYSTEM','2015-12-02 12:34:41','SYSTEM'),
	(3,'closed','2015-12-02 12:34:48','SYSTEM','2015-12-02 12:34:48','SYSTEM'),
	(6,'discard','2015-12-02 12:35:37','SYSTEM','2015-12-02 12:35:37','SYSTEM'),
	(7,'bounce','2015-12-02 12:35:43','SYSTEM','2015-12-02 12:35:43','SYSTEM'),
	(8,'reopen','2015-12-02 12:35:49','SYSTEM','2015-12-02 12:35:49','SYSTEM');

/*!40000 ALTER TABLE `master_state_type` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table master_user_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `master_user_type`;

CREATE TABLE `master_user_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL DEFAULT '',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT '',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `master_user_type` WRITE;
/*!40000 ALTER TABLE `master_user_type` DISABLE KEYS */;

INSERT INTO `master_user_type` (`id`, `type`, `created_at`, `created_by`, `updated_at`, `updated_by`)
VALUES
	(1,'complainer','2015-12-02 11:56:23','SYSTEM','2015-12-02 11:56:26','SYSTEM'),
	(2,'agent','2015-12-02 12:21:04','SYSTEM','2015-12-02 12:21:04','SYSTEM'),
	(3,'superadmin','2015-12-02 12:21:36','SYSTEM','2015-12-02 12:21:36','SYSTEM'),
	(4,'salesadmin','2015-12-02 12:23:15','SYSTEM','2015-12-02 12:23:15','SYSTEM');

/*!40000 ALTER TABLE `master_user_type` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ticket
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `complainer_id` varchar(50) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `source_type_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ticket_assignment_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ticket_assignment_history`;

CREATE TABLE `ticket_assignment_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `agent_id` varchar(50) DEFAULT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `assigned_by` varchar(50) DEFAULT NULL,
  `effective_assignment_date` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ticket_priority_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ticket_priority_history`;

CREATE TABLE `ticket_priority_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) DEFAULT NULL,
  `ticket_priority_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` int(11) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ticket_status_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ticket_status_history`;

CREATE TABLE `ticket_status_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) DEFAULT NULL,
  `state_type_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` int(11) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ticket_summary
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ticket_summary`;

CREATE TABLE `ticket_summary` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `current_state_id` int(11) DEFAULT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `current_assignment_id` int(11) DEFAULT NULL,
  `current_priority_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `username`)
VALUES
	(1,'Manoranjan'),
	(2,'Amit'),
	(3,'Rohit'),
	(4,'Om');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



CREATE TABLE `cron_jobs_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `job_name` varchar(200) DEFAULT NULL,
  `job_class_name` varchar(500) DEFAULT NULL,
  `job_desc` text,
  `job_time_expression` varchar(200) DEFAULT NULL,
  `job_process_id` mediumint(11) unsigned DEFAULT NULL,
  `job_brand_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` mediumint(11) unsigned DEFAULT NULL,
  `updated_by_name` varchar(300) DEFAULT NULL,
  `updated_by_ip_address` varchar(900) DEFAULT NULL,
  `process_host` varchar(20) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `automatic_process_index` (`job_process_id`),
  CONSTRAINT `automatic_process_index` FOREIGN KEY (`job_process_id`) REFERENCES `automatic_process` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `social_cron_data` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `social_cron_type` int(11) NOT NULL,
  `company_id` mediumint(8) unsigned DEFAULT NULL,
  `status` smallint(3) NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `ipAddress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `facebook_company_tokens_data` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `brand_id` mediumint(8) unsigned DEFAULT NULL,
  `page_access_token` varchar(400) DEFAULT NULL,
  `fb_page_id` varchar(50) DEFAULT NULL,
  `fb_page_name` varchar(200) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `fb_realtime_feed` smallint(3) NOT NULL DEFAULT '0',
  `to_request_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `company_facebook_fk_1` (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





CREATE TABLE `facebook_page_admin_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facebook_company_tokens_id` int(10) unsigned NOT NULL,
  `fb_user_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `twitter_raw_data` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `resource_id` bigint(11) NOT NULL,
  `resource_type` tinyint(1) NOT NULL,
  `raw_data` longtext CHARACTER SET utf8mb4 NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `last_api_call_data` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` mediumint(8) unsigned DEFAULT '0',
  `last_resource_id` int(11) DEFAULT NULL,
  `last_request_date` datetime DEFAULT NULL,
  `resource_type` smallint(3) unsigned DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
