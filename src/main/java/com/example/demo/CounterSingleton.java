package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CounterSingleton {


    public int get() {
        return mCounter;
    }

    public void set(int mCounter) {
        this.mCounter = mCounter;
    }

    private int mCounter = 0;

//    private CounterSingleton(){}
}
