-- drop table if EXISTS t_bankcard;
-- CREATE TABLE t_bankcard (
--   id BIGINT(20) NOT NULL AUTO_INCREMENT,
--   bank_name VARCHAR(64) NOT NULL,
--   bank_code CHAR(32) NOT NULL,
--   card_name VARCHAR(64) NULL,
--   card_no_length TINYINT(2) NOT NULL,
--   card_no_sample CHAR(32) NOT NULL,
--   bin_length TINYINT(2) NOT NULL,
--   bin CHAR(16) NOT NULL,
--   card_type CHAR(8) CHARACTER SET 'utf8' NOT NULL,
--   PRIMARY KEY (id),
--   INDEX idx_bin USING BTREE (bin ASC)
-- )DEFAULT CHARSET=utf8;
-- 
-- ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='数据字典表';
-- 
-- 
-- 

-- select * from t_bankcard
-- delete from t_bankcard

-- insert into girl (cup_size,age) values('C',16);
-- alter table girl modify cup_size char(1);

-- drop table hibernate_sequence;
-- 
-- alter table girl modify column id int auto_increment;
-- alter table hibernate_sequence ENGINE=InnoDB;
-- alter table db_user modify column pass_wd varchar(20);
-- alter table db_user modify column user_name varchar(20);
-- alter table db_user ENGINE=InnoDB; 

alter table db_product engine=InnoDB;
-- Drop table if exists `people`;

-- CREATE TABLE `people` (
--   `person_id` int(11) NOT NULL AUTO_INCREMENT,
--   `first_name` varchar(20) default NULL,
--   `last_name` varchar(20) default NULL,
--   PRIMARY KEY  (`person_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
