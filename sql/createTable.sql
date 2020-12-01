CREATE TABLE `table_demo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) unsigned DEFAULT '0' COMMENT '是否逻辑删除：1-删除，0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;