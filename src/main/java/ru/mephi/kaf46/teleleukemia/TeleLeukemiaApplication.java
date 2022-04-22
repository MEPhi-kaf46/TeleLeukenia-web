package ru.mephi.kaf46.teleleukemia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * @author Yury Zorin
 */
@EnableSpringDataWebSupport
@SpringBootApplication
public class TeleLeukemiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeleLeukemiaApplication.class, args);
    }

}
