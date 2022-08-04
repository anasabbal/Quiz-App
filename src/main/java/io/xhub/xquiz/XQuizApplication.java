package io.xhub.xquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class XQuizApplication{

    public static void main(String[] args) {
        SpringApplication.run(XQuizApplication.class, args);
    }

}
