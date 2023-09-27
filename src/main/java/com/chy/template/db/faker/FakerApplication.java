package com.chy.template.db.faker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author chy
 */
@SpringBootApplication
@MapperScan("com.chy.template.db.faker.mapper")
public class FakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FakerApplication.class, args);
    }

}
