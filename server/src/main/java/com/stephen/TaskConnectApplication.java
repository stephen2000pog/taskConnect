package com.stephen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class TaskConnectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskConnectApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Beans loaded by Spring:");
            Arrays.stream(ctx.getBeanDefinitionNames())
                    .filter(name -> name.contains("security") || name.contains("jwt"))
                    .forEach(System.out::println);
        };
    }

}
