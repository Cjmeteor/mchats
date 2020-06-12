package com.mchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description:
 * @author: zhangwenzhi
 * @time: 2020/4/21 17:13
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.mchat" })
public class Stater {
    public static void main(String[] args) {
        SpringApplication.run(Stater.class);
    }
}
