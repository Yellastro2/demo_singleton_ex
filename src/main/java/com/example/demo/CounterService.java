package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class CounterService {
    @Autowired
    private ApplicationContext ctx;

//    ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);

    @GetMapping("/get")
    public String getCount() {
        CounterSingleton fCounter = ctx.getBean(CounterSingleton.class);
        return fCounter.get()+"";
//        return 1+"";
    }

    @GetMapping("/set")
    public @ResponseBody ResponseEntity<String> post(
            @RequestParam(defaultValue = "1")  Integer value
           ) {
        CounterSingleton fCounter = ctx.getBean(CounterSingleton.class);
        fCounter.set(value);
        return new ResponseEntity<String>("Value saved", HttpStatus.OK);
    }
}
