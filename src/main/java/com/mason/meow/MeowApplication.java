package com.mason.meow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nothing2.modules.*.domain.mapper")
public class MeowApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeowApplication.class,args);
    }
}
