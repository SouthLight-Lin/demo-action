package com.lnw.mongodb;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/8
 */
@SpringBootApplication
public class Application implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        System.out.println("111111111");
    }
}
