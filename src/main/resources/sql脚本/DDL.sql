-- t_user
CREATE TABLE `t_user` (
    `user_id` bigint NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL,
    `tel` varchar(11) NOT NULL,
    `address` varchar(255) DEFAULT NULL,
    `birthday` datetime DEFAULT NULL,
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`) USING BTREE,
    UNIQUE KEY `idx_tel` (`tel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- t_student
CREATE TABLE `t_student` (
    `student_id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL,
    `tel` varchar(11) NOT NULL,
    `address` varchar(255) DEFAULT NULL,
    `birthday` datetime DEFAULT NULL,
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`student_id`) USING BTREE,
    UNIQUE KEY `idx_tel` (`tel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;