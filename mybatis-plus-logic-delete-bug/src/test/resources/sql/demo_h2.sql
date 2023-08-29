DROP TABLE IF EXISTS `demo_entity`;
CREATE TABLE `demo_entity` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `demo` varchar(32) NOT NULL COMMENT 'demo',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
);
INSERT INTO `demo_entity`(`demo`, `deleted`) VALUES ('t1', 0);
INSERT INTO `demo_entity`(`demo`, `deleted`) VALUES ('t2', 1);