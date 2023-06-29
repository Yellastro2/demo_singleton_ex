package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);

        ApplicationContext f_ctx = SpringApplication.run(DemoApplication.class, args);
        CounterSingleton f_cont = f_ctx.getBean(CounterSingleton.class);
        f_cont.set(5);

    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
