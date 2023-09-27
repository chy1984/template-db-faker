DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`          bigint      NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `username`    varchar(50) NOT NULL COMMENT '用户名',
    `tel`         varchar(11) NOT NULL COMMENT '手机号',
    `address`     varchar(255)         DEFAULT '' COMMENT '住址',
    `birthday`    datetime             DEFAULT NULL COMMENT '生日',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_username` (`username`),
    KEY `idx_tel` (`tel`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户表';

DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`
(
    `id`          bigint      NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `name`        varchar(50) NOT NULL COMMENT '姓名',
    `tel`         varchar(11) NOT NULL COMMENT '手机号',
    `address`     varchar(255)         DEFAULT '' COMMENT '住址',
    `birthday`    datetime             DEFAULT NULL COMMENT '生日',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `idx_name` (`name`),
    KEY `idx_tel` (`tel`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='学生表';
